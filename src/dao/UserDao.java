package dao;

import beans.User;

public interface UserDao {

    void create( User user ) throws DAOException;

    User find( String email ) throws DAOException;
    
    void modify ( User user) throws DAOException;
    
    void delete ( User user) throws DAOException;

}