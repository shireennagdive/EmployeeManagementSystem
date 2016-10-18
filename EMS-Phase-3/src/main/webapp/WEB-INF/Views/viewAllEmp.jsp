<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="JavaScript">
      function checkAll(field)
      {
          for (i=0; i < field.length; i++)
          {
              field[i].checked = true;
          }
      }
  </script>
<title>Employees</title>
</head>
<body>
	 <p><a href="employeeForm">[ADD EMPLOYEE]</a></p>
	<h1 align="center"><b>Employee Management System</b></h1>
	<br>
	
	<fieldset style="width: 200px">
	<legend><b>Search</b></legend>
	<form action="searchEmp" method="post">
	
	<br>
		By EmployeeId: <input type="text" name="searchval"
			value='${searchval}' /><br>
		<br> <input type="submit" name="search" value="Search" onclick="load()"><br>
		<br>
		<br>
		<c:if test="${!empty semp }">
		 <table id="searchemp" border="" bordercolor="pink">
			
			<c:forEach items='${semp}' var='employee'>
			<c:if test="${employee==null}">
				<h4 style="color: red; font-weight: bold" >Employee Not found</h4>
			</c:if>
			<c:if test="${employee!=null}">
			<tr>
			<th>ID</th>
			<th>Name</th>
			<th>KinID</th>
			<th>EmailID</th>
			<th>Phone Number</th>
			<th>Date Of Birth</th>
			<th>Date of joining</th>
			<th>Address</th>
			<th>Department</th>
			<th>Role</th>
			<th>Project</th>
			<th>Edit</th>
			<th>Delete</th>
			</tr> 
			<tr>
			<td>${employee.empId}</td>
			<td>${employee.name}</td>
			<td>${employee.kinid}</td>
			<td>${employee.emailid}</td>
			<td>${employee.phoneno}</td>
			<td>${employee.empDob}</td>
			<td>${employee.empDoj}</td>
			<td>${employee.address}</td>
			<td>${employee.department}</td>
			<td>${employee.role}</td>
			<td>${employee.project}</td>
			<td><a href="edit?id=${employee.empId}">Update</a></td>
			<td>
				<a href="deleteEmployee?id=${employee.empId}">Delete</a>
				&nbsp;&nbsp;&nbsp;
			</td>
			
		</tr>
		</c:if>
			</c:forEach>
		</table>
		<br><br>
		<a href="showEmp">[Back to List]</a>
		</c:if>

		<script type="text/javascript">
	  $(document).ready(function(){
		  $("#searchemp").hide();
		  $("#allemp").show();

		     	$("#searchsubmit").click(function(){
		     		$("#allemp").hide();
		     		
		     		$("#searchemp").show();

		     	});
		});
	  </script>
	</form>
	</fieldset>
	<br><br>
	<c:if test="${!empty employees }">
	<fieldset>
	<legend><b>All Employees</b></legend>
	<form name="deleteForm" method="post" action="deleteEmployee">
		<table  id="allemp" border="" bordercolor="blue">
		
	<tr>
      <th><a href="javascript:checkAll(document.deleteForm.id)">Select All</a></th>
      <th>Edit</th>
      <th>KinID</th>
      <th>Name</th>
      <th>EmailId</th>
      <th>Phone Number</th>
      <th>Date of Birth</th>
      <th>Date of joining</th>
      <th>Address</th>
      <th>Role</th>
      <th>Department</th>
      <th>Project</th>
    </tr> 

			<c:forEach items='${employees}' var='emp'>
				<tr>
					<td><input type="checkbox" name="id" value="${emp.empId}">${emp.empId}</td>
					<td><a href="edit?id=${emp.empId}">Edit</a></td>
					<td>${emp.kinid}</td>
					<td>${emp.name}</td>
					<td>${emp.emailid}</td>
					<td>${emp.phoneno}</td>
					<td>${emp.empDob}</td>
					<td>${emp.empDoj}</td>
					<td>${emp.address}</td>
					<td>${emp.role}</td>
					<td>${emp.department}</td>
					<td>${emp.project}</td>
				</tr>
			</c:forEach>
 
			<!-- <tr style="border-color: white">
				<td colspan="5">
				<input type="submit" name="Delete Checked" value="Delete Checked" /> 
				&nbsp;&nbsp;
			<input type="reset" name="Reset" value="Reset"/>
				</td>
			</tr>  -->

		</table>
		<br><br>
		 <input type="submit" name="Delete Checked" value="Delete Checked" /> 
				&nbsp;&nbsp;
			<input type="reset" name="Reset" value="Reset"/> 
	</form>
	</fieldset>
	</c:if>
</body>
</html>