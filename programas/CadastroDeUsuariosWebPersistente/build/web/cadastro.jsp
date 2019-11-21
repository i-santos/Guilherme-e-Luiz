<%-- 
    Document   : cadastro
    Created on : 21/11/2019, 13:12:13
    Author     : Professor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String email = (String) request.getParameter("email");
    String erroEmail = (String) request.getAttribute("erroEmail");
    
    if (email == null) {
        email = "";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <a href="index.html">Home</a>
        <h1>Faça seu Cadastro</h1>
        <form method="POST" action="CadastrarServlet">
            <p>
                <label>E-mail: </label>
                <input type="email" name="email" value="<%= email %>" />
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="senha" />
            </p>
            <input type="submit"/>
            <p>
                <% if (erroEmail != null) {%>
                    <%= "* " + erroEmail %>
                <% }%>
            </p>
        </form>
    </body>
</html>
