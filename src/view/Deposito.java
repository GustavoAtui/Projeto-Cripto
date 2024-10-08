/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import controller.Controle;
import model.Investidor;

import java.text.DecimalFormat;
import javax.swing.JButton;

import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 *
 * @author Gustavo Atui
 * jframe onde realiza o deposito
 */
public class Deposito extends javax.swing.JFrame {

    /**
     * Creates new form Deposito
     */
    Controle control;
    Investidor pessoa;
    public Deposito(Investidor pessoa, Controle control) {
        this.pessoa = pessoa;
        this.control = control;
        initComponents();
    }

    public void setPessoa(Investidor pessoa) {
        this.pessoa = pessoa;
    }

    public void setAreasaldo(JTextArea areasaldo) {
        this.areasaldo = areasaldo;
    }

    public void setBconfirma(JButton bconfirma) {
        this.bconfirma = bconfirma;
    }

    public JTextArea getAreasaldo() {
        return areasaldo;
    }

    public JButton getBconfirma() {
        return bconfirma;
    }

    public JTextField getTvalor() {
        return tvalor;
    }

    public void setTvalor(JTextField tvalor) {
        this.tvalor = tvalor;
    }
    public Investidor getPessoa() {
        return pessoa;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tvalor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        areasaldo = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        bconfirma = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("Deposito");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setText("Digite o Valor que sera depositado em reais: ");

        tvalor.setBackground(new java.awt.Color(51, 0, 51));
        tvalor.setForeground(new java.awt.Color(255, 255, 255));
        tvalor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvalorActionPerformed(evt);
            }
        });

        areasaldo.setBackground(new java.awt.Color(51, 0, 51));
        areasaldo.setColumns(20);
        areasaldo.setForeground(new java.awt.Color(255, 255, 255));
        areasaldo.setRows(5);
        jScrollPane1.setViewportView(areasaldo);

        jLabel3.setText("Saldo atualizado ");

        bconfirma.setBackground(new java.awt.Color(51, 0, 51));
        bconfirma.setForeground(new java.awt.Color(255, 255, 255));
        bconfirma.setText("Confirma");
        bconfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bconfirmaActionPerformed(evt);
            }
        });

        jMenu1.setText("Voltar");

        jMenuItem1.setText("Menu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(bconfirma)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bconfirma)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Menu menu = new Menu(pessoa);
        menu.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tvalorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvalorActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_tvalorActionPerformed

    private void bconfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bconfirmaActionPerformed
        double valor = Double.parseDouble(tvalor.getText());
        control.depositoReais(valor,pessoa);
        atualizarSaldo();// TODO add your handling code here:
    }//GEN-LAST:event_bconfirmaActionPerformed
    private void atualizarSaldo() {
        
        DecimalFormat df = new DecimalFormat("$0.000");
        String saldoReais = df.format(pessoa.getSaldoreais());
        String saldobtc = df.format(pessoa.getSaldobtc());
        String saldoeth = df.format(pessoa.getSaldoeth());
        String saldoxrp = df.format(pessoa.getSaldoxrp());
        
        
        areasaldo.setText("Novo saldo\nNome: " + pessoa.getNome() +"\nCPF: " + pessoa.getCpf() +
        "\nReais: " + saldoReais +"\nBitcoin: " + saldobtc + "\nEthereum: " + saldoeth +"\nRipple: " + saldoxrp);
    }
   
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Deposito().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areasaldo;
    private javax.swing.JButton bconfirma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tvalor;
    // End of variables declaration//GEN-END:variables
}
