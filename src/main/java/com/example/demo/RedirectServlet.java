package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Extraction des paramètres de la requête
        String action = request.getParameter("action");
        String page = request.getParameter("page");

        if (page != null) {
            page = page.replaceAll("^\"|\"$", "");  // Retire les guillemets en début et fin de chaîne
        }

        // Vérification des paramètres pour la redirection
        if ("PageRedirect".equals(action) && page != null && !page.isEmpty()) {
            // Redirection vers l'URL spécifiée dans le paramètre 'page'
            response.sendRedirect(page);
        } else if ("GoogleSearch".equals(action) && page != null && !page.isEmpty()) {
            response.sendRedirect("https://www.google.fr/search?q="+page);
        } else {
            // Si les paramètres sont incorrects, envoyer un message d'erreur
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h3>Erreur : paramètres de redirection invalides</h3>");
            response.getWriter().println("</body></html>");
        }
    }
}