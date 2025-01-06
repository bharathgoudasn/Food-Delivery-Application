<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,com.food.model.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  font-family: sans-serif;
}
h1{
    text-align: center;
}

table {
  width: 80%;
  border-collapse: collapse;
  margin: 20px auto;
}

th, td {
  border: 1px solid #ddd;
  padding: 10px;
  text-align: left;
}

th {
  background-color: #d3c7c7;
}

tr{
  background-color: #f9f9f9;
}
</style>
</head>
<body>
    <h1>Cart History</h1>

<table>
<%   
    ArrayList<Orders> orders = (ArrayList<Orders>)session.getAttribute("OrderHistory");
    ListIterator<Orders> iterator = orders.listIterator(orders.size());
%>
  <tr>
    <th>Order ID</th>
    <th>Total Amount</th>
    <th>Status</th>
    <th>Payment Mode</th>
  </tr>
            <% 
                while(iterator.hasPrevious()) {
                    Orders o = iterator.previous();
            %>
  <tr>
    <td><%= o.getOrderid() %></td>
    <td><%= o.getTotalamount() %></td>
    <td><%= o.getStatus() %></td>
    <td><%= o.getPaymentmode() %></td>
  </tr>
<%
                }
%>
</table>

</body>
</html>