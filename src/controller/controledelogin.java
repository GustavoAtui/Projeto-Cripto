/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Naja Info
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
        Investidor pessoa = new Investidor(null,view.getTcpf().getText(),view.getTsenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            
            
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultar(pessoa);
            if(res.next()){
                if (view.getTsenha().getText().equals(pessoa.getSenha())){
                    JOptionPane.showMessageDialog(view, "Login Feito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    double saldoreais = res.getDouble("saldoreais");
                    double saldobtc = res.getDouble("saldobtc");
                    double saldoeth = res.getDouble("saldoeth");
                    double saldoxrp = res.getDouble("saldoxrp");              
                    String nome = res.getString("nome");
                    Investidor investidor = new Investidor(saldoreais,saldobtc,saldoeth,saldoxrp,nome,view.getTcpf().getText(),view.getTsenha().getText());
                    Menu viewlogin = new Menu(investidor);
                    viewlogin.setVisible(true);
                    view.setVisible(false);
                }
                
            }
            else{
                JOptionPane.showMessageDialog(view, "Login não efetuado", "Erro", JOptionPane.ERROR_MESSAGE);
                
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
                
        }
    }
}
