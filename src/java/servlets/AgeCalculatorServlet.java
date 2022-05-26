package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get requests end up here!

        //This will load a JSP from the servlet.
        getServletContext().getRequestDispatcher("/WEB-INF/AgeCalculatorForm.jsp").forward(request, response);
        return; //Stops the code call. VERY IMPORTANT.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Post requests end up here!

        //capture both incoming parameters
        String age = request.getParameter("age");

//            System.out.println(firstname + " " + lastname);
        //set up attributes in the request object to be sent to the JSP.
        request.setAttribute("age", age);

        String message = "Your age next birthday will be ${age+1}";
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/AgeCalculatorForm.jsp").forward(request, response);
        return; //stop the code call after loading a jsp.

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
