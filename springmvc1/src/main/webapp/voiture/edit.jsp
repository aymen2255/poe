<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="save.do" method="POST" commandName="voiture">
	
	
		<table>
			<tr>
				<td>id</td>
				<td>Marque</td>
				<td>Modele</td>
				<td>date</td>
				<td>email</td>
			</tr>
			<tr>
			<td><form:input path="id" /><form:errors path="id"/></td>
				<td><form:input path="marque" /><form:errors path="marque"/></td>
				<td><form:input path="model" /><form:errors path="model"/></td>
				<td><form:input path="date" /><form:errors path="date"/></td>
				<td><form:input path="email" /><form:errors path="email"/></td>
			</tr>
		</table>
		<input type="submit" value="valider">
	</form:form>


</body>
</html>