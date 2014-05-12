package formsexercises;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/** Servlet that prints out the param1, param2, and param3
 *  request parameters. Does not filter out HTML tags.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and Java</a>.
 */

@WebServlet("/user-post")
public class UserPostPersistent extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Reading Three Request Parameters";
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<UL>\n" +
                "  <LI><B>First Name</B>: "
                + ServletUtilities.filter(ServletUtilities.checkIfEmptyOrMalformed(request.getParameter("firstname"))) + "\n" +
                "  <LI><B>Second Name</B>: "
                + ServletUtilities.filter(ServletUtilities.checkIfEmptyOrMalformed(request.getParameter("surname"))) + "\n" +
                "  <LI><B>Email</B>: "
                + ServletUtilities.filter(ServletUtilities.checkIfEmptyOrMalformed(request.getParameter("email"))) + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
  }
  
  
  @Override
  public void doPost(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {
	  doGet(request, response);
  }
}
