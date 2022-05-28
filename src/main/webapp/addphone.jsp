<%@ page import="com.wcd.excercise5.entity.Phone" %><%--
  Created by IntelliJ IDEA.
  User: Nghĩa Hà
  Date: 5/28/2022
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Phone phone = (Phone) request.getAttribute("phone");
    if (phone == null) {
        phone = new Phone();
    }
%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - youtube.com/codingnepal -->
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Animated Login Form | CodingNepal</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="center">
    <h1>Add Phone</h1>
    <form method="post" action="/addphone">
        <div class="txt_field">
            <input type="text" name="name" value="<%= phone.getName() %>" required>
            <span></span>
            <label>Phone's Name</label>
        </div>
        <br><br>
        <label for="brands">Choose a brand</label>
        <select name="brand" id="brands">
            <option value="Samsung">Samsung</option>
            <option value="Apple">Apple</option>
            <option value="Nokia">Nokia</option>
            <option value="Others">Others</option>
        </select>
        <br><br>
        <div class="txt_field">
            <input type="text" name="description" value="<%= phone.getDescription() %>" required>
            <span></span>
            <label>Description</label>
        </div>
        <div class="txt_field">
            <input type="text" name="price" value="<%= phone.getPrice() %>" required>
            <span></span>
            <label>Price</label>
        </div>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
</div>

</body>
</html>
