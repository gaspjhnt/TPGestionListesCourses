

<%@page import="java.util.List"%>
<%@page import="fr.eni.ecole.javaee.tpgestioncourse.bo.LstCourse" %>
<%@page import="fr.eni.ecole.javaee.tpgestioncourse.bo.Articles" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> COURSES </title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
</head>
	<body>
		<header>
			<h1>COURSES</h1>
			<h4>Listes prédéfinies</h4>
		</header>
		
		<% List<LstCourse> lst = (List<LstCourse>)request.getAttribute("lstCourse"); 
		List<String> lstMsg = (List<String>) request.getAttribute("listErreur");
		if (lst == null){%>
			<% if (lstMsg != null){
				for (String element : lstMsg){%>
			<p><%=element %></p>
		<%}
		} 
			}else { %>
		
		<div class="Listes">
			<form method="get" action="./ServletAccueil">
	 
	  	<%for (LstCourse element : lst){%>
			<p><%=element.getNom() %></p>
			<button type="submit" name="butt" value="cart<%=element.getIdLstCourse()%>"> 
				<span class="material-symbols-outlined">
					shopping_cart
				</span>
			</button>
			<button type="submit" name="butt" value="delete<%=element.getIdLstCourse()%>">
				<span class="material-symbols-outlined">
					delete_forever
				</span>
			</button>
		<%}
	 		}%>
			</form>
		</div>
		
		<footer>
			<form method="post" action="./ServletAccueil">
				<button type="submit" value="cart"> 
					<span class="material-symbols-outlined">
						add_circle
					</span>
				</button>
			</form>
		</footer>
	
	</body>
</html>