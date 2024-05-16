/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
/**
 *
 * @author Naja Info
 */
public class Conexao {
    public Connection getConnection() throws SQLException{
    try{
        Connection conexao = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/projava",
        "postgres", "fei");
        System.out.println("Conexao bem sucedida");
        return conexao;
    }catch(SQLException e){
        System.out.println(e);
        return null;
    }
  } 
}
