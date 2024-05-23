/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import model.Investidor;
import model.real;
import model.btc;
import model.xrp;
import model.eth;

/**
 *
 * @author Gustavo Atui
 * implementa as funcoes do codigo
 */
public class Controle {
    private InvestidorDAO investidorDAO;

    public Controle(Investidor pessoa) {
        try {
            Conexao conexao = new Conexao();
            this.investidorDAO = new InvestidorDAO(conexao.getConnection());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String data() {
        Date data = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return simple.format(data);
    }

    public void depositoReais(double valor, Investidor pessoa) {
        double saldoAtual = pessoa.getSaldoreais();
        double novoSaldo = saldoAtual + valor;
        pessoa.setSaldoreais(novoSaldo);

        if (novoSaldo >= 0) {
            pessoa.setSaldoreais(novoSaldo);

            if (investidorDAO.atualizarSaldoBancoDados(pessoa)) {
                JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso!");
                investidorDAO.registrarExtrato(pessoa.getCpf(), data(), "+", valor, "REAL", 1.00, 0.0, novoSaldo, pessoa.getSaldobtc(), pessoa.getSaldoeth(), pessoa.getSaldoxrp());
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

            if (investidorDAO.atualizarSaldoBancoDados(pessoa)) {
                JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
                investidorDAO.registrarExtrato(pessoa.getCpf(), data(), "-", valor, "REAL", 1.00, 0.0, novoSaldo, pessoa.getSaldobtc(), pessoa.getSaldoeth(), pessoa.getSaldoxrp());
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar saldo no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    public String atualizarCotacoes() {
        if (investidorDAO == null) {
            JOptionPane.showMessageDialog(null, "Operação falhou: Conexão com o banco de dados não estabelecida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        try {
            return investidorDAO.atualizarCotacoes();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cotações: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public void comprarCripto(double valorEmReais, Investidor pessoa, String cripto) {
        try {
            double cotacaoMoeda = investidorDAO.obterCotacao(cripto); 

            double saldoReais = pessoa.getSaldoreais();
            double novoSaldoReais = saldoReais - valorEmReais;

            if (novoSaldoReais < 0) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar a compra.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double taxaCompra = 0.0;
            switch (cripto) {
                case "btc":
                    taxaCompra = new btc(0).getTaxacompra();
                    break;
                case "eth":
                    taxaCompra = new eth(0).getTaxacompra();
                    break;
                case "xrp":
                    taxaCompra = new xrp(0).getTaxacompra();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Criptomoeda não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
            }
    
            if (saldoReais >= 0) {
                double quantidadeComprada = valorEmReais / (cotacaoMoeda * (1 + taxaCompra));

                switch (cripto) {
                    case "btc":
                        pessoa.setSaldobtc(pessoa.getSaldobtc() + quantidadeComprada);
                        break;
                    case "eth":
                        pessoa.setSaldoeth(pessoa.getSaldoeth() + quantidadeComprada);
                        break;
                    case "xrp":
                        pessoa.setSaldoxrp(pessoa.getSaldoxrp() + quantidadeComprada);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Criptomoeda não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                }

                pessoa.setSaldoreais(novoSaldoReais);

                if (investidorDAO.atualizarSaldoBancoDados(pessoa)) {
                    JOptionPane.showMessageDialog(null, "Compra de " + cripto.toUpperCase() + " realizada com sucesso!");
                    investidorDAO.registrarExtrato(pessoa.getCpf(), data(), "+", quantidadeComprada, cripto.toUpperCase(), cotacaoMoeda, taxaCompra, novoSaldoReais, pessoa.getSaldobtc(), pessoa.getSaldoeth(), pessoa.getSaldoxrp());
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar saldo no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar a compra.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
           
            ex.printStackTrace(); 
        }
    }
    public void venderCripto(double quantidade, Investidor pessoa, String cripto) throws SQLException {
        switch (cripto) {
            case "btc":
                if (quantidade > pessoa.getSaldobtc()) {
                    JOptionPane.showMessageDialog(null, "Você não possui saldo suficiente de Bitcoin para vender.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
            case "eth":
                if (quantidade > pessoa.getSaldoeth()) {
                    JOptionPane.showMessageDialog(null, "Você não possui saldo suficiente de Ethereum para vender.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
            case "xrp":
                if (quantidade > pessoa.getSaldoxrp()) {
                    JOptionPane.showMessageDialog(null, "Você não possui saldo suficiente de Ripple para vender.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Criptomoeda não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
        }

        double cotacao = investidorDAO.obterCotacao(cripto);
        double valorVenda = quantidade * cotacao;

        double taxaVenda = 0.0;
        switch (cripto) {
            case "btc":
                taxaVenda = new btc(0).getTaxavenda();
                break;
            case "eth":
                taxaVenda = new eth(0).getTaxavenda();
                break;
            case "xrp":
                taxaVenda = new xrp(0).getTaxavenda();
                break;
        }
        valorVenda -= valorVenda * taxaVenda;

        switch (cripto) {
            case "btc":
                pessoa.setSaldobtc(pessoa.getSaldobtc() - quantidade);
                break;
            case "eth":
                pessoa.setSaldoeth(pessoa.getSaldoeth() - quantidade);
                break;
            case "xrp":
                pessoa.setSaldoxrp(pessoa.getSaldoxrp() - quantidade);
                break;
        }
        pessoa.setSaldoreais(pessoa.getSaldoreais() + valorVenda);

        if (investidorDAO.atualizarSaldoBancoDados(pessoa)) {
            JOptionPane.showMessageDialog(null, "Venda de " + cripto.toUpperCase() + " realizada com sucesso!");
            investidorDAO.registrarExtrato(pessoa.getCpf(), data(), "-", quantidade, cripto.toUpperCase(), cotacao, taxaVenda, pessoa.getSaldoreais(), pessoa.getSaldobtc(), pessoa.getSaldoeth(), pessoa.getSaldoxrp());
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar saldo no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   
    public String obterTodasAsCotacoes() throws SQLException {
    
        String cotacoes = ""; 
        cotacoes += "BTC: " + investidorDAO.obterCotacao("btc") + "\n";
        cotacoes += "ETH: " + investidorDAO.obterCotacao("eth") + "\n";
        cotacoes += "XRP: " + investidorDAO.obterCotacao("xrp") + "\n";
        return cotacoes;
    }
    public List<String> printExtrato(String cpf) {
        if (investidorDAO == null) {
            JOptionPane.showMessageDialog(null, "Operação falhou: Conexão com o banco de dados não estabelecida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        try {
            return investidorDAO.printExtrato(cpf);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter extrato: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
   
}
