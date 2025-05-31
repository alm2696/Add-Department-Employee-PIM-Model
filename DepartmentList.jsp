<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList,mod09_OYO.PIMModel,mod09_OYO.Department,mod09_OYO.DepartmentList"%>
<html>
<head>
<title>Departments: List</title>
</head>
<body>
	<h1>Departments List</h1>

	<%
        // Initialize the model to interact with the data source
        PIMModel model = new PIMModel();
        ArrayList<Department> departments = null;  // Declare the list of employees
        String errorMessage = null;  // Declare an error message variable

        try {
            // Attempt to retrieve the list of departments from the model
            departments = (ArrayList<Department>) model.getDepartments();
        } catch (Exception e) {
            // If an error occurs, store the error message for display
            errorMessage = "Error retrieving the department list: " + e.getMessage();
        }
    %>

	<%
        // Check if there's an error message and display it
        if (errorMessage != null) {
    %>
	<!-- Display the error message if retrieval failed -->
	<h2><%= errorMessage %></h2>
	<%
        } else {
    %>
	<!-- If no error, display the departments in a table -->
	<table border="1">
		<thead>
			<tr>
				<!-- Table headers for the department ID, name, and location -->
				<th>ID</th>
				<th>Name</th>
				<th>Location</th>
			</tr>
		</thead>
		<tbody>
			<%
                    // Loop through each department in the list and display its details
                    for (Department department : departments) {
                %>
			<tr>
				<!-- Display department details in table rows -->
				<td><%= department.getDepartmentId() %></td>
				<td><%= department.getDepartmentName() %></td>
				<td><%= department.getLocation() %></td>
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
