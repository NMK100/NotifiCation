package model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("/userForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Récupération des paramètres
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        
        // Récupération de la session
        HttpSession session = request.getSession();
        
        // Récupération ou creation de la liste d'utilisateurs
        @SuppressWarnings("unchecked")
		List<User> utilisateurs = (List<User>) session.getAttribute("utilisateurs");
        if(utilisateurs == null) {
        	utilisateurs = new ArrayList<>();
        }
        
        // Ajout du nouvel utilisateur
        utilisateurs.add(new User(nom, email));
        
        // Mise à jour de la session
        session.setAttribute("utilisateurs", utilisateurs);
           
        // Redirection vers userDetails.jsp
        request.getRequestDispatcher("/userDetails.jsp").forward(request, response);
    }
}