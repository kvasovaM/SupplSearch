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