<%--
Document : inserirConta
Created on : 20/09/2017, 20:49:49
--%>
<%@page import="bancodao.Conta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>Inserir Conta</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="assets/css/layout.css">
        
    </head>
    <body>        
        <div class="container titulo">
            <%
                int result = (Integer) request.getAttribute("inserir_conta");
                if (result != -1) {
            %>
            <h1>Conta Inserida com Sucesso!</h1>

            <%}
            else{
            %>
                <h1>Desculpe, conta ja existente!</h1>
            <%
                }
            %>
            <br>
            <input class="btn" type="button" value="Voltar" onClick="history.go(-1)">
        </div>
    </body>
</html>