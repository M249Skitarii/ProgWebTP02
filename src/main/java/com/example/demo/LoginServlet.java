package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    // Identifiants valides
    private static final String VALID_USERNAME = "J2EE";
    private static final String VALID_PASSWORD = "J2EE";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Récupération des paramètres du formulaire
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Vérification des identifiants
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            // Authentification réussie, affichage du formulaire de redirection
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h2>Bienvenue " + username + " !</h2>");
            response.getWriter().println("<form action='redirect' method='GET'>");
            response.getWriter().println("<label for='action'>Type d'action :</label>");
            response.getWriter().println("<select id='action' name='action'>");
            response.getWriter().println("<option value='GoogleSearch'>GoogleSearch</option>");
            response.getWriter().println("<option value='PageRedirect'>PageRedirect</option>");
            response.getWriter().println("</select><br><br>");
            response.getWriter().println("<label for='page'>URL ou terme de recherche :</label>");
            response.getWriter().println("<input type='text' id='page' name='page' required><br><br>");
            response.getWriter().println("<button type='submit'>Rediriger</button>");
            response.getWriter().println("</form>");
            response.getWriter().println("</body></html>");
        } else {
            // Authentification échouée, affichage d'un message d'erreur
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h3>Erreur : identifiants incorrects.</h3>");
            response.getWriter().println("<a href='login.html'>Réessayer</a>");
            response.getWriter().println("</body></html>");
        }
    }
}
