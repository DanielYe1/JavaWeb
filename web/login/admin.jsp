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
        <li class="list-group-item"><a href="admin">Listar e deletar dados</a></li>
        <li class="list-group-item"><a href="../tabelasCadastro.jsp">Cadastrar dados</a></li>
        <li class="list-group-item"><a href="../tabelasAtualiza.jsp">Alterar dados</a></li>
        <li class="list-group-item"><a href="comentarios">Verificar notas alunos</a></li>
        <li class="list-group-item"><a href="comentarios">Verifica valor professores</a></li>
        <li class="list-group-item"><a href="comentarios">Upload foto instrutor</a></li>
        <li class="list-group-item"><a href="comentarios">Upload foto curso</a></li>
    </ul>
</div>
<jsp:include page="../paginas/rodape.html" />

</body>
</html>
