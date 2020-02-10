<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
    <br/>

    <div class="row">


        <c:forEach items="${cursos}" var="val">
        <div class="col-md-3 col-sm-4">
            <div class="thumbnail">
                <img class="img-rounded img-responsive center-block" src="images/investimentos.jpg">
                <div class="caption">
                    <h3>${val.nome}</h3>
                    <p>ID:${val.id}</p>
                    <p>Preço:${val.preco}</p>
                    <p>Ementa:${val.ementa}</p>
                    <p>Carga horária:${val.cargaHoraria}</p>
                    <p>Requisito:${val.requisito}</p>
                </div>
            </div>
        </div>
        </c:forEach>


        <div class="col-md-3 col-sm-4">
            <div id="pm" class="thumbnail">
                <img class="img-rounded img-responsive center-block" src="images/scrum.jpg">
                <div class="caption">
                    <h3>Gestão Ágil</h3>
                    <p>Indiscutivelmente o mais completo: gestão ágil de projetos com SCRUM Agile, Liderança, Negociação
                        e Produtividade.</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-4">
            <div class="thumbnail">
                <img class="img-rounded img-responsive center-block" src="images/planejamento.jpg">
                <div class="caption">
                    <h3>Planejamento</h3>
                    <p>Indiscutivelmente o mais completo: planejamento, gestão de projetos, MS Project, Liderança,
                        Negociação, GTD e Coaching</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-4">
            <div class="thumbnail">
                <img class="img-rounded img-responsive center-block" src="images/python.jpg">
                <div class="caption">
                    <h3>Python</h3>
                    <p>Aprenda Programação em Python e Resolva Problemas Reais do Mundo das Finanças em Python -
                        Treinamento Completo em Python</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-4">
            <div class="thumbnail">
                <img class="img-rounded img-responsive center-block" src="images/trade.jpg">
                <div class="caption">
                    <h3>Day Trade</h3>
                    <p>Domine Análise Técnica e seja um Trader da Bolsa de Valores em Day Trade e Swing Trade</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-4">
            <div class="thumbnail">
                <img class="img-rounded img-responsive center-block" src="images/design.jpg">
                <div class="caption">
                    <h3>Design Gráfico</h3>
                    <p>Aprenda Photoshop, Illustrator, InDesign, Camera Raw e Adobe Portfólio. Projetos reais para você
                        praticar e aplicar</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-4">
            <div class="thumbnail">
                <img class="img-rounded img-responsive center-block" src="images/devweb.jpg">
                <div class="caption">
                    <h3>Desenvolvimento Web</h3>
                    <p>Domine Web - 20 Cursos - HTML5, CSS3, SASS, Bootstrap, JS, ES6, PHP 7, OO, MySQL, JQuery, MVC,
                        APIs, IONIC e muito mais</p>
                </div>
            </div>
        </div>

        <div class="col-md-3 col-sm-4">
            <div class="thumbnail">
                <img class="img-rounded img-responsive center-block" src="images/algoritmos.jpg">
                <div class="caption">
                    <h3>Algoritmos</h3>
                    <p>Aprenda de uma vez por todas Algoritmos, Lógica de Programação, Constantes, Variáveis, Operadores
                        e muito mais!</p>
                </div>
            </div>
        </div>
    </div>
</div>

