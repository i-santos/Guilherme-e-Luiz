<%-- 
    Document   : home
    Created on : 29/11/2019, 17:23:27
    Author     : igor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Tarefa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <%@include file="jspf/nav.jspf" %>
        <h1>Seja bem-vindo, ${usuario.email}</h1>

        <form method="POST" action="AdicionarTarefaServlet" enctype="multipart/form-data">
            <p>
                <label>Título: </label>
                <input type="text" name="titulo"/>
            </p>
            <p>
                <label>Imagem: </label>
                <input type="file" name="imagem"/>
            </p>
            <input type="submit" value="Adicionar Tarefa"/>
            <p>${erro}</p>
        </form>
        <!--JSTL, EL-->

        <c:choose>

            <c:when test="${tarefas.size() == 0}">
                <p>Sua lista de tarefas está vazia!</p>
            </c:when>

            <c:when test="false">
                <p>Aqui tambeḿ pode ter uma condição!!</p>
            </c:when>

            <c:otherwise>
                <h2>Lista de Tarefas</h2>

                <form method="POST" action="FinalizarTarefaServlet">

                    <c:forEach items="${tarefas}" var="t">
                        <p>
                            <input type="checkbox" name="tarefas" value="${t.id}"/>
                            <img src="ImagemTarefaServlet?imagem=${t.nomeImagem}" width="64" height="64"/>
                            ${t.titulo} ( 
                            <c:if test="${t.finalizada}">
                                Finalizada
                            </c:if>
                            <c:if test="${!t.finalizada}">
                                Em Aberto
                            </c:if>
                            )
                        </p>
                    </c:forEach>



                    <input type="submit" value="Finalizar" />
                </form>
            </c:otherwise>

        </c:choose>


    </body>
</html>
