package studentrecordproject;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class StudentRecordsFrame extends javax.swing.JFrame {

    public StudentRecordsFrame() {
        initComponents();
        setLocationRelativeTo(null);
        insertData();
    }

    
    public void insertData(){
        String tData[] = {"ID", "Student Name", "Gender", "Contact Detail", "Email ID", "Address"};
        DefaultTableModel model = new DefaultTableModel(tData, database.getColumnCount());
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12569113", "sql12569113", "5HvIP5idv8");
            Statement stm = con.createStatement();
            
            try{
                ResultSet Data = stm.executeQuery("select * from personaldetails");
                while(Data.next()){
                    int row = Data.getRow();
                    for(int col=0; col<database.getColumnCount(); col++){
                        tData[col] = Data.getString(col+1);
                        if(database.getColumnName(col).equals("Gender")){
                            if(Data.getString(col+1) == null)
                                tData[col] = "Not Mention";                            
                            else if(Data.getString(col+1).equals("Male"))
                                tData[col] = "Male";
                            else if(Data.getString(col+1).equals("Female"))
                                tData[col] = "Female";
                        }                        
                    }
                    model.insertRow(row, tData);
                    
                } 
                Data.close();

            }catch(Exception sqle){
                System.out.println("Exception during fetch data :"+sqle);
            }
            database.setModel(model);
            stm.close();
            con.close();            
            
        }catch(Exception e){
            System.out.println("Exception at the end of insert methode:"+e);
        }           
    }
    
//    public static void insertDataIntoTable(int ID, String name, String ContactNo, String){
//        if(){
//            
//        }
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        database = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Record");

        database.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student Name", "Gender", "Contact Details", "Email ID", "Address"
            }
        ));
        jScrollPane1.setViewportView(database);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1106, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentRecordsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable database;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
