<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/styles.css">
</head>
<script src="js/bootstrap.js"></script>
<body>

<jsp:include page="paginas/menu.jsp"/>

<div class="container">

    <br>
    <h2>Alunos</h2>
    <table class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>id</th>
            <th>cpf</th>
            <th>nome</th>
            <th>email</th>
            <th>celular</th>
            <th>login</th>
            <th>senha</th>
            <th>endereco</th>
            <th>cidade</th>
            <th>bairro</th>
            <th>cep</th>
            <th>comentario</th>
            <th>aprovado</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${alunos}" var="val">
            ${val}
        </c:forEach>
        </tbody>
    </table>


    <h2>Instrutor</h2>
    <table class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>id</th>
            <th>nome</th>
            <th>email</th>
            <th>valorHora</th>
            <th>login</th>
            <th>senha</th>
            <th>experiencia</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${instrutores}" var="val">
            ${val}
        </c:forEach>
        </tbody>
    </table>


    <h2>Turmas</h2>
    <table class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>id</th>
            <th>idInstrutor</th>
            <th>idCurso</th>
            <th>dataInicio</th>
            <th>dataFinal</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${turmas}" var="val">
            ${val}
        </c:forEach>
        </tbody>
    </table>

    <h2>Cursos</h2>
    <table class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>id</th>
            <th>nome</th>
            <th>requisito</th>
            <th>ementa</th>
            <th>cargaHoraria</th>
            <th>preco</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${cursos}" var="val">
            ${val}
        </c:forEach>
        </tbody>
    </table>

</div>
<jsp:include page="paginas/rodape.html"/>

</body>
</html>
