<%-- 
    Document   : home
    Created on : 29/11/2019, 17:23:27
    Author     : igor
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Tarefa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Tarefa> tarefas = (ArrayList<Tarefa>) request.getAttribute("tarefas");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <a href="LogoutServlet">Logout</a>
        <h1>Seja bem-vindo, ${usuario.email}</h1>

        <form method="POST" action="AdicionarTarefaServlet">
            <p>
                <label>Título: </label>
                <input type="text" name="titulo"/>
            </p>
            <input type="submit" value="Adicionar Tarefa"/>
            <p>${erro}</p>
        </form>

        <h2>Lista de Tarefas</h2>

        <form method="POST" action="FinalizarTarefaServlet">

            <% for (Tarefa t : tarefas) {%>

            <p>
                <input type="checkbox" name="tarefas" value="<%= t.getId() %>"/>
                <%= t.getTitulo()%> ( <%= t.isFinalizada() %> )
            </p>
            <% }%>
            
            <input type="submit" value="Finalizar" />
        </form>


    </body>
</html>
