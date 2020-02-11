<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Valor</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/styles.css">
</head>
<script src="../js/bootstrap.js"></script>
<body>

<jsp:include page="/paginas/menu.jsp"/>

<div class="jumbotron">
    <h2>O valor a receber é: ${valor}</h2>
</div>

<jsp:include page="/paginas/rodape.html"/>

</body>
</html>
