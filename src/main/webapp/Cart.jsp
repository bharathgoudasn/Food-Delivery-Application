<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*,com.food.model.*,com.food.controller.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart - Food Delivery</title>
    
      <link rel="stylesheet" href="cart.css">
      <style >
       * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, sans-serif;
        }

        body {
            min-height: 100vh;
            background: linear-gradient(to bottom, #f7f7f7, #edf2f7);
            color: #2d3748;
            line-height: 1.5;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
            color: #8a1e1e;
        }

        .cart-items {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .cart-item {
            background: white;
            border-radius: 1rem;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            transition: box-shadow 0.3s ease;
        }


        .cart-item:hover {
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
        }

        .item-details {
            flex-grow: 1;
        }

      
        .item-name {
            font-weight: 600;
            font-size: 18px;
            color: #2d3748;
            margin-bottom: 0.25rem;
        }

       
        .item-price {
            color: #718096;
            font-size: 0.875rem;
        }

        .item-total {
            font-weight: bold;
            color: #a82f2f;
        }

        .item-actions {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 10px;
        }

        .item-quantity {
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .quantity-btn {
            width: 2rem;
            height: 2rem;
            border-radius: 50%;
            border: 1px solid #a1a6ac;
            background: #f7fafc;
            color: #4a5568;
            cursor: pointer;
            transition: all 0.2s ease;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 1rem;
        }

        .quantity-btn:hover {
            background: #f7fafc;
            border-color: #cbd5e0;
        }

        .remove-btn {
            background: #fed7d7;
            color: #c53030;
            border: none;
            border-radius: 4px;
            padding: 5px 10px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .remove-btn:hover {
            background-color: #d80d0d;
        }

       
        .cart-actions {
            display: flex;
            justify-content: space-between;
            gap: 1rem;
            flex-wrap: wrap;
        }

        .action-btn {
            background: #ce3131;
            color: white;
            border: none;
            border-radius: 4px;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .action-btn:hover {
            background-color: #791212;
        }

        .action-btn.secondary {
            background: #f0b6b6;
            color: #23272e;
        }

        .action-btn.secondary:hover {
            background-color: #ef7d7d;
        }

        .cart-total {
            border-radius: 8px;
            padding: 0px;
            margin-top: 20px;
            text-align: right;
            font-size: 1.25rem;
            font-size: 20px;
            font-weight: 600;
            color: #2d3748;
            margin-bottom: 1.5rem;
        }
       

        @media (max-width: 600px) {
            .cart-item {
                flex-direction: column;
                align-items: flex-start;
                gap: 15px;
            }

            .item-actions {
                width: 100%;
                flex-direction: row;
                justify-content: space-between;
            }

            .cart-actions {
                flex-direction: column;
                gap: 10px;
            }

            .action-btn {
                width: 100%;
            }
        }</style>

</head>
<body>
	<div class="container">
        <h1>Your Cart</h1>
           <div class="cart-items">
      <% Cart cart = (Cart) session.getAttribute("Cart");
          int restaurantId=0;
            
           Map<Integer,CartItem> map=cart.getItems();
           if(map==null || map.size()==0){
       %>
        	   <h1>Cart is empty</h1>
       <% 
           }
           else {
           Set<Integer> key=map.keySet();
           float total=0;
           for(Integer id:key){
           CartItem cartItem=map.get(id);
           total=total+cartItem.getPrice()*cartItem.getQuantity();
           restaurantId=cartItem.getRestaurantid();
          %>
            <div class="cart-item">
                <div class="item-details">
                    <div class="item-name"><%= cartItem.getName() %></div>
                    <div class="item-price">Price: ₹<%=cartItem.getPrice() %></div>
                    <div class="item-total">Total: ₹<%= cartItem.getPrice()*cartItem.getQuantity() %></div>
                </div>
                <div class="item-actions">
                    <div class="item-quantity">
                    <form action="CartServlet">
                   		 <input type="hidden" name="action" value="update">
                   		 <input type="hidden" name="menuid" value="<%=cartItem.getItemid() %>">
                   		 <input type="hidden" name="quantity" value="<%= cartItem.getQuantity()-1 %>">
                        <button class="quantity-btn">-</button>
                    </form>
                        <span><%= cartItem.getQuantity() %></span>
                    <form action="CartServlet">
                   		 <input type="hidden" name="action" value="update">
                   		  <input type="hidden" name="menuid" value="<%=cartItem.getItemid() %>">
                  		  <input type="hidden" name="quantity" value="<%= cartItem.getQuantity()+1 %>">
                        <button class="quantity-btn">+</button>
                      </form>
                    </div>
                  <form action="CartServlet">
                   	   <input type="hidden" name="action" value="remove">
                   	   <input type="hidden" name="menuid" value="<%=cartItem.getItemid() %>">
                    <button class="remove-btn">Remove</button>
                  </form>
                </div>
            </div>
            <% } %>
        </div>
        <div class="cart-total">
            Total Price: ₹<%=total  %>
        </div>
      
        <div class="cart-actions">
         <a href="GetMenu?restaurantId=<%= restaurantId  %>" class="action-btn secondary" >Add More Items</a>
          <a href="CheckOut.jsp" class="action-btn">Proceed to Checkout</a>
        </div>
           <% } %>
    </div>
</body>
</html>

