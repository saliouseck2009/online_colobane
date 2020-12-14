package servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import beans.User;
import dao.DAOFactory;
import dao.UserDao;
import forms.ConnexionForm;
import forms.InscriptionForm;


public class Login extends HttpServlet {
	public static final String ATT_USER         = "user";
    public static final String ATT_FORM         = "form";
    public static final String VUE              = "/WEB-INF/login.jsp";
    public static final String VUE_SUCCES = "/WEB-INF/home.jsp";
    public static final String CONF_DAO_FACTORY = "daofactory";


    private UserDao userDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.userDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUserDao();
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm( userDao );

        /* Traitement de la requête et récupération du bean en résultant */
        User user = form.connexionUser( request );

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, user );
        if (form.getErreurs().isEmpty()){
        	this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        }else {
        	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
        
    }
    


}