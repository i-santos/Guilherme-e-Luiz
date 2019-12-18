<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
    </head>
    <body>
        <%@include file="jspf/nav.jspf" %>
        <h1>Perfil</h1>
        <form method="POST" action="PerfilServlet" enctype="multipart/form-data">
            <p>
                <label>E-mail: </label>
                <input type="email" value="${usuario.email}" disabled />
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="senha" value="${usuario.senha}"/>
            </p>
            <p>
                <label>Imagem: </label>
                <c:if test="${usuario.imagem != null}">

                    <img src="ImagemPerfilServlet" width="128" height="128"/>
                </c:if>
                <c:if test="${usuario.imagem == null}">

                    <img src="http://placehold.it/128x128" width="128" height="128"/>
                </c:if>
                    
                <input type="file" name="imagem" />
            </p>

            <input type="submit" value="Salvar"/>
            <p>${msg}</p>
        </form>
    </body>
</html>
