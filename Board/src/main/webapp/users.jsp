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
    <table>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>grade</td>
            <td>update</td>
            <td>delete</td>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><a href="/userRead.do?id=${user.getId()}"> ${user.getId()}</a></td>
                <td>${user.getPassword()}</td>
                <td>${user.getName()}</td>
                <td>${user.getProfileFileName()}</td>
                <td>
                    <button type="button" onclick="location.href='/userUpdate.do?id=${user.getId()}'">update</button>
                </td>
                <td>
                    <button type="button" onclick="location.href='/userDelete.do?id=${user.getId()}'">delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button type="button" onclick="location.href='/userPlus.do';">create</button>

    <a href="/">Go to Main</a>
</body>
</html>
