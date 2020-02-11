<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
    <div class="jumbotron">
        <h2>Aprovar alunos</h2>
    </div>
    <br>

    <h2>Novos registrados</h2>
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


    <h2>Aluno a ser aprovado</h2>
    <form class="form-horizontal" action="transforma-aluno" method="post">
        <div class="form-group">
            <label class="col-sm-2 control-label">ID Aluno</label>
            <div class="col-sm-4">
                <input class="form-control" type="number" name="id">
            </div>

            <div class="form-group">
                <div class="col-sm-4 col-sm-offset-2">
                    <button type="submit" class="btn btn-primary"> Enviar
                    </button>
                </div>
            </div>
        </div>
    </form>

</div>
<jsp:include page="paginas/rodape.html"/>

</body>
</html>
