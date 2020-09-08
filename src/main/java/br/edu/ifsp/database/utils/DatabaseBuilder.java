package br.edu.ifsp.database.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class DatabaseBuilder {

    public static void main(String[] args) {
        clear();
        build();
    }

    private static void clear() {
        System.out.println("Cleaning up...");
        try {
            Files.deleteIfExists(Paths.get("IRPF.db"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void build() {
        try (Statement stmt = ConnectionFactory.createStatement()) {
            stmt.addBatch("CREATE TABLE Declaracao (\n" +
                    "\tid INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                    "\tvalor_pago REAL,\n" +
                    "\ttipo INTEGER NOT NULL,\n" +
                    "\trenda REAL);");
            stmt.addBatch("CREATE TABLE Deducao (\n" +
                    "\tid INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                    "\tdescricao TEXT,\n" +
                    "\tcnpj TEXT,\n" +
                    "\tinstituicao TEXT,\n" +
                    "\tconselho TEXT,\n" +
                    "\tvalor REAL);");
            stmt.executeBatch();
            stmt.close();
            System.out.println("Database has been created ...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
