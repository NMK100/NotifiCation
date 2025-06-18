<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des utilisateurs</title>
</head>
<body>
    <h3>Liste des utilisateurs</h3>
    <ol>
        <% 
            List<User> utilisateurs = (List<User>) session.getAttribute("utilisateurs");
            if(utilisateurs != null && !utilisateurs.isEmpty()) {
                for(User nmk : utilisateurs) {
        %>
            <li><%= nmk.getNom() %> --- <%= nmk.getEmail() %></li>
        <%
                }
            } else {
        %>
            <li>Aucun utilisateur enregistré</li>
        <% } %>
    </ol>
    <a href="userForm.jsp">Retour au formulaire</a>
</body>
</html>