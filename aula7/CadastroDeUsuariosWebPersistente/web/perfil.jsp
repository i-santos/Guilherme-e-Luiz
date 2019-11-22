<%-- 
    Document   : perfil
    Created on : 22/11/2019, 17:58:27
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil do usuário</title>
    </head>
    <body>
        <a href="ProcurarServlet">Voltar</a>
        <h1>Perfil</h1>
        
        <form method="POST" action="AlterarServlet">
            <p>
                <label>ID: </label>
                <input type="number" name="id" value="${usuario.id}"/>
            </p>
            <p>
                <label>E-mail:</label>
                <input type="email" name="email" value="${usuario.email}" />
            </p>
            <p>
                <label>Senha:</label>
                <input type="password" name="senha" value="${usuario.senha}" />
            </p>
            <input type="submit" value="Salvar"/>
            <p>${mensagem}</p>
        </form>
        
    </body>
</html>
