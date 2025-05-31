<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList,mod09_OYO.PIMModel,mod09_OYO.Department,mod09_OYO.DepartmentList"%>
<html>
<head>
<title>Departments: Add</title>
</head>
<body>
	<h2>Add a Department</h2>

	<!-- Form to add a new department -->
	<form method="POST" action="DepartmentAdd">
		<!-- Input for department name with validation for maximum length and required field -->
		Department Name: <input type="text" name="department_name" maxlength="50" required><br>

		<!-- Input for location with validation for maximum length and required field -->
		Location: <input type="text" name="location" maxlength="50" required><br>

		<!-- Submit button to insert the department -->
		<input type="submit" value="Insert">
	</form>

	<!-- Link to go back to the home page -->
	<p>
		<a href="index.html">Back to Home</a>
	</p>
</body>
</html>
