<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Info</title>
</head>
<body>
<h2>Список контактов</h2>
<c:set var="contactCount" value="0"/>
<table>
    <c:forEach var="contact" items="${contactList}">
        <tr>
            <td>${contact.id}</td>
            <td>Имя: ${contact.name}</td>
            <td>Фамилия: ${contact.surname}</td>
            <td>E-mail: ${contact.email}</td>
            <td>Телефон: ${contact.phone}</td>
            <td><a href="http://localhost:8080/contact/${contact.id}">
                <button>Удалить</button>
            </a></td>
            <c:set var="contactCount" value="${contactCount + 1}"/>
        </tr>
    </c:forEach>
</table>

<h3>Всего контактов: ${contactCount}</h3>

</body>
</html>