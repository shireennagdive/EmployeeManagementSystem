<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UserServlet" method="POST">
<table>
<tr>
<th>EmpID</th>
<th>Name</th>
<th>KinID</th>
<th>EmailID</th>
<th>Adress</th>
<th>PhoneNumber</th>
<th>DateOfBirth</th>
<th>DateOfJoining</th>
<th>DepartmentID</th>
<th>ProjectID</th>
<th>RoleID</th>
</tr>
<c:forEach items='${empList}' var='emp'>
<tr>
<td>${emp.getEmp_Id() }</td>
<td>${emp.getName() }</td>
<td>${emp.getKin_Id() }</td>
<td>${emp.getEmail_id()}</td>
<td>${emp.getAdress() }</td>
<td>${emp.getPhone_no() }</td>
<td>${emp.getDateofbirth() }</td>
<td>${emp.getDateofjoin() }</td>
<td>${emp.getDepartmentId() }</td>
<td>${emp.getProjecttId() }</td>
<td>${emp.getRoleId() }</td>
<td></td>
</tr>
</table>
</c:forEach>

<input type="submit" name="action" value="getAll"/>
</form>
</body>
</html>