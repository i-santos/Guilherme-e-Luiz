<%-- 
    Document   : index
    Created on : 29/11/2019, 17:21:47
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Tarefas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Lista de Tarefas</h1>
        
        <h2>Faça seu Login</h2>
        <form method="POST" action="AutenticarServlet">
            <p>
                <label>E-mail: </label>
                <input type="email" name="email" />
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="senha" />
            </p>
            <input type="submit" value="Entrar"/>
            <p>${erro}</p>
        </form>
        <p>
            <a href="cadastro.jsp">Não possui uma conta ainda? Faça seu cadastro.</a>
        </p>
    </body>
</html>