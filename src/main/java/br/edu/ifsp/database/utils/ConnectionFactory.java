package br.edu.ifsp.database.utils;

import java.sql.*;

public class ConnectionFactory implements AutoCloseable{ // para o try-with-resources

    private static Connection connection; //variável precisa ser estática
    private static PreparedStatement preparedStatement;  //variável precisa ser estática
    private static Statement statement;

    //Cria um objeto statement já configurado
    public  static Connection createConnection() {
        try {
            if(connection == null)
                connection = DriverManager.getConnection("jdbc:sqlite:IRPF.db");
        }
        catch (SQLException e) { e.printStackTrace();}
        return connection;
    }

    //Cria um objeto statement já configurado
    public  static PreparedStatement createPreparedStatement(String sql) {
        try {preparedStatement = createConnection().prepareStatement(sql);}
        catch (SQLException e) { e.printStackTrace();}
        return preparedStatement;
    }

    //Cria um objeto statement já configurado
    public  static Statement createStatement() {
        try {statement = createConnection().createStatement();}
        catch (SQLException e) { e.printStackTrace();}
        return statement;
    }

    @Override
    public void close() throws Exception {
            if(connection != null){
                connection.close();
                if(preparedStatement != null)
                    preparedStatement.close();
                if(statement != null)
                    statement.close();
        }
    }
}