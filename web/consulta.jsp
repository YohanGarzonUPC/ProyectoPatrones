<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : consulta
    Created on : 22/11/2022, 11:01:25 PM
    Author     : USUARIO
--%>
<%@page import="modelo.Usuario"  %>
<%@page import="java.util.ArrayList"  %>
<%
    ArrayList<Usuario> usuario = (ArrayList<Usuario>)request.getSession().getAttribute("usuario");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mostrar todo</h1>
        <%
            for(int i=0; i<usuario.size(); i++){
                out.println("<p>Usuario: "+usuario.get(i).getUserName()+"</p>");
            }
        %>
        <c:forEach var="usuarios" items="${sessionScope.usuario}">
            <p>$(usuarios.UserName)</p>
        </c:forEach>
        <form action="RegistroUsua" method="post">
            <div class="form-group">
                <label >Agregar Al carrito</label>
                <input type="String" class="form-control" name="user_Name" placeholder="Nombre "required>
            </div>
    </body>
</html>
