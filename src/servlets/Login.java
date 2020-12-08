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


public class Login extends HttpServlet {
    public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ATT_INTERVALLE_CONNEXIONS = "intervalleConnexions";
    public static final String COOKIE_DERNIERE_CONNEXION = "derniereConnexion";
    public static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";
    public static final String CHAMP_MEMOIRE  = "memoire";
    public static final int    COOKIE_MAX_AGE = 60 * 60 * 24 * 365;  // 1 an
    public static final String VUE              = "/WEB-INF/login.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }


}