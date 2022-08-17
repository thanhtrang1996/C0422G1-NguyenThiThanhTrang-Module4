
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>DisplayDetail</title>
</head>
<body>
<form action="/check">
<table>
    <tr><h3>Mailbox Detail</h3></tr>
    <tr>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spams Filter</th>
        <th>Signature</th>
    </tr>
  <c:forEach items="${mailboxList}" var="mailbox">
      <tr>
          <td>${mailbox.language}</td>
          <td>${mailbox.pageSize}</td>
          <td>${mailbox.spamsFilter}</td>
          <td>${mailbox.signature}</td>
      </tr>
  </c:forEach>
</table>
</form>
</body>
</html>
