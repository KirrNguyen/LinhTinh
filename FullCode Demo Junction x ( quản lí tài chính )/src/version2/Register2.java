/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version2;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static version2.Main.PanelMain;
import static version2.Main.fn;
import static version2.Register.EMAIL;
import static version2.Register.NAME;
import static version2.Register.PASSWORD;

/**
 *
 * @author KirrNguyen
 */
public class Register2 extends javax.swing.JPanel {

    /**
     * Creates new form Register2
     */
    
    public Register2() {
        initComponents();
    }
    public void start(){
        Start.setText("");
    }
    private Icon getIcon(String name) {
        Image image = new ImageIcon(getClass().getResource(
                "/Image/" + name + ".png")).getImage();
        Icon icon = new ImageIcon(image);
        return icon;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Start = new javax.swing.JLabel();
        input1 = new javax.swing.JTextField();
        input2 = new javax.swing.JTextField();
        input3 = new javax.swing.JTextField();
        input4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        Start.setText("jLabel1");

        input2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Thu Nhập Ước Tính");

        jLabel2.setText("Thu Nhập");

        jLabel3.setText("Thức Ăn");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Chi Tiêu Bình Quân");

        jLabel5.setText("Khoảng cố định");

        jLabel6.setText("Ngày Nhận Lương");

        jLabel7.setText("Bữa Sáng,Trưa,Tối,... cho 1 ngày");

        jLabel8.setText("Xăng xe,internet,tiền nhà,.... cho 1 tháng");

        jButton1.setText("Đăng Kí");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Start))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(input1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(input4)
                            .addComponent(input3)
                            .addComponent(input2)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(56, 56, 56)
                .addComponent(jLabel4)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(2, 2, 2)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(60, 60, 60)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(Start))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void input2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(input1.getText().equals("") || input2.getText().equals("")|| input3.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Bạn hãy nhập đủ các trường");
        }else if(input4.getText().equals("") || Integer.parseInt(input4.getText())>31 || Integer.parseInt(input4.getText())<1){
            JOptionPane.showMessageDialog(null, "Hãy nhập đúng ngày");
        }else{
            if(Integer.parseInt(input1.getText()) < Integer.parseInt(input2.getText())*30+Integer.parseInt(input3.getText())){
                JOptionPane.showMessageDialog(null, "Số tiền sử dụng không thể nhiều hơn tiền lương");
            }else{
                fn.Register(EMAIL, NAME, Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()),
                    Integer.parseInt(input3.getText()), Integer.parseInt(input4.getText()),PASSWORD);
                fn.CreateTable(EMAIL);
                next();
            }
           
        }
        
//        fn.Update(NAME, Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()),
//                Integer.parseInt(input3.getText()), Integer.parseInt(input4.getText()));
    }//GEN-LAST:event_jButton1ActionPerformed
    public void next(){
        try{
            PanelMain.removeAll();
        }catch(Exception ex){}
            Login login = new Login();
            login.setBounds(0, 0, 450, 600);
            PanelMain.add(login);
            PanelMain.repaint();
            login.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Start;
    private javax.swing.JTextField input1;
    private javax.swing.JTextField input2;
    private javax.swing.JTextField input3;
    private javax.swing.JTextField input4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
