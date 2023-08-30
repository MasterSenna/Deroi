<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inserir Viagem</title>
</head>
<body>
    <h1>Formulário de Inserção de Viagem</h1>
    <form action="/InserirViagemServlet" method="POST">
        <label for="destino">Destino:</label>
        <input type="text" id="destino" name="destino" required><br><br>
        
        <label for="data_partida">Data de Partida:</label>
        <input type="date" id="data_partida" name="data_partida" required><br><br>
        
        <label for="data_retorno">Data de Retorno:</label>
        <input type="date" id="data_retorno" name="data_retorno" required><br><br>
        
        <input type="submit" value="Inserir Viagem">
    </form>
</body>
</html>
    