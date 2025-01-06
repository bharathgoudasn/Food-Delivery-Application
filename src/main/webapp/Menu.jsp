<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*,com.food.model.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        :root {
            --primary-color: #FF0000;
            --background-color: #F7FFF7;
            --card-background: #ffffff;
            --text-color: #2C3E50;
            --price-color: #E74C3C;
            --border-radius: 12px;
            --spacing: 16px;
            --navbar-height: 50px;
            --search-navbar-height: 60px;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: var(--background-color);
            margin: 0;
            padding: 0;
            color: var(--text-color);
        }

   
           .navbar-container {
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            height: var(--navbar-height);
            background-color: white;
            border-bottom: 1px solid #e0e0e0;
            z-index: 999;
              height: 60px;
        }

        .navbar {
            background-color: white;
            max-width: 1200px;
            height: var(--navbar-height);
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 var(--spacing);
            position: fixed;
              top: 8px;
            left: 50%;
            transform: translateX(-50%);
            z-index: 1000;
            width: 100%;
        }


      .navbar-brand {
           font-size: 1.8em;
            font-weight: bold;
            margin: 0;
        }

        .navbar-items {
            display: flex;
            align-items: center;
        }

        .navbar-item {
            display: flex;
            align-items: center;
            color: var(--text-color);
            text-decoration: none;
            margin-left: 20px;
            font-size: 0.9em;
            cursor: pointer;
        }

        .navbar-item i {
            margin-right: 5px;
        }

       

        .menu-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
            gap: var(--spacing);
              position:absolute;
            top:80px;
             left: 145px;
            max-width: 1200px;
            margin: var(--spacing) auto;
            padding: 0 var(--spacing);
        }

        @media (min-width: 1200px) {
            .menu-grid {
                grid-template-columns: repeat(4, 1fr);
            }
        }

        .menu-item {
            background-color: var(--card-background);
            border-radius: var(--border-radius);
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            transition: transform 0.3s ease;
            display: flex;
            flex-direction: column;
        }

        .menu-item:hover {
            transform: translateY(-5px);
        }

        .menu-image {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }

        .menu-info {
            padding: var(--spacing);
            flex-grow: 1;
            display: flex;
            flex-direction: column;
        }

        .menu-name {
            font-size: 1.2em;
            font-weight: bold;
            margin: 0 0 8px 0;
            color: #000000;
        }

        .menu-description {
            color: var(--text-color);
            font-size: 0.9em;
            margin-bottom: 8px;
            flex-grow: 1;
        }

        .menu-price {
            font-weight: bold;
            color: var(--price-color);
            font-size: 1.1em;
            margin-bottom: 8px;
        }

        .menu-category {
            color: var(--text-color);
            font-size: 0.9em;
            margin-top: auto;
        }

        .menu-status {
            display: flex;
            align-items: center;
            margin-top: 8px;
        }

        .status-indicator {
            width: 8px;
            height: 8px;
            border-radius: 50%;
            margin-right: 6px;
        }

        .status-available {
            background-color: #2ECC71;
        }

        .status-unavailable {
            background-color: #E74C3C;
        }

        .small-text {
            font-size: 0.8em;
        }

        .formbutton {   
            position: relative;
            left: 50%;
            transform: translateX(-50%);
            margin-top: -10px;
            margin-bottom: 0px;
        }
        
        .add-button {
            position: relative;
            left: 50%;
            transform: translateX(-50%);
            margin-top: -50px;
            margin-bottom: 0px;
            background-color: white;
            color: var(--primary-color);
            padding: 8px 16px;
            border-radius: 4px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease, color 0.3s ease;
            border-color: #F7FFF7;
            z-index: 1;
            width: 90px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.5);
        }

        .add-button:hover {
            background-color: #f8f8f8;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15);
        }

        .profile-container {
            position: relative;
        }

        .profile-dropdown {
            position: absolute;
            top: 100%;
            right: 0;
            width: 250px;
            background-color: rgb(0, 0, 0);
            border-radius: var(--border-radius);
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
            padding: var(--spacing);
            margin-top: 8px;
            display: none;
            z-index: 1001;
        }

        .profile-dropdown.active {
            display: block;
            animation: fadeIn 0.2s ease-out;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-10px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .profile-header {
            display: flex;
            align-items: center;
            margin-bottom: 16px;
            padding-bottom: 12px;
            border-bottom: 1px solid #e0e0e0;
        }

        .profile-avatar {
            width: 48px;
            height: 48px;
            border-radius: 50%;
            background-color: var(--primary-color);
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-weight: bold;
            margin-right: 12px;
        }

        .profile-name {
            font-weight: bold;
            color: var(--text-color);
            margin: 0;
        }

        .profile-info {
            display: flex;
            flex-direction: column;
            gap: 12px;
        }

        .profile-item {
            display: flex;
            align-items: center;
            gap: 8px;
            color: var(--text-color);
            font-size: 0.9em;
        }

        .profile-item i {
            width: 16px;
            color: var(--primary-color);
        }
    </style>
</head>
<body>
	 <% User u = (User) session.getAttribute("User"); %>
	     <% List<Menu> mlist = (List<Menu>) request.getAttribute("menulist"); %>
    <% int r_id =  (Integer) request.getAttribute("restaurantId");
    
    %>
     <% List<Restuarant> rlist = (List<Restuarant>) session.getAttribute("restuarantlist"); %>
            <% 
                 for(Restuarant r : rlist) { 
                	 if(r.getRestaurantId()==r_id){
                		 %>
                
    <div class="navbar-container">
        <nav class="navbar">
            <h1 class="navbar-brand"> <%= r.getName() %></h1>
             <%
                	 }
                 }
            %>
            <div class="navbar-items">
             
                  <a href="home.jsp" class="navbar-item">
                    <i class="fas fa-home"></i> Home
                </a>
                <a href="CartHistory" class="navbar-item">
                    <i class="fas fa-shopping-cart"></i> Order-History
                </a>
                <div class="profile-container">
                    <a href="#" class="navbar-item" id="profileButton">
                        <i class="fas fa-user"></i> Profile
                    </a>
                    <div class="profile-dropdown" id="profileDropdown">
                        <div class="profile-header">
                            <div class="profile-avatar"><%= u.getUsername().charAt(0) %></div>
                            <h3 class="profile-name"><%= u.getUsername() %></h3>
                        </div>
                        <div class="profile-info">
                            <div class="profile-item">
                                <i class="fas fa-envelope"></i>
                                <span><%= u.getEmail() %></span>
                            </div>
                            <div class="profile-item">
                                <i class="fas fa-user"></i>
                                <span>@<% String name=u.getUsername().toLowerCase();
                                 String[] ar=name.split(" ");
                                 out.println(ar[0]); %></span>
                            </div>
                            <div class="profile-item">
                                <i class="fas fa-phone"></i>
                                <span>+91 982307488</span>
                            </div>
                        </div>
                    </div>
                </div>
                <a href="Logout" class="navbar-item">
                    <i class="fas fa-sign-out-alt"></i> Logout
                </a>
            </div>
        </nav>
    </div>
	

   
    <div class="menu-grid">
        <% 
            for(Menu m: mlist) { 
            	if(m.getIsavailable().equals("Yes")){
         %>
        <div class="menu-item">
            <img src="<%= m.getImagePath() %>" alt="Image of <%= m.getName() %>" class="menu-image">
            <form action="CartServlet" method="post" class="formbutton">
            <input type="hidden" name="action" value="add">
            <input type="hidden" name="menuid" value="<%= m.getMenuid() %>">
            <input type="hidden" name="quantity" value="1">
            <button type="submit" class="add-button">Add</button>
            </form>
            <div class="menu-info">
                <h2 class="menu-name"><%= m.getName() %></h2>
                <span class="menu-description"><%= m.getDescription() %></span>
                <span class="menu-price">Price: ₹<%= m.getPrice()%></span>
              
            </div>
        </div>
        <% 
            	}} 
          %>       
    </div>
       
       <script src="menu.js"></script>
</body>
</html>

