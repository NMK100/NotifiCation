<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Formulaire </title>
</head>
<body>
<style>
 body{
 	background-color: white;
 }
 
 form{
 background-color: olive;
 width:40%;
 margin: 0 Auto;
 justify-content: center;
 padding: 20 px;
 border-radius: 20 px;
 border: 4px solid white;
 }
 
 form input[type="submit"] {
  width: 20%;
  padding: 10px;
  background-color: white;
  color: black;
  border: 1px solid gray;
  border-radius: 3px;
  cursor: pointer;
  margin: 0 40% 1% 40%;
}

form input[type="text"]{
width: 80%;
 margin: 0 40% 1% 05%;
}

form label{
  margin: 0.5% 40% 0.5% 05%;
}

h3{
text-align: center;
}
 
</style>
 <c:if test= "${!empty sessionScope.nom && !empty sessionScope.email && !empty sessionScope.quartier} "></c:if> 
    <h3>Veuillez Saisir Vos Informations</h3>
<form method="post" action="UserServlet">
<label for="nom"> Nom : </label><br>
<input type="text" name ="nom" id="nom"	required placeholder="Votre Nom"/><br><br>
	
<label for="email"> Email : </label><br>
<input type="text" name ="email" id="email" required placeholder="Votre Email"/><br><br>

<label for="Quartier"> Quartier : </label><br>
<input type="text" name="quartier" id="quartier" required placeholder="Votre Quartier" /> <br><br>
	
<input type="submit" />
</form>

</body>
</html>
