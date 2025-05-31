package mod09_OYO;

/**
 * The Department class represents a department in the organization.
 * It holds details such as department ID, name, and location.
 * 
 * @author angel
 */
public class Department {

    private int department_id;  // Unique identifier for the department
    private String department_name;  // Name of the department
    private String location;  // Location of the department

    /**
     * Constructor to create a Department object without an ID. The department_id
     * will be auto-generated when the department is added to the database.
     *
     * @param department_name The name of the department.
     * @param location        The location of the department.
     */
    public Department(String department_name, String location) {
        this.department_name = department_name;
        this.location = location;
    }

    /**
     * Constructor to create a Department object with an ID.
     *
     * @param department_id   The unique ID of the department.
     * @param department_name The name of the department.
     * @param location        The location of the department.
     */
    public Department(int department_id, String department_name, String location) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.location = location;
    }

    /**
     * Getter for the department ID.
     * 
     * @return The unique identifier of the department.
     */
    public int getDepartmentId() {
        return department_id;
    }

    /**
     * Setter for the department ID.
     * 
     * @param department_id The unique identifier of the department.
     */
    public void setDepartmentId(int department_id) {
        this.department_id = department_id;
    }

    /**
     * Getter for the department name.
     * 
     * @return The name of the department.
     */
    public String getDepartmentName() {
        return department_name;
    }

    /**
     * Setter for the department name.
     * 
     * @param department_name The name of the department.
     */
    public void setDepartmentName(String department_name) {
        this.department_name = department_name;
    }

    /**
     * Getter for the department location.
     * 
     * @return The location of the department.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setter for the department location.
     * 
     * @param location The location of the department.
     */
    public void setLocation(String location) {
        this.location = location;
    }
}
