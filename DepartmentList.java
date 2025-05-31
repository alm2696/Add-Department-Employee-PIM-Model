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
 * The DepartmentList servlet handles HTTP GET requests for displaying the list
 * of departments. It retrieves department data from the model, sets it as a
 * request attribute, and forwards the request to a JSP page for rendering.
 * 
 * @author angel
 */
@WebServlet("/DepartmentList")
public class DepartmentList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for the DepartmentList servlet.
	 */
	public DepartmentList() {
		super();
	}

	/**
	 * Handles GET requests to display the department list. It retrieves
	 * the list of departments from the model, sets the list as a request
	 * attribute, and forwards the request to the JSP page for rendering.
	 *
	 * @param request           The HttpServletRequest object that contains the client's request.
	 * @param response          The HttpServletResponse object used to send the response to the client.
	 * @throws ServletException If an error occurs during servlet processing.
	 * @throws IOException      If an input or output error occurs while handling the request.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// Get the model instance to interact with the database
			PIMModel model = PIMModel.getInstance();

			// Retrieve the list of departments from the model
			List<Department> departments = model.getDepartments();

			// Set the department list as a request attribute to be accessed in the JSP
			request.setAttribute("departments", departments);

			// Forward the request to the JSP page for rendering
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/jsp/DepartmentList.jsp");
			dispatcher.forward(request, response);

		} catch (Exception exception) {
			// Handle any exceptions that occur during department list retrieval
			ServletException error = new ServletException("Error while generating the Department List", exception);

			// Set the exception as a request attribute to display the error page
			request.setAttribute("exception", error);

			// Forward the request to the error page
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/jsp/Error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
