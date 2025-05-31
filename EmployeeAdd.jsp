<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList,mod09_OYO.PIMModel,mod09_OYO.Employee,mod09_OYO.EmployeeList"%>
<html>
<head>
<title>Employees: Add</title>
</head>
<body>
	<h2>Add an Employee</h2>

	<%
	String errorMessage = (String) request.getAttribute("errorMessage");
	if (errorMessage != null) {
	%>
	<p class="error"><%=errorMessage%></p>
	<%
	}
	%>

	<form method="POST" action="EmployeeAdd">

		<label for="first_name">First Name:</label> <input type="text"
			id="first_name" name="first_name" required><br> <label
			for="last_name">Last Name:</label> <input type="text" id="last_name"
			name="last_name" required><br> <label
			for="department_id">Department ID:</label> <input type="number"
			id="department_id" name="department_id" min="1" required><br>

		<label for="salary">Salary:</label> <input type="number" id="salary"
			name="salary" step="0.01" min="0.01" required><br> <input
			type="submit" value="Insert">
	</form>
	<p>
		<a href="index.html">Back to Home</a>
	</p>
</body>
</html>
