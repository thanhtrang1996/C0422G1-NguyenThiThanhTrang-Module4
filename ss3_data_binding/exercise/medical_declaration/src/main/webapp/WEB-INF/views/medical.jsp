
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Medical</title>
</head>
</head>
<body>
<form:form method="get" action="/medical" modelAttribute="medicalDeclaration">
  <table >
    <tr >
      <td ><h2>Tờ khai y tế</h2></td>
      <td ><h3>Đây là tài liệu quan trọng,thông tin của anh/chị sẽ giúp cơ quan y tế liên lạc khi
        cần thiết để phòng chống dịch bệnh truyền nhiễm </h3></td>
      <td ><h4>Khuyến cáo :Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý
        hình sự</h4></td>
    </tr>
    <tr>
      <td><form:label path="name">Họ và tên : </form:label></td>
      <form:input path="name"/>
      </td>

    </tr>
    <tr>
      <td><form:label path="dateOfBirth">Year : </form:label></td>
      <td><form:select path="dayOfBirth" items="${yearList }">
      </form:select></td>
    </tr>

    <tr>
      <td><input type="submit" value="Submit"/></td>
    </tr>
  </table>
</form:form>
</body>
</html>
