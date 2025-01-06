<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
   <style >
   @charset "UTF-8";

body {
    font-family: 'Poppins', Arial, sans-serif;
    background: linear-gradient(135deg, #1d4354, #a43931);
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    color: #333;
}

.login-container {
    background: rgba(255, 255, 255, 0.9);
    padding: 40px;
    border-radius: 15px;
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
    width: 100%;
    max-width: 350px;
    text-align: center;
}

.login-container h1 {
    margin-bottom: 25px;
    font-size: 28px;
    color: #333;
}

.login-container form {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.login-container input[type="text"],
.login-container input[type="password"] {
    width: 90%;
    padding: 12px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 8px;
    background: #f4f4f4;
    font-size: 16px;
    color: #333;
}

.login-container input[type="text"]:focus,
.login-container input[type="password"]:focus {
    outline: none;
    border: 2px solid #a43931;
}

.login-container input[type="submit"] {
    background: #a43931;
    color: #fff;
    border: none;
    padding: 12px;
    width: 100%;
    border-radius: 8px;
    font-size: 18px;
    cursor: pointer;
    transition: background 0.3s ease;
}

.login-container input[type="submit"]:hover {
    background: #1d4354;
}

.anchor {
    display: block;
    margin-top: 15px;
    font-size: 14px;
    color: #50231e;
    text-decoration: none;
}

.login-container a {
    font-size: 14px;
    color: #8a160a;
    text-decoration: none;
}

.login-container a:hover {
    text-decoration: underline;
}

.error-message
{
  color: #d9534f;
    margin: 0 0 15px;
    font-size: 14px;
    text-align: left;
    width: 90%;
    padding: 10px;
    background-color: #f8d7da;
    border: 1px solid #f5c6cb;
    border-radius: 4px;
}
   </style>
</head>
<body>
  <div class="login-container">
    <h1>Welcome Back!</h1>
    <form action="Login">
      <input type="text" name="email" placeholder="Enter your email" required>
      <input type="password" name="password" placeholder="Enter your password" required>
     <%  
        String error = (String) request.getAttribute("error");
        if (error != null && !error.isEmpty()) {  
      %>
        <div id="error" class="error-message"><%= error %></div>
      <% 
        }
      %>
      <input type="submit" value="Login">
 </form>
      <div class="anchor"> 
      <a href="#">Forgot Password?</a>
      <p>Don't have an account? <a href="Register.jsp">Sign up</a>.</p>
      
    </div>
   
  </div>
</body>
</html>




