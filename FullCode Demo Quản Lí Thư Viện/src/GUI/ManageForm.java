/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.ManageControl;

/**
 *
 * @author KirrNguyen
 */
public class ManageForm extends javax.swing.JPanel{
    ManageControl control = new ManageControl();
    public ManageForm() {
        initComponents();
    }

    public void start(){
        Start.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserManageButton = new javax.swing.JButton();
        BorrowButton = new javax.swing.JButton();
        BookManageButton = new javax.swing.JButton();
        ReturnButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        Start = new javax.swing.JLabel();

        UserManageButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        UserManageButton.setText("Quản Lí Thành Viên");
        UserManageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserManageButtonActionPerformed(evt);
            }
        });

        BorrowButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        BorrowButton.setText("Quản Lí Mượn");
        BorrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrowButtonActionPerformed(evt);
            }
        });

        BookManageButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        BookManageButton.setText("Quản Lí Sách");
        BookManageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookManageButtonActionPerformed(evt);
            }
        });

        ReturnButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ReturnButton.setText("Quản Lí Trả");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        LogoutButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LogoutButton.setText("Đăng Xuất");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        Start.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BorrowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BookManageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserManageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(Start)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Start))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BookManageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UserManageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BorrowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReturnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(39, 39, 39)
                .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        control.Logout();
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void BookManageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookManageButtonActionPerformed
        control.BookManage();
    }//GEN-LAST:event_BookManageButtonActionPerformed

    private void UserManageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserManageButtonActionPerformed
        control.UserManage();
    }//GEN-LAST:event_UserManageButtonActionPerformed

    private void BorrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrowButtonActionPerformed
        control.BorrowManage();
    }//GEN-LAST:event_BorrowButtonActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        control.ReturnManage();
    }//GEN-LAST:event_ReturnButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BookManageButton;
    private javax.swing.JButton BorrowButton;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JLabel Start;
    private javax.swing.JButton UserManageButton;
    // End of variables declaration//GEN-END:variables
}
