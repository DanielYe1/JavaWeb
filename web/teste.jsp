<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<% List elist = (List)request.getAttribute("alunos");
    for (int i = 0; i < elist.size(); i++) {
        out.println(elist.get(0));
    }
%>
<c:forEach items="${alunos}" var="student">
    <p>${student.nome}</p><br/>
</c:forEach>

</body>
</html>
