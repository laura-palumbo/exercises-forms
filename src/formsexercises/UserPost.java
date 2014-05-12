package formsexercises;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet that prints out the param1, param2, and param3 request parameters.
 * Does not filter out HTML tags.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and
 * Java</a>.
 */

@WebServlet("/user-post-form1")
public class UserPost extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Reading Three Request Parameters";
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
				+ "Transitional//EN\">\n";
		String theForm = docType
				+ "<HTML>\n"
				+ "<HEAD><TITLE>"
				+ title
				+ "</TITLE></HEAD>\n"
				+ "<BODY BGCOLOR=\"#FDF5E6\">\n"
				+ "<H1 ALIGN=\"CENTER\">"
				+ title
				+ "</H1>\n"
				+ "<FORM ACTION=\"user-post-inline\" METHOD=\"POST\">\n"
				+ "First Name:  <INPUT TYPE=\"TEXT\" NAME=firstname VALUE=\""
				+ ServletUtilities.filter(ServletUtilities
						.checkIfEmptyOrMalformed(request
								.getParameter("firstname")))
				+ "\"><BR>\n"
				+ "Second Name: <INPUT TYPE=\"TEXT\" NAME=\"surname\" VALUE=\""
				+ ServletUtilities.filter(ServletUtilities
						.checkIfEmptyOrMalformed(request
								.getParameter("surname")))
				+ "\"><BR>\n"
				+ "Email:  <INPUT TYPE=\"TEXT\" NAME=\"email\" VALUE=\""
				+ ServletUtilities
						.filter(ServletUtilities
								.checkIfEmptyOrMalformed(request
										.getParameter("email")))
				+ "\"><BR>\n"
				+ "<CENTER><INPUT TYPE=\"SUBMIT\" NAME=\"submitted\"></CENTER>\n"
				+ "</FORM>\n" + "</BODY></HTML>";

		out.println(theForm);
	}

}
