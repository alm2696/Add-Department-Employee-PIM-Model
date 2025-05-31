package mod09_OYO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The EmployeeAdd servlet handles both the GET and POST requests for adding an
 * employee. GET request: Displays the form for adding an employee. POST request: 
 * Processes the form submission and adds a new employee to the database.
 * 
 * @author angel
 */
@WebServlet("/EmployeeAdd")
public class EmployeeAdd extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Handles GET requests to display the form for adding a new employee.
     * 
     * @param request           The HTTP request object containing the client request.
     * @param response          The HTTP response object to send the response to the client.
     * @throws ServletException If an error occurs while handling the request.
     * @throws IOException      If an input/output error occurs during the request handling.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the EmployeeAdd.jsp page for displaying the form
        request.getRequestDispatcher("/WEB-INF/jsp/EmployeeAdd.jsp").forward(request, response);
    }

    /**
     * Handles POST requests to process the form submission for adding a new
     * employee. Extracts form data, creates a new Employee object, and adds it to
     * the database. If an error occurs, the request is forwarded to an error page.
     * 
     * @param request           The HTTP request object containing the form data submitted by the client.
     * @param response          The HTTP response object to send the response to the client.
     * @throws ServletException If an error occurs during the processing of the form.
     * @throws IOException      If an input/output error occurs during the request handling.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve form parameters
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            int departmentId = Integer.parseInt(request.getParameter("department_id"));
            double salary = Double.parseDouble(request.getParameter("salary"));

            // Create a new employee object without an employee_id
            Employee employee = new Employee(firstName, lastName, departmentId, salary);

            // Get the instance of the PIMModel and add the employee
            PIMModel model = PIMModel.getInstance();
            model.addEmployee(employee);

            // Redirect to the employee list page after successful addition
            response.sendRedirect("EmployeeList");
            
        } catch (Exception e) {
            // In case of an error, set the exception as an attribute and forward to the error page
            request.setAttribute("javax.servlet.error.exception", e);
            request.getRequestDispatcher("/WEB-INF/jsp/Error.jsp").forward(request, response);
        }
    }
}
