package mod09_OYO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The DepartmentAdd servlet handles HTTP GET and POST requests for
 * adding new departments. It displays the department addition form
 * on GET requests and processes the form data on POST requests.
 * 
 * @author angel
 */
@WebServlet("/DepartmentAdd")
public class DepartmentAdd extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Handles GET requests to display the department addition form. It forwards the
	 * request to the DepartmentAdd.jsp page where the user can input department details.
	 *
	 * @param request           The HttpServletRequest object that contains the client's request.
	 * @param response          The HttpServletResponse object used to send the response to the client.
	 * @throws ServletException If an error occurs during servlet processing.
	 * @throws IOException      If an input or output error occurs while handling the request.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Forward the request to the DepartmentAdd.jsp page for displaying the form
		request.getRequestDispatcher("/WEB-INF/jsp/DepartmentAdd.jsp").forward(request, response);
	}

	/**
	 * Handles POST requests to process the department addition form. It retrieves the
	 * department details from the request, creates a new Department object, and adds it
	 * to the database through the model. It then redirects to the department list page.
	 *
	 * @param request           The HttpServletRequest object that contains the form data.
	 * @param response          The HttpServletResponse object used to send the response to the client.
	 * @throws ServletException If an error occurs during servlet processing.
	 * @throws IOException      If an input or output error occurs while handling the request.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Retrieve form parameters from the request
			String departmentName = request.getParameter("department_name");
			String location = request.getParameter("location");

			// Create a new Department object using the provided data
			Department department = new Department(departmentName, location);

			// Get the model instance and add the new department
			PIMModel model = PIMModel.getInstance();
			model.addDepartment(department);

			// Redirect to the department list page after successful addition
			response.sendRedirect("DepartmentList");

		} catch (Exception e) {
			// In case of an error, forward the exception to the error page
			request.setAttribute("javax.servlet.error.exception", e);
			request.getRequestDispatcher("/WEB-INF/jsp/Error.jsp").forward(request, response);
		}
	}
}
