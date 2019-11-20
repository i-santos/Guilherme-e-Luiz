<%-- 
    Document   : respostaCadastro
    Created on : 20/11/2019, 13:09:49
    Author     : igor
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 

    String mensagemDeErroSenha = (String) request.getAttribute("erroSenha");
    String mensagemDeErroEmail = (String) request.getAttribute("erroEmail");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <a href="index.html">Home</a>
        <h1>Faça seu cadastro</h1>
        <form method="POST" action="CadastroServlet">
            <p>
                <label>E-mail: </label>
                <input name="email"/>
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="password"/>
            </p>
            <input type="submit"/>
            <p>
                <% if(mensagemDeErroEmail.length() > 0) { %>
                    <%= "* " + mensagemDeErroEmail %>
                <% } %>
            </p>
            <p>
                <% if(mensagemDeErroSenha.length() > 0) { %>
                    <%= "* " + mensagemDeErroSenha %>
                <% } %>
            </p>
        </form>
    </body>
</html>

