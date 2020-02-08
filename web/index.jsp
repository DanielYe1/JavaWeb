<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: daniel.ye
  Date: 08/03/17
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
$DEVERIA FUNCIONAR$
<% List elist = (List)request.getAttribute("empList");
    for (int i = 0; i < elist.size(); i++) {
        out.println(elist.get(0));
    }
%>

</body>
</html>
