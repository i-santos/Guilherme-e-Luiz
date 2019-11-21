<%-- 
    Document   : removeUsuario
    Created on : 21/11/2019, 14:13:46
    Author     : Professor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensagem = (String) request.getAttribute("mensagem");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remover um usuário</title>
    </head>
    <body>
        <a href="index.html">Home</a>
        <h2>Remover um usuário</h2>
        <form method="POST" action="RemoverUsuarioServlet">
            <p>
                <label>E-mail:</label>
                <input type="email" name="email"/>
            </p>
            <input type="submit"/>
            <% if (mensagem != null) { %>
            <p><%= "* " + mensagem %></p>
            <% }%>
        </form>
    </body>
</html>
