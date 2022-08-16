<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/calculate" method="post">
        <div><h1 class="text-danger">Calculator</h1></div>
        <div><input type="number" class="form-control mb-3 " required name="number1" placeholder="number1"></div>
        <div><input type="number" class="form-control mb-3 " required name="number2" placeholder="number2"></div>
        <div class="mb-3"><select name="choose" id="choose" class="form-control">
            <option>Choose</option>
            <option value="addition">Addition(+)</option>
            <option value="subtraction">Subtraction(-)</option>
            <option value="multiplication">Multiplication(*)</option>
            <option value="division">Division(/)</option>
        </select></div>
        <div class="mb-3">
            <button class="btn btn-success" type="submit">Solve</button>
        </div>
        <div class="mb-3"><b>Result : ${result}</b></div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
