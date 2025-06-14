
package alumina.inventory.management.system;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class Supplier extends javax.swing.JFrame {

    
    public Supplier() {
        initComponents();
        Connect();
        Supplier_Load();
        
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    

    public void Connect(){
                
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alumina_inventory_management","root","");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        }
    
    public void Supplier_Load(){
                
                int c;
                
        try {
            pst =con.prepareStatement("select * from supplier");
            ResultSet rs1 = pst.executeQuery();
            
            ResultSetMetaData rsd = rs1.getMetaData();
            c =rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)supplier_tbl.getModel();
            d.setRowCount(0);
            
            while(rs1.next()){
                Vector v2 =new Vector();
                
                for(int i=1;i<c;i++){
                    v2.add(rs1.getString("id"));
                    v2.add(rs1.getString("supplier_name"));
                    v2.add(rs1.getString("address"));
                    v2.add(rs1.getString("email"));
                    v2.add(rs1.getString("contact_no"));
                    v2.add(rs1.getString("category"));
                    v2.add(rs1.getString("br_no"));
                }
                
                d.addRow(v2);
                
            }
            
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                
                
                
        }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        address_lbl = new javax.swing.JLabel();
        supplier_email_lbl = new javax.swing.JLabel();
        supplier_name_txt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        address_txt_area = new javax.swing.JTextArea();
        supplier_email_txt = new javax.swing.JTextField();
        supplier_lbl = new javax.swing.JLabel();
        supplier_category_lbl = new javax.swing.JLabel();
        br_no_lbl = new javax.swing.JLabel();
        contact_no_lbl = new javax.swing.JLabel();
        supplier_category_combobox = new javax.swing.JComboBox<>();
        br_txt = new javax.swing.JTextField();
        contact_txt = new javax.swing.JTextField();
        supplier_update_btn = new javax.swing.JButton();
        supplier_delete_btn = new javax.swing.JButton();
        supplier_add_btn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        supplier_tbl = new javax.swing.JTable();
        des_login_txtxt = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 900));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Supplier Page");

        address_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        address_lbl.setForeground(new java.awt.Color(255, 255, 255));
        address_lbl.setText("Address");

        supplier_email_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        supplier_email_lbl.setForeground(new java.awt.Color(255, 255, 255));
        supplier_email_lbl.setText("Email");

        supplier_name_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        supplier_name_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_name_txtActionPerformed(evt);
            }
        });

        address_txt_area.setColumns(20);
        address_txt_area.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        address_txt_area.setRows(5);
        jScrollPane1.setViewportView(address_txt_area);

        supplier_email_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        supplier_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        supplier_lbl.setForeground(new java.awt.Color(255, 255, 255));
        supplier_lbl.setText("Supplier Name");

        supplier_category_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        supplier_category_lbl.setForeground(new java.awt.Color(255, 255, 255));
        supplier_category_lbl.setText("Category");

        br_no_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        br_no_lbl.setForeground(new java.awt.Color(255, 255, 255));
        br_no_lbl.setText("Business Registration No");

        contact_no_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        contact_no_lbl.setForeground(new java.awt.Color(255, 255, 255));
        contact_no_lbl.setText("Contact No");

        supplier_category_combobox.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        supplier_category_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "All", "Desktop", "Laptop", "SmartBoard", "Spare Parts", "Software" }));

        br_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        br_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                br_txtActionPerformed(evt);
            }
        });

        contact_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        contact_txt.setToolTipText("");
        contact_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contact_txtActionPerformed(evt);
            }
        });

        supplier_update_btn.setBackground(new java.awt.Color(0, 102, 102));
        supplier_update_btn.setFont(new java.awt.Font("Rockwell", 1, 48)); // NOI18N
        supplier_update_btn.setForeground(new java.awt.Color(255, 255, 255));
        supplier_update_btn.setText("Update");
        supplier_update_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supplier_update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_update_btnActionPerformed(evt);
            }
        });

        supplier_delete_btn.setBackground(new java.awt.Color(0, 102, 102));
        supplier_delete_btn.setFont(new java.awt.Font("Rockwell", 1, 48)); // NOI18N
        supplier_delete_btn.setForeground(new java.awt.Color(255, 255, 255));
        supplier_delete_btn.setText("Delete");
        supplier_delete_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supplier_delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_delete_btnActionPerformed(evt);
            }
        });

        supplier_add_btn.setBackground(new java.awt.Color(0, 102, 102));
        supplier_add_btn.setFont(new java.awt.Font("Rockwell", 1, 48)); // NOI18N
        supplier_add_btn.setForeground(new java.awt.Color(255, 255, 255));
        supplier_add_btn.setText("Add");
        supplier_add_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supplier_add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_add_btnActionPerformed(evt);
            }
        });

        supplier_tbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        supplier_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Supplier Name", "Address", "Email", "Contact No", "Category", "BR No"
            }
        ));
        supplier_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplier_tblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(supplier_tbl);

        des_login_txtxt.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        des_login_txtxt.setForeground(new java.awt.Color(255, 255, 255));
        des_login_txtxt.setText("© 2025 Alumina Pvt Ltd. All Rights Reserved.");

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(br_no_lbl)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(supplier_add_btn)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(supplier_update_btn)
                            .addComponent(br_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(supplier_lbl)
                            .addComponent(address_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplier_email_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contact_no_lbl)
                            .addComponent(supplier_category_lbl))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                            .addComponent(supplier_name_txt)
                            .addComponent(supplier_email_txt)
                            .addComponent(contact_txt)
                            .addComponent(supplier_category_combobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(supplier_delete_btn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(446, 446, 446)
                        .addComponent(des_login_txtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(supplier_lbl)
                            .addComponent(supplier_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(address_lbl)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(supplier_email_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(supplier_email_txt))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contact_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contact_no_lbl))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(supplier_category_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplier_category_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(br_no_lbl)
                            .addComponent(br_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplier_add_btn)
                    .addComponent(supplier_update_btn))
                .addGap(40, 40, 40)
                .addComponent(supplier_delete_btn)
                .addGap(51, 51, 51)
                .addComponent(des_login_txtxt)
                .addGap(147, 147, 147))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void br_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_br_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_br_txtActionPerformed

    private void supplier_name_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_name_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplier_name_txtActionPerformed

    private void contact_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contact_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contact_txtActionPerformed

    private void supplier_add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_add_btnActionPerformed
        
        String supplier_name=supplier_name_txt.getText();
        String supplier_address=address_txt_area.getText();
        String supplier_email=supplier_email_txt.getText();
        String contact_no=contact_txt.getText();
        String supplier_category=supplier_category_combobox.getSelectedItem().toString();
        String br_no=br_txt.getText();
        
        
        
        try {
            pst = con.prepareStatement("insert into supplier(supplier_name,address,email,contact_no,category,br_no)values(?,?,?,?,?,?)");
            pst.setString(1, supplier_name);
            pst.setString(2, supplier_address);
            pst.setString(3, supplier_email);
            pst.setString(4, contact_no);
            pst.setString(5, supplier_category);
            pst.setString(6, br_no);
            
            int k =pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Supplier added Successfully.");
                
                supplier_name_txt.setText("");
                address_txt_area.setText("");
                supplier_email_txt.setText("");
                contact_txt.setText("");
                supplier_category_combobox.setSelectedIndex(-1);
                br_txt.setText("");
                supplier_name_txt.requestFocus();
                Supplier_Load();
                
            }
            else{
                JOptionPane.showMessageDialog(this,"Error!!!!");
            }
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_supplier_add_btnActionPerformed

    private void supplier_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplier_tblMouseClicked
        
        DefaultTableModel model = (DefaultTableModel)supplier_tbl.getModel();
            int selectedIndex =supplier_tbl.getSelectedRow();
            
            int id =Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            
            supplier_name_txt.setText(model.getValueAt(selectedIndex,1).toString());
            address_txt_area.setText(model.getValueAt(selectedIndex,2).toString());
            supplier_email_txt.setText(model.getValueAt(selectedIndex,3).toString());
            contact_txt.setText(model.getValueAt(selectedIndex,4).toString());
            supplier_category_combobox.setSelectedItem(model.getValueAt(selectedIndex,5).toString()); 
            br_txt.setText(model.getValueAt(selectedIndex,6).toString());
            
            supplier_add_btn.setEnabled(false);
        
    }//GEN-LAST:event_supplier_tblMouseClicked

    private void supplier_update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_update_btnActionPerformed
        
        DefaultTableModel model = (DefaultTableModel)supplier_tbl.getModel();
        int selectedIndex =supplier_tbl.getSelectedRow();
        
        int id =Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        
        String supplier_name=supplier_name_txt.getText();
        String supplier_address=address_txt_area.getText();
        String supplier_email=supplier_email_txt.getText();
        String contact_no=contact_txt.getText();
        String supplier_category=supplier_category_combobox.getSelectedItem().toString();
        String br_no=br_txt.getText();
        
        try {
            pst = con.prepareStatement("update supplier set supplier_name=?,address=?,email=?,contact_no=?,category=?,br_no=? where id=?");
            pst.setString(1,supplier_name);
            pst.setString(2,supplier_address);
            pst.setString(3,supplier_email);
            pst.setString(4,contact_no);
            pst.setString(5,supplier_category);
            pst.setString(6,br_no);
            pst.setInt(7, id);
            
            int k =pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Supplier Updated Successfully.");
                supplier_name_txt.setText("");
                address_txt_area.setText("");
                supplier_email_txt.setText("");
                contact_txt.setText("");
                supplier_category_combobox.setSelectedIndex(-1);
                br_txt.setText("");
                supplier_name_txt.requestFocus();
                
            Supplier_Load();    
                
            }
            else{
                JOptionPane.showMessageDialog(this,"Error!!!!");
            }
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_supplier_update_btnActionPerformed

    private void supplier_delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_delete_btnActionPerformed
        
        DefaultTableModel model = (DefaultTableModel)supplier_tbl.getModel();
        int selectedRowIndex =supplier_tbl.getSelectedRow();
        
        int id =Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
           
       
        
        try {
            pst = con.prepareStatement("delete from supplier where id=?");
            
            pst.setInt(1, id);
            
            int k =pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Supplier Deleted Successfully.");
                supplier_name_txt.setText("");
                address_txt_area.setText("");
                supplier_email_txt.setText("");
                contact_txt.setText("");
                supplier_category_combobox.setSelectedIndex(-1);
                br_txt.setText("");
                supplier_name_txt.requestFocus();
                
            Supplier_Load();    
                
            }
            else{
                JOptionPane.showMessageDialog(this,"Error!!!!");
            }
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_supplier_delete_btnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ProcurementPage p2=new ProcurementPage();
        p2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address_lbl;
    private javax.swing.JTextArea address_txt_area;
    private javax.swing.JLabel br_no_lbl;
    private javax.swing.JTextField br_txt;
    private javax.swing.JLabel contact_no_lbl;
    private javax.swing.JTextField contact_txt;
    private javax.swing.JLabel des_login_txtxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton supplier_add_btn;
    private javax.swing.JComboBox<String> supplier_category_combobox;
    private javax.swing.JLabel supplier_category_lbl;
    private javax.swing.JButton supplier_delete_btn;
    private javax.swing.JLabel supplier_email_lbl;
    private javax.swing.JTextField supplier_email_txt;
    private javax.swing.JLabel supplier_lbl;
    private javax.swing.JTextField supplier_name_txt;
    private javax.swing.JTable supplier_tbl;
    private javax.swing.JButton supplier_update_btn;
    // End of variables declaration//GEN-END:variables
}
