package br.com.decola.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConexao() {
        Connection conexao = null;

        try {
            // Use a classe correta para o driver JDBC do SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // Altere a URL de conexão para se adequar ao seu ambiente local
            conexao = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ViagensDB;user=sa;password=TecInfo;encrypt=true;trustServerCertificate=true");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL Exception: " + e.getMessage());
        }
        return conexao;
    }

    public static Connection getConnection() {
        // TODO Auto-generated method stub
        return null;
    }
}
