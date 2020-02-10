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
                    <img class="img-rounded img-responsive center-block" src="images/aluno1.jpeg">
                    <div class="caption">
                        <h3>${aluno.id}</h3>
                        <p>${aluno.comentario}</p>
                    </div>
                </div>
            </div>
        </c:forEach>


        <div class="col-md-3 col-sm-4">
            <div id="pm" class="thumbnail">
                <img class="img-rounded img-responsive center-block" src="images/aluno2.jpeg">
                <div class="caption">
                    <h3>Enzo Silva</h3>
                    <p>Sim. Foi acima das minhas expectativas. Não atuo na área, mas tive gerenciamento de projeto na
                        faculdade. Com este curso pude ver a prática. O intuito é utilizar nos meus projetos e ampliar
                        meu leque oportunidades no meu currículo.</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-4">
            <div class="thumbnail">
                <img class="img-rounded img-responsive center-block" src="images/aluno3.jpeg">
                <div class="caption">
                    <h3>Ana Farias</h3>
                    <p>O curso é perfeito, muito completo. Além de me fazer evoluir profissionalmente me fez evoluir
                        como pessoa. Hoje sei perfeitamente como planejar meu dia a dia e como executar com exito minhas
                        tarefas diárias!</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-4">
            <div class="thumbnail">
                <img class="img-rounded img-responsive center-block" src="images/aluno2.jpeg">
                <div class="caption">
                    <h3>Jonas Andrade</h3>
                    <p>Excelente curso. Com uma metodologia simples e bem explicativa. Conteudo bem selecionado. Ideal
                        para quem quer aprender como desenvolver melhor suas ideias. Com certeza, com a aplicação das
                        tecnicas, todos terão um crescimento considerado não só na vida profissional como também na
                        pessoal.</p>
                </div>
            </div>
        </div>
    </div>

</div>

