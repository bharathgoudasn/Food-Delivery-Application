<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Delivery App</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            background-image: url('https://placeholder.svg?height=1080&width=1920');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
        }
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 1rem 2rem;
            background-color: #411010;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        .logo {
            font-size: 1.8rem;
            font-weight: bold;
            color: #f0eeee;
        }
        .nav-links {
            display: flex;
            gap: 3rem;
        }
        .nav-links a {
            text-decoration: none;
            color: #f0eeee;
        }
        .main-content {
            flex-grow: 1;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding: 2rem;
            background-image: url('https://wallpaperaccess.com/full/767033.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            position: relative;
        }
        .main-content::before {
            content: '';
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            background-color: rgba(0, 0, 0, 0.5);
            z-index: 1;
        }
        .card-container {
            position: relative;
            z-index: 2;
            display: flex;
            gap: 1rem;
        }
        .card {
            background-color: #f7dede;
            border-radius: 10px;
            box-shadow: 0 10px 20px rgba(0,0,0,0.1);
            padding: 2rem;
            text-align: center;
            width: 280px;
            height: 380px;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            color: #5d1919;
            transition: transform 0.3s ease;
        }
        .card:hover {
            transform: translateY(-10px);
        }
        .card h2 {
            margin-bottom: 1rem;
            color: #2c3e50;
            font-size: 1.5rem;
        }
        .card i {
            font-size: 3rem;
            margin-bottom: 1rem;
            color: #db3434;
        }
        .btn {
            display: inline-block;
            padding: 0.8rem 1.5rem;
            background-color: #db3434;
            color: white;
            text-decoration: none;
            border-radius: 25px;
            transition: background-color 0.3s, transform 0.3s;
            font-weight: bold;
            text-transform: uppercase;
            letter-spacing: 1px;
        }
        .btn:hover {
            background-color: #db3434;
            transform: scale(1.05);
        }
      
     
    </style>
</head>
<body>
    <nav class="navbar">
        <div class="logo">FoodDelivery</div>
        <div class="nav-links">
            <a href="#">Home</a>
            <a href="#">About Us</a>
            <a href="#">Contact Us</a>
        </div>
    </nav>

    <main class="main-content">
        <div class="card-container">
            <div class="card">
                <i class="fas fa-user-circle"></i>
                <h2>Already have an account?</h2>
                <p>Welcome back! Sign in to access your account and start ordering.</p>
                <a href="login.jsp" class="btn">Login here</a>
            </div>
            <div class="card">
                <i class="fas fa-user-plus"></i>
                <h2>New to FoodDelivery?</h2>
                <p>Join us today and discover a world of delicious meals at your fingertips!</p>
                <a href="Register.jsp" class="btn">Register now</a>
            </div>
        </div>
    </main>

</body>
</html>

