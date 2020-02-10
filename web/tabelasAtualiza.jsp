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

<% //In case, if Editor session is not set, redirect to Login page
    if ((request.getSession(false).getAttribute("admin") == null)) {
%>
<jsp:forward page="semacesso.jsp"></jsp:forward>
<%} %>
<jsp:include page="paginas/menu.jsp"/>
<br>
<div class="container">
    <div class="jumbotron">
        <h2>Atualização de dados</h2>
    </div>
</div>
<jsp:include page="paginas/corpo-atualiza-tabelas.html"/>
<jsp:include page="paginas/rodape.html"/>
</body>
</html>