package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get requests end up here!
String message = "--";
request.setAttribute("message", message);
        //This will load a JSP from the servlet.
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return; //Stops the code call. VERY IMPORTANT.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Post requests end up here!

        //capture both incoming parameters
        String first = request.getParameter("first");
        String second = request.getParameter("second");

//            System.out.println(firstname + " " + lastname);
        //set up attributes in the request object to be sent to the JSP.
        request.setAttribute("first", first);
        request.setAttribute("second", second);

        //Validation against blank text boxes and non-numeric text. 
        if (first == null || first.equals("") || second == null || second.equals("")) {
            String message = "invalid";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return; //stop the code call after loading a jsp.
        }
        
        boolean isNum;
        try {
            Double.parseDouble(first);
            Double.parseDouble(second);
            isNum = true;
        } catch (NumberFormatException e) {
            isNum = false;
        }
        if (!isNum) {
            String message = "invalid";

            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return; //stop the code call after loading a jsp.
        }

        int firstNum = Integer.parseInt(first);
        int secondNum = Integer.parseInt(second);
        
        String operator = request.getParameter("operator");
        request.setAttribute("operator", operator);
        
        if(operator.equals("+")){
            int total = firstNum + secondNum;
            String message = ""+total;
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;//stop the code call after loading a jsp.
            
        } else if(operator.equals("-")){
            int total = firstNum - secondNum;
            String message = ""+total;
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return; //stop the code call after loading a jsp.
            
        } else if(operator.equals("*")){
            int total = firstNum*secondNum;
            String message = ""+total;
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return; //stop the code call after loading a jsp.
            
        }else if(operator.equals("%")){
            int total = firstNum%secondNum;
            String message = ""+total;
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return; //stop the code call after loading a jsp.
        }
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
