package com.operator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OperatorDBUtil {

	private static Connection con = null;
	private static Statement stmt = null;
	
	public static boolean validate(String OpName, String password) {
	    boolean isValid = false; 
	    
	    try {
	        con = DBconnect.getConnection();
	        stmt = con.createStatement();
	        String sql = "SELECT * FROM operator WHERE username='" + OpName + "' AND password='" + password + "'";
	        ResultSet rs = stmt.executeQuery(sql);
	        if (rs.next()) {
	            isValid = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); 
	        System.out.println("Error");
	    }	    
	    return isValid;
	}



	public static boolean insertCustomer(String username, String reply) {
	    boolean isSuccess = false;
	    
	    try {
	        con = DBconnect.getConnection();
	        stmt = con.createStatement();
	        
	        String sql = "UPDATE user SET reply = '" + reply + "' WHERE username = '" + username + "'";
	        
	        int rowsAffected = stmt.executeUpdate(sql);
	        
	        if (rowsAffected > 0) {
	            isSuccess = true;
	        } else {
	            isSuccess = false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    
	    return isSuccess;
	}

	
	
	public static boolean delete(String username) {
	    boolean isSuccess = false;
	    
	    try (Connection con = DBconnect.getConnection();
	         Statement stmt = con.createStatement()) {
	        
	        String sql = "DELETE FROM user WHERE username = '" + username + "'";
	        int rs = stmt.executeUpdate(sql);

	        if (rs > 0) {
	            isSuccess = true;
	        } else {
	            isSuccess = false;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	    
	    return isSuccess;
	}


	public static List<user> getCustomerDetails() {
	    
	    ArrayList<user> cus = new ArrayList<>();
	    
	    try {
	        Connection con = DBconnect.getConnection();
	        Statement stmt = con.createStatement();
	        String sql = "SELECT * FROM user ";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            int id1 = rs.getInt(1);
	            String name = rs.getString(2);
	            String email = rs.getString(3);
	            String phone = rs.getString(4);
	            String username = rs.getString(5);
	            String password = rs.getString(6);
	            String ticket = rs.getString(7);
	            String reply = rs.getString(8);
	            
	            user o = new user(id1, name, password, username, email, phone, ticket,reply);
	            cus.add(o);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return cus;
	}

	}	