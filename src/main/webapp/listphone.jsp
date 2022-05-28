<%@ page import="com.wcd.excercise5.entity.Phone" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Nghĩa Hà
  Date: 5/28/2022
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Phone> phone = (List<Phone>) request.getAttribute("phone");
    if (phone == null) {
        phone = new ArrayList<>();
    }
%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - youtube.com/codingnepal -->
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Animated Login Form | CodingNepal</title>
    <link rel="stylesheet" href="style.css">
    <link rel="script" href="script.js">
</head>
<body>
<div>
    <table>
        <thead>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Brand</td>
                <td>Description</td>
                <td>Price</td>
                <td>Created At</td>
                <td>Updated At</td>
            </tr>
        </thead>
        <tbody>
        <% for (Phone obj : phone) { %>
            <tr>
                <td> <%= obj.getId() %></td>
                <td> <%= obj.getName() %></td>
                <td> <%= obj.getBrand() %></td>
                <td> <%= obj.getDescription() %></td>
                <td> <%= obj.getPrice() %></td>
                <td> <%= obj.getCreatedAt() %></td>
                <td> <%= obj.getUpdatedAt() %></td>
            </tr>
        <% } %>
        </tbody>
        <tfoot>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Brand</td>
                <td>Description</td>
                <td>Price</td>
                <td>Created At</td>
                <td>Updated At</td>
            </tr>
        </tfoot>
    </table>

</div>

</body>
</html>
