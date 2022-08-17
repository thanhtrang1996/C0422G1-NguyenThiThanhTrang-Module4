
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
      <td><form:label path="name">Họ và tên : </form:label></td>
      <td><form:input path="name"/></td>
    </tr>
    <tr>
      <td><form:label path="dayOfBirth">Năm Sinh : </form:label></td>
      <td><form:select path="dayOfBirth" items="${yearList}">
      </form:select></td>
    </tr>

    <tr>
      <td><form:label path="gender">Giới Tính: </form:label></td>
      <td><form:select path="gender" items="${genderList}">
      </form:select></td>
    </tr>
    <tr>
      <td><form:label path="nation">Quốc Tịch: </form:label></td>
      <td><form:select path="nation" items="${nationList}">
      </form:select></td>
    </tr>
    <tr>
      <td><form:label path="idCard">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác </form:label></td>
      <td><form:input path="idCard"/></td>
    </tr>
    <tr>
      <td><form:label path="travelInformation">Thông tin đi lại</form:label></td>
      <td><form:radiobuttons path="travelInformation" items="${travelInformationList}"/></td>
    </tr>
    <tr>
      <td><form:label path="vehicleNumber">Số hiệu phương tiện </form:label></td>
      <td><form:input path="vehicleNumber"/></td>
    </tr>
    <tr>
      <td><form:label path="seats">Số ghế </form:label></td>
      <td><form:input path="seats"/></td>
    </tr>
    <tr>
      <td><form:label path="departureDay">Ngày khởi hành</form:label></td>
      <td colspan="3">
               <span><form:select path="departureDay" items="${dayList}">
               </form:select></span>
        <span><form:select path="departureMonth" items="${monthList}">
        </form:select></span>
        <span><form:select path="departureYear" items="${yearList}">
        </form:select></span>
      </td>
    </tr>
    <tr>
      <td><form:label path="endDate">Ngày khởi hành</form:label></td>
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
      <td><form:label
              path="information">Trong vòng 14 ngày qua anh chi có đi tỉnh thành nào không </form:label></td>
      <td><form:input path="information"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="Submit"/></td>
    </tr>
  </table>
</form:form>
</body>
</html>
