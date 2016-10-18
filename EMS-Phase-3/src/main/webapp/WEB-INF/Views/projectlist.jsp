<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<table>
<tr>
<td>Project: </td>
	<td>
	<c:if test="${!empty projectli}">
	<c:forEach items="${projectli}" var="pro">
		<option value="${pro.id}">${pro.name}</option>
	</c:forEach>
	</c:if>
	</td>
	<tr>
</table>

</body>
</html>