/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Gustavo
 * Implementa a função de login
 */
import DAO.InvestidorDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.Login;
import view.Menu;

public class controledelogin {
    private Login view;
    
    public controledelogin(Login view){
        this.view = view;
    }
    
     public void loginInvestidor(){
        String cpf = view.getTcpf().getText().replace(".", "").replace("-", "");
        String senha = view.getTsenha().getText();

        if (senha.length() != 6) {
            JOptionPane.showMessageDialog(view, "A senha deve ter 6 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Investidor pessoa = new Investidor(null, cpf, senha);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultar(pessoa);
            if(res.next()){
                if (senha.equals(pessoa.getSenha())){
                    JOptionPane.showMessageDialog(view, "Login Feito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    double saldoreais = res.getDouble("saldoreais");
                    double saldobtc = res.getDouble("saldobtc");
                    double saldoeth = res.getDouble("saldoeth");
                    double saldoxrp = res.getDouble("saldoxrp");              
                    String nome = res.getString("nome");
                    Investidor investidor = new Investidor(saldoreais, saldobtc, saldoeth, saldoxrp, nome, cpf, senha);
                    Menu viewlogin = new Menu(investidor);
                    viewlogin.setVisible(true);
                    view.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(view, "Login não efetuado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
