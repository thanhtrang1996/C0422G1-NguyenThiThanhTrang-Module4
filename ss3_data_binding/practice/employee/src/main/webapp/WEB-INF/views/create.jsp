<%--
  Created by IntelliJ IDEA.
  User: Gia Nguyen Store
  Date: 08/16/2022
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form action="/employee/create" method="post">
    <table>
        <tr>
            <th>ID:</th>
            <td>
                <input type="text" name="id">
            </td>
        </tr>
        <tr>
            <th>Name:</th>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <th>Contact Number:</th>
            <td>
                <input type="text" name="contactNumber">
            </td>
        </tr>
        <tr>
            <th>
                <a href="/employee/list">Back</a>
            </th>
            <th>
                <button type="submit">Save</button>
            </th>
        </tr>
    </table>
</form>
</body>
</html>
