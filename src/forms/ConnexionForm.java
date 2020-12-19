package forms;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import beans.User;
import dao.DAOException;
import dao.UserDao;
import forms.md5;

public final class ConnexionForm {
	private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "password";
    //private static final String CHAMP_PROFILE = "profile";
    private static final String ALGO_CHIFFREMENT = "SHA-256";
    
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();
    private UserDao userDao;
	
    
    public ConnexionForm(UserDao userDao) {
    	this.userDao = userDao;
	}

	public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public User connexionUser( HttpServletRequest request ) {
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String password = getValeurChamp( request, CHAMP_PASS );
        //String profile = getValeurChamp(request, CHAMP_PROFILE);

        User user = new User();

        try {
        	user = validationConnexion(email,password, user);
        	
        	if (erreurs.isEmpty()) {
                resultat = "Succés de la connexion.";
            } else {
                resultat = "échec de la connexion.";
            }
        } catch ( DAOException e) {
            resultat = "Echec de l'inscription : une erreur imprévue est survenue, merci de réssayer dans quelques instants.";
            e.printStackTrace();
        } catch (FormValidationException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

        return user;
    }
    
    
//    private void traiterProfile( String profile, User user ) {
//        try {
//            validationProfile( profile );
//        } catch ( FormValidationException e ) {
//            setErreur( CHAMP_PROFILE, e.getMessage() );
//        }
//        user.setProfile(profile);
//    }
    
    /* Validation de l'adresse email */
    private User validationConnexion( String email, String password, User user ) throws FormValidationException{
    	String message ="Merci de renseigner des identifiants valides";
    	user = userDao.find_by_email( email );
        if ( user != null ) {
        	md5 md =new md5();
            String passwordChiffre = ((md5) md).hachPassword(password);
            
        	
           // if ( passwordEncryptor.checkPassword(password,user.getPassword()) ) {
           if ( passwordChiffre == user.getPassword() ) {
                return user;
            } else if ( userDao.find_by_email( email ) != null ) {
            	user =null;
            	setErreur(password, message);
            	throw new FormValidationException("Mot de passe incorrect ");
            }
        } else {
        	setErreur(email, message);
        	throw new FormValidationException("l'email entré n'existe pas ");
            
        }
        return user;
    }

    
//    private void validationProfile( String profile ) throws FormValidationException {
//        if ( profile != null && profile.length() < 2) {
//            throw new FormValidationException( "Le profile contenir au moins 2 caractères." );
//        }
//    }
    

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