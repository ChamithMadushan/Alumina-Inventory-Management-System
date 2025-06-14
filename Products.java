/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package alumina.inventory.management.system;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Products extends javax.swing.JFrame {

   
    public Products() {
        initComponents();
        Connect();
        Category_Load();
        getSum();
        showProductCategoryTotals();
        
        
        
        
    }
        Connection con;
        PreparedStatement pst;
        ResultSet rs1;
    
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
          
        
        public void Category_Load(){
                
                int c;
                
        try {
            pst =con.prepareStatement("select * from category");
            ResultSet rs1 = pst.executeQuery();
            
            ResultSetMetaData rsd = rs1.getMetaData();
            c =rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)product_tbl.getModel();
            d.setRowCount(0);
            
            while(rs1.next()){
                Vector v2 =new Vector();
                
                for(int i=1;i<c;i++){
                    v2.add(rs1.getString("id"));
                    v2.add(rs1.getString("p_no"));
                    v2.add(rs1.getString("p_description"));
                    v2.add(rs1.getString("warranty"));
                    v2.add(rs1.getString("qty"));
                    v2.add(rs1.getString("category"));
                    v2.add(rs1.getString("sub_category"));
                }
                
                d.addRow(v2);
                
            }
            
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                
                
                
            }
            
        public void getSum(){
            int sum=0;
            for(int i = 0; i<product_tbl.getRowCount(); i++){
                sum = sum + Integer.parseInt(product_tbl.getValueAt(i, 4).toString());
            }
            sum_qty_lbl.setText(Integer.toString(sum));
        }    
            
       public void showProductCategoryTotals(){

           int hardwaretotal=0;
           int softwaretotal=0;

           DefaultTableModel model = (DefaultTableModel)product_tbl.getModel();
            int rowCount = model.getRowCount();
            
            for(int i = 0;i< rowCount; i++){
                String category =model.getValueAt(i, 5).toString();
                int qty=0;
                
                try{
                    qty=Integer.parseInt(model.getValueAt(i, 4).toString());
                    
                    
                }catch(NumberFormatException e){
                    e.printStackTrace();
                }
                if(category.equalsIgnoreCase("Hardware")){
                    hardwaretotal += qty;
                }else if(category.equalsIgnoreCase("Software")){
                    softwaretotal += qty;
                }
            }
        hardware_cb_lbl.setText(""+hardwaretotal);
        software_cb_lbl.setText(""+softwaretotal);
           
       } 
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        product_no_txt = new javax.swing.JTextField();
        product_description_txt = new javax.swing.JTextField();
        warranty_txt = new javax.swing.JTextField();
        qty_txt = new javax.swing.JTextField();
        product_no_lbl = new javax.swing.JLabel();
        product_description_lbl = new javax.swing.JLabel();
        warranty_lbl = new javax.swing.JLabel();
        qty_lbl = new javax.swing.JLabel();
        product_update_btn = new javax.swing.JButton();
        category_combobox = new javax.swing.JComboBox<>();
        sub_category_txt = new javax.swing.JTextField();
        category_lbl = new javax.swing.JLabel();
        sub_catagory_lbl = new javax.swing.JLabel();
        product_add_btn = new javax.swing.JButton();
        product_delete_btn = new javax.swing.JButton();
        hardware_cb_lbl = new javax.swing.JLabel();
        software_cb_lbl = new javax.swing.JLabel();
        sum_qty_lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        product_tbl = new javax.swing.JTable();
        des_login_txt1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1003, 800));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1003, 965));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Products Page");

        product_no_txt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        product_description_txt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        warranty_txt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        qty_txt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        product_no_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        product_no_lbl.setForeground(new java.awt.Color(255, 255, 255));
        product_no_lbl.setText("Product No");

        product_description_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        product_description_lbl.setForeground(new java.awt.Color(255, 255, 255));
        product_description_lbl.setText("Product Description");

        warranty_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        warranty_lbl.setForeground(new java.awt.Color(255, 255, 255));
        warranty_lbl.setText("Warranty");

        qty_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        qty_lbl.setForeground(new java.awt.Color(255, 255, 255));
        qty_lbl.setText("Quantity");

        product_update_btn.setBackground(new java.awt.Color(0, 102, 102));
        product_update_btn.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        product_update_btn.setForeground(new java.awt.Color(255, 255, 255));
        product_update_btn.setText("Update");
        product_update_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        product_update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_update_btnActionPerformed(evt);
            }
        });

        category_combobox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        category_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Hardware", "Software" }));
        category_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category_comboboxActionPerformed(evt);
            }
        });

        sub_category_txt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        sub_category_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_category_txtActionPerformed(evt);
            }
        });

        category_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        category_lbl.setForeground(new java.awt.Color(255, 255, 255));
        category_lbl.setText("Catogory");

        sub_catagory_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        sub_catagory_lbl.setForeground(new java.awt.Color(255, 255, 255));
        sub_catagory_lbl.setText("Sub Catogory");

        product_add_btn.setBackground(new java.awt.Color(0, 102, 102));
        product_add_btn.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        product_add_btn.setForeground(new java.awt.Color(255, 255, 255));
        product_add_btn.setText("Add");
        product_add_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        product_add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_add_btnActionPerformed(evt);
            }
        });

        product_delete_btn.setBackground(new java.awt.Color(0, 102, 102));
        product_delete_btn.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        product_delete_btn.setForeground(new java.awt.Color(255, 255, 255));
        product_delete_btn.setText("Delete");
        product_delete_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        product_delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_delete_btnActionPerformed(evt);
            }
        });

        hardware_cb_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        hardware_cb_lbl.setForeground(new java.awt.Color(0, 255, 51));
        hardware_cb_lbl.setText("Hardware");

        software_cb_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        software_cb_lbl.setForeground(new java.awt.Color(51, 255, 51));
        software_cb_lbl.setText("Software");

        sum_qty_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        sum_qty_lbl.setForeground(new java.awt.Color(51, 255, 51));
        sum_qty_lbl.setText("Sum");

        product_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Product No", "Product Description", "Warranty", "Qty", "Category", "Sub Category"
            }
        ));
        product_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(product_tbl);

        des_login_txt1.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        des_login_txt1.setForeground(new java.awt.Color(255, 255, 255));
        des_login_txt1.setText("© 2025 Alumina Pvt Ltd. All Rights Reserved.");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total Qty");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Hardware");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Software");

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(product_no_lbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(product_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(product_description_lbl)
                                        .addGap(15, 15, 15)
                                        .addComponent(product_description_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(warranty_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(qty_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(category_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(warranty_txt)
                                            .addComponent(qty_txt)
                                            .addComponent(category_combobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(product_add_btn)
                                            .addComponent(sub_catagory_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(sub_category_txt))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(product_update_btn)
                                                .addGap(9, 9, 9))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(product_delete_btn)
                                .addGap(166, 166, 166)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addComponent(software_cb_lbl))
                                            .addComponent(jLabel4)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(53, 53, 53)
                                            .addComponent(hardware_cb_lbl)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(des_login_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(437, 437, 437)
                        .addComponent(sum_qty_lbl))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(64, 64, 64))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(product_no_lbl)
                            .addComponent(product_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(product_description_lbl)
                            .addComponent(product_description_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(warranty_lbl)
                            .addComponent(warranty_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qty_lbl)
                            .addComponent(qty_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(sum_qty_lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(hardware_cb_lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(software_cb_lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(category_lbl)
                            .addComponent(category_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sub_catagory_lbl)
                            .addComponent(sub_category_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(product_update_btn)
                            .addComponent(product_add_btn))
                        .addGap(25, 25, 25)
                        .addComponent(product_delete_btn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(des_login_txt1)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void product_add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_add_btnActionPerformed
        
        String product_no=product_no_txt.getText();
        String product_des=product_description_txt.getText();
        String warranty=warranty_txt.getText();
        String qty=qty_txt.getText();
        String category=category_combobox.getSelectedItem().toString();
        String sub_category=sub_category_txt.getText();
        
        try {
            pst = con.prepareStatement("insert into category(p_no,p_description,warranty,qty,category,sub_category)values(?,?,?,?,?,?)");
            pst.setString(1, product_no);
            pst.setString(2, product_des);
            pst.setString(3, warranty);
            pst.setString(4, qty);
            pst.setString(5, category);
            pst.setString(6, sub_category);
            int k =pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Product added Successfully.");
                product_no_txt.setText("");
                product_description_txt.setText("");
                warranty_txt.setText("");
                qty_txt.setText("");
                category_combobox.setSelectedIndex(-1);
                sub_category_txt.setText("");
                Category_Load();
                
            }
            else{
                JOptionPane.showMessageDialog(this,"Error!!!!");
            }
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_product_add_btnActionPerformed

    private void product_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_tblMouseClicked
        
            DefaultTableModel model = (DefaultTableModel)product_tbl.getModel();
            int selectedRowIndex =product_tbl.getSelectedRow();
            
            int id =Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
            
            product_no_txt.setText(model.getValueAt(selectedRowIndex,1).toString());
            product_description_txt.setText(model.getValueAt(selectedRowIndex,2).toString());
            warranty_txt.setText(model.getValueAt(selectedRowIndex,3).toString());
            qty_txt.setText(model.getValueAt(selectedRowIndex,4).toString());
            category_combobox.setSelectedItem(model.getValueAt(selectedRowIndex,5).toString()); 
            sub_category_txt.setText(model.getValueAt(selectedRowIndex,6).toString());
            
            product_add_btn.setEnabled(false);
    }//GEN-LAST:event_product_tblMouseClicked

    private void product_update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_update_btnActionPerformed
        
        DefaultTableModel model = (DefaultTableModel)product_tbl.getModel();
        int selectedRowIndex =product_tbl.getSelectedRow();
        
        int id =Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        
        String product_no=product_no_txt.getText();
        String product_des=product_description_txt.getText();
        String warranty=warranty_txt.getText();
        String qty=qty_txt.getText();
        String category=category_combobox.getSelectedItem().toString();
        String sub_category=sub_category_txt.getText();
        
        try {
            pst = con.prepareStatement("update category set p_no=?,p_description=?,warranty=?,qty=?,category=?,sub_category=? where id=?");
            pst.setString(1, product_no);
            pst.setString(2, product_des);
            pst.setString(3, warranty);
            pst.setString(4, qty);
            pst.setString(5, category);
            pst.setString(6, sub_category);
            pst.setInt(7, id);
            int k =pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Product Updated Successfully.");
                product_no_txt.setText("");
                product_description_txt.setText("");
                warranty_txt.setText("");
                qty_txt.setText("");
                category_combobox.setSelectedIndex(-1);
                sub_category_txt.setText("");
                Category_Load();
                product_add_btn.setEnabled(true);
                
                
            }
            else{
                JOptionPane.showMessageDialog(this,"Error!!!!");
            }
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_product_update_btnActionPerformed

    private void product_delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_delete_btnActionPerformed
        
        DefaultTableModel model = (DefaultTableModel)product_tbl.getModel();
        int selectedRowIndex =product_tbl.getSelectedRow();
        
        int id =Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        
        //String product_no=product_no_txt.getText();
        //String product_des=product_description_txt.getText();
        //String warranty=warranty_txt.getText();
        //String qty=qty_txt.getText();
        //String category=category_combobox.getSelectedItem().toString();
        //String sub_category=sub_category_txt.getText();
        
        try {
            pst = con.prepareStatement("delete from category where id=?");
            //pst.setString(1, product_no);
            //pst.setString(2, product_des);
            //pst.setString(3, warranty);
            //pst.setString(4, qty);
            //pst.setString(5, category);
            //pst.setString(6, sub_category);
            pst.setInt(1, id);
            int k =pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Product Deleted Successfully.");
                product_no_txt.setText("");
                product_description_txt.setText("");
                warranty_txt.setText("");
                qty_txt.setText("");
                category_combobox.setSelectedIndex(-1);
                sub_category_txt.setText("");
                Category_Load();
                product_add_btn.setEnabled(true);
                
                
            }
            else{
                JOptionPane.showMessageDialog(this,"Error!!!!");
            }
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_product_delete_btnActionPerformed

    private void category_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_category_comboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_category_comboboxActionPerformed

    private void sub_category_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_category_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_category_txtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ProcurementPage p1=new ProcurementPage();
        p1.setVisible(true);
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
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Products().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> category_combobox;
    private javax.swing.JLabel category_lbl;
    private javax.swing.JLabel des_login_txt1;
    private javax.swing.JLabel hardware_cb_lbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton product_add_btn;
    private javax.swing.JButton product_delete_btn;
    private javax.swing.JLabel product_description_lbl;
    private javax.swing.JTextField product_description_txt;
    private javax.swing.JLabel product_no_lbl;
    private javax.swing.JTextField product_no_txt;
    private javax.swing.JTable product_tbl;
    private javax.swing.JButton product_update_btn;
    private javax.swing.JLabel qty_lbl;
    private javax.swing.JTextField qty_txt;
    private javax.swing.JLabel software_cb_lbl;
    private javax.swing.JLabel sub_catagory_lbl;
    private javax.swing.JTextField sub_category_txt;
    private javax.swing.JLabel sum_qty_lbl;
    private javax.swing.JLabel warranty_lbl;
    private javax.swing.JTextField warranty_txt;
    // End of variables declaration//GEN-END:variables
}
