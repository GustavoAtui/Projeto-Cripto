/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Gustavo Atui
 * pega as informacoes das tabelas e tras para o codigo 
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Investidor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;




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
    public boolean atualizarSaldoBancoDados(Investidor pessoa) {
        String sql = "UPDATE usuario.pessoa SET saldoreais = ?, saldobtc = ?, saldoeth = ?, saldoxrp = ? WHERE senha = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, pessoa.getSaldoreais());
            pstmt.setDouble(2, pessoa.getSaldobtc());
            pstmt.setDouble(3, pessoa.getSaldoeth());
            pstmt.setDouble(4, pessoa.getSaldoxrp());
            pstmt.setString(5, pessoa.getSenha());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar saldo no banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public String atualizarCotacoes() throws SQLException {
        StringBuilder sb = new StringBuilder();
        String sql = "SELECT moeda, valor FROM usuario.criptos WHERE moeda IN ('btc', 'eth', 'xrp')";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String moeda = rs.getString("moeda");
                double valorAtual = rs.getDouble("valor");
                double variacao = (Math.random() * 10 - 5) / 100;
                double novoValor = valorAtual * (1 + variacao);
                String updateSql = "UPDATE usuario.criptos SET valor = ? WHERE moeda = ?";
                try (PreparedStatement updatePstmt = conn.prepareStatement(updateSql)) {
                    updatePstmt.setDouble(1, novoValor);
                    updatePstmt.setString(2, moeda);
                    updatePstmt.executeUpdate();
                }
                sb.append(String.format(" %.2f %s \n\n", novoValor, moeda));
            }
        }
        return sb.toString();
    }

    public double obterCotacao(String cripto) throws SQLException {
        String sql = "SELECT valor FROM usuario.criptos WHERE moeda = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cripto);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("valor");
                } else {
                    throw new SQLException("Criptomoeda não encontrada.");
                }
            }
        }
    }

    public void registrarExtrato(String cpf, String data, String tipo, double valor, String moeda, double cotacao, double taxa, double saldoReais, double saldoBtc, double saldoEth, double saldoXrp) {
        String sql = "INSERT INTO usuario.extrato (cpf, data, tipo, valor, moeda, cotacao, taxa, saldoreais, saldobtc, saldoeth, saldoxrp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            pstmt.setString(2, data);
            pstmt.setString(3, tipo);
            pstmt.setDouble(4, valor);
            pstmt.setString(5, moeda);
            pstmt.setDouble(6, cotacao);
            pstmt.setDouble(7, taxa);
            pstmt.setDouble(8, saldoReais);
            pstmt.setDouble(9, saldoBtc);
            pstmt.setDouble(10, saldoEth);
            pstmt.setDouble(11, saldoXrp);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar extrato no banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<String> printExtrato(String cpf) throws SQLException {
        List<String> extrato = new ArrayList<>();
        String sql = "SELECT data, tipo, valor, moeda, cotacao, taxa, saldoreais, saldobtc, saldoeth, saldoxrp FROM usuario.extrato WHERE cpf = ? ORDER BY data";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String data = rs.getString("data");
                    String tipo = rs.getString("tipo");
                    double valor = rs.getDouble("valor");
                    String moeda = rs.getString("moeda");
                    double cotacao = rs.getDouble("cotacao");
                    double taxa = rs.getDouble("taxa");
                    double saldoreais = rs.getDouble("saldoreais");
                    double saldobtc = rs.getDouble("saldobtc");
                    double saldoeth = rs.getDouble("saldoeth");
                    double saldoxrp = rs.getDouble("saldoxrp");
                    String linhaExtrato = String.format("Data: %s  %s %.4f %s Cotação: %.2f Taxa: %.2f Real: %.2f BTC: %.6f ETH: %.6f XRP: %.6f\n",
                            data, tipo, valor, moeda, cotacao, taxa, saldoreais, saldobtc, saldoeth, saldoxrp);
                    extrato.add(linhaExtrato);
                }
            }
        }
        return extrato;
    }
    

    
    
    
}
