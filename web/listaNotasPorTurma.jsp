<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/styles.css">
    <title>Bootstrap</title>
</head>
<body>
<jsp:include page="paginas/menu.jsp"/>
<div class="container">
    <br>
    <div class="jumbotron">
        <h2>Escreva o ID da turma que quer verificar as notas</h2>
    </div>

    <form class="form-horizontal" action="/notas-turma" method="get">

        <div class="form-group">
            <label class="col-sm-2 control-label required">Id Turma</label>
            <div class="col-sm-8">
                <input class="form-control" type="number" name="idTurma" required>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-8 col-sm-offset-2">
                <button type="submit" class="btn btn-primary">Enviar
                </button>
            </div>
        </div>
    </form>
</div>
<jsp:include page="paginas/rodape.html"/>
</body>
</html>