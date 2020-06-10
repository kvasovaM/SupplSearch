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
    ${button}

    <br><br>
    <div class="row"></div>

    <form class="form-inline" action="" method="get">
        <div class="form-group mb-2">
            <label for="category" class="sr-only">Категория</label>
            <input type="text" name="category" class="form-control" id="category" value="" placeholder="Категория">
        </div>
        <div class="form-group mx-sm-3 mb-2">
            <label for="city" class="sr-only">Город</label>
            <input type="text" name="city" class="form-control" id="city" value="" placeholder="Город">
        </div>
        <div class="form-group mx-sm-3 mb-2">
            <label for="minQuantity" class="sr-only">Мин. объём</label>
            <input type="text" name="minQuantity" class="form-control" id="minQuantity" value="" placeholder="Минимальный объём">
        </div>
        <div class="form-group mx-sm-3 mb-2">
            <label for="maxQuantity" class="sr-only">Макс. объём</label>
            <input type="text" name="maxQuantity" class="form-control" id="maxQuantity" value="" placeholder="Максимальный объём">
        </div>
        <button type="submit" class="btn btn-primary mb-2">Поиск по параметрам</button>
    </form>

    <div class="row"></div>

    <table class="table table-bordered">
        <thead class="thead-inverse">
        <tr><th>Покупатель</th><th>Категория</th><th>Город</th><th>Объем заказа</th><th>Частота заказа</th><th>Описание</th>
            <th>Дата размещения</th>
            <th>Действия</th></tr>
        </thead>
            ${cont}
    </table>
</t:wrapper>

