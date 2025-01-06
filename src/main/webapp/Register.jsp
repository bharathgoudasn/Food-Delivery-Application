<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register Here</title>
<style>
  body {
    font-family: 'Poppins', Arial, sans-serif;
    background: linear-gradient(135deg, #1d4354, #a43931);
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    color: #fff;
  }

  .register-container {
    background: rgba(255, 255, 255, 0.9);
    padding: 30px;
    border-radius: 15px;
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
    width: 100%;
    max-width: 400px;
    box-sizing: border-box;
    text-align: center;
  }

  .register-container h1 {
    margin-bottom: 25px;
    font-size: 28px;
    color: #333;
  }

  .register-container label {
    display: block;
    text-align: left;
    font-size: 14px;
    color: #555;
    margin-bottom: 5px;
  }

  .register-container input[type="text"],
  .register-container input[type="password"],
  .register-container input[type="email"] {
    width: 100%;
    padding: 12px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 8px;
    font-size: 14px;
    color: #333;
    background: #f9f9f9;
    box-sizing: border-box;
  }

  .register-container input[type="text"]:focus,
  .register-container input[type="password"]:focus,
  .register-container input[type="email"]:focus {
    outline: none;
    border: 2px solid #4e4376;
  }

  .register-container input[type="submit"] {
    background: #4e4376;
    color: #fff;
    border: none;
    padding: 12px;
    width: 100%;
    border-radius: 8px;
    font-size: 16px;
    cursor: pointer;
    transition: background 0.3s ease;
  }

  .register-container input[type="submit"]:hover {
    background: #2b5876;
  }
  .acc
  {
    color:#4e4376
  }
  .acc a
  {
    color:#41395d
  }
  
  /* New styles for error message */
  .error-message {
     color: #9e312d;
    font-size: 14px;
    margin-top: -10px;
    margin-bottom: 10px;
    text-align: left;
  }
</style>
</head>
<body>
  <div class="register-container">
    <h1>Register Here</h1>
    <form action="Register" onsubmit="return validateForm()">
      <label for="username">Username</label>
      <input type="text" id="username" name="username" placeholder="Enter username" required>
      
      <label for="password">Password</label>
      <input type="password" id="password" name="password" placeholder="Enter password" required>
      
      <label for="cpassword">Confirm Password</label>
      <input type="password" id="cpassword" name="cpassword" placeholder="Confirm password" required>
      <div id="password-error" class="error-message"></div>
      
      <label for="email">Email</label>
      <input type="email" id="email" name="email" placeholder="Enter email" required>
      
      <label for="address">Address</label>
      <input type="text" id="address" name="address" placeholder="Enter address" required>
      
      <input type="submit" value="Register">
    </form>
    <div class="acc">
     <p>Already have an account? <a href="login.jsp">Sign in</a>.</p>
    </div>
  </div>

  <script src="register.js"></script>
</body>
</html>