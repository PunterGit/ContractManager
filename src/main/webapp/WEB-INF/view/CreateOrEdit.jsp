<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head lang="ru">
    <title>Добавить договор</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/CreateOrEdit.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script>
        let curDate = "<%= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) %>"; // Передача даты в js для дальнейшей вставки при расчёте
        let passId = "<fmt:formatNumber minIntegerDigits="4" pattern="####" value="${client.passportId}"/>"; // Передача паспорта частями для вставки в input
        let passId2 = "<fmt:formatNumber maxIntegerDigits="0" minFractionDigits="6" pattern="######" value="${client.passportId}"/>".substr(1);
    </script>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>Менеджер договоров</h2>
    </div>
</div>

<div class="container">

    <form name="addContract" action="${pageContext.request.contextPath}/add" method="post">

        <label>
            <input type="text" name="contractId" value="${contract.id}" hidden>
            <input type="text" name="clientId" value="${client.id}" hidden>
        </label>

        <div class="row">
            <div class="col-3">
                <label>Страховая сумма </label>
            </div>
            <div class="col-3">
                <label><input type="number" name="insuranceSum" value="${contract.insuranceSum}" required/></label>
            </div>
            <div class="col-md-auto">
                <label>Срок действия с </label>
                <label><input type="date" name="insuranceStartDate" value="${contract.insuranceStartDate}" required/></label>
            </div>
            <div class="col-md-auto">
                <label> по </label>
                <label><input type="date" name="insuranceEndDate" value="${contract.insuranceEndDate}" required/></label>
            </div>
        </div>

        <div class="row">
            <div class="col-3">
                <label>Тип недвижимости </label>
            </div>
            <div class="col-3">
                <label>
                    <select class="custom-select" name="property" required>
                        <option value="Квартира" <% try {
                            if (request.getAttribute("contract").toString().contains("property:'Квартира'")){ %> selected <% }
                        } catch (Exception e) {} %>>Квартира</option>
                        <option value="Дом" <% try {
                            if (request.getAttribute("contract").toString().contains("property:'Дом'")){ %> selected <% }
                        }catch (Exception e){} %>>Дом</option>
                        <option value="Комната" <% try {
                            if (request.getAttribute("contract").toString().contains("property:'Комната'")){ %> selected <% }
                        } catch (Exception e) {} %>>Комната</option>
                    </select>
                </label>
            </div>
        </div>

        <div class="row">
            <div class="col-3">
                <label>Год постройки </label>
            </div>
            <div class="col-3">
                <label><input type="number" name="constructionYear" value="${contract.constructionYear}" required/></label>
            </div>
        </div>

        <div class="row">
            <div class="col-3">
                <label>Площадь, кв.м. </label>
            </div>
            <div class="col-3">
                <label><input type="number" name="area" value="${contract.area}" required/></label>
            </div>
        </div>

        <div class="row align-items-center"><div class="col-12"><button class="btn btn-dark" type="button" name="calculate">Расчитать</button></div></div>

        <div class="row">
            <div class="col-3">
                <label>Дата расчёта </label>
            </div>
            <div class="col-3">
                <label><input type="date" name="computationDate" value="${contract.computationDate}" readonly/></label>
            </div>
            <div class="col-3">
                <label>Страховая премия </label>
            </div>
            <div class="col-3">
                <label><input type="number" name="insurancePremium" value="${contract.insurancePremium}" readonly/></label>
            </div>
        </div>

        <div class="row" style="margin-bottom: 40px;">
            <div class="col-3">
                <label>Номер договора </label>
            </div>
            <div class="col-3">
                <label><input placeholder="Поле автоматически заполнится" type="text" name="id" value="<fmt:formatNumber pattern="000000" value="${contract.id}"/>" readonly/></label>
            </div>
            <div class="col-3">
                <label>Дата заключения </label>
            </div>
            <div class="col-3">
                <label><input type="date" name="contractDate" value="${contract.contractDate}"/></label>
            </div>
        </div>

        <div class="row"><div class="col-12"><label><b>Страхователь</b></label></div></div>

        <div class="client">
            <div class="row align-items-center">
                <div class="col-3 btnDiv">
                    <label><button class="btn btn-dark" type="button" name="pickClient">Выбрать</button></label>
                </div>
                <div class="col-3">
                    <label>Фамилия</label>
                    <label><input type="text" name="surname" value="${client.surname}" readonly/></label>
                </div>
                <div class="col-3">
                    <label>Имя</label>
                    <label><input type="text" name="name" value="${client.name}" readonly /></label>
                </div>
                <div class="col-3">
                    <label>Отчество</label>
                    <label><input type="text" name="middlename" value="${client.middlename}" readonly/></label>
                </div>
            </div>

            <div class="row">
                <div class="col-3 btnDiv">
                    <label><button class="btn btn-dark" type="button" name="addClient">Добавить</button></label>
                </div>
                <div class="col-3 passport"></div>
                <div class="col-6" style="text-align: center; font-weight: bolder;">Паспорт</div>
            </div>

            <div class="row align-items-center">
                <div class="col-3 btnDiv">
                    <label><button class="btn btn-dark" type="button" name="editClient">Изменить</button></label>
                </div>
                <div class="col-3">
                    <label>Дата рождения</label>
                    <label><input type="date" name="birthDate" value="${client.birthDate}" readonly/></label>
                </div>
                <div class="col-3">
                    <label>Серия</label>
                    <label><input type="number" name="passportId" value="" readonly/></label>
                </div>
                <div class="col-3">
                    <label>Номер</label>
                    <label><input type="number" name="passportId2" value="" readonly/></label>
                </div>
            </div>
        </div>

        <div class="row"><div class="col-12"><label><b>Адрес недвижимости</b></label></div></div>

        <div class="row">
            <div class="col-3">
                <label>Государство </label>
            </div>
            <div class="col-3">
                <label><input type="text" name="country" value="${contract.country}" required/></label>
            </div>
            <div class="col-3">
                <label>Индекс </label>
            </div>
            <div class="col-3">
                <label><input type="text" name="postcode" value="${contract.postcode}" required/></label>
            </div>
        </div>

        <div class="row">
            <div class="col-3">
                <label>Республика, край, область </label>
            </div>
            <div class="col-3">
                <label><input type="text" name="republic" value="${contract.republic}" required/></label>
            </div>
            <div class="col-3">
                <label>Район </label>
            </div>
            <div class="col-3">
                <label><input type="text" name="region" value="${contract.region}" required/></label>
            </div>
        </div>

        <div class="row">
            <div class="col-3">
                <label>Населенный пункт </label>
            </div>
            <div class="col-3">
                <label><input type="text" name="locality" value="${contract.locality}" required/></label>
            </div>
            <div class="col-3">
                <label>Улица </label>
            </div>
            <div class="col-3">
                <label><input type="text" name="street" value="${contract.street}" required/></label>
            </div>
        </div>

        <div class="row">
            <div class="col-3">
                <label>Дом </label>
            </div>
            <div class="col-3">
                <label><input type="text" name="house" value="${contract.house}" required/></label>
            </div>
            <div class="col-3">
                <label>Корпус </label>
            </div>
            <div class="col-3">
                <label><input type="text" name="housing" value="${contract.housing}" required/></label>
            </div>
        </div>

        <div class="row">
            <div class="col-3">
                <label>Строение </label>
            </div>
            <div class="col-3">
                <label><input type="text" name="building" value="${contract.building}" required/></label>
            </div>
            <div class="col-3">
                <label>Квартира </label>
            </div>
            <div class="col-3">
                <label><input type="text" name="apartment" value="${contract.apartment}" required/></label>
            </div>
        </div>




        <div class="row">
            <div class="col-12" style="vertical-align: center;justify-content: center;">
                <label><b>Комментарий </b></label>
                <label><textarea name="comment" value="${contract.comment}" required style="resize: none;" rows="3" cols="140">${contract.comment}</textarea></label>
            </div>
        </div>


        <label></label>
        <input type="submit" value="Сохранить" class="btn btn-dark"/>

    </form>
    <button class="btn btn-light" onclick="location.href='${pageContext.request.contextPath}/list';">Договоры</button>

</div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/CreateOrEdit.js"></script>
</html>










