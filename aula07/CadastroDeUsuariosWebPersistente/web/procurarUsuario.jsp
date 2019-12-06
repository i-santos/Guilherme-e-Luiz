<%-- 
    Document   : procurarUsuario
    Created on : 22/11/2019, 17:50:15
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procurar Usuário</title>
    </head>
    <body>
        <a href="index.html">Home</a>
        <h1>Procure um usuário:</h1>
        <form method="POST" action="ProcurarServlet">
            <p>
                <label>E-mail: </label>
                <input type="email" name="email"/>
            </p>
            <input type="submit" value="Procurar" />
        </form>
    </body>
</html>
