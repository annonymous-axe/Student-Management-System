package studentrecordproject;

import javax.swing.JOptionPane;
import java.sql.*;

public class ChangePasswordFrame extends javax.swing.JFrame {

    public ChangePasswordFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public void changePasswordDB(String username, String password, String newPassword){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12569113", "sql12569113", "5HvIP5idv8");
            PreparedStatement pstm = con.prepareStatement("select * from logindetails "
                        + " where username = ? and pass = ?");
            pstm.setString(1, username);
            pstm.setString(2, password);
            
            try{
                ResultSet srt = pstm.executeQuery();
                String str[] = {"",""};
                while(srt.next()){
                    for(int col=0; col<2; col++){
                        str[col] = srt.getString(col+1);
                    }
                }
                if(str[0].equals(""))
                    JOptionPane.showMessageDialog(rootPane, "You enter incorrect username or password!");
                else{
                    Statement stm = con.createStatement();
                    stm.executeUpdate("update logindetails "
                            + "set pass='"+newPassword+"' where username='"+username+"'");
                    JOptionPane.showMessageDialog(rootPane, "Password change successfully.");
                }
            }catch(SQLException sql){
                System.out.println("Internal Exception :"+sql);
            }
            pstm.close();
            con.close();
            
        }catch(Exception e){
            System.out.println("External Exception :" +e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        username_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        old_password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        new_password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        conf_password = new javax.swing.JPasswordField();
        chenge_pass_btn = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change Password");
        setExtendedState(1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel1.setText("Username");

        username_txt.setFont(new java.awt.Font("Cambria", 1, 25)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel2.setText("Old Password");

        old_password.setFont(new java.awt.Font("Cambria", 1, 25)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel3.setText("New Password");

        new_password.setFont(new java.awt.Font("Cambria", 1, 25)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel4.setText("Confirm Password");

        conf_password.setFont(new java.awt.Font("Cambria", 1, 25)); // NOI18N

        chenge_pass_btn.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        chenge_pass_btn.setText("Change Password");
        chenge_pass_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chenge_pass_btnActionPerformed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        cancel.setText("Cancel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(new_password, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(old_password, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(chenge_pass_btn)
                        .addGap(28, 28, 28)
                        .addComponent(cancel)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(old_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(new_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chenge_pass_btn)
                    .addComponent(cancel))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chenge_pass_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chenge_pass_btnActionPerformed
        if(username_txt.getText().equals(""))
            JOptionPane.showMessageDialog(rootPane, "Please enter username!");
        else if(old_password.getText().equals(""))
            JOptionPane.showMessageDialog(rootPane, "Please enter old password!");
        else if(new_password.getText().equals(""))
            JOptionPane.showMessageDialog(rootPane, "Please enter new password!");
        else if(conf_password.getText().equals(""))
            JOptionPane.showMessageDialog(rootPane, "Please confirm your password!");  
        else if(!new_password.getText().equals(conf_password.getText()))
            JOptionPane.showMessageDialog(rootPane, "New password and confirm password does not match.");
        else
            changePasswordDB(username_txt.getText(), old_password.getText(), new_password.getText());
    }//GEN-LAST:event_chenge_pass_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton chenge_pass_btn;
    private javax.swing.JPasswordField conf_password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField new_password;
    private javax.swing.JPasswordField old_password;
    private javax.swing.JTextField username_txt;
    // End of variables declaration//GEN-END:variables
}
