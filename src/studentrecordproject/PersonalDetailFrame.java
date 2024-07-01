
package studentrecordproject;
import java.sql.*;
import javax.swing.JOptionPane;
public class PersonalDetailFrame extends javax.swing.JFrame {
    String user;
    public PersonalDetailFrame(String userName) {
        user = userName;
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        if(!user.equals("admin")){
            update_btn.setEnabled(false);
            search_btn.setText("Save");
            setData(user);
            setDisable();
        }
    }
    public void setDisable(){
        roll_no.setEditable(false);
        fullname.setEditable(false);
        contact_txt.setEditable(false);
        male_rbtn.setEnabled(false);
        female_rbtn.setEnabled(false);
        email_txt.setEditable(false);
        add_txt.setEditable(false);
        reset_btn.setEnabled(false);
        search_btn.setEnabled(false);
    }
    public void updateUser(String rollNo, String fname, String gender, String contactNo, String email, String address){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12569113", "sql12569113", "5HvIP5idv8");
            Statement stm = con.createStatement();
            try{
                stm.executeUpdate("update personaldetails "
                        + "set sname='"+fname+"', gender='"+gender+"', contactNo='"+contactNo+"', email='"+email+"', address='"+address+"' "
                        + "where ID = '"+rollNo+"' ");
            }catch(SQLException sql){
                System.out.println("sqlexception :"+sql);
            }
            
        }catch(Exception e){
            System.out.println("Exception :"+e);
        }                
    }
    public void setData(String userName){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12569113", "sql12569113", "5HvIP5idv8");
            Statement stm = con.createStatement();
            try{
                ResultSet rst = stm.executeQuery("select * from personaldetails where username='"+userName+"'");
                if(rst.next()){
                    roll_no.setText(rst.getString("ID"));
                    fullname.setText(rst.getString("sname"));
                    contact_txt.setText(rst.getString("contactNo"));
                    email_txt.setText(rst.getString("email"));
                    add_txt.setText(rst.getString("address"));
                    String gender = rst.getString("gender");
                    if(gender.equals("Male"))
                        male_rbtn.setSelected(true);
                    else if(gender.equals("Female"))
                        female_rbtn.setSelected(true);                     
                }
            }catch(SQLException sql){
                System.out.println("sqlexception :"+sql);
            }
            
        }catch(Exception e){
            System.out.println("Exception :"+e);
        }
        
    }
    public int JDBCExample(int RollNo){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12569113", "sql12569113", "5HvIP5idv8");
            Statement stmt = conn.createStatement();
            try{
                ResultSet rst = stmt.executeQuery("select * from personaldetails where ID='"+RollNo+"'");
                if(rst.next()){
                    fullname.setText(rst.getString("sname"));
                    contact_txt.setText(rst.getString("contactNo"));
                    email_txt.setText(rst.getString("email"));
                    add_txt.setText(rst.getString("address"));
                    String gender;
                    if(rst.getString("gender") == null)
                        gender="Not Mention";
                    else{
                        gender = rst.getString("gender");
                        if(gender.equals("Male"))
                            male_rbtn.setSelected(true);
                        else if(gender.equals("Female"))
                            female_rbtn.setSelected(true);                                
                    }
                    stmt.close();
                    conn.close();
                    return 0;
                }
            }catch(SQLException sqle){
                System.out.println("Could not insert tuple." +sqle);
            }
            stmt.close();
            conn.close();
        }
        catch(Exception sqle){
                        System.out.println("Exception :"+sqle);
        }
        return 1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fullname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        contact_txt = new javax.swing.JTextField();
        country_code_combox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        male_rbtn = new javax.swing.JRadioButton();
        female_rbtn = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        music_cbox = new javax.swing.JCheckBox();
        dance_cbox = new javax.swing.JCheckBox();
        singing_cbox = new javax.swing.JCheckBox();
        drawing_cbox = new javax.swing.JCheckBox();
        movie_cbox = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        email_txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        add_txt = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        roll_no = new javax.swing.JTextField();
        search_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        reset_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Personal Details");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Trebuchet MS", 1, 25), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(483, 527));
        jPanel2.setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("*");

        fullname.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel3.setText("Contact Number");

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("*");

        contact_txt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        country_code_combox.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        country_code_combox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+91" }));
        country_code_combox.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel5.setText("Gender");

        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("*");

        buttonGroup1.add(male_rbtn);
        male_rbtn.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        male_rbtn.setText("Male");
        male_rbtn.setMultiClickThreshhold(2L);
        male_rbtn.setName("Gender"); // NOI18N

        buttonGroup1.add(female_rbtn);
        female_rbtn.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        female_rbtn.setText("Female");

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel7.setText("Habits");

        buttonGroup2.add(music_cbox);
        music_cbox.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        music_cbox.setText("Music");
        music_cbox.setEnabled(false);

        buttonGroup2.add(dance_cbox);
        dance_cbox.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        dance_cbox.setText("Dance");
        dance_cbox.setEnabled(false);

        buttonGroup2.add(singing_cbox);
        singing_cbox.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        singing_cbox.setText("Singing");
        singing_cbox.setEnabled(false);

        buttonGroup2.add(drawing_cbox);
        drawing_cbox.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        drawing_cbox.setText("Drawing");
        drawing_cbox.setEnabled(false);

        buttonGroup2.add(movie_cbox);
        movie_cbox.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        movie_cbox.setText("Movie");
        movie_cbox.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel8.setText("Email ID");

        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("*");

        email_txt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        email_txt.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel10.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel10.setText("Address");

        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("*");

        add_txt.setColumns(20);
        add_txt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        add_txt.setRows(5);
        jScrollPane1.setViewportView(add_txt);

        jLabel14.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel14.setText("Roll No.");

        jLabel15.setForeground(new java.awt.Color(255, 0, 51));
        jLabel15.setText("*");

        roll_no.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fullname)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(country_code_combox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(contact_txt)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(email_txt))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(34, 34, 34)
                                .addComponent(male_rbtn)
                                .addGap(37, 37, 37)
                                .addComponent(female_rbtn))
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(music_cbox)
                                .addGap(10, 10, 10)
                                .addComponent(dance_cbox)
                                .addGap(11, 11, 11)
                                .addComponent(singing_cbox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(drawing_cbox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(movie_cbox)))
                        .addContainerGap(79, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(roll_no, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(roll_no, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contact_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(country_code_combox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(male_rbtn)
                    .addComponent(female_rbtn))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(music_cbox)
                    .addComponent(dance_cbox)
                    .addComponent(singing_cbox)
                    .addComponent(drawing_cbox)
                    .addComponent(movie_cbox))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        search_btn.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        update_btn.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        update_btn.setText("Update");
        update_btn.setEnabled(false);
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        reset_btn.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        reset_btn.setText("Reset");
        reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(search_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(update_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reset_btn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btnActionPerformed
        roll_no.setText("");
        fullname.setText("");
        country_code_combox.setSelectedIndex(0);
        contact_txt.setText("");
        email_txt.setText("");
        add_txt.setText("");
        male_rbtn.setSelected(false);
        female_rbtn.setSelected(false);
        roll_no.setEditable(true);
        update_btn.setEnabled(false);
        music_cbox.setSelected(false);
        dance_cbox.setSelected(false);
        singing_cbox.setSelected(false);
        drawing_cbox.setSelected(false);
        movie_cbox.setSelected(false);
    }//GEN-LAST:event_reset_btnActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        if(user.equals("admin")){
            int flag = JDBCExample(Integer.parseInt(roll_no.getText()));
            if(flag==0){
                update_btn.setEnabled(true);
                roll_no.setEditable(false);
            }
            else
                JOptionPane.showMessageDialog(rootPane, "Enered Roll Number user doesn't exist!");
        }
    }//GEN-LAST:event_search_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        String gender=null;
        if(male_rbtn.isSelected())
            gender="Male";
        else if(female_rbtn.isSelected())
            gender="Female";
            
        updateUser(roll_no.getText(), fullname.getText(), gender, contact_txt.getText(), email_txt.getText(), add_txt.getText());
    }//GEN-LAST:event_update_btnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonalDetailFrame("admin").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea add_txt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField contact_txt;
    private javax.swing.JComboBox<String> country_code_combox;
    private javax.swing.JCheckBox dance_cbox;
    private javax.swing.JCheckBox drawing_cbox;
    private javax.swing.JTextField email_txt;
    private javax.swing.JRadioButton female_rbtn;
    private javax.swing.JTextField fullname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton male_rbtn;
    private javax.swing.JCheckBox movie_cbox;
    private javax.swing.JCheckBox music_cbox;
    private javax.swing.JButton reset_btn;
    private javax.swing.JTextField roll_no;
    private javax.swing.JButton search_btn;
    private javax.swing.JCheckBox singing_cbox;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
