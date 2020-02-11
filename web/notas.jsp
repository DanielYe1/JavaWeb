<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/styles.css">
</head>
<script src="../js/bootstrap.js"></script>
<body>

<jsp:include page="/paginas/menu.jsp"/>

<div class="container">


    <h2>Notas</h2>
    <table class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>idAluno</th>
            <th>idTurma</th>
            <th>Curso</th>
            <th>Nota</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${notas}" var="val">
            ${val}
        </c:forEach>

        </tbody>
    </table>


</div>




<jsp:include page="/paginas/rodape.html"/>

</body>
</html>
