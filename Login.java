
package alumina.inventory.management.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public Login() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        username_txt = new javax.swing.JLabel();
        username_login_lbl = new javax.swing.JTextField();
        password_txt = new javax.swing.JLabel();
        password_login_lbl = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        user_role_combobox = new javax.swing.JComboBox<>();
        login_page_btn = new javax.swing.JButton();
        create_user_lbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        des_login_txt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 750));

        username_txt.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        username_txt.setForeground(new java.awt.Color(255, 255, 255));
        username_txt.setText("Username");

        username_login_lbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        password_txt.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        password_txt.setForeground(new java.awt.Color(255, 255, 255));
        password_txt.setText("Password");

        password_login_lbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        password_login_lbl.setName(""); // NOI18N
        password_login_lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_login_lblActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Role");

        user_role_combobox.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        user_role_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Admin", "Finance", "Procurement", "Warehouse" }));
        user_role_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_role_comboboxActionPerformed(evt);
            }
        });

        login_page_btn.setBackground(new java.awt.Color(0, 102, 102));
        login_page_btn.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        login_page_btn.setForeground(new java.awt.Color(255, 255, 255));
        login_page_btn.setText("Login");
        login_page_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login_page_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_page_btnActionPerformed(evt);
            }
        });

        create_user_lbl.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        create_user_lbl.setForeground(new java.awt.Color(255, 255, 255));
        create_user_lbl.setText("Crate a New User");
        create_user_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        create_user_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create_user_lblMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chamith Madushan\\Desktop\\project images\\login.png")); // NOI18N

        des_login_txt.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        des_login_txt.setForeground(new java.awt.Color(255, 255, 255));
        des_login_txt.setText("© 2025 Alumina Pvt Ltd. All Rights Reserved.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(username_login_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(password_login_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(user_role_combobox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(login_page_btn)
                                .addGap(3, 3, 3)))))
                .addGap(0, 35, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(create_user_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(des_login_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_txt)
                    .addComponent(username_login_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_txt)
                    .addComponent(password_login_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user_role_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(50, 50, 50)
                .addComponent(login_page_btn)
                .addGap(37, 37, 37)
                .addComponent(create_user_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(des_login_txt)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void create_user_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create_user_lblMouseClicked
              // TODO add your handling code here:
        Register RegisterFrame=new Register();
        RegisterFrame.setVisible(true);
        RegisterFrame.pack();
        RegisterFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_create_user_lblMouseClicked

    private void user_role_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_role_comboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_role_comboboxActionPerformed

    private void login_page_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_page_btnActionPerformed
        // TODO add your handling code here:
        //login code
        String uname=username_login_lbl.getText();
        String pword=password_login_lbl.getText();
        String role=user_role_combobox.getSelectedItem().toString();
        
        if(uname.equals("")||pword.equals("")||role.equals("Select")){
            JOptionPane.showMessageDialog(rootPane, "Some fields are empty","Error",1);
        }else{
            try{
                con = Con.getConnection();
                pst =con.prepareStatement("SELECT * FROM `login_table` WHERE username=? AND password=?");
                pst.setString(1, uname);
                pst.setString(2, pword);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    String s1 = rs.getString("role");
                    String un =rs.getString("username");
                    if(role.equalsIgnoreCase("Admin") && s1.equalsIgnoreCase("admin")){
                        AdminPage ad=new AdminPage(un);
                        ad.setVisible(true);
                        setVisible(false);
                    }
                     if(role.equalsIgnoreCase("Procurement") && s1.equalsIgnoreCase("procurement")){
                        ProcurementPage pro=new ProcurementPage(un);
                        pro.setVisible(true);
                        setVisible(false);
                    }
                     if(role.equalsIgnoreCase("Finance") && s1.equalsIgnoreCase("finance")){
                        FinancePage fpage=new FinancePage();
                        fpage.setVisible(true);
                        setVisible(false);
                    }
                     
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Incorrect Username or Password.","Login Error",1);
                   
                }
                
            }catch(Exception ex){
                System.out.println(""+ex);
            }
        }
        
    }//GEN-LAST:event_login_page_btnActionPerformed

    private void password_login_lblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_login_lblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_login_lblActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel create_user_lbl;
    private javax.swing.JLabel des_login_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login_page_btn;
    private javax.swing.JPasswordField password_login_lbl;
    private javax.swing.JLabel password_txt;
    private javax.swing.JComboBox<String> user_role_combobox;
    private javax.swing.JTextField username_login_lbl;
    private javax.swing.JLabel username_txt;
    // End of variables declaration//GEN-END:variables
}
