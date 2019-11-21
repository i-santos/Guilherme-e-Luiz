<%-- 
    Document   : usuario
    Created on : 21/11/2019, 14:11:30
    Author     : Professor
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario u = (Usuario) request.getAttribute("usuario");
    String mensagem = (String) request.getAttribute("mensagem");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="procuraUsuario.jsp">Voltar</a>
        <h1>Perfil</h1>
        <form method="POST" action="AlterarUsuarioServlet">
            <input type="hidden" name="id" value="<%= u.getId()%>"/>
            <p>
                <label>E-mail: </label>
                <input type="email" name="email" value="<%= u.getEmail()%>"/>
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="senha" value="<%= u.getSenha()%>"/>
            </p>
            <input type="submit" value="Salvar"/>

            <% if (mensagem != null) {%>
            <p>

                <%= "* " + mensagem%>
            </p>
            <% }%>
        </form>
    </body>
</html>
