<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <!-- Yandex.Metrika counter -->
    <script type="text/javascript" >
        (function(m,e,t,r,i,k,a){m[i]=m[i]||function(){(m[i].a=m[i].a||[]).push(arguments)};
            m[i].l=1*new Date();k=e.createElement(t),a=e.getElementsByTagName(t)[0],k.async=1,k.src=r,a.parentNode.insertBefore(k,a)})
        (window, document, "script", "https://mc.yandex.ru/metrika/tag.js", "ym");

        ym(62291737, "init", {
            clickmap:true,
            trackLinks:true,
            accurateTrackBounce:true
        });
    </script>
    <noscript><div><img src="https://mc.yandex.ru/watch/62291737" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
    <!-- /Yandex.Metrika counter -->

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
            <label for="textarea" class="col-sm-2 col-form-label">О продукции</label>
            <textarea class="form-control" id="textarea1" name="aboutProduction" required>${aboutProduction}</textarea>
        </div>
        <div class="form-group row">
            <label for="textarea2" class="col-sm-2 col-form-label">Контакты</label>
            <textarea class="form-control" id="textarea2" name="contacts" required>${contacts}</textarea>
        </div>
        <button class="btn btn-dark" type="submit">Изменить данные</button>
    </form>
</t:wrapper>