<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <form action="/addsupply" method="post">


        <div class="form-group row">
            <label for="category" class="col-sm-2 col-form-label">Категория</label>
            <textarea class="form-control" id="category" name="category" required></textarea>
        </div>
        <div class="form-group row">
            <label for="city" class="col-sm-2 col-form-label">Город</label>
            <textarea class="form-control" id="city" name="city" required></textarea>
        </div>
        <div class="form-group row">
            <label for="description" class="col-sm-2 col-form-label">Описание</label>
            <textarea class="form-control" id="description" name="description" required></textarea>
        </div>
        <button class="btn btn-dark" type="submit">Создать</button>
    </form>
</t:wrapper>