<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    ${button}
    <p>
        <a class="btn btn-primary ml-1 mt-1" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Поиск по параметрам
        </a>
    </p>

    <table>
        <thead class="thead-inverse">
        <tr><th>Покупатель</th><th>Категория</th><th>Город</th><th>Объем заказа</th><th>Частота заказа</th><th>Описание</th><th>Дата размещения</th></tr>
        </thead>
            ${cont}
    </table>
</t:wrapper>

