
package studentrecordproject;

import java.awt.Image;
import javax.swing.ImageIcon;


public class MainFrame extends javax.swing.JFrame {
    static String user;
    public MainFrame(String str) {
        initComponents();
        user = str;
        logout_item.setText("Logout -"+user);
        if(!str.equals("admin")){
            registration_item.setEnabled(false);
            changepass_item.setEnabled(false);
            login_detail_item.setEnabled(false);
            place_cri_item.setEnabled(false);
            student_rec_item.setEnabled(false);
           profile_entry.setEnabled(false);
        }
        scaleImage();
//        setExtendedState(MAXIMIZED_BOTH);   
    }
    
    public void scaleImage(){
        ImageIcon icon = new ImageIcon("D:\\NetBeans Projects\\StudentRecordProject\\img\\innfrastacue.jpg");
        
        Image img = icon.getImage();
        Image scaled_img = img.getScaledInstance(img_label.getWidth(), img_label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon selected_icon = new ImageIcon(scaled_img);
        img_label.setIcon(selected_icon);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        img_label = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        registration_item = new javax.swing.JMenuItem();
        changepass_item = new javax.swing.JMenuItem();
        login_detail_item = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        logout_item = new javax.swing.JMenuItem();
        exit_itm = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        profile_entry = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        place_cri_item = new javax.swing.JMenuItem();
        student_rec_item = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1920, 1000));
        setResizable(false);

        img_label.setInheritsPopupMenu(false);

        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204)));

        jMenu1.setBackground(new java.awt.Color(204, 204, 255));
        jMenu1.setText("Users");
        jMenu1.setFont(new java.awt.Font("Shruti", 1, 16)); // NOI18N
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        registration_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        registration_item.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        registration_item.setText("Registration");
        registration_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registration_itemActionPerformed(evt);
            }
        });
        jMenu1.add(registration_item);

        changepass_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        changepass_item.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        changepass_item.setText("Change Password");
        changepass_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changepass_itemActionPerformed(evt);
            }
        });
        jMenu1.add(changepass_item);

        login_detail_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        login_detail_item.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        login_detail_item.setText("Login Details");
        login_detail_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_detail_itemActionPerformed(evt);
            }
        });
        jMenu1.add(login_detail_item);
        jMenu1.add(jSeparator1);

        logout_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        logout_item.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        logout_item.setText("Logout");
        logout_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_itemActionPerformed(evt);
            }
        });
        jMenu1.add(logout_item);

        exit_itm.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exit_itm.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        exit_itm.setText("Exit");
        exit_itm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_itmActionPerformed(evt);
            }
        });
        jMenu1.add(exit_itm);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(204, 204, 255));
        jMenu2.setText("Students");
        jMenu2.setFont(new java.awt.Font("Shruti", 1, 18)); // NOI18N
        jMenu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jMenuItem6.setText("Personal Details");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem7.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jMenuItem7.setText("Academic Details");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);
        jMenu2.add(jSeparator2);

        profile_entry.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        profile_entry.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        profile_entry.setText("Profile Entry");
        profile_entry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile_entryActionPerformed(evt);
            }
        });
        jMenu2.add(profile_entry);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(204, 204, 255));
        jMenu3.setText("Reports");
        jMenu3.setFont(new java.awt.Font("Shruti", 1, 18)); // NOI18N
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        place_cri_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        place_cri_item.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        place_cri_item.setText("Placement Criteria");
        place_cri_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                place_cri_itemActionPerformed(evt);
            }
        });
        jMenu3.add(place_cri_item);

        student_rec_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        student_rec_item.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        student_rec_item.setText("Student Records");
        student_rec_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_rec_itemActionPerformed(evt);
            }
        });
        jMenu3.add(student_rec_item);

        jMenuBar1.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(204, 204, 255));
        jMenu4.setText("Help");
        jMenu4.setFont(new java.awt.Font("Shruti", 1, 18)); // NOI18N
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem11.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jMenuItem11.setText("About");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img_label, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img_label, javax.swing.GroupLayout.DEFAULT_SIZE, 1120, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exit_itmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_itmActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exit_itmActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new AboutFrame().show();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void registration_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registration_itemActionPerformed
        new RegistrationFrame().show();
    }//GEN-LAST:event_registration_itemActionPerformed

    private void changepass_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changepass_itemActionPerformed
        new ChangePasswordFrame().show();
    }//GEN-LAST:event_changepass_itemActionPerformed

    private void logout_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_itemActionPerformed
        new LoginFrame().show();
        dispose();
    }//GEN-LAST:event_logout_itemActionPerformed

    private void login_detail_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_detail_itemActionPerformed
        new LoginDetail().show();
    }//GEN-LAST:event_login_detail_itemActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new PersonalDetailFrame(user).show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void student_rec_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_rec_itemActionPerformed
        new StudentRecordsFrame().show();
    }//GEN-LAST:event_student_rec_itemActionPerformed

    private void profile_entryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_entryActionPerformed
        new ProfileEntryFrame().show();
    }//GEN-LAST:event_profile_entryActionPerformed

    private void place_cri_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place_cri_itemActionPerformed
        new PlacementCriteria().show();
    }//GEN-LAST:event_place_cri_itemActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new AcademicDetailFrame(user).show();
    }//GEN-LAST:event_jMenuItem7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem changepass_item;
    private javax.swing.JMenuItem exit_itm;
    private javax.swing.JLabel img_label;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem login_detail_item;
    private javax.swing.JMenuItem logout_item;
    private javax.swing.JMenuItem place_cri_item;
    private javax.swing.JMenuItem profile_entry;
    private javax.swing.JMenuItem registration_item;
    private javax.swing.JMenuItem student_rec_item;
    // End of variables declaration//GEN-END:variables
}