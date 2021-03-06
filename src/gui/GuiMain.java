/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.JButton;
import java.util.Locale;
import observerapp.JokeListener;
import observerapp.JokeTeller;
import observerapp.ListenerVerwaltung;
import strings.Language;

/**
 *
 * @author Fahid Shehzad
 */
public class GuiMain extends javax.swing.JFrame {
    private JokeTeller jokeTeller;
    private ListenerVerwaltung jokeListeners = new ListenerVerwaltung();

    /**
     * Creates new form GuiMain
     */
    public GuiMain() {
        initComponents();
        lblAnzahlListeners.setText("0");
        this.setLocationRelativeTo(null);
        aktiviereButtons();
        protokolliere(Language.getString("PartyStartMessage"));
        pnlListeners.setLayout(new FlowLayout());
        //Locale.setDefault(Locale.US);
    }
    
    public void protokolliere(String antrag) {
        taProtokoll.append(getUhrzeit());
        taProtokoll.append(" - ");
        taProtokoll.append(antrag);
        taProtokoll.append("\n");
    }
    
    public void addSampleButtons(int anzahl) {
        for(int i=0;i<anzahl;i++){
            addListenerButton("Listener" + i, String.valueOf(i));
        }
    }
    
    private void aktiviereButtons(){
        btnJokeTellerNameFestlegen.setEnabled(jokeTeller==null);
        txtJokeTellerName.setEnabled(jokeTeller==null);
        btnWitzErzaehlen.setEnabled(jokeTeller!=null);
        btnListenerAnmelden.setEnabled(jokeTeller!=null);
    }
    
    public void aktualisiereOberflaeche(){
        aktiviereButtons();
        reloadListeners();
    }
    
    protected void removeListener(int id) {
        protokolliere(jokeListeners.get(id).getName() + Language.getString("ListenerRemovedMessage"));
        jokeTeller.deleteObserver(jokeListeners.get(id));
        jokeListeners.removeListener(id);
        aktualisiereOberflaeche();
    }
    public String getUhrzeit() {
        String format = "HH:mm:ss";
        return new java.text.SimpleDateFormat(format)
                .format(new java.util.Date(System.currentTimeMillis()));
    }
    
    public void reloadListeners() {
        //Component[] components = pnlListeners.getComponents();
        pnlListeners.removeAll();
        int id = 0;
        for(JokeListener jokeListener : jokeListeners.getAllListeners()) {
            addListenerButton(jokeListener.getName(), String.valueOf(id));
            id++;
        }
        pnlListeners.revalidate();
        spListeners.revalidate();
    }
    
    private void addListenerButton(String name, String id) {
        int btnWidth = 120;
        int btnHeight = 70;
        int btnMargin[] = {5, 5, 5, 5};
        
        JButton button = new JButton(name);
        button.setName(id);

        button.setMinimumSize(new Dimension(btnWidth, btnHeight));
        button.setPreferredSize(new Dimension(btnWidth, btnHeight));
        button.setMargin(new Insets(
                btnMargin[0], btnMargin[1], 
                btnMargin[2], btnMargin[3]));

        button.addActionListener(new ListenerButtonActionController(this));
        pnlListeners.add(button);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taProtokoll = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtJokeTellerName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblAnzahlListeners = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnJokeTellerNameFestlegen = new javax.swing.JButton();
        btnWitzErzaehlen = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtListenerName = new javax.swing.JTextField();
        btnListenerAnmelden = new javax.swing.JButton();
        spListeners = new javax.swing.JScrollPane();
        pnlListeners = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("strings/language"); // NOI18N
        jLabel1.setText(bundle.getString("AppName")); // NOI18N
        jPanel1.add(jLabel1);

        taProtokoll.setColumns(20);
        taProtokoll.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        taProtokoll.setRows(5);
        jScrollPane3.setViewportView(taProtokoll);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("JokeTeller"))); // NOI18N

        txtJokeTellerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJokeTellerNameActionPerformed(evt);
            }
        });

        jLabel2.setText(bundle.getString("LabelName")); // NOI18N

        lblAnzahlListeners.setText("jLabel4");

        jLabel3.setText(bundle.getString("LabelAnzahlListeners")); // NOI18N

        btnJokeTellerNameFestlegen.setText(bundle.getString("ButtonSetJokeTellerName")); // NOI18N
        btnJokeTellerNameFestlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJokeTellerNameFestlegenActionPerformed(evt);
            }
        });

        btnWitzErzaehlen.setText(bundle.getString("ButtonTellJoke")); // NOI18N
        btnWitzErzaehlen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWitzErzaehlenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnJokeTellerNameFestlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnWitzErzaehlen, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(lblAnzahlListeners, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtJokeTellerName, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJokeTellerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJokeTellerNameFestlegen)
                    .addComponent(btnWitzErzaehlen))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblAnzahlListeners))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("Listener"))); // NOI18N

        jLabel5.setText(bundle.getString("LabelName")); // NOI18N

        txtListenerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtListenerNameActionPerformed(evt);
            }
        });

        btnListenerAnmelden.setText(bundle.getString("ButtonJoin")); // NOI18N
        btnListenerAnmelden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListenerAnmeldenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListenerAnmelden)
                    .addComponent(txtListenerName, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtListenerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnListenerAnmelden)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlListeners.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlListenersLayout = new javax.swing.GroupLayout(pnlListeners);
        pnlListeners.setLayout(pnlListenersLayout);
        pnlListenersLayout.setHorizontalGroup(
            pnlListenersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );
        pnlListenersLayout.setVerticalGroup(
            pnlListenersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );

        spListeners.setViewportView(pnlListeners);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spListeners)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spListeners, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJokeTellerNameFestlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJokeTellerNameFestlegenActionPerformed
        // TODO add your handling code here:
        String jokeTellerName = txtJokeTellerName.getText();
        if(jokeTellerName.length() < 2) { return; }
        jokeTeller = new JokeTeller(jokeTellerName);
        jokeTeller.setGui(this);
        protokolliere(jokeTellerName + Language.getString("JokeTellerSetMessage"));
        aktualisiereOberflaeche();
    }//GEN-LAST:event_btnJokeTellerNameFestlegenActionPerformed

    private void btnListenerAnmeldenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListenerAnmeldenActionPerformed
        // TODO add your handling code here:
        String listenerName = txtListenerName.getText();
        if(listenerName.length() < 2) { return; }
        JokeListener listener = new JokeListener(listenerName);
        listener.setGui(this);
        if(jokeListeners.addListener(listener)){
            protokolliere(listenerName + Language.getString("ListeenerJoinMessage"));
            txtListenerName.setText("");
            jokeTeller.addObserver(listener);
        }
        aktualisiereOberflaeche();
    }//GEN-LAST:event_btnListenerAnmeldenActionPerformed

    private void txtJokeTellerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJokeTellerNameActionPerformed
        // TODO add your handling code here:
        btnJokeTellerNameFestlegen.doClick();
    }//GEN-LAST:event_txtJokeTellerNameActionPerformed

    private void txtListenerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtListenerNameActionPerformed
        // TODO add your handling code here:
        btnListenerAnmelden.doClick();
    }//GEN-LAST:event_txtListenerNameActionPerformed

    private void btnWitzErzaehlenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWitzErzaehlenActionPerformed
        // TODO add your handling code here:
        jokeTeller.tellJoke();
    }//GEN-LAST:event_btnWitzErzaehlenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        if(args.length > 0) {
            String deutsch = "de";
            if(args[0].equalsIgnoreCase(deutsch)){
                Locale.setDefault(Locale.GERMANY);
            }else {
                Locale.setDefault(Locale.ENGLISH);
            }
        }
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
            java.util.logging.Logger.getLogger(GuiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJokeTellerNameFestlegen;
    private javax.swing.JButton btnListenerAnmelden;
    private javax.swing.JButton btnWitzErzaehlen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAnzahlListeners;
    private javax.swing.JPanel pnlListeners;
    private javax.swing.JScrollPane spListeners;
    private javax.swing.JTextArea taProtokoll;
    private javax.swing.JTextField txtJokeTellerName;
    private javax.swing.JTextField txtListenerName;
    // End of variables declaration//GEN-END:variables
}
