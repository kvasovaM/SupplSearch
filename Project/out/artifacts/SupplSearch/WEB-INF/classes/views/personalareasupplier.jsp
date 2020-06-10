<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>

    <form action="/personalarea" method="post">
        <div class="form-group row">
            <label for="role" class="col-sm-2 col-form-label">Роль</label>
            <label id="role" class="col-sm-2 col-form-label">${role}</label>
        </div>
        <div class="form-group row">
            <label for="login" class="col-sm-2 col-form-label">Логин</label>
            <label id="login" class="col-sm-2 col-form-label">${login}</label>
        </div>
        <div class="form-group row">
            <label for="inputPassword" class="col-sm-2 col-form-label">Пароль</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control" id="inputPassword">
            </div>
        </div>
        <div class="form-group row">
            <label for="nameCompany" class="col-sm-2 col-form-label">Название компании</label>
            <div class="col-sm-10">
                <input type="nameCompany" name="nameCompany" class="form-control" id="nameCompany">
            </div>
        </div>
        <div class="form-group row">
            <label for="textarea" class="col-sm-2 col-form-label">О компании</label>
            <textarea class="form-control" id="textarea" name="aboutCompany" required>${aboutCompany}</textarea>
        </div>
        <div class="form-group row">
            <label for="textarea" class="col-sm-2 col-form-label">О закупках</label>
            <textarea class="form-control" id="textarea1" name="aboutProcurement" required>${aboutProcurement}</textarea>
        </div>
        <div class="form-group row">
            <label for="textarea2" class="col-sm-2 col-form-label">Контакты</label>
            <textarea class="form-control" id="textarea2" name="contacts" required>${contacts}</textarea>
        </div>
        <button class="btn btn-dark" type="submit">Изменить данные</button>
    </form>
</t:wrapper>