<%@ page contentType="text/html;charset=UTF-8" errorPage="error.jsp" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages" var="message"/>
<html>
<head>
    <meta charset='UTF-8'/>
    <title>MemberList</title>
</head>
<body>
<form method="post" action="/members.do">
    <table>
        <tr>
            <td>id</td>
            <td>pwd</td>
            <td>name</td>
            <td>profile</td>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getName()}</td>
                <td>${user.getProfileFileName()}</td>
            </tr>
        </c:forEach>
    </table>
</form>
<a href="/">Go to Main</a>
</body>
</html>
