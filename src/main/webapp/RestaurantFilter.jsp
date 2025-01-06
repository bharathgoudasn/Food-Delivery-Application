<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,com.food.model.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant List</title>
    
           <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
      <link rel="stylesheet" href="home.css">
      
</head>
<body>
    <% User u = (User) session.getAttribute("User"); %>
    <div class="navbar-container">
        <nav class="navbar">
            <h1 class="navbar-brand">FoodDelivery</h1>
            <div class="navbar-items">
                
                   <a href="#" class="navbar-item">
                    <i class="fas fa-sliders"></i> Filter
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

    <div class="search-navbar-container">
        <div class="search-navbar">
            <div class="search-container">
                <input type="text" class="search-input" placeholder="Search for restaurants or cuisines...">
                <i class="fas fa-search search-icon"></i>
            </div>
        </div>
    </div>

    <div class="restaurant-grid" >
    
       
        <% List<Restuarant> rlist = (List<Restuarant>) session.getAttribute("restuarantlist"); 
            ArrayList<Restuarant> flist=new ArrayList<>();
                 for(Restuarant r : rlist) { 
                	 if(r.isActive().equals("Yes")){
                		 flist.add(r);
                	 }
                 }
                 Collections.sort(flist);
                 for(Restuarant r:flist){
            %>
       <a href="GetMenu?restaurantId=<%=r.getRestaurantId()  %>" class="restaurant-card">
            <img src="<%= r.getImagePath() %>" alt="Image of <%= r.getName() %>" class="restaurant-image">
            <div class="restaurant-info">
                <div class="restaurant-details">
                    <h2 class="restaurant-name"><%= r.getName() %></h2>
                    <span class="restaurant-rating"><%= r.getRating() %> ★</span>
                </div>
                <span class="cuisine-type"><%= r.getCuisineType() %></span>
                <p class="restaurant-location">
                     <%= r.getAddress() %>
                    <span class="restaurant-time"><%= r.getDeliveryTime() %> min</span>
                </p>
                <div class="restaurant-status">
                    <span class="status-indicator status-active "></span>
                    <span class="small-text">   <%= r.isActive().equals("Yes") ? "Open Now" : "Closed" %>
					</span>
                </div>
            </div>
         </a>
        <% 
          } 
         %>
    </div>
               <div class="no-result-message" id="msg">
    </div>
    
   
       <script src="home.js"></script>
    
</body>
</html>


