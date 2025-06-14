package alumina.inventory.management.system;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class PurchaseOrder extends javax.swing.JFrame {

   
    public PurchaseOrder() {
        initComponents();
        loadSuppliersIntoComboBox();
        Connect();
        PurchaseOrder_Load();
        
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
     public void Connect(){
                
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alumina_inventory_management","root","");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        }
     
    public void PurchaseOrder_Load(){
                
                int c;
                
        try {
            pst =con.prepareStatement("select * from purchase_order");
            ResultSet rs1 = pst.executeQuery();
            
            ResultSetMetaData rsd = rs1.getMetaData();
            c =rsd.getColumnCount();
            
            DefaultTableModel d1 = (DefaultTableModel)po_tbl.getModel();
            d1.setRowCount(0);
            
            while(rs1.next()){
                Vector v2 =new Vector();
                
                for(int i=1;i<c;i++){
                    v2.add(rs1.getString("po_date"));
                    v2.add(rs1.getString("po_no"));
                    v2.add(rs1.getString("supplier_name"));
                    v2.add(rs1.getString("item"));
                    v2.add(rs1.getString("price"));
                    v2.add(rs1.getString("qty"));
                    v2.add(rs1.getString("total"));
                }
                
                d1.addRow(v2);
                
            }
            
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                
                
                
        }
    
    public void loadSuppliersIntoComboBox(){
        try{
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/alumina_inventory_management","root","");
        PreparedStatement pst =con.prepareStatement("SELECT supplier_name FROM supplier");
        ResultSet rs =pst.executeQuery();
        po_supplier_name_combobox.removeAllItems();
        
        while(rs.next()){
            po_supplier_name_combobox.addItem(rs.getString("supplier_name"));
        }
        
        rs.close();
        pst.close();
        con.close();
        
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error Loading Suppliers"+e.getMessage());
        }
        }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        item_txt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        price_txt = new javax.swing.JTextField();
        po_supplier_name_lbl = new javax.swing.JLabel();
        qty_txt = new javax.swing.JTextField();
        po_supplier_name_combobox = new javax.swing.JComboBox<>();
        po_create_btn = new javax.swing.JButton();
        po_no_txt = new javax.swing.JTextField();
        po_date_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        total_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        po_tbl = new javax.swing.JTable();
        des_login_txtxt = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 900));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        item_txt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Purchase Order");

        price_txt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        po_supplier_name_lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        po_supplier_name_lbl.setForeground(new java.awt.Color(255, 255, 255));
        po_supplier_name_lbl.setText("Supplier Name");

        qty_txt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        po_supplier_name_combobox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        po_supplier_name_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        po_create_btn.setBackground(new java.awt.Color(0, 102, 102));
        po_create_btn.setFont(new java.awt.Font("Rockwell", 1, 48)); // NOI18N
        po_create_btn.setForeground(new java.awt.Color(255, 255, 255));
        po_create_btn.setText("Create");
        po_create_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        po_create_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                po_create_btnActionPerformed(evt);
            }
        });

        po_no_txt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        po_date_txt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Date");
        jLabel2.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Purchase Order No");

        total_txt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Item");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Price");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Qty");

        po_tbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        po_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Purchase Date", "Purchase Order No", "Supplier Name", "Item", "Price", "Qty"
            }
        ));
        po_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                po_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(po_tbl);

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
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(po_date_txt))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(po_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(po_supplier_name_lbl)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total_txt)
                            .addComponent(item_txt)
                            .addComponent(price_txt)
                            .addComponent(qty_txt)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(po_supplier_name_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(89, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(33, 33, 33))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(po_create_btn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(des_login_txtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(po_date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(po_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(po_supplier_name_lbl)
                            .addComponent(po_supplier_name_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(item_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(price_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(qty_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(po_create_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(des_login_txtxt)
                .addGap(157, 157, 157))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void po_create_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_po_create_btnActionPerformed
        
       String po_date=po_date_txt.getText();
        String  po_no=po_no_txt.getText();
        String supplier_name=po_supplier_name_combobox.getSelectedItem().toString();
        String po_item=item_txt.getText();
        int po_price=Integer.parseInt(price_txt.getText());
        int po_qty=Integer.parseInt(qty_txt.getText());
        
        int total =Integer.parseInt(price_txt.getText())* Integer.parseInt(qty_txt.getText());
        
        
        try {
            pst = con.prepareStatement("insert into purchase_order(po_date,po_no,supplier_name,item,price,qty,total)values(?,?,?,?,?,?,?)");
            pst.setString(1, po_date);
            pst.setString(2, po_no);
            pst.setString(3, supplier_name);
            pst.setString(4, po_item);
            pst.setInt(5, po_price);
            pst.setInt(6, po_qty);
            pst.setInt(7, total);
            
            int k =pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Supplier added Successfully.");
                
                po_date_txt.setText("");
                po_no_txt.setText("");
                po_supplier_name_combobox.setSelectedIndex(-1);
                item_txt.setText("");
                price_txt.setText("");
                qty_txt.setText("");
                total_txt.setText("");
                po_no_txt.requestFocus();
                PurchaseOrder_Load();
                
            }
            else{
                JOptionPane.showMessageDialog(this,"Error!!!!");
            }
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_po_create_btnActionPerformed

    private void po_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_po_tblMouseClicked
           
            DefaultTableModel model = (DefaultTableModel)po_tbl.getModel();
            int selectedIndex =po_tbl.getSelectedRow();
            
            int id =Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            
            po_date_txt.setText(model.getValueAt(selectedIndex,1).toString());
            po_no_txt.setText(model.getValueAt(selectedIndex,2).toString());
            po_supplier_name_combobox.setSelectedItem(model.getValueAt(selectedIndex,3).toString());
            item_txt.setText(model.getValueAt(selectedIndex,4).toString());
            price_txt.setText(model.getValueAt(selectedIndex,5).toString()); 
            qty_txt.setText(model.getValueAt(selectedIndex,6).toString());
            total_txt.setText(model.getValueAt(selectedIndex,7).toString());
            
            
    }//GEN-LAST:event_po_tblMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        ProcurementPage pp1= new ProcurementPage();
        pp1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel des_login_txtxt;
    private javax.swing.JTextField item_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton po_create_btn;
    private javax.swing.JTextField po_date_txt;
    private javax.swing.JTextField po_no_txt;
    private javax.swing.JComboBox<String> po_supplier_name_combobox;
    private javax.swing.JLabel po_supplier_name_lbl;
    private javax.swing.JTable po_tbl;
    private javax.swing.JTextField price_txt;
    private javax.swing.JTextField qty_txt;
    private javax.swing.JTextField total_txt;
    // End of variables declaration//GEN-END:variables
}
