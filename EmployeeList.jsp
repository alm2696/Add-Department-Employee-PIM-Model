<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList,mod09_OYO.PIMModel,mod09_OYO.Employee,mod09_OYO.EmployeeList"%>
<html>
<head>
<title>Employees: List</title>
</head>
<body>
	<h1>Employee List</h1>

	<%
        // Create an instance of PIMModel to interact with the model layer
        PIMModel model = new PIMModel();
        ArrayList<Employee> employees = null;  // Declare the list of employees
        String errorMessage = null;  // Declare an error message variable
        
        try {
            // Retrieve the list of employees from the model
            employees = (ArrayList<Employee>) model.getEmployees();
        } catch (Exception e) {
            // If an exception occurs, set the error message
            errorMessage = "Error retrieving the employee list: " + e.getMessage();
        }
    %>

	<%
        // If an error message exists, display it to the user
        if (errorMessage != null) {
    %>
    <!-- Display the error message -->
	<h2><%= errorMessage %></h2>
	<%
        } else {
    %>
	<!-- Display the employee list in a table if no error occurred -->
	<table border="1">
		<thead>
			<tr>
				<!-- Employee ID -->
				<th>ID</th>
				<!-- Employee Name -->
				<th>Name</th>
				<!-- Department ID -->
				<th>Department ID</th>
				<!-- Employee Salary -->
				<th>Salary</th>	
			</tr>
		</thead>
		<tbody>
			<%
                    // Loop through the list of employees and display each one in a table row
                    for (Employee employee : employees) {
                %>
			<tr>
				<!-- Display each employee's information in the corresponding column -->
				<td><%= employee.getEmployeeId() %></td>
				<td><%= employee.getFirstName() + " " + employee.getLastName() %></td>
				<td><%= employee.getDepartmentId() %></td>
				<td><%= employee.getSalary() %></td>
			</tr>
			<%
                    }
                %>
		</tbody>
	</table>
	<%
        }
    %>
    
	<!-- Link to go back to the home page -->
	<p>
		<a href="index.html">Back to Home</a>
	</p>
</body>
</html>
