<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

<jsp:include page="paginas/menu.jsp" />

<div class="container">

    <br>
    <div class="jumbotron">
        <h2>Central</h2>
        <p>Caso ja esteja logado, entre na sua central!!</p>
    </div>
    <br>
    <ul class="list-group">
        <li class="list-group-item"><a href="centralAluno.jsp">Central do aluno</a></li>
        <li class="list-group-item"><a href="centralInstrutor.jsp">Cenral do instrutor</a></li>
        <li class="list-group-item"><a href="centralAdmin.jsp">Central do admin</a></li>
    </ul>
</div>
<jsp:include page="paginas/rodape.html" />

</body>
</html>
