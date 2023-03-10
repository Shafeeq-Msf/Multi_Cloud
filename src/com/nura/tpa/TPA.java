/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nura.tpa;

import com.nura.security.hashing.SHA256;
import com.nura.db.access.HashDetailsAccess;
import com.nura.db.entity.HashDetails;
import com.nura.dropbox.AuthenticateUser;
import com.nura.filehandling.StringReader;
import com.nura.mail.JavaEmail;
import constants.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import logger.LoggerUtil;

/**
 *
 * @author Arun Kumar
 */
public class TPA extends javax.swing.JFrame {

    private List<com.nura.db.entity.HashDetails> hashDtlsLst = new HashDetailsAccess().getHashDtlsLst();
    private Map<String, HashDetails> storeHashDtls = new HashMap<String, HashDetails>();
    private static final LoggerUtil log = new LoggerUtil();

    /**
     * Creates new form TPA
     */
    public TPA() {
        initComponents();
        prePopulateDtls();
        try {
            AuthenticateUser.main();
        } catch (Exception ex) {
            Logger.getLogger(TPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prePopulateDtls() {
        DefaultComboBoxModel dcb = new DefaultComboBoxModel();
        dcb.addElement("");
        for (HashDetails hd : hashDtlsLst) {
            storeHashDtls.put(hd.getFileName(), hd);
            dcb.addElement(hd.getFileName());
        }
        fileItemLst_cb.setModel(dcb);
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
        jLabel1 = new javax.swing.JLabel();
        fileItemLst_cb = new javax.swing.JComboBox();
        validate_bt = new javax.swing.JButton();
        exit_bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("File Name:-");

        fileItemLst_cb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        fileItemLst_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));

        validate_bt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        validate_bt.setText("Validate");
        validate_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validate_btActionPerformed(evt);
            }
        });

        exit_bt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        exit_bt.setText("Exit");
        exit_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(fileItemLst_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(validate_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exit_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fileItemLst_cb, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(validate_bt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(exit_bt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exit_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exit_btActionPerformed

    private void validate_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validate_btActionPerformed
        File file1 = null;
        File file2 = null;
        File file3 = null;
        File file4 = null;
        String getContents[] = new String[4];

        boolean part1 = false;
        boolean part2 = false;
        boolean part3 = false;
        boolean part4 = false;

        try {
            // TODO add your handling code here:
            String selFile = fileItemLst_cb.getSelectedItem().toString();
            HashDetails hd = new HashDetails();
            hd = storeHashDtls.get(selFile);

            JavaEmail jemail = new JavaEmail();

            file1 = AuthenticateUser.download(Constants.CS1, selFile);
            getContents[0] = StringReader.readFile(file1);
            log.addLog("Contents of part1 :-" + getContents[0]);
            getContents[0] = new SHA256().hash(getContents[0].getBytes());
            log.addLog("Hash of part1 :-" + getContents[0]);
            file1.delete();

            file2 = AuthenticateUser.download(Constants.CS2, selFile);
            getContents[1] = StringReader.readFile(file2);
            log.addLog("Contents of part2 :-" + getContents[1]);
            getContents[1] = new SHA256().hash(getContents[1].getBytes());
            log.addLog("Hash of part2 :-" + getContents[1]);
            file2.delete();

            file3 = AuthenticateUser.download(Constants.CS3, selFile);
            getContents[2] = StringReader.readFile(file3);
            log.addLog("Contents of part3 :-" + getContents[2]);
            getContents[2] = new SHA256().hash(getContents[2].getBytes());
            log.addLog("Hash of part3 :-" + getContents[2]);
            file3.delete();

            file4 = AuthenticateUser.download(Constants.CS4, selFile);
            getContents[3] = StringReader.readFile(file4);
            log.addLog("Contents of part4 :-" + getContents[3]);
            getContents[3] = new SHA256().hash(getContents[3].getBytes());
            log.addLog("Hash of part4 :-" + getContents[3]);
            file4.delete();

            //Validating the hash parts
            if (getContents[0].equals(hd.getHash1_part())) {
                part1 = true;
            } else {
                //Send mail
                jemail.sendMail(hd.getMailid(), "File corrupted", "Part1 of the file " + selFile + " has been corrupted");
                JOptionPane.showMessageDialog(this, "Part 1 is corrupted");
            }
            if (getContents[1].equals(hd.getHash2_part())) {
                part2 = true;
            } else {
                jemail.sendMail(hd.getMailid(), "File corrupted", "Part2 of the file " + selFile + " has been corrupted");
                JOptionPane.showMessageDialog(this, "Part 2 is corrupted");
            }
            if (getContents[2].equals(hd.getHash3_part())) {
                part3 = true;
            } else {
                jemail.sendMail(hd.getMailid(), "File corrupted", "Part3 of the file " + selFile + " has been corrupted");
                JOptionPane.showMessageDialog(this, "Part 3 is corrupted");
            }
            if (getContents[3].equals(hd.getHash4_part())) {
                part4 = true;
            } else {
                jemail.sendMail(hd.getMailid(), "File corrupted", "Part4 of the file " + selFile + " has been corrupted");
                JOptionPane.showMessageDialog(this, "Part 4 is corrupted");
            }
            

        } catch (Exception ex) {
            Logger.getLogger(TPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_validate_btActionPerformed

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
            java.util.logging.Logger.getLogger(TPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TPA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit_bt;
    private javax.swing.JComboBox fileItemLst_cb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton validate_bt;
    // End of variables declaration//GEN-END:variables
}
