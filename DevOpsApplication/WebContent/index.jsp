<%@page import="org.quinnox.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="org.quinnox.dao.DashBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dockers Demo</title>
</head>
<body>
	<img src="./images/docker_mysql.png" width="300" height="200">
	<%List<Employee> employeeList; %>
	<%DashBoardDAO dao = new DashBoardDAO();
	  employeeList = dao.getFileList();
	%>
	<h2 align="center">INFORMATION FROM DOCKER CONTAINER DATABASE</h2>
	<table width="400" border="3" align="center" style="margin-top: 100px;" width="50px;">
		<tr>
			<td><b> ID </b></td>
			<td><b> NAME </b></td>
			<td><b> ADDRESS </b></td>
		</tr>
		<%for(Employee emp : employeeList){%> 
		<tr>
			<td><%=emp.getId()%></td>
			<td><%=emp.getName()%></td>
			<td><%=emp.getAddress()%></td>
		</tr>
		<% }%>
		
	</table>
	
</body>
</html>