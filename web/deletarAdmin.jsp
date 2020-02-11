<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h2>Deletar por ID</h2>
    </div>
    <br>
    <h2>Aluno</h2>
    <form class="form-horizontal" action="deleta-aluno" method="post">
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

    <h2>Instrutor</h2>
    <form class="form-horizontal" action="deleta-instrutor" method="post">
        <div class="form-group">
            <label class="col-sm-2 control-label">ID Instrutor</label>
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

    <h2>Turma</h2>
    <form class="form-horizontal" action="deleta-turma" method="post">
        <div class="form-group">
            <label class="col-sm-2 control-label">ID Turma</label>
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

    <h2>Curso</h2>
    <form class="form-horizontal" action="deleta-curso" method="post">
        <div class="form-group">
            <label class="col-sm-2 control-label">ID Curso</label>
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
