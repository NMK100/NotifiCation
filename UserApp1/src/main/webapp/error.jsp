<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Une erreur est survenue</h2>

<p><%= exception !=null ? exception.getMessage(): "Erreur inconnue, survenue a un problème du faute d'url ou <br> Un champ non remplie dans le formulaire" %></p>
<a href="userForm.jsp">Formulaire</a>
</body>
</html>