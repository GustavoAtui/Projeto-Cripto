/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import model.Investidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import model.Investidor;

/**
 *
 * @author Naja Info
 */
public class Controle {

    public Controle(Investidor pessoa) {
    }
    private Conexao conexao = new Conexao();

    
    public String data(){
        Date data = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy HH:mm");
        return simple.format(data);

    }
    

    
    
    
    private void atualizarCotacao(String moeda, double novoValor) throws SQLException {
    Connection con = conexao.getConnection();
    PreparedStatement pstmt = null;

    try {
        String query = null;
        switch (moeda) {
            case "btc":
                query = "UPDATE usuario.cripto SET valor = ? WHERE moeda = 'btc'";
                break;
            case "eth":
                query = "UPDATE usuario.cripto SET valor = ? WHERE moeda = 'eth'";
                break;
            case "xrp":
                query = "UPDATE usuario.cripto SET valor = ? WHERE moeda = 'xrp'";
                break;
            default:
                throw new IllegalArgumentException("Moeda inválida: " + moeda);
        }
        pstmt = con.prepareStatement(query);
        pstmt.setDouble(1, novoValor);
        pstmt.executeUpdate();
    } finally {
        if (pstmt != null) {
            pstmt.close();
        }
        if (con != null) {
            con.close();
        }
        }
    }   
    public void depositoReais(double valor, Investidor pessoa) {
        double saldoAtual = pessoa.getSaldoreais();
        double novoSaldo = saldoAtual + valor;
        pessoa.setSaldoreais(novoSaldo);
        
        if (novoSaldo >= 0) {
            pessoa.setSaldoreais(novoSaldo);
            
            
            if (atualizarSaldoBancoDados(pessoa.getCpf(), novoSaldo)) {
                JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar saldo no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saqueReais(double valor, Investidor pessoa) {
        double saldoAtual = pessoa.getSaldoreais();
        double novoSaldo = saldoAtual - valor;
        
        if (novoSaldo >= 0) {
            pessoa.setSaldoreais(novoSaldo);
            
            
            if (atualizarSaldoBancoDados(pessoa.getCpf(), novoSaldo)) {
                JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar saldo no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar o saque.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
     private boolean atualizarSaldoBancoDados(String senha, double novoSaldo) {
        String sql = "UPDATE usuario.pessoa SET saldoreais = ? WHERE senha = ?";
        
        try (Connection con = conexao.getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setDouble(1, novoSaldo);
            pstmt.setString(2, senha);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Saldo atualizado no banco de dados.");
                return true; 
            } else {
                return false; 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar saldo no banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false; 
        }
    }
    
    
    
    
}
