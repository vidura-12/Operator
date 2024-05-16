package com.operator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("uid");
        String password = request.getParameter("pass");

        try {
            boolean isValid = OperatorDBUtil.validate(username, password);

            if (isValid) {
                List<user> opDetails = OperatorDBUtil.getCustomerDetails();
                request.setAttribute("OpDetails", opDetails);

                RequestDispatcher dis = request.getRequestDispatcher("operatoraccount.jsp");
                dis.forward(request, response);
            } else {
            	response.sendRedirect("login.jsp?error=invalid");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Login validation failed", e);
        }
    }
}
