<%-- 
    Document   : procuraUsuario
    Created on : 21/11/2019, 14:12:28
    Author     : Professor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    String email = request.getParameter("email");
    String erro = (String) request.getAttribute("erro");

    if (email == null) {
        email = "";
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procurar um usuário</title>
    </head>
    <body>
        <a href="index.html">Home</a>
        <h2>Procurar um usuário</h2>
        <form method="POST" action="ProcurarUsuarioServlet">
            <p>
                <label>E-mail:</label>
                <input type="email" name="email" value="<%= email%>"/>
            </p>
            <input type="submit"/>
            <% if (erro != null) { %>
            <p>
                <%= "* " + erro %>
            </p>
            <% }%>
        </form>
    </body>
</html>
