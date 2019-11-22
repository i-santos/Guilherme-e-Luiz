<%-- 
    Document   : listaUsuarios
    Created on : 22/11/2019, 17:23:24
    Author     : igor
--%>

<%@page import="modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuários cadastros</title>
    </head>
    <body>
        <a href="index.html">Home</a>
        <h1>Usuários cadastrados:</h1>
        <table>
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Email</td>
                    <td>Senha</td>
                </tr>
            </thead>
            <tbody>
                <% for (Usuario u : usuarios) { %>
                <tr>
                    <td><%= u.getId() %></td>
                    <td><%= u.getEmail() %></td>
                    <td><%= u.getSenha() %></td>
                </tr>                
                <% } %>
            </tbody>
        </table>
    </body>
</html>
