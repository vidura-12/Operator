package com.operator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class edit
 */
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	             List<user> opDetails = OperatorDBUtil.getCustomerDetails();
	             request.setAttribute("OpDetails", opDetails);

	             RequestDispatcher dis = request.getRequestDispatcher("edit.jsp");
	             dis.forward(request, response);
	          
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new ServletException("Login validation failed", e);
	        }
	}

}
