<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="index.jsp" class="navbar-brand">
                Home
            </a>
        </div>
        <div class="collapse navbar-collapse" id="collapsemenu">
            <ul class="nav navbar-nav">
                <li><a href="cursos">Cursos</a></li>
                <li><a href="sobre.jsp">Sobre</a></li>
                <li><a href="instrutor">Professores</a></li>
                <li><a href="comentarios">Comentários</a></li>
                <li><a href="registro.jsp">Registro</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="central.jsp">Central</a></li>
                <%
                    if((request.getSession().getAttribute("id") != null)) {
                        out.println("<li><a href=\"logout\">Logout</a></li>");
                    }
                %>
            </ul>
        </div>
    </div>
</nav>
