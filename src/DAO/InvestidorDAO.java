/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Naja Info
 */
import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Investidor;
import java.sql.ResultSet;
import java.sql.SQLException;



public class InvestidorDAO {
    private Connection conn;
    
    public InvestidorDAO(Connection conn){
        this.conn = conn;
    }
    
    
    
    public ResultSet consultar(Investidor pessoa) throws SQLException{
        
        String sql = "SELECT * FROM usuario.pessoa WHERE cpf = ? AND senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getCpf());
        statement.setString(2, pessoa.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
        
        
    }
    
    
}
