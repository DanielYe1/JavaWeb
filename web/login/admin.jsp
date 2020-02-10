<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>

<jsp:include page="../paginas/menu.jsp" />
<div class="container">

    <br>
    <div class="jumbotron">
        <h2>Central do administrador</h2>
    </div>
    <br>
    <ul class="list-group">
        <li class="list-group-item"><a href="comentarios">Matricula em curso</a></li>
        <li class="list-group-item"><a href="comentarios">Alterar dados</a></li>
        <li class="list-group-item"><a href="comentarios">Verificar notas</a></li>
        <li class="list-group-item"><a href="comentarios">Upload foto</a></li>
    </ul>
</div>
<jsp:include page="../paginas/rodape.html" />

</body>
</html>
