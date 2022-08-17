
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>mailbox</title>
</head>
<body>
<form:form method="POST" action="/check" modelAttribute="mailbox">
    <table>
        <tr>
            <td><form:label path="language">Language: </form:label></td>
            <td><form:select path="language" items="${languageList}">
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td><form:select path="pageSize" items="${pageSizeList}">
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams Filter: </form:label></td>
            <td><form:checkbox path="spamsFilter"/>
            <form:label path="spamsFilter"> Enable Spams Filter</form:label></td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature </form:label></td>
            <td><form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
