/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NMEAProxy;

import javax.swing.JOptionPane;

/**
 *
 * @author Bernhard Bagyura
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
       //jTextField1.setText(FileHandling.getPreference("ServerIP"));
       //BBG 15.Aug.17 Hier wird direkt nach dem initialisieren der Componenten das confuguration.xml gelesen sofern vorhanden 
       jTextFieldServerPort.setText(LastSettings.getPreference("ServerPort"));
       jTextFieldmaxClients.setText(LastSettings.getPreference("MaxClients"));
       jTextFieldClientIP.setText(LastSettings.getPreference("ClientIP"));
       jTextFieldClientPort.setText(LastSettings.getPreference("ClientPort"));
       jTextFieldNotizen.setText(LastSettings.getPreference("Notizen"));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonStart = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldServerPort = new javax.swing.JTextField();
        jTextFieldmaxClients = new javax.swing.JTextField();
        jTextFieldClientIP = new javax.swing.JTextField();
        jTextFieldClientPort = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabelaktverbindungen = new javax.swing.JLabel();
        jTextFieldNotizen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NMEA Proxy");
        setResizable(false);

        jButtonStart.setText("Start");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonStop.setText("Stop");
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        jLabel1.setText("Server Port");

        jLabel2.setText("Client IP");

        jLabel3.setText("Client Port");

        jLabel4.setText("Max Clients");

        jLabel5.setText("Aktive Verbindungen:");

        jLabelaktverbindungen.setText("0");

        jTextFieldNotizen.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextFieldNotizen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNotizenActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Notizen");

        jMenu1.setText("File");

        jMenuItem1.setText("exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setLabel("Save Settings");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenuItem3.getAccessibleContext().setAccessibleName("jMenuItemSave");
        jMenuItem3.getAccessibleContext().setAccessibleDescription("");

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");

        jMenuItem2.setText("about NMEA Proxy");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonStart)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldServerPort, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(127, 127, 127))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldClientIP)
                                .addGap(43, 43, 43)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jButtonStop)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldClientPort, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jTextFieldmaxClients, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextFieldNotizen, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelaktverbindungen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldmaxClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldClientIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldClientPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStart)
                    .addComponent(jButtonStop))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelaktverbindungen))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNotizen)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        // TODO add your handling code here:
        try {
            a.stopmasterclient();
            a.stopmyServerSocket(); 
            a.stopmyclients();
        } catch (Exception e) {
            System.out.println("Gui Zeile 148: " + e);
        }
        a = null;
        System.gc();
        jLabelaktverbindungen.setText("0");
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        // TODO add your handling code here:
        
        // Starter mit maximale Anzahl der Verbindungen instanzieren
        
        if (a == null){
        JOptionPane.showMessageDialog(rootPane, "Starte neue Verbindung zu: " +
                                      jTextFieldClientIP.getText() + ":" + jTextFieldClientPort.getText());
        // Neue Instanz mit int max Connections
        a = new Starter(Integer.parseInt(jTextFieldmaxClients.getText()),Integer.parseInt(jTextFieldServerPort.getText()),this);
        // methode beginn mit angabe von Portnummer 
        a.begin();
        // Starte den MasterClient mit IP und Port
        a.startMasterClient(jTextFieldClientIP.getText(), Integer.parseInt(jTextFieldClientPort.getText()));
        
        System.out.println(a.toString()); 
        }else{
            JOptionPane.showMessageDialog(rootPane, "Eine Verbindung ist Aktiv");
        }
        
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "NMEA Proxy 0.2\nby Bagy\n22 August 2017");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jTextFieldNotizenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNotizenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNotizenActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        saveallSettings();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public void setActiveVerbindungen(int verbindungen){
        jLabelaktverbindungen.setText(Integer.toString(verbindungen));
    }
    
    public void saveallSettings(){
       //Speichern der anktuellen Settings in ein File namens Configuration-xml
       // BBG 15.Aug.17
       LastSettings.setPreference("ServerPort",jTextFieldServerPort.getText());
       LastSettings.setPreference("MaxClients",jTextFieldmaxClients.getText());
       LastSettings.setPreference("ClientIP",jTextFieldClientIP.getText());
       LastSettings.setPreference("ClientPort",jTextFieldClientPort.getText());
       LastSettings.setPreference("Notizen",jTextFieldNotizen.getText());
    }
    
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    private Starter a;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelaktverbindungen;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JTextField jTextFieldClientIP;
    private javax.swing.JTextField jTextFieldClientPort;
    private javax.swing.JTextField jTextFieldNotizen;
    private javax.swing.JTextField jTextFieldServerPort;
    private javax.swing.JTextField jTextFieldmaxClients;
    // End of variables declaration//GEN-END:variables
}
