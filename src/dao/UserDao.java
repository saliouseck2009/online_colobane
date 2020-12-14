package dao;

import beans.User;

public interface UserDao {

    void create( User user ) throws DAOException;

    User find_by_email( String email ) throws DAOException;
    
    User find_by_email_password( String email, String password);
    
    void modify ( User user) throws DAOException;
    
    void delete ( User user) throws DAOException;

}