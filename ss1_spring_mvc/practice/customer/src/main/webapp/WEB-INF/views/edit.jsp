
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit customer</h1>
<form action="/customer/edit" method="post">
    <table>
        <tr>
            <th>ID:</th>
            <td>
                <input type="text" name="id" value="${customer.id}" readonly>
            </td>
        </tr>
        <tr>
            <th>Name:</th>
            <td>
                <input type="text" name="name" value="${customer.name}">
            </td>
        </tr>
        <tr>
            <th>Age:</th>
            <td>
                <input type="text" name="age" value="${customer.age}">
            </td>
        </tr>
        <tr>
            <th>
                <a href="/customer/list">Back</a>
            </th>
            <th>
                <button type="submit">Save</button>
            </th>
        </tr>
    </table>
</form>
</body>
</html>
