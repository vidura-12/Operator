<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
    body {
        font-family: Arial, sans-serif;
        background-image: url('images/5561569.jpg');
        background-size: cover;
        background-repeat: no-repeat;
        padding: 20px;
        color: #333;
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
    }

    table.customer-table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        background-color: transparent; /* Make table background transparent */
    }

    table.customer-table th, table.customer-table td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
        background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background for cells */
    }

    table.customer-table th {
        color: #555;
        text-transform: uppercase;
    }

   .button-container {
    display: flex;
    align-items: center;
}

.button-container form {
    margin-right: 10px; /* Adjust this value as needed */
}

.button-container button {
    margin-right: 10px; /* Adjust this value as needed */
}


    input[type="text"], button[type="submit"] {
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    input[type="text"] {
        width: 200px;
        margin-right: 10px;
    }

    button[type="submit"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button[type="submit"]:hover {
        background-color: #0056b3;
    }

    /* Form styling */
    form {
        margin-bottom: 20px;
    }

    /* Alert styling */
    .alert {
        padding: 10px;
        background-color: #f44336;
        color: white;
        margin-bottom: 15px;
        border-radius: 4px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    /* Responsive design */
    @media screen and (max-width: 600px) {
        table.customer-table {
            width: 100%;
        }
        input[type="text"] {
            width: 100%;
            margin-right: 0;
            margin-bottom: 10px;
        }
    }
 .form-container {

    justify-content: center;
    align-items: center;
    height: 100vh; /* Full viewport height */
}

.styled-button {
    padding: 10px 20px;
    font-size: 16px;
    border: none;
    border-radius: 5px;
    background-color: #3498db; /* Blue */
    color: white;
    cursor: pointer;
    transition: background-color 0.3s ease;
    margin-left: 850px;
    margin-top: 50px;
   
}

    
</style>


<title>Online Help Desk</title>
</head>
<body>
<table class="customer-table">
    <tr>
        <th>Customer ID</th>
        <th>Customer Name</th>
        <th>Customer Email</th>
        <th>Customer Phone</th>
        <th>Customer User Name</th>
        <th>Customer Password</th>
        <th>Customer Ticket</th>
        <th>reply </th>
        <th></th>
    </tr>
    <c:forEach var="cus" items="${OpDetails}">
        <tr>
            <td>${cus.id}</td>
            <td>${cus.name}</td>
            <td>${cus.email}</td>
            <td>${cus.phone}</td>
            <td>${cus.username}</td>
            <td>${cus.password}</td>
            <td>${cus.ticket}</td>
            <td>${cus.reply}</td>
          <td> <div class="button-container">
          
   <form action="reply" method="post" class="h">
   <input type="hidden" value="${cus.username}" name="username">
   <input type="text" name="reply">
   <button type="submit" >Reply</button>
   </form>
   <form action="delete"  method="post">
    <input type="hidden" value="${cus.username}" name="username">
   <button type="submit" >delete</button>
   </form>
   

	</div>
</td>  

        </tr>
    </c:forEach>
</table>

<div class="form-container">
    <form action="edit" method="post"> 
        <button type="submit" class="styled-button">Edit My Reply</button>
    </form>
</div>

    <% 
        String error = request.getParameter("error");
        if (error != null && error.equals("invalid")) {
    %>
        <script>
            alert("Error");
        </script>
    <% } %>
</body>
</html>
