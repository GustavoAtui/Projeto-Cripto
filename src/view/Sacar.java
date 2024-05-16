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
 * @author Naja Info
 */
    
public class Sacar extends javax.swing.JFrame {
    Controle control;
    Investidor pessoa;
    public Sacar(Investidor pessoa, Controle control) {
        initComponents();
        this.pessoa = pessoa;
        this.control = control;
    }
    /**
     * Creates new form Saque
     */
    

    public JTextArea getAreasaldo() {
        return areasaldo;
    }

    public JButton getConfirmasenha() {
        return bconfirma;
    }

    public JTextField getTsenha() {
        return tvalor;
    }

    public void setAreasaldo(JTextArea areasaldo) {
        this.areasaldo = areasaldo;
    }

    public void setConfirmasenha(JButton confirmasenha) {
        this.bconfirma = confirmasenha;
    }

    public void setTsenha(JTextField tsenha) {
        this.tvalor = tsenha;
    }
    Controle controle;

    public Investidor getPessoa() {
        return pessoa;
    }

    public void setPessoa(Investidor pessoa) {
        this.pessoa = pessoa;
    }

    public Controle getControle() {
        return controle;
    }

    public void setControle(Controle controle) {
        this.controle = controle;
    }
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
        jLabel1.setText("Sacar Reais");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Digite o valor que deseja sacar em reais:");

        tvalor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvalorActionPerformed(evt);
            }
        });

        areasaldo.setColumns(20);
        areasaldo.setRows(5);
        jScrollPane1.setViewportView(areasaldo);

        jLabel3.setText("Saldo atualizado");

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
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(bconfirma)))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bconfirma)
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       
        Menu menu = new Menu(pessoa);
        menu.setVisible(true);    
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed
     
    private void bconfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bconfirmaActionPerformed
        double valor = Double.parseDouble(tvalor.getText());
        control.saqueReais(valor,pessoa);
        atualizarSaldo();
        
    }//GEN-LAST:event_bconfirmaActionPerformed
    private void atualizarSaldo() {
        DecimalFormat df = new DecimalFormat("$0.000");
        String saldobtc = df.format(pessoa.getSaldobtc());
        String saldoeth = df.format(pessoa.getSaldoeth());
        String saldoxrp = df.format(pessoa.getSaldoxrp());
        
        double saldoReais = pessoa.getSaldoreais();
        areasaldo.setText("Novo saldo\nNome: " + pessoa.getNome() +"\nCPF: " + pessoa.getCpf() +
        "\nReais: " + saldoReais +"\nBitcoin: " + saldobtc + "\nEthereum: " + saldoeth +"\nRipple: " + saldoxrp);
    }
    private void tvalorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvalorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tvalorActionPerformed

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(Sacar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Sacar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Sacar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Sacar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Sacar().setVisible(true);
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
