package com.operator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public reply() {
        super();
       
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reply = request.getParameter("reply");
		String username = request.getParameter("username");
		
		 try {
	            boolean isValid = OperatorDBUtil.insertCustomer(username, reply);

	            if (isValid) {
	            	List<user> opDetails = OperatorDBUtil.getCustomerDetails();
	                request.setAttribute("OpDetails", opDetails);
	                RequestDispatcher dis = request.getRequestDispatcher("operatoraccount.jsp");
	                dis.forward(request, response);
	            } else {
	            	response.sendRedirect("operatoraccount.jsp?error=invalid");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new ServletException("Login validation failed", e);
	        }
	}

}
