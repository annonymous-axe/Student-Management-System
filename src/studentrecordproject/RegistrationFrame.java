
package studentrecordproject;

import javax.swing.JOptionPane;
import java.sql.*;


public class RegistrationFrame extends javax.swing.JFrame {

    public RegistrationFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    public void updateDB(int RollNo, String username){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12569113", "sql12569113", "5HvIP5idv8");
            Statement stm = conn.createStatement();
            try{
                stm.executeUpdate("update personaldetails "
                        + "set sname='"+fullname_txt.getText()+"', email='"+emailid_txt.getText()+"', contactno='"+contact_txt.getText()+"',"
                        + "address='"+address.getText()+"' "
                        + "where id='"+RollNo+"'");
                stm.executeUpdate("update logindetails "
                        + "set pass='"+password_txt.getText()+"' "
                        + "where username='"+username+"'");
            }catch(SQLException sql){
                System.out.println("SQLException :" +sql);
            }
        }catch(Exception e){
            System.out.println("Exception :"+e);
        }
            
        
    }
    public void searchDB(int RollNo, String username){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12569113", "sql12569113", "5HvIP5idv8");
            Statement stm = conn.createStatement();
            try{
                ResultSet rst = stm.executeQuery("select * from personaldetails where id='"+RollNo+"'");
                if(rst.next()){
                    roll_no_txt.setText(""+RollNo);
                    fullname_txt.setText(rst.getString("sname"));
                    username_txt.setText(rst.getString("username"));
                    emailid_txt.setText(rst.getString("email"));
                    address.setText(rst.getString("address"));
                    contact_txt.setText(rst.getString("contactNo"));
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Roll no not exist!");   
                }
                rst = stm.executeQuery("select pass from logindetails where username='"+username+"'");
                if(rst.next()){
                    password_txt.setText(rst.getString("pass"));
                }
                rst.close();                
            }catch(SQLException sql){
                System.out.println("SQLException :"+sql);
            }
            stm.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println("Exception "+e);
        }
    }
    public void userDB(int RollNo, String name, String contact_no, String email, String username, String password, String address){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12569113", "sql12569113", "5HvIP5idv8");
            Statement stm = con.createStatement();
            try{
                stm.executeUpdate("insert into logindetails(username, pass) value('"+username+"', '"+password+"')");
                stm.executeUpdate("insert into personaldetails(ID, sname, contactNo, email, address, username) value('"+RollNo+"', '"+name+"', '"+contact_no+"', '"+email+"', '"+address+"', '"+username_txt.getText()+"')");
                stm.executeUpdate("insert into academicdetail(ID) value('"+RollNo+"')");
                stm.executeUpdate("insert into marksdetail(ID) value('"+RollNo+"')");
                JOptionPane.showMessageDialog(rootPane, "Information insert Successfully.");
            
            }catch(SQLIntegrityConstraintViolationException sq){
                JOptionPane.showConfirmDialog(rootPane, "Roll no Or username already exist!\nDo you want to update?");
            }
            catch(SQLException sqle){
                System.out.println("Exception :"+sqle);                
            }
             stm.close();
             con.close();
            
        }catch(Exception e){
            System.out.println("Exception :"+e);
        }
    }

    public String[] getUserDB(int RollNo, String username){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12569113", "sql12569113", "5HvIP5idv8");
            PreparedStatement pstm = con.prepareStatement("select ID, sname, username, pass, emailID, contactNo "
                                                + "from student,logindetails "
                                                + "where ID = ? and username = ?");
            pstm.setInt(1, RollNo);
            pstm.setString(2, username);
            
            try{
                ResultSet rs = pstm.executeQuery();
                String str[] = {"","","","","",""};
                while(rs.next()){
                    int row = rs.getRow();
                    for(int col=0; col<6; col++){
                        str[col] = rs.getString(col+1);
                    }
                }
                return str;
            }catch(SQLIntegrityConstraintViolationException sq){
                JOptionPane.showMessageDialog(rootPane, username+" username already use!\nEnter different username.");
            }
            catch(SQLException sqle){
                System.out.println("Exception :"+sqle);                
            }    
        }catch(Exception e){
            System.out.println("Exception :"+e);
        }
        return null;
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fullname_txt = new javax.swing.JTextField();
        username_txt = new javax.swing.JTextField();
        emailid_txt = new javax.swing.JTextField();
        contact_txt = new javax.swing.JTextField();
        password_txt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        roll_no_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        new_btn = new javax.swing.JButton();
        save_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        search_records = new javax.swing.JButton();
        records_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usert Registration");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Detail", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel2.setText("Full Name");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel3.setText("User Name");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel5.setText("Email ID");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel6.setText("Contact No.");

        fullname_txt.setFont(new java.awt.Font("Cambria", 0, 25)); // NOI18N

        username_txt.setFont(new java.awt.Font("Cambria", 0, 25)); // NOI18N

        emailid_txt.setFont(new java.awt.Font("Cambria", 0, 25)); // NOI18N

        contact_txt.setFont(new java.awt.Font("Cambria", 0, 25)); // NOI18N

        password_txt.setFont(new java.awt.Font("Cambria", 0, 25)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel7.setText("Roll No");

        roll_no_txt.setFont(new java.awt.Font("Cambria", 0, 25)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel8.setText("Address");

        address.setColumns(20);
        address.setFont(new java.awt.Font("Cambria", 0, 25)); // NOI18N
        address.setRows(5);
        jScrollPane1.setViewportView(address);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(contact_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailid_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fullname_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(username_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(password_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(roll_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(401, 401, 401)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roll_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailid_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contact_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        new_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        new_btn.setText("New");
        new_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_btnActionPerformed(evt);
            }
        });
        jPanel2.add(new_btn);

        save_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        save_btn.setText("Save");
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });
        jPanel2.add(save_btn);

        delete_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        delete_btn.setText("Delete");
        delete_btn.setEnabled(false);
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        jPanel2.add(delete_btn);

        update_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        update_btn.setText("Update");
        update_btn.setEnabled(false);
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
        jPanel2.add(update_btn);

        search_records.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        search_records.setText("Search Records");
        search_records.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_recordsActionPerformed(evt);
            }
        });
        jPanel2.add(search_records);

        records_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        records_btn.setText("See All Records");
        records_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                records_btnActionPerformed(evt);
            }
        });
        jPanel2.add(records_btn);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search_recordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_recordsActionPerformed

        if( username_txt.getText().equals("") && roll_no_txt.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Enter username and Roll No of student.");        
        }
        else{
            searchDB(Integer.parseInt(roll_no_txt.getText()), username_txt.getText());
            search_records.setEnabled(false);
            save_btn.setEnabled(false);
            delete_btn.setEnabled(true);
            update_btn.setEnabled(true);
            roll_no_txt.setEditable(false);
            username_txt.setEditable(false);            
        }      
    }//GEN-LAST:event_search_recordsActionPerformed

    private void new_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_btnActionPerformed
        fullname_txt.setText("");
        username_txt.setText("");
        password_txt.setText("");
        emailid_txt.setText("");
        contact_txt.setText("");     
        address.setText("");
        roll_no_txt.setEditable(true);
        username_txt.setEditable(true);
        update_btn.setEnabled(false);
        delete_btn.setEnabled(false);
        save_btn.setEnabled(true);
    }//GEN-LAST:event_new_btnActionPerformed

    private void records_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_records_btnActionPerformed
        new StudentRecordsFrame().show();
    }//GEN-LAST:event_records_btnActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        if(checkEmptyValue()){
            JOptionPane.showMessageDialog(rootPane, "Please fill Data first!");
        }
        else{
            userDB(Integer.parseInt(roll_no_txt.getText()), fullname_txt.getText(), contact_txt.getText(), emailid_txt.getText(), username_txt.getText(), password_txt.getText(), address.getText());
        }
    }//GEN-LAST:event_save_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        int rollNo = Integer.parseInt(roll_no_txt.getText());
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12569113", "sql12569113", "5HvIP5idv8");
            Statement stm = conn.createStatement();
            try{
                stm.executeUpdate("delete from personaldetails where id='"+rollNo+"'");
                stm.executeUpdate("delete from logindetails where username='"+username_txt.getText()+"'");
                stm.executeUpdate("delete from academicdetail where id='"+rollNo+"'");
                stm.executeUpdate("delete from marksdetail where id='"+rollNo+"'");
            }catch(SQLException sql){
                System.out.println("sqlexception :"+sql);
            }
        }catch(Exception e){
            System.out.println("exception :"+e);
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed

        updateDB(Integer.parseInt(roll_no_txt.getText()), username_txt.getText());
    }//GEN-LAST:event_update_btnActionPerformed

    public boolean checkEmptyValue(){
        if(roll_no_txt.getText().equals("") || fullname_txt.getText().equals("") || username_txt.getText().equals("") || 
                password_txt.getText().equals("") || emailid_txt.getText().equals("") || contact_txt.getText().equals(""))
            return true;  
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address;
    private javax.swing.JTextField contact_txt;
    private javax.swing.JButton delete_btn;
    private javax.swing.JTextField emailid_txt;
    private javax.swing.JTextField fullname_txt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton new_btn;
    private javax.swing.JTextField password_txt;
    private javax.swing.JButton records_btn;
    private javax.swing.JTextField roll_no_txt;
    private javax.swing.JButton save_btn;
    private javax.swing.JButton search_records;
    private javax.swing.JButton update_btn;
    private javax.swing.JTextField username_txt;
    // End of variables declaration//GEN-END:variables
}
