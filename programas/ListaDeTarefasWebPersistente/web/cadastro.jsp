<%-- 
    Document   : cadastro
    Created on : 21/11/2019, 16:43:48
    Author     : 04285763117
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <a href="index.html">Home</a>
        <h1>Faça seu cadastro!</h1>
        <form method="POST" action="CadastrarServlet">
            <p>
                <label>E-mail: </label>
                <input type="email" name="email" value=""/>
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="senha" value=""/>
            </p>
            <input type="submit" value="Cadastrar" />
        </form>
        <p>
            <a href="AutenticarServlet">Já possui conta? Faça o login</a>
        </p>
    </body>
</html>
