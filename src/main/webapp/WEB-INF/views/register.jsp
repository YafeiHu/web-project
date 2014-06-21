<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<form action="user/register" method="post">
username<input type="text" name="username">
password<input type="text" name="password">
email<input type="text" name="email">
<input type="submit">
</form>
</body>
</html>
