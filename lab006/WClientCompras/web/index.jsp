<%-- 
    Document   : index
    Created on : 02/06/2024, 03:47:51 PM
    Author     : angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
                background-color: #f0f0f0;
            }
            form {
                width: 300px;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            .form-group {
                margin-bottom: 15px;
                display: flex;
                flex-direction: column;
                align-items: center;
            }
            label {
                width: 100%;
                margin-bottom: 5px;
                text-align: left;
            }
            input[type="number"] {
                width: 100%;
                padding: 8px;
                box-sizing: border-box;
            }
            input[type="submit"] {
                width: 100%;
                padding: 10px;
                background-color: #28a745;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-top: 10px;
            }
            input[type="submit"]:hover {
                background-color: #218838;
            }
            .container {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="container">
        <h1>Compra de productos</h1>
            <form action="ComprasServlet" method="post">
                <div class="form-group">
                    <label for="cantidadPan">Cantidad de Pan:</label>
                    <input type="number" id="cantidadPan" name="cantidadPan" min="0" value="0" required>
                </div>
                <div class="form-group">
                    <label for="cantidadQueso">Cantidad de Queso:</label>
                    <input type="number" id="cantidadQueso" name="cantidadQueso" min="0" value="0" required>
                </div>
                <div class="form-group">
                    <label for="cantidadPlatano">Cantidad de Plátano:</label>
                    <input type="number" id="cantidadPlatano" name="cantidadPlatano" min="0" value="0" required>
                </div>
                <div class="form-group">
                    <label for="cantidadNaranja">Cantidad de Naranja:</label>
                    <input type="number" id="cantidadNaranja" name="cantidadNaranja" min="0" value="0" required>
                </div>
                <input type="submit" value="Enviar">
            </form>
        </div>
    </body>
</html>