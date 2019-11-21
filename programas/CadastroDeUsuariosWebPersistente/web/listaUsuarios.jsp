<%-- 
    Document   : listaUsuarios
    Created on : 21/11/2019, 13:57:56
    Author     : Professor
--%>

<%@page import="model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="index.html">Home</a>
        <h1>Usuários cadastrados:</h1>

        <table>
            <style>
                thead {
                    background: #dfdfdf; font-size: 1.2em;
                }
                thead td {
                    font-weight: bold;
                }
            </style>
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Email</td>
                    <td>Senha</td>
                </tr>
            </thead>
            <tbody>

                <% for (Usuario u : usuarios) {%>
                <tr>
                    <td>
                        <%= u.getId()%>
                    </td>
                    <td>
                        <%= u.getEmail()%>
                    </td>
                    <td>
                        <%= u.getSenha()%>
                    </td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>
