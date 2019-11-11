<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Contracts</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ContractList.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>Менеджер договоров</h2>
    </div>
</div>

<button type="button" onclick="window.location.href='add';" class="btn btn-dark">
    Создать
</button>

<div class="container">
    <div class="row">
        <div class="col-2">Серия-Номер</div>
        <div class="col-2">Дата заключения</div>
        <div class="col-3">Страхователь</div>
        <div class="col-1">Премия</div>
        <div class="col-2">Срок действия</div>
        <div class="col-2">Действия</div>
    </div>

    <c:forEach var="tempContract" items="${contracts}">

        <c:url var="updateLink" value="/update">
            <c:param name="contractId" value="${tempContract.id}" />
        </c:url>

        <c:url var="deleteLink" value="/delete">
            <c:param name="contractId" value="${tempContract.id}" />
        </c:url>

        <div class="row">
            <div class="col-2"> <fmt:formatNumber pattern="000000" value="${tempContract.id}"/> </div>
            <div class="col-2"> ${tempContract.contractDate} </div>
            <div class="col-3">${tempContract.clientId.surname} ${tempContract.clientId.name} ${tempContract.clientId.middlename}</div>
            <div class="col-1"> ${tempContract.insurancePremium} </div>
            <div class="col-2"> <fmt:formatDate value="${tempContract.insuranceStartDate}" pattern="dd.MM.yyyy"/>-<fmt:formatDate value="${tempContract.insuranceEndDate}" pattern="dd.MM.yyyy"/> </div>
            <div class="col-2">
                <button class="btn btn-dark" type="button" onclick="location.href='${updateLink}'">Update</button>
                <button class="btn btn-dark" type="button"
                        onclick="if (!(confirm('Вы уверены, что хотите удалить договор?'))) return false;
                                else {location.href='${deleteLink}'}">Delete</button>
            </div>
        </div>
    </c:forEach>
</div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ContractList.js"></script>
</html>








