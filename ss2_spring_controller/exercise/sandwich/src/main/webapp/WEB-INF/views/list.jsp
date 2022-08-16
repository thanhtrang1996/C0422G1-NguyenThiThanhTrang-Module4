<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/list">
        <div><h1 class="text-danger">Sandwich condiments</h1></div>
        <div><c:forEach var="priceList" items="${price}">
            <p><input type="checkbox" value="${priceList}" name="condiments">${priceList}</p>
        </c:forEach>
        </div>
        <div>
            <button type="submit" class="btn btn-success">Save</button>
        </div>
    </form>
     <div><b>Your want choose sandwich and price is :</b>
        <c:forEach var="resultList" items="${result}">
            <p>${resultList}</p>
        </c:forEach>
     </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
