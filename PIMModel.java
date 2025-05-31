package mod09_OYO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The PIMModel class handles database operations related to employees and departments. It
 * provides methods to retrieve, add, and manage data related to employees and departments. The
 * class uses the Singleton design pattern to ensure a single instance of the database connection.
 * 
 * @author angel
 */
public class PIMModel {

	// Singleton instance
	private static PIMModel instance = null;

	// Connection counter to track the number of active instances
	private static int counter = 0;

	// Database connection object
	private static Connection DBConn = null;

	// Prepared statements for various queries
	private static PreparedStatement queryEmployeeList = null;
	private static PreparedStatement queryEmployeeAdd = null;
	private static PreparedStatement queryDepartmentsList = null;
	private static PreparedStatement queryDepartmentsAdd = null;

	// Database connection details
	private final String DBDriver = "com.mysql.cj.jdbc.Driver"; // MySQL JDBC Driver
	private final String DBURL = "jdbc:mysql://localhost:3306/CMSC230"; // Database URL
	private final String DBUser = "root"; // Database username
	private final String DBPassword = "Password!!"; // Database password

	/**
	 * Constructor to establish a database connection. If the
	 * connection is not already established, it will create one.
	 *
	 * @throws SQLException           If an error occurs while establishing the connection.
	 * @throws ClassNotFoundException If the JDBC driver class is not found.
	 */
	public PIMModel() throws SQLException, ClassNotFoundException {
		if (DBConn == null) {
			Class.forName(DBDriver); // Load JDBC driver
			DBConn = DriverManager.getConnection(DBURL, DBUser, DBPassword); // Establish the connection
		}
		counter++; // Increment connection counter
	}

	/**
	 * Returns the singleton instance of the PIMModel class. Ensures
	 * that only one instance of the database connection exists.
	 *
	 * @return The singleton instance of PIMModel.
	 * @throws ClassNotFoundException If the JDBC driver class is not found.
	 * @throws SQLException           If an error occurs while establishing the connection.
	 */
	public static synchronized PIMModel getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			synchronized (PIMModel.class) {
				if (instance == null) {
					instance = new PIMModel(); // Create the instance if it does not exist
				}
			}
		}
		return instance;
	}

	/**
	 * Closes the database connection if no more references
	 * exist. This method ensures proper resource cleanup.
	 *
	 * @throws SQLException If an error occurs while closing the connection.
	 */
	public void close() throws SQLException {
		counter--; // Decrease the reference count
		if (counter == 0 && DBConn != null) {
			DBConn.close(); // Close the connection if no references are left
		}
	}

	/**
	 * Prepares the SQL statement for execution. If the prepared statement is already
	 * created, returns the existing one. Otherwise, it creates a new prepared statement.
	 *
	 * @param query             The SQL query string.
	 * @param preparedStatement The prepared statement to be used or created.
	 * @return The prepared statement.
	 * @throws SQLException     If an error occurs while preparing the statement.
	 */
	private PreparedStatement prepareStatement(String query, PreparedStatement preparedStatement) throws SQLException {
		if (preparedStatement == null) {
			return DBConn.prepareStatement(query); // Create a new prepared statement if it does not exist
		}
		return preparedStatement; // Return the existing prepared statement
	}

	/**
	 * Retrieves the list of all employees from the database.
	 *
	 * @return A list of Employee objects.
	 * @throws SQLException If an error occurs while fetching employee data.
	 */
	public List<Employee> getEmployees() throws SQLException {
		String employeeQuery = """
				SELECT employee_id, first_name, last_name, department_id, salary
				FROM employees
				ORDER BY employee_id
				""";
		queryEmployeeList = prepareStatement(employeeQuery, queryEmployeeList); // Prepare the SQL statement
		ResultSet results = queryEmployeeList.executeQuery(); // Execute the query

		List<Employee> employees = new ArrayList<>();
		try {
			while (results.next()) {
				// Add each employee to the list
				employees.add(new Employee(
						results.getInt("employee_id"),
						results.getString("first_name"),
						results.getString("last_name"),
						results.getInt("department_id"),
						results.getDouble("salary")
						));
			}
		} finally {
			results.close(); // Ensure the ResultSet is closed to avoid resource leaks
		}
		return employees; // Return the list of employees
	}

	/**
	 * Adds a new employee to the database.
	 *
	 * @param employee      The employee object to be added to the database.
	 * @throws SQLException If an error occurs while inserting the employee data.
	 */
	public void addEmployee(Employee employee) throws SQLException {
		String employeeInsertQuery = """
				INSERT INTO employees (first_name, last_name, department_id, salary)
				VALUES (?, ?, ?, ?)
				""";
		queryEmployeeAdd = prepareStatement(employeeInsertQuery, queryEmployeeAdd); // Prepare the SQL statement

		// Set the parameters for the prepared statement
		queryEmployeeAdd.setInt(1, employee.getEmployeeId());
		queryEmployeeAdd.setString(2, employee.getFirstName());
		queryEmployeeAdd.setString(3, employee.getLastName());
		queryEmployeeAdd.setInt(4, employee.getDepartmentId());
		queryEmployeeAdd.setDouble(5, employee.getSalary());

		queryEmployeeAdd.executeUpdate(); // Execute the insert statement
	}

	/**
	 * Retrieves the list of all departments from the database.
	 *
	 * @return A list of Department objects.
	 * @throws SQLException If an error occurs while fetching department data.
	 */
	public List<Department> getDepartments() throws SQLException {
		String departmentQuery = """
				SELECT department_id, department_name, location
				FROM departments
				ORDER BY department_id
				""";
		queryDepartmentsList = prepareStatement(departmentQuery, queryDepartmentsList); // Prepare the SQL statement
		ResultSet results = queryDepartmentsList.executeQuery(); // Execute the query

		List<Department> departments = new ArrayList<>();
		try {
			while (results.next()) {
				// Add each department to the list
				departments.add(new Department(
						results.getInt("department_id"),
						results.getString("department_name"),
						results.getString("location")
						));
			}
		} finally {
			results.close(); // Ensure the ResultSet is closed to avoid resource leaks
		}
		return departments; // Return the list of departments
	}

	/**
	 * Adds a new department to the database.
	 *
	 * @param department    The department object to be added to the database.
	 * @throws SQLException If an error occurs while inserting the department data.
	 */
	public void addDepartment(Department department) throws SQLException {
		String departmentInsertQuery = """
				INSERT INTO departments (department_name, location)
				VALUES (?, ?)
				""";
		queryDepartmentsAdd = prepareStatement(departmentInsertQuery, queryDepartmentsAdd); // Prepare the SQL statement

		// Set the parameters for the prepared statement
		queryDepartmentsAdd.setInt(1, department.getDepartmentId());
		queryDepartmentsAdd.setString(2, department.getDepartmentName());
		queryDepartmentsAdd.setString(3, department.getLocation());

		queryDepartmentsAdd.executeUpdate(); // Execute the insert statement
	}
}
