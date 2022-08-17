<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<form action="/showList">
    <table border="1">
        <a href="/list">Create</a>
        <tr>
            <td>Họ tên</td>
            <td>Năm sinh</td>
            <td>Giới tính</td>
            <td>Quốc tịch</td>
            <td>Số hộ chiếu</td>
            <td>Thông tin đi lại</td>
            <td>Số hiệu phương tiện</td>
            <td>Số ghế</td>
            <td colspan="3">Ngày khởi hành</td>
            <td colspan="3">Ngày kết thúc</td>
            <td>Thông tin trong 14 ngày</td>
            <td>update</td>

        </tr>
        <c:forEach items="${medicalDeclarationList}" var="medical">
            <tr>
                <td>${medical.name}</td>
                <td>${medical.dayOfBirth}</td>
                <td>${medical.gender}</td>
                <td>${medical.nation}</td>
                <td>${medical.idCard}</td>
                <td>${medical.travelInformation}</td>
                <td>${medical.vehicleNumber}</td>
                <td>${medical.seats}</td>
                <td>${medical.departureDay}</td>
                <td>${medical.departureMonth}</td>
                <td>${medical.departureYear}</td>
                <td>${medical.endDate}</td>
                <td>${medical.endMonth}</td>
                <td>${medical.endYear}</td>
                <td>${medical.information}</td>
                <td><a href="/update/${medical.idCard}">Update</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
