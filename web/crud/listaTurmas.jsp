<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Turmas</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/styles.css">
</head>
<script src="../js/bootstrap.js"></script>
<body>

<jsp:include page="../paginas/menu.jsp" />
<c:forEach items="${turmas}" var="val">
    <p>${val}</p><br/>
</c:forEach>
<jsp:include page="../paginas/rodape.html" />

</body>
</html>
