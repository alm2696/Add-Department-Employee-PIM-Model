package mod09_OYO;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The EmployeeList servlet retrieves the list of employees from
 * the PIMModel and forwards the data to a JSP page for rendering.
 * It also handles errors by forwarding them to an error JSP page.
 * 
 * @author angel
 */
@WebServlet("/EmployeeList")
public class EmployeeList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for the EmployeeList servlet.
	 */
	public EmployeeList() {
		super();
	}

	/**
	 * Handles GET requests to retrieve a list of employees and forwards the data to the JSP
	 * page for rendering. If an error occurs, the request is forwarded to an error JSP page.
	 * 
	 * @param request           The HTTP request object containing the client request.
	 * @param response          The HTTP response object to send the response to the client.
	 * @throws ServletException If an error occurs during the processing of the request.
	 * @throws IOException      If an input/output error occurs during the request handling.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Get the instance of PIMModel
			PIMModel model = PIMModel.getInstance();

			// Retrieve the list of employees from the model
			List<Employee> employees = model.getEmployees();

			// Set the list of employees as a request attribute to be accessed in the JSP
			request.setAttribute("employees", employees);

			// Forward the request and response to the EmployeeList.jsp page for rendering
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/jsp/EmployeeList.jsp");
			dispatcher.forward(request, response);
		} catch (Exception exception) {
			// If an error occurs, create a ServletException and forward it to the error JSP page
			ServletException error = new ServletException("Error while generating the Employee List", exception);

			// Set the exception as a request attribute
			request.setAttribute("exception", error);

			// Forward the request and response to the Error.jsp page
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/jsp/Error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
