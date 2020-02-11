<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <br/>

    <div class="row">

        <c:forEach items="${cursos}" var="val">
        <div class="col-md-3 col-sm-4">
            <div class="thumbnail">
                <img class="img-rounded img-responsive center-block" src="images/curso/${val.id}.png">
                <div class="caption">
                    <h3>${val.nome}</h3>
                    <p>Preco:${val.preco}</p>
                    <p>Ementa:${val.ementa}</p>
                    <p>Carga horaria:${val.cargaHoraria}</p>
                    <p>Requisito:${val.requisito}</p>
                </div>
            </div>
        </div>
        </c:forEach>

    </div>
</div>

