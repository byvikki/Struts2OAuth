<%@ page language="java" contentType="text/html; charset=ISO-8859-1" session="false"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is the First App</title>
</head>
<body>
	<h2>This is the First app from the JSP</h2>

	<p>
		Link to Hello World Action Class <a href="<s:url action='hello'/>">
			Click here</a>
	</p>



	<s:url value="https://accounts.google.com/o/oauth2/auth"
		var="googleLink">
		<s:param name="response_type">code</s:param>
		<s:param name="client_id">250936567640.apps.googleusercontent.com</s:param>
		<s:param name="redirect_uri">http://localhost:8080<s:url
				action="hello"></s:url>?with=google</s:param>
		<s:param name="scope">https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/plus.login</s:param>
	</s:url>


	<s:url value="https://www.facebook.com/dialog/oauth" var="fbLink">
		<s:param name="client_id">185354518239982</s:param>
		<s:param name="redirect_uri">http://localhost:8080<s:url
				action="hello"></s:url>?with=fb</s:param>
	</s:url>
	<p>Login With Google</p>
	<a href="${googleLink}">${googleLink}</a>


	<p>Login With FaceBook</p>
	<a href="${fbLink}">${fbLink}</a>
	<br />
	<img src="https://graph.facebook.com/100000069827486/picture" />


</body>
</html>