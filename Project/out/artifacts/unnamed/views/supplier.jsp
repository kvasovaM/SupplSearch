<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <br><br>
    <div class="row"></div>

    <form class="form-inline" action="" method="get">
        <div class="form-group mb-2">
            <label for="nameCompany" class="sr-only">Название</label>
            <input type="text" name="nameCompany" class="form-control" id="nameCompany" value="" placeholder="Название">
        </div>&nbsp;&nbsp;
        <button type="submit" class="btn btn-primary mb-2">Поиск</button>
    </form>

    <div class="row"></div>

    <table class="table table-bordered">
        <thead class="thead-inverse">
        <tr><th>Название компании</th><th>О компании</th><th>О продукции</th><th>Контакты</th></tr>
        </thead>
            ${cont}
    </table>
</t:wrapper>
