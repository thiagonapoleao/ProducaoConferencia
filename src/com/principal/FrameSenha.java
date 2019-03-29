/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;

import com.bean.Login;
import com.dao.LoginJpaDAO;
import com.user.User;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thiago.napoleao
 */
public class FrameSenha extends javax.swing.JFrame {

    /**
     * Creates new form FrameSenha
     */
    public FrameSenha() {
        initComponents();
    }
    
    public void cadastro(){
        
        List<Login> logins = LoginJpaDAO.getInstance().findByUser(matriculaTxt.getText());      
          String data = "";
          String roler = "";
          int id = 0;
            
             for(int b = 0; b < logins.size(); b ++){
             
              String tempId = "";
              tempId = Integer.toString(logins.get(b).getId());
              tempId = tempId.replace("", "");
              id = Integer.parseInt(tempId);                      
                 
              String tempData = "";
              tempData = logins.get(b).getData_cadastro().replace("", "");
              tempData = tempData.replace("", "");
              data = tempData;
              
              String tempRoler = "";
              tempRoler = logins.get(b).getRole().replace("", "");
              tempRoler = tempRoler.replace("", "");
              roler = tempRoler;
              
              Login log = new Login();
              log.setUser(matriculaTxt.getText());
              log.setNome(usuarioTxt.getText());
              log.setPassword(passwordTxt.getText().toUpperCase());
              log.setData_cadastro(data);
              log.setRole(roler);
              
              LoginJpaDAO.getInstance().removeById(id);
              
              LoginJpaDAO.getInstance().persist(log);
              JOptionPane.showMessageDialog(null, "Senha Cadastrada com Sucesso!");
              
             }
             FrameSenha.super.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        matriculaTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usuarioTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(18, 33, 71));

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Confirme a Matricula");

        matriculaTxt.setFont(new java.awt.Font("Lucida Fax", 2, 18)); // NOI18N
        matriculaTxt.setForeground(new java.awt.Color(0, 51, 102));
        matriculaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        matriculaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                matriculaTxtKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Digite a Senha com 6 digitos");

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Confirme o Usuario");

        usuarioTxt.setFont(new java.awt.Font("Lucida Fax", 2, 18)); // NOI18N
        usuarioTxt.setForeground(new java.awt.Color(204, 0, 51));
        usuarioTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usuarioTxtKeyReleased(evt);
            }
        });

        passwordTxt.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        passwordTxt.setForeground(new java.awt.Color(0, 51, 102));
        passwordTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordTxtKeyReleased(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/logo13.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(matriculaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usuarioTxt)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matriculaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuarioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void matriculaTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matriculaTxtKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == 10){
            try{
             List<Login> logins = LoginJpaDAO.getInstance().findByUser(matriculaTxt.getText());           
                            
             if(logins.size() > 0){
             String nome = "";
            
             for(int b = 0; b < logins.size(); b ++){
              String tempNome = "";
              tempNome = logins.get(b).getNome().replace("", "");
              tempNome = tempNome.replace("", "");
              nome = tempNome;
                   usuarioTxt.setText(nome);     
                   passwordTxt.requestFocus(true);
                }                     
              } else{
                    JOptionPane.showMessageDialog(null, "Usuario não cadastrado! Verifique com seu Lider!");
                    usuarioTxt.setText("");
              }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_matriculaTxtKeyReleased

    private void usuarioTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioTxtKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == 10){
            try {
                passwordTxt.requestFocus();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_usuarioTxtKeyReleased

    private void passwordTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTxtKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == 10) {
            try {                
                String numero = passwordTxt.getText();
                String s = numero;
                System.out.println(s.length());
                
                if(s.length() == 6){
                  cadastro();                 
                }else{
                    JOptionPane.showMessageDialog(null, "A senha tem que conter 6 digitos!");
                    passwordTxt.setText("");
                }
            } catch (Exception ex) {
               ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_passwordTxtKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameSenha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField matriculaTxt;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JTextField usuarioTxt;
    // End of variables declaration//GEN-END:variables
}