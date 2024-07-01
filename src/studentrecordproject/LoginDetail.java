package studentrecordproject;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class LoginDetail extends javax.swing.JFrame {

    public LoginDetail() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setData();
    }
    
    public void setData(){
        String data[] = {"", ""};
        DefaultTableModel model = new DefaultTableModel(data, database.getColumnCount());        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12569113", "sql12569113", "5HvIP5idv8");
            Statement stm = con.createStatement();
            try{
                ResultSet rst = stm.executeQuery("select * from logindetails");
                while(rst.next()){
                    int row = rst.getRow();
                    for(int col=0; col<database.getColumnCount(); col++){
                        data[col] = rst.getString(col+1);
                    }
                    model.insertRow(row, data);
                }
                rst.close();                
            }catch(SQLException sql){
                System.out.println("SQLException :"+sql);
            }
            database.setModel(model);
            stm.close();
            con.close();
            
        }catch(Exception e){
            System.out.println("Exception :"+e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        database = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login Details");

        database.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "username", "password"
            }
        ));
        database.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(database);
        database.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable database;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
