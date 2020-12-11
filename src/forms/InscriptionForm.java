package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.User;
import dao.UserDao;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import dao.DAOException;

public final class InscriptionForm {
	
    private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "password";
    private static final String CHAMP_CONF   = "confirmpassword";
    private static final String CHAMP_NOM    = "nom";
    private static final String CHAMP_PHONE    = "phone";
    private static final String CHAMP_PRENOM = "prenom";
    private static final String CHAMP_USERNAME ="username";
    private static final String CHAMP_ADDR = "address";
    private static final String CHAMP_PROFILE = "profile";
    
    private static final String ALGO_CHIFFREMENT = "SHA-256";
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();
    private UserDao userDao;
    
    public InscriptionForm(UserDao userDao) {
    	this.userDao = userDao;
	}

	public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public User inscrireUser( HttpServletRequest request ) {
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String password = getValeurChamp( request, CHAMP_PASS );
        String confirmation = getValeurChamp( request, CHAMP_CONF );
        String nom = getValeurChamp( request, CHAMP_NOM );
        String phone = getValeurChamp(request, CHAMP_PHONE);
        String prenom = getValeurChamp(request, CHAMP_PRENOM);
        String username = getValeurChamp(request, CHAMP_USERNAME);
        String address = getValeurChamp(request, CHAMP_ADDR);
        String profile = getValeurChamp(request, CHAMP_PROFILE);

        User user = new User();

        try {
        	traiterEmail(email, user);
        	traiterMotsDePasse( password,confirmation, user);
        	traiterNom(nom, user);
        	traiterPrenom(prenom, user);
        	traiterPhone(phone, user);
        	traiterUsername(username, user);
        	traiterAddress(address, user);
        	traiterProfile(profile, user);
        	
        	if ( erreurs.isEmpty() ) {
                userDao.create( user );
                resultat = "Succés de l'inscription.";
            } else {
                resultat = "échec de l'inscription.";
            }
        } catch ( DAOException e ) {
            resultat = "Echec de l'inscription : une erreur imprévue est survenue, merci de réssayer dans quelques instants.";
            e.printStackTrace();
        }

        return user;
    }
    
    /*
     * Appel Ã  la validation de l'adresse email reçue et initialisation de la
     * propriété email du bean
     */
    private void traiterEmail( String email, User user ) {
        try {
            validationEmail( email );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        user.setEmail( email );
    }
    
    /*
     * Appel Ã  la validation des mots de passe reÃ§us, chiffrement du mot de
     * passe et initialisation de la propriété password du bean
     */
    private void traiterMotsDePasse( String password, String confirmation, User user ) {
        try {
            validationMotsDePasse( password, confirmation );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, null );
        }

        /*
         * Utilisation de la bibliothÃ¨que Jasypt pour chiffrer le mot de passe
         * efficacement.
         * 
         * L'algorithme SHA-256 est ici utilisÃ©, avec par dÃ©faut un salage
         * aléatoire et un grand nombre d'itÃ©rations de la fonction de hashage.
         * 
         * La String retournÃ©e est de longueur 56 et contient le hash en Base64.
         */
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
        passwordEncryptor.setPlainDigest( false );
        String passwordChiffre = passwordEncryptor.encryptPassword( password );

        user.setPassword( passwordChiffre );
    }
            
        
    
    /*
     * Appel a  la validation du nom reçu et initialisation de la propriété nom
     * du bean
     */
    
    private void traiterNom( String nom, User user ) {
        try {
            validationNom( nom );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        user.setNom( nom );
    }
    
    private void traiterPrenom( String prenom, User user ) {
        try {
            validationPrenom( prenom );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        user.setPrenom( prenom );
    }
    
    private void traiterPhone( String phone, User user ) {
        try {
            validationPhone( phone );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_PHONE, e.getMessage() );
        }
        user.setPhone( phone );
    }
    
    private void traiterUsername( String username, User user ) {
        try {
            validationUsername( username );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_USERNAME, e.getMessage() );
        }
        user.setUsername(username);
    }
    
    private void traiterAddress( String address, User user ) {
        try {
            validationAddress( address );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_ADDR, e.getMessage() );
        }
        user.setUsername(address);
    }
    
    private void traiterProfile( String profile, User user ) {
        try {
            validationProfile( profile );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_PROFILE, e.getMessage() );
        }
        user.setProfile(profile);
    }
    
    
    
    
    /* Validation de l'adresse email */
    private void validationEmail( String email ) throws FormValidationException {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new FormValidationException( "Merci de saisir une adresse mail valide." );
            } else if ( userDao.find( email ) != null ) {
                throw new FormValidationException( "Cette adresse email est déjà utilisé, merci d'en choisir une autre." );
            }
        } else {
            throw new FormValidationException( "Merci de saisir une adresse mail." );
        }
    }

    private void validationMotsDePasse( String password, String confirmation ) throws FormValidationException {
        if ( password != null && confirmation != null ) {
            if ( !password.equals( confirmation ) ) {
                throw new FormValidationException( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
            } else if ( password.length() < 3 ) {
                throw new FormValidationException( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new FormValidationException( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    private void validationNom( String nom ) throws FormValidationException {
        if ( nom != null && nom.length() < 2 ) {
            throw new FormValidationException( "Le nom doit contenir au moins 2 caractères." );
        }
    }
    
    private void validationPrenom( String prenom ) throws FormValidationException {
        if ( prenom != null && prenom.length() < 2 ) {
            throw new FormValidationException( "Le prenom doit contenir au moins 2 caractères." );
        }
    }
    
    private void validationUsername( String username ) throws FormValidationException {
        if ( username != null && username.length() < 3 ) {
            throw new FormValidationException( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }
    
    private void validationPhone( String phone ) throws FormValidationException {
        if ( phone != null && phone.length() < 3 ) {
            throw new FormValidationException( "Le numero de téléphone doit etre formater correctement." );
        }
    }
    
    private void validationAddress( String address ) throws FormValidationException {
        if ( address != null && address.length() < 2) {
            throw new FormValidationException( "Laddresse  doit contenir au moins 2 caractères." );
        }
    }
    
    private void validationProfile( String profile ) throws FormValidationException {
        if ( profile != null && profile.length() < 2) {
            throw new FormValidationException( "Le profile contenir au moins 2 caractères." );
        }
    }
    

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
    
}