<%-- 
    Document   : result
    Created on : 02/06/2024, 09:00:48 PM
    Author     : angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <c:choose>
        <c:when test="${param.isErrorPage == null || param.isErrorPage == ''}">
            <h1>Debe ingresar valores mayores a 0.</h1>
        </c:when>
        <c:otherwise>
            <h1>El error es: ${param.isErrorPage}</h1>
        </c:otherwise>
        </c:choose>
        
    </body>
</html>
