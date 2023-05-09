<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Info</title>
</head>
<body>

<h4>Добавить новый контакт</h4>
<form action="http://localhost:8080/contacts", method="post">

    <label>
        <input type="text", name="name">
    </label>Имя<br>

    <label>
        <input type="text", name="surname">
    </label>Фамилия<br>

    <label>
        <input type="text", name="email">
    </label>E-mail<br>

    <label>
        <input type="text", name="phone">
    </label>Телефон<br>

    <input type="submit" value="Добавить">
</form>

</body>
</html>