<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<fieldset>
<legend>Delete</legend>
<form action="REST/WebService/delete" method="post" >

<div>
Email:
<input type="text"  name="email" placeholder="Enter Email" required />
</div>
<br>

<div>
Username:
<input type="text"  name="username" placeholder="Enter Username" required/>
</div>
<br>
<input type="submit" value="submit" name="submit" />


</form>
</fieldset>
</center>
</body>
</html>