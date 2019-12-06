<%-- 
    Document   : cadastro
    Created on : 29/11/2019, 17:02:36
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro | Lista de Tarefas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Lista de Tarefas</h1>

        <h2>Faça seu Cadastro</h2>
        <form method="POST" action="CadastrarServlet">
            <p>
                <label>E-mail: </label>
                <input type="email" name="email" />
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="senha" />
            </p>
            <input type="submit" value="Cadastrar"/>
            <p>${erro}</p>
        </form>
        <p>
            <a href="index.jsp">Já possui uma conta? Faça o login.</a>
        </p>
    </body>
</html>