package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static dao.DAOUtilitaire.*;

import beans.User;

public class UserDaoImpl implements UserDao {
	
	private DAOFactory          daoFactory;
	
	//definition des requestes
	private static final String SQL_SELECT_PAR_EMAIL = "SELECT * FROM ACHETEUR WHERE email = ?";
	private static final String SQL_INSERT = "INSERT INTO ACHETEUR (username, email, password, prenom, nom, tel, addresse) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
	UserDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
	/* Implémentation de la méthode définie dans l'interface UtilisateurDao */
    @Override
    public User find( String email ) throws DAOException {
        return find( SQL_SELECT_PAR_EMAIL, email );
    }
    
	@Override
	public void create(User user) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet valeursAutoGenerees = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, user.getUsername(), user.getEmail(), user.getPassword(),  user.getPrenom(), user.getNom(), user.getPhone(),user.getAddress());
	        int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
	        }
	        /* Récupération de l'id auto-généré par la requête d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
	            user.setId( valeursAutoGenerees.getLong( 1 ) );
	        } else {
	            throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
	    }
	}
	
	


	
	private User find(String sql, Object... objets) throws DAOException {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    User user = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_EMAIL, false, objets );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	            user = map( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

	    return user;
	}

	@Override
	public void modify(User user) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des users (un
	 * ResultSet) et un bean user.
	 */
	private static User map( ResultSet resultSet ) throws SQLException {
	    User user = new User();
	    user.setId( resultSet.getLong( "id_acheteur" ) );
	    user.setUsername( resultSet.getString("username"));
	    user.setEmail( resultSet.getString( "email" ) );
	    user.setPassword( resultSet.getString( "password" ) );
	    user.setNom( resultSet.getString( "nom" ) );
	    user.setPrenom( resultSet.getString( "prenom" ) );
	    user.setPhone( resultSet.getString( "tel" ) );
	    user.setAddress( resultSet.getString( "addresse" ) );
	    user.setDateInscription( resultSet.getTimestamp( "date_inscription" ) );
	    return user;
	}
	
	
}