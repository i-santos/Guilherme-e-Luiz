<%-- 
    Document   : login
    Created on : 21/11/2019, 16:45:56
    Author     : 04285763117
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <a href="index.html">Home</a>
        <h1>Faça seu Login!</h1>
        <form method="POST" action="AutenticarServlet">
            <p>
                <label>E-mail: </label>
                <input type="email" name="email" value=""/>
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="senha" value=""/>
            </p>
            <input type="submit" value="Login" />
        </form>
        <p>
            <a href="AutenticarServlet">Não possui uma conta? Faça o cadastro</a>
        </p>

    </body>
</html>
