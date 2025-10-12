<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Roberto de Frutos Jiménez</h1>
    <p>
        <% 
        String nombre = "Roberto";
        String profesion = "Profesión";
        int edad = 18;
        %>
        Mi nombre es <%= nombre %>
        
        <%
        if(edad >= 18){
        }%>
        <a>Tienes mas de 18</a>
        
    </p>
</body>
</html>