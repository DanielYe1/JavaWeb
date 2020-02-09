<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/styles.css">
</head>
<script src="js/bootstrap.js"></script>
<body>

<jsp:include page="paginas/menu.html" />
<c:forEach items="${alunos}" var="student">
    <p>${student}</p><br/>
</c:forEach>
TESTEZAO
<jsp:include page="teste.jsp" />

</body>
</html>
