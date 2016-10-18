<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.errmsg{
	color: red;
	font-size: 14px;
	font-weight: bold;
}
</style>
<script>
	function showProject(str) {
    if (str == "") {
        document.getElementById("pro").innerHTML = "";
        return;
    } else { 
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("pro").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET","showpro?q="+str,true);
        xmlhttp.send();
    }
}
</script>
<title>Add Employees</title>
</head>
<body style="margin-left: 20px">
	<p>
		<a href="showEmp">[Back]</a>
	</p>
	<h1 align="center"><b>Employee Management System</b></h1>
	<br>
	<fieldset style="width: 300px; margin-left: 20px">
	<legend><b>Employee Form</b></legend>
	<br>
	<form:form commandName="emp" action="empSave" method="post">
		<form:input type="hidden" path="empId" value="${emp.empId}"/>
		<table style="width: 400px">
			<tr>
				<td>KinID<font color="red"><sup>*</sup></font>
				</td>
				<td><form:input type="text" path="kinid" value="${emp.kinid}" /></td>
				<td>
					<form:errors path="kinid" cssClass="errmsg"/>
				</td>
			</tr>
			<tr></tr><tr></tr>
			<tr>
				<td>Name<font color="red"><sup>*</sup></font></td>
				<td><form:input type="text" path="name" value="${emp.name}" /></td>
				<td>
					<form:errors path="name" cssClass="errmsg"/>
				</td>
			</tr>
			<tr></tr><tr></tr>
			<tr>
				<td class="emailid">EmailId<font color="red"><sup>*</sup></font></td>
				<td><form:input type="text" path="emailid" value="${emp.emailid}" /></td>
				<td>
					<form:errors path="emailid" cssClass="errmsg"/>
				</td>
			</tr>
			<tr></tr><tr></tr>
			<tr>
				<td>Phone Number</td>
				<td><form:input type="text" path="phoneno" value="${emp.phoneno}" /></td>
						<td>
					<form:errors path="phoneno" cssClass="errmsg"/>
				</td>
			</tr>
			<tr></tr><tr></tr>
			<tr>
				<td>Date Of Birth</td>
				<td><form:input type="text" path="empDob" value="${emp.empDob}" /></td>
				<td>
					<form:errors path="empDob" cssClass="errmsg"/>
				</td>
			</tr>
			<tr></tr><tr></tr>
			<tr>
				<td>Date Of Joining</td>
				<td><form:input type="text" path="empDoj" value="${emp.empDoj}" /></td>
				<td>
					<form:errors path="empDoj" cssClass="errmsg"/>
				</td>
			</tr>
			<tr></tr><tr></tr>
			<tr>
				<td>Address</td>
				<td><form:input type="text" path="address" value="${emp.address}" /></td>
				<td>
				</td>
				<td>
				</td>
			</tr>
			<tr></tr><tr></tr>
			<tr>
			<td>Role</td>
			<td>
			<c:if test="${!empty roles }">
				<form:select id="role" path="role">
				<option>---Select---</option>
				<c:forEach items="${roles}" var="role">
						<form:option value="${role.id}">${role.name}</form:option>
				</c:forEach>
				</form:select>
			</c:if>
			</td>
			<td>
			</td>
		</tr>
		<tr></tr><tr></tr>
		<tr>
			<td><label for="department">Departments</label></td>
			<td>
			<c:if test="${!empty deps }">
				 <form:select id="department" path="department" onchange="showProject(this.value)"> 
				<option>---Select---</option>
				<c:forEach items="${deps}" var="dept">
					<form:option value="${dept.id}">${dept.name}</form:option>
					</c:forEach> 
				
				</form:select> 
			</c:if>
			</td>
			<td>
			</td>
		</tr>
		<tr></tr><tr></tr>
		
		<tr>
		<td>Project:</td> 
		<td>
		<form:select id="pro" path="project">
		 <c:if test="${ emp.project==null}">
		<option value="---Select---">---Select---</option> </c:if>
		 <c:if test="${ emp.project!=null}">
		<option value="${emp.project.id}">${emp.project.name }</option></c:if> 
		</form:select>
		</td>
	
		</tr>
		
		<tr></tr>
		<tr></tr>
		<tr></tr>
			
			<!-- Save/Reset buttons -->
			<tr>
				<td colspan="2"><input type="submit" name="save" value="Save" />
					&nbsp;&nbsp; <input type="reset" name="reset" value="Reset" /></td>
			</tr>
		</table>
	</form:form>
	</fieldset>
</body>
</html>