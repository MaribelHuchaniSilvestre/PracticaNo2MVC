<%
    if (session.getAttribute("login")!="OK"){
        response.sendRedirect("login.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido <%= session.getAttribute("usuario") %></h1>
        <ul>
            <li><a href="inscripcion_curso.jsp">Inscripcion en curso</a></li>
            <li><a href="registro_usuario.jsp">Registro de usuarios</a></li>
            <li><a href="registro_producto.jsp">Inscripcionde productos</a></li>
            <li><a href="registro_libro.jsp">Registro de libros</a></li>
        </ul>
        <p></p>
        <a href="LoginSession">Salir</a>
    </body>
</html>
