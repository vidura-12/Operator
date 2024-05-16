<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="login" method="post">
            <div class="form-group">
                <label for="uid">Username:</label>
                <input type="text" id="uid" name="uid" required>
            </div>
            <div class="form-group">
                <label for="pass">Password:</label>
                <input type="password" id="pass" name="pass" required>
            </div>
            <div class="form-group">
                <button type="submit">Login</button>
            </div>
        </form>
     <% 
        String error = request.getParameter("error");
        if (error != null && error.equals("invalid")) {
    %>
        <script>
            alert("Invalid username or password. Please try again.");
        </script>
    <% } %>
    </div>
</body>
</html>
