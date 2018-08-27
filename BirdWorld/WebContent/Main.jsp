<%@ 
page language="java" 
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
import="GameLogic.Card, GameLogic.Pile"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World - JSP tutorial</title>
</head>
<body>
<%
	int[] attributes = {1, 2, 3, 4, 5};
	Card card = new Card("Robin", attributes, " ");
	Pile pile = new Pile();
	
	Card newCard = pile.draw();
	out.print(newCard.getBirdName());
%>
</body>
</html>