<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
				<td>Id</td>
				<td>Marque</td>
				<td>Modele</td>
				<td>date</td>
				<td>email</td>
				<td>Action</td>
			</tr>
<c:forEach var="v" items="${voitures}">
<tr>
<td>${v.id}</td>
<td>${v.marque}</td>
<td>${v.model}</td>
<td>${v.date}</td>
<td>${v.email}</td>
<td><a href="delete.do?id=${v.id}">delete</a></td>

</tr>


				
			</c:forEach>
			
</table>
<a href="edit.do">edit</a>			
</body>
</html>