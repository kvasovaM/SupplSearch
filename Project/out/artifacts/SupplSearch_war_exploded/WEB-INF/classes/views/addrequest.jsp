<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <form action="/addrequest" method="post">



        <div class="form-group row">
            <label for="category" class="col-sm-2 col-form-label">Категория</label>
            <textarea class="form-control" id="category" name="category" required></textarea>
        </div>
        <div class="form-group row">
            <label for="сity" class="col-sm-2 col-form-label">Город</label>
            <textarea class="form-control" id="сity" name="сity" required></textarea>
        </div>
        <div class="form-group row">
            <label for="orderQuantity" class="col-sm-2 col-form-label">Объем заказа</label>
            <input class="form-control" type="text" name="orderQuantity" id="orderQuantity" >
        </div>
        <div class="form-group row">
            <label for="orderFrequency" class="col-sm-2 col-form-label">Частота заказа</label>
            <textarea class="form-control" id="orderFrequency" name="orderFrequency" required></textarea>
        </div>
        <div class="form-group row">
            <label for="description" class="col-sm-2 col-form-label">Описание</label>
            <textarea class="form-control" id="description" name="description" required></textarea>
        </div>
        <button class="btn btn-dark" type="submit">Создать</button>
    </form>
</t:wrapper>