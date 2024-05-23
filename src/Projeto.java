
import view.Login;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author Gustavo Atui
 * Projeto Exchange de Criptomoedas da Diciplina Orientação a obejtos
 * utilizando interfaces graficas e banco de dados SQL para armazenar os dados do projeto. O projeto conta com 9 funções sendo elas
 *1- Login
 *2- Menu
 *3- Consultar Saldo
 *4- Consultar extrato
 *5-Deposito
 *6-Sacar (apenas em Real)
 *7-Comprar Criptomoedas
 *8-Vender Criptomoedas
 *9- Atualizar a Cotação das criptomoedas
 * e 3 tabelas no banco de dados SQL uma de Pessoa uma onde tem as moedas e uma para os extratos 
 * 
 */
public class Projeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
        
    }
    
}
