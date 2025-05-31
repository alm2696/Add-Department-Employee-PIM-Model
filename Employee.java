package mod09_OYO;

/**
 * The Employee class contains information such as the employee's ID, first name, last name,
 * department ID, and salary. It provides constructors for creating employees with or
 * without an ID, getter and setter methods for all fields, and utility methods.
 * 
 * @author angel
 */
public class Employee {

	private int employee_id;
	private String first_name;
	private String last_name;
	private int department_id;
	private double salary;

	/**
	 * Constructor for creating an Employee without ID.
	 * The employee ID will be set later by the database.
	 * 
	 * @param first_name    The employee's first name.
	 * @param last_name     The employee's last name.
	 * @param department_id The ID of the department to which the employee belongs.
	 * @param salary        The employee's salary.
	 */
	public Employee(String first_name, String last_name, int department_id, double salary) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.department_id = department_id;
		this.salary = salary;
	}

	/**
	 * Constructor for creating an Employee with an ID.
	 * 
	 * @param employee_id   The unique ID of the employee.
	 * @param first_name    The employee's first name.
	 * @param last_name     The employee's last name.
	 * @param department_id The ID of the department to which the employee belongs.
	 * @param salary        The employee's salary.
	 */
	public Employee(int employee_id, String first_name, String last_name, int department_id, double salary) {
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.department_id = department_id;
		this.salary = salary;
	}

	// Getter and setter methods

	/**
	 * Gets the employee's ID.
	 * 
	 * @return The employee's ID.
	 */
	public int getEmployeeId() {
		return employee_id;
	}

	/**
	 * Sets the employee's ID.
	 * 
	 * @param employee_id The employee's ID.
	 */
	public void setEmployeeId(int employee_id) {
		this.employee_id = employee_id;
	}

	/**
	 * Gets the employee's first name.
	 * 
	 * @return The employee's first name.
	 */
	public String getFirstName() {
		return first_name;
	}

	/**
	 * Sets the employee's first name.
	 * 
	 * @param first_name The employee's first name.
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * Gets the employee's last name.
	 * 
	 * @return The employee's last name.
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * Sets the employee's last name.
	 * 
	 * @param last_name The employee's last name.
	 */
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * Gets the department ID to which the employee belongs.
	 * 
	 * @return The department ID.
	 */
	public int getDepartmentId() {
		return department_id;
	}

	/**
	 * Sets the department ID. Ensures the department ID is positive.
	 * 
	 * @param department_id             The department ID.
	 * @throws IllegalArgumentException If the department ID is non-positive.
	 */
	public void setDepartmentId(int department_id) {
		if (department_id <= 0) {
			throw new IllegalArgumentException("Department ID must be a positive integer.");
		}
		this.department_id = department_id;
	}

	/**
	 * Gets the employee's salary.
	 * 
	 * @return The employee's salary.
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Sets the employee's salary. Ensures the salary is non-negative.
	 * 
	 * @param salary                    The employee's salary.
	 * @throws IllegalArgumentException If the salary is negative.
	 */
	public void setSalary(double salary) {
		if (salary < 0) {
			throw new IllegalArgumentException("Salary cannot be negative.");
		}
		this.salary = salary;
	}

	// Override methods

	/**
	 * Returns a string representation of the Employee object, which
	 * includes the employee's ID, name, department ID, and salary.
	 * 
	 * @return A string representation of the Employee object.
	 */
	@Override
	public String toString() {
		return "Employee ID: " + employee_id + ", Name: " + first_name + " " + last_name +
				", Department ID: " + department_id + ", Salary: $" + salary;
	}

	/**
	 * Compares this Employee object to another object for equality. Two
	 * Employee objects are considered equal if they have the same employee ID.
	 * 
	 * @param obj   The object to compare this Employee to.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;  // Check if the objects are the same reference
		if (obj == null || getClass() != obj.getClass()) return false;  // Check for null and class mismatch
		Employee employee = (Employee) obj;
		return employee_id == employee.employee_id;  // Compare employee IDs
	}

	/**
	 * Returns a hash code for this Employee object. The hash code is based on the employee ID.
	 * 
	 * @return The hash code for this Employee object.
	 */
	@Override
	public int hashCode() {
		return Integer.hashCode(employee_id);  // Hash based on employee ID
	}
}
