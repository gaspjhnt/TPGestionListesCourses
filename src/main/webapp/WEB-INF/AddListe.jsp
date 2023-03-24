<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COURSES</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
</head>
	<body>
		<header>
			<h1>COURSES</h1>
			<h4>Nouvelle liste</h4>
		</header>
		
		<%boolean articleBool = (boolean) request.getAttribute("articleBool");
		String valueLst = (String) request.getAttribute("valueLst");%>
		
		<div class="formNomDeLaList">
			<form method="post" action="./ServletAddList">
				<div class="nomDeLst">
				
					<%if (articleBool){ %>
						<p>Nom de la liste</p>
						<label for="input_nomList"></label><input id="input_nomList" type="text" name="nomLst" required/> 		
						<p>Articles</p>	
						<label for="input_nomArticle"></label><input id="input_nomArticle" type="text" name="nomArticle" required disabled/>
						
					<%} else {%>
						<p>Nom de la liste</p>
						<p><%=valueLst %></p>		
						<p>Articles</p>	
						<label for="input_nomArticle"></label><input id="input_nomArticle" type="text" name="nomArticle" required/>
					<%} %>
					
					<button type="submit" value="valider"> 
						<span class="material-symbols-outlined">
							add_circle
						</span>
					</button>
				</div>
			</form>
		</div>
		
<!-- 		<div  class="affichageArt"> -->
<!-- 			<p> article 1</p> -->
<!-- 		</div> -->
		
		
<!-- 		<div class="formArticles">			 -->
<!-- 			<form method="get" action="./ServletAddList"> -->
<!-- 				<div class="nomArticle"> -->
<!-- 					<p>Article :</p> -->

<!-- 				</div> -->
<!-- 			</form> -->
<!-- 		</div> -->
		
		
		<footer>
			<form method="get" action="./ServletAddList">
				<button type="submit" value="cart"> 
					<span class="material-symbols-outlined">
						undo
					</span>
				</button>
			</form>
		</footer>
	</body>
</html>