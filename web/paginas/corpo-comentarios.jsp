<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">

    <br/>
    <div class="jumbotron">
        <h2>Feedback do aluno</h2>
    </div>

    <div class="row">

        <c:forEach items="${alunos}" var="aluno">
            <div class="col-md-3 col-sm-4">
                <div class="thumbnail">
                    <img class="img-rounded img-responsive center-block" src="images/aluno/${aluno.id}.png">
                    <div class="caption">
                        <h3>${aluno.nome}</h3>
                        <p>${aluno.comentario}</p>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>

</div>

