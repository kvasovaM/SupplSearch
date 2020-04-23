<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>

    <table>
        <thead class="thead-inverse">
        <tr><th>Название компании</th><th>О компании</th><th>О закупках</th><th>Контакты</th></tr>
        </thead>
            ${cont}
    </table>
</t:wrapper>

