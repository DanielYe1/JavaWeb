<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">

    <br/>
    <div class="jumbotron">
        <h2>Instrutores</h2>

        <p>As pessoas responsáveis por te capacitar para qualquer desafio.</p>
    </div>

    <div class="row">

        <c:forEach items="${instrutores}" var="instrutor">
        <div class="col-md-4 col-sm-6">
            <div class="thumbnail">
                <img class="img-rounded img-responsive center-block" src="images/instrutor/${instrutor.id}.png">
                <div class="caption">
                    <h3>${instrutor.nome}</h3>
                    <p>${instrutor.experiencia}</p>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>

</div>