<%--
  Created by IntelliJ IDEA.
  User: Gia Nguyen Store
  Date: 08/16/2022
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<h2>List Employee</h2>
<a href="/employee/create">Create Employee</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>ContactNumber</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.contactNumber}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
