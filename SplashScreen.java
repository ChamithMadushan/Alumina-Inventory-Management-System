
package alumina.inventory.management.system;

import javax.swing.JOptionPane;

public class SplashScreen extends javax.swing.JFrame {

    
    public SplashScreen() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loading_txt = new javax.swing.JLabel();
        losdingname_txt = new javax.swing.JLabel();
        ss_p_bar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        des_txt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loading_txt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        loading_txt.setText("0%");

        losdingname_txt.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        losdingname_txt.setText("Loading...");

        ss_p_bar.setBackground(new java.awt.Color(255, 188, 0));
        ss_p_bar.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chamith Madushan\\Desktop\\Alumina Pvt Ltd\\Splash Screen\\Alumina Logo Png.png")); // NOI18N
        jLabel1.setText("jLabel1");

        des_txt.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        des_txt.setText("© 2025 Alumina Pvt Ltd. All Rights Reserved.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(des_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ss_p_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(loading_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(losdingname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(244, 244, 244))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loading_txt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ss_p_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(losdingname_txt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(des_txt)
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      SplashScreen sp =new SplashScreen();
       sp.setVisible(true);
        
       try{
           for(int i=0;i<=100;i++){
               Thread.sleep(100);
               sp.loading_txt.setText(i+"%");
               
               if(i==10){
                   sp.losdingname_txt.setText("Getting things ready...");
               }
               if(i==20){
                   sp.losdingname_txt.setText("Launching Application...");
               }
               if(i==30){   
                   sp.losdingname_txt.setText("Initialization Modules...");
               }
               if(i==50){
                   sp.losdingname_txt.setText("Loading Resources...");
               }
               if(i==70){
                   sp.losdingname_txt.setText("Starting Services...");
               }
               if(i==90){
                   sp.losdingname_txt.setText("Almost There...");
               }
               sp.ss_p_bar.setValue(i);
           }
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           
       }
       
        sp.setVisible(false);
       Login log=new Login();
        log.setVisible(true);
       
          
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreen().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel des_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel loading_txt;
    private javax.swing.JLabel losdingname_txt;
    private javax.swing.JProgressBar ss_p_bar;
    // End of variables declaration//GEN-END:variables
}
