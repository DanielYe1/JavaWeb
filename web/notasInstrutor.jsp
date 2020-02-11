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
        <h2>Se não for professor da turma, ocorrerá um erro na página</h2>
    </div>

    <form class="form-horizontal" action="atualiza-nota" method="post">

        <div class="form-group">
            <label class="col-sm-2 control-label required">ID da turma</label>
            <div class="col-sm-8">
                <input class="form-control" type="number" name="turmas_id" minlength="3" maxlength="10" required>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label required">ID do aluno</label>
            <div class="col-sm-8">
                <input class="form-control" type="number" name="alunos_id" minlength="3" maxlength="11" required>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">Nota</label>
            <div class="col-sm-8">
                <input class="form-control" type="number" name="nota" min="0" max="10">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-8 col-sm-offset-2">
                <button type="submit" class="btn btn-primary"><span
                        class="glyphicon glyphicon-save"></span>Enviar
                </button>
            </div>
        </div>
        <br/>
        <br/>
        <br/>
    </form>


</div>
<jsp:include page="paginas/rodape.html"/>
</body>
</html>