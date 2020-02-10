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
        <h2>Atualize seus dados</h2>
    </div>

    <form class="form-horizontal" action="atualiza-aluno" method="post">

        <div class="form-group">
            <label class="col-sm-2 control-label required">CPF</label>
            <div class="col-sm-8">
                <input class="form-control" type="text"name="cpf" minlength="3" maxlength="11" required>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label required">Nome</label>
            <div class="col-sm-8">
                <input class="form-control" type="text" name="nome" minlength="3" maxlength="50" required>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label required">Email</label>
            <div class="col-sm-8">
                <input class="form-control" type="text" name="email" minlength="3" maxlength="50" required>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label required">Celular</label>
            <div class="col-sm-8">
                <input class="form-control" type="text" name="celular" minlength="3" maxlength="14" required>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label required">Login</label>
            <div class="col-sm-8">
                <input class="form-control" type="text" name="login" minlength="3" maxlength="20" required>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label required">Senha</label>
            <div class="col-sm-8">
                <input class="form-control" type="password" name="senha" minlength="3" maxlength="255" required>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">Endereço</label>
            <div class="col-sm-8">
                <input class="form-control" type="text" name="endereco" minlength="3" maxlength="50">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">Cidade</label>
            <div class="col-sm-8">
                <input class="form-control" type="text" name="cidade" minlength="3" maxlength="30">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">Bairro</label>
            <div class="col-sm-8">
                <input class="form-control" type="text" name="bairro" minlength="3" maxlength="30">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">CEP</label>
            <div class="col-sm-8">
                <input class="form-control" type="text" name="cep" minlength="3" maxlength="9">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-8 col-sm-offset-2">
                <button type="submit" class="btn btn-primary"><span
                        class="glyphicon glyphicon-save"></span>Enviar
                </button>
            </div>
        </div>
    </form>

</div>
<jsp:include page="paginas/rodape.html"/>
</body>
</html>