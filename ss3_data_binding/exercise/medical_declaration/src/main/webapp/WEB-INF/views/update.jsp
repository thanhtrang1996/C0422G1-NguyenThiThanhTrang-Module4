
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form:form method="post" action="/update" modelAttribute="medicalDeclaration">
  <table>
    <tr><h1>Tờ khai y tế</h1></tr>
    <tr><h3>Đây là tài liệu quan trọng,thông tin của anh/chị sẽ giúp cơ quan y tế liên lạc khi
      cần thiết để phòng chống dịch bệnh truyền nhiễm </h3></tr>
    <tr><h4>Khuyến cáo :Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý
      hình sự</h4></tr>

    <tr>
      <td><label for="name">Name</label></td>
      <td><form:input path="name" id="name"/></td>
    </tr>
    <tr>
      <td><label for="dayOfBirth">Day of birthday</label></td>
      <td><form:select path="dayOfBirth" id="dayOfBirth" items="${yearList}" >
      </form:select></td>
    </tr>

    <tr>
      <td><label for="gender"></label></td>
      <td><form:select path="gender" id="gender" items="${genderList}">
      </form:select></td>
    </tr>
    <tr>
      <td><label for="nation">Nation</label></td>
      <td><form:select path="nation" id="nation" items="${nationList}">
      </form:select></td>
    </tr>
    <tr>
      <td><label for="idCard">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label></td>
      <td><form:input path="idCard" id="idCard"/></td>
    </tr>
    <tr>
      <td><label for="travelInformation">Thông tin đi lại</label></td>
      <td><form:radiobuttons path="travelInformation" id="travelInformation" items="${travelInformationList}"/></td>
    </tr>
    <tr>
      <td><label for="vehicleNumber">Số hiệu phương tiện</label></td>
      <td><form:input path="vehicleNumber" id="vehicleNumber"/></td>
    </tr>
    <tr>
      <td><label for="seats">Số ghế</label></td>
      <td><form:input path="seats" id="seats"/></td>
    </tr>
    <tr>
      <td><label for="departureDay">Ngày khởi hành</label></td>
      <td colspan="3">
               <span><form:select path="departureDay" id="departureDay" items="${dayList}">
               </form:select></span>
        <span><form:select path="departureMonth" items="${monthList}">
        </form:select></span>
        <span><form:select path="departureYear" items="${yearList}">
        </form:select></span>
      </td>
    </tr>
    <tr>
      <td><label for="endDate">Ngày khởi hành</label></td>
      <td colspan="3">
               <span><form:select path="endDate" items="${dayList}">
               </form:select></span>
        <span><form:select path="endMonth" items="${monthList}">
        </form:select></span>
        <span><form:select path="endYear" items="${yearList}">
        </form:select></span>
      </td>
    </tr>
    <tr>
      <td><label for="information">Trong vòng 14 ngày qua anh chi có đi tỉnh thành nào không </label></td>
      <td><form:input path="information" id="information"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="Submit"/></td>
    </tr>
  </table>
</form:form>
</body>
</html>
