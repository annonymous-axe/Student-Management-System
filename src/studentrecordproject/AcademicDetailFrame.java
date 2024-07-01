
package studentrecordproject;

import java.sql.*;

public class AcademicDetailFrame extends javax.swing.JFrame {
    public AcademicDetailFrame(String user) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);        
        if(!user.equals("admin")){
            //if admin not login then perticular person's information are feeded and not give the right to chagne.
            searchPerson(user);
            setDisable();
        }
    }
    
    public void setDisable(){
        roll_no.setEditable(false);
        branch.setEnabled(false);
        batch.setEnabled(false);
        fees.setEnabled(false);
        math_marks.setEditable(false);
        sci_marks.setEditable(false);
        eng_marks.setEditable(false);
        phy_marks.setEditable(false);
        bio_marks.setEditable(false);
        chem_marks.setEditable(false); 
        search_btn.setEnabled(false);
        reset_btn.setEnabled(false);
        update_btn.setEnabled(false);        
    }
    public void setAcademicDetailEntry(int rollNo, int branch, int batch, int fees){
        roll_no.setText(""+rollNo);
        this.branch.setSelectedIndex(branch);
        this.batch.setSelectedIndex(batch);
        this.fees.setSelectedIndex(fees);                
    }
    public void setMarks(String Math, String Eng, String Sci, String Phy, String Chem, String Bio, String Total, String Percentage){
        math_marks.setText(Math);
        eng_marks.setText(Eng);
        sci_marks.setText(Sci);
        phy_marks.setText(Phy);
        chem_marks.setText(Chem);
        bio_marks.setText(Bio);
        total_marks.setText(Total);
        percentage.setText(Percentage);
    }
// set person's info directly to adframe when login by username and password.
    public void searchPerson(String username){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12569113", "sql12569113", "5HvIP5idv8");
            Statement stm = conn.createStatement();
            try{
                int rollNo;
                ResultSet rst = stm.executeQuery("select ID from personaldetails where username='"+username+"'");
                if(rst.next()){
                    rollNo = rst.getInt("ID");
                    rst = stm.executeQuery("select * from academicdetail where id='"+rollNo+"'");
                    if(rst.next()){
                        setAcademicDetailEntry(rollNo, rst.getInt("branch"), rst.getInt("batch"), rst.getInt("fees"));
                    }
                    rst = stm.executeQuery("select * from marksdetail where id='"+rollNo+"'");
                    if(rst.next()){
                        setMarks(rst.getString("maths"), rst.getString("english"), rst.getString("science"), rst.getString("physics"), 
                                rst.getString("chemestry"), rst.getString("biology"), rst.getString("total"), rst.getString("percentage"));
                    }
                    rst.close();
                }
                    
            }catch(SQLException sql){
                System.out.println("SQLException :"+sql);
            }
            stm.close();
            conn.close();
        }catch(Exception sql){
            System.out.println("Exceptions :"+sql);
        }
    }
    public void searchInfo(int RollNo){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12569113", "sql12569113", "5HvIP5idv8");
            Statement stm = conn.createStatement();
            try{
                ResultSet rst=stm.executeQuery("select * from academicdetail where id='"+RollNo+"'");
                if(rst.next()){
                    setAcademicDetailEntry(RollNo, rst.getInt("branch"),rst.getInt("batch"), rst.getInt("fees"));

                    rst = stm.executeQuery("select * from marksdetail where id='"+RollNo+"'");
                    if(rst.next()){
                        setMarks(rst.getString("maths"), rst.getString("english"), rst.getString("science"), rst.getString("physics"), 
                                rst.getString("chemestry"), rst.getString("biology"), rst.getString("total"), rst.getString("percentage"));
                    }
                }
                rst.close();
            }catch(SQLException sql){
                System.out.println("SQl Exception :"+sql);
            }
            stm.close();
            conn.close();
        }catch(Exception e){
            System.out.println("Exception :"+e);
        }
    }
    
    public void updateInfo(int RollNo, int branch, int batch, int fees){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12569113", "sql12569113", "5HvIP5idv8");
            Statement stm = conn.createStatement();
            try{
                stm.executeUpdate("update academicdetail set batch='"+batch+"' ,branch='"+branch+"' ,fees='"+fees+"' where id='"+RollNo+"'");
                stm.executeUpdate("update marksdetail set maths='"+math_marks.getText()+"', english='"+eng_marks.getText()+"',"
                        + "science='"+sci_marks.getText()+"', physics='"+phy_marks.getText()+"',"
                        + "chemestry='"+chem_marks.getText()+"', biology='"+bio_marks.getText()+"', total='"+total_marks.getText()+"',"
                         + "percentage='"+percentage.getText()+"' ");
            }catch(SQLException sql){
                System.out.println("SQL Exception :"+sql);
            }
            conn.close();
            stm.close();
        }catch(Exception e){
            System.out.println("Exception :"+e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        roll_no = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        branch = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        batch = new javax.swing.JComboBox<>();
        fees = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        math_marks = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        eng_marks = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        sci_marks = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        phy_marks = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        chem_marks = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        bio_marks = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        total_marks = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        percentage = new javax.swing.JLabel();
        enter_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        search_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        reset_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acadamic Details");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Academic Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Trebuchet MS", 1, 25), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(483, 527));
        jPanel3.setRequestFocusEnabled(false);

        jLabel14.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel14.setText("Roll No.");

        jLabel15.setForeground(new java.awt.Color(255, 0, 51));
        jLabel15.setText("*");

        roll_no.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel16.setText("Branch");

        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("*");

        branch.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select Branch--", "CSE", "ME", "CE", "EE", "ENTC", "BCA", "BSc", "" }));

        jLabel21.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel21.setText("Paid Fees");

        jLabel22.setForeground(new java.awt.Color(255, 0, 51));
        jLabel22.setText("*");

        jLabel25.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel25.setText("Batch");

        jLabel26.setForeground(new java.awt.Color(255, 0, 51));
        jLabel26.setText("*");

        batch.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        batch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select Batch--", "A", "B", "C", "D", "E", "F", "G", "H" }));

        fees.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        fees.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Paid Fees--", "45,950", "91,900" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roll_no, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26)
                                .addGap(46, 46, 46)
                                .addComponent(batch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(roll_no, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(batch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(fees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Marks Detail", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Trebuchet MS", 1, 25), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel18.setText("Maths");

        math_marks.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        math_marks.setText("0");

        jLabel19.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel19.setText("English");

        eng_marks.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        eng_marks.setText("0");

        jLabel20.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel20.setText("Science");

        sci_marks.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        sci_marks.setText("0");

        jLabel23.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel23.setText("Physics");

        phy_marks.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        phy_marks.setText("0");

        jLabel24.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel24.setText("Chemestry");

        chem_marks.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        chem_marks.setText("0");

        jLabel28.setFont(new java.awt.Font("Cambria", 0, 20)); // NOI18N
        jLabel28.setText("Biology");

        bio_marks.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        bio_marks.setText("0");

        jLabel29.setFont(new java.awt.Font("Cambria", 0, 30)); // NOI18N
        jLabel29.setText("Total");

        total_marks.setFont(new java.awt.Font("Cambria", 0, 30)); // NOI18N
        total_marks.setText("0");

        jLabel31.setFont(new java.awt.Font("Cambria", 0, 30)); // NOI18N
        jLabel31.setText("Percentage");

        percentage.setFont(new java.awt.Font("Cambria", 0, 30)); // NOI18N
        percentage.setText("0");

        enter_btn.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        enter_btn.setText("Enter Marks");
        enter_btn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        enter_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enter_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 30)); // NOI18N
        jLabel1.setText("%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(math_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(phy_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(104, 104, 104)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(47, 47, 47)
                                .addComponent(eng_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(chem_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(104, 104, 104)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(sci_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(bio_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(total_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(percentage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))))
                    .addComponent(enter_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(math_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(eng_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(sci_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(phy_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(chem_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(bio_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(enter_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_marks, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percentage, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
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
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enter_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enter_btnActionPerformed
        int total = Integer.parseInt(math_marks.getText())+Integer.parseInt(eng_marks.getText())+Integer.parseInt(sci_marks.getText())+Integer.parseInt(phy_marks.getText())+Integer.parseInt(chem_marks.getText())+Integer.parseInt(bio_marks.getText());
        total_marks.setText(""+total);
        if(total >= 35){
            percentage.setText(""+(total/6));
        }  
    }//GEN-LAST:event_enter_btnActionPerformed

    private void reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btnActionPerformed
        roll_no.setText("");
        branch.setSelectedIndex(0);
        batch.setSelectedIndex(0);
        fees.setSelectedIndex(0);
        
        math_marks.setText("0");
        sci_marks.setText("0");
        eng_marks.setText("0");
        phy_marks.setText("0");
        chem_marks.setText("0");
        bio_marks.setText("0");
        total_marks.setText("0");
        percentage.setText("0%");
    }//GEN-LAST:event_reset_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        updateInfo(Integer.parseInt(roll_no.getText()), branch.getSelectedIndex(), batch.getSelectedIndex(), fees.getSelectedIndex());
    }//GEN-LAST:event_update_btnActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        searchInfo(Integer.parseInt(roll_no.getText()));
    }//GEN-LAST:event_search_btnActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(AcademicDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AcademicDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AcademicDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AcademicDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AcademicDetailFrame("admin").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> batch;
    private javax.swing.JTextField bio_marks;
    private javax.swing.JComboBox<String> branch;
    private javax.swing.JTextField chem_marks;
    private javax.swing.JTextField eng_marks;
    private javax.swing.JButton enter_btn;
    private javax.swing.JComboBox<String> fees;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField math_marks;
    private javax.swing.JLabel percentage;
    private javax.swing.JTextField phy_marks;
    private javax.swing.JButton reset_btn;
    private javax.swing.JTextField roll_no;
    private javax.swing.JTextField sci_marks;
    private javax.swing.JButton search_btn;
    private javax.swing.JLabel total_marks;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
