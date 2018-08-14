/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view.operacao;

import client.view.*;
import auxiliar.RandomString;
import client.view.RelatorioVendas;
import controller.ControladorLogin;
import controller.SipConnector;
import data.APIAcess;
import data.DataBaseAcess;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author suporteti
 */
public class OperacaoMenu extends javax.swing.JFrame {
    static private String nomeUsuario;
    static private String ramalUsuario;
    private DataBaseAcess dba;
    private String dataLogin = ZonedDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    ZonedDateTime date = ZonedDateTime.now();
    private String dataDia = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    private String HoraLogin = date.format(DateTimeFormatter.ISO_LOCAL_TIME);
    private ControladorLogin clog;
    private APIAcess api;
    private String idlog;
    private final RandomString session;

    public OperacaoMenu(String nome, String ramal) {
        this.setLocationRelativeTo(null);
        try {
            this.dba = DataBaseAcess.getInstance();
            this.api = APIAcess.getInstance();
            this.clog = ControladorLogin.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(OperacaoMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        OperacaoMenu.nomeUsuario = nome;
        OperacaoMenu.ramalUsuario = ramal;    
        session = new RandomString(8, ThreadLocalRandom.current());
        idlog  = session.toString().substring(session.toString().indexOf("@")+1);
        initComponents();
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuInfo = new javax.swing.JTextField();
        logoutButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MenuBar1 = new javax.swing.JMenuBar();
        mSetores1 = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        opVendas = new javax.swing.JMenuItem();
        rVendas = new javax.swing.JMenuItem();
        mConfig1 = new javax.swing.JMenu();
        sys1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Teleconectividade :: Ares");
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(400, 340));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        menuInfo.setEditable(false);
        menuInfo.setBackground(new java.awt.Color(204, 204, 204));
        menuInfo.setAutoscrolls(false);
        menuInfo.setBorder(null);
        getContentPane().add(menuInfo);
        menuInfo.setBounds(0, 259, 400, 20);

        logoutButton.setText("LOGOUT");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton);
        logoutButton.setBounds(290, 220, 100, 30);

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("META DIÁRIA:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 20, 80, 14);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 40, 0, 0);

        jPanel1.setBackground(new java.awt.Color(255, 255, 50));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("5 CRIVOS: R$20,00");

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("1º DO RANKING: R$50,00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 170, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/resources/bg.jpg"))); // NOI18N
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 279);

        mSetores1.setText("Operações");
        mSetores1.add(jSeparator2);

        opVendas.setText("Vendas");
        opVendas.setMultiClickThreshhold(1L);
        opVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opVendasActionPerformed(evt);
            }
        });
        mSetores1.add(opVendas);

        rVendas.setText("Visualisar Vendas");
        rVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rVendasActionPerformed(evt);
            }
        });
        mSetores1.add(rVendas);

        MenuBar1.add(mSetores1);

        mConfig1.setText("Configurações");
        mConfig1.setEnabled(false);
        MenuBar1.add(mConfig1);

        sys1.setText("Sobre");
        sys1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sys1ActionPerformed(evt);
            }
        });
        MenuBar1.add(sys1);

        setJMenuBar(MenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void opVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opVendasActionPerformed
        Vendas v = new Vendas(ramalUsuario, nomeUsuario);
        v.setVisible(true);
        
    }//GEN-LAST:event_opVendasActionPerformed

    private void rVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rVendasActionPerformed
        OpVendas a = new OpVendas(ramalUsuario);
        a.setVisible(true);
    }//GEN-LAST:event_rVendasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         
         Timer timer = new Timer(120000, new ActionListener() {
            RankingVendas r = new RankingVendas(); 
        @Override
        public void actionPerformed(ActionEvent arg0) {
            
            r.dispose();
            r = new RankingVendas();
            r.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            r.setVisible(true);
        }
    });
    timer.start();
        menuInfo.setText(ramalUsuario+" : "+nomeUsuario + " | Logado às: " + dataLogin);
        try {            
            boolean ponto = dba.execute("INSERT INTO controle_ponto (ssid, ramal, nome, data, hora_login) "
                    + "VALUES ('"+idlog+"', '"+ramalUsuario+"', '"+nomeUsuario+"', '"+dataDia+"', '"+HoraLogin+"')"
            );            
            if(ponto){
               JOptionPane.showMessageDialog(this, "Hora de login registrada.\n"+HoraLogin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacaoMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        boolean auth = false;        
        try {
            ResultSet logOut = dba.execQry("SELECT autorizar FROM supervisao_controle WHERE id_operador = 1");
            if(logOut.next()){
                String out = logOut.getString("autorizar");
                if(out.equals("S")){auth = true;}
            }
            if(auth){
                dba.execute("UPDATE usuario SET status = 1 WHERE (ramal = " + ramalUsuario + ")");
                ZonedDateTime logout = ZonedDateTime.now();
                String HoraLogout = logout.format(DateTimeFormatter.ISO_LOCAL_TIME);
                boolean ponto = dba.execute("UPDATE controle_ponto SET hora_logout = '"+HoraLogout+"' WHERE (ssid = '" + idlog + "')");
                if(ponto){
                    JOptionPane.showMessageDialog(this, "Hora de logout registrada.\n"+HoraLogout);
                }
                logOut.close();
                dba.closeConnnection();
                this.setVisible(false);
                SipConnector sip = new SipConnector();
                api.logout(ramalUsuario);
                sip.Logout();
                this.dispose();
                System.exit(0);
            }else{
                JOptionPane.showMessageDialog(this, "Espere a Supervisão liberar o Login!", "ARES :: Teleconectividade", JOptionPane.ERROR_MESSAGE);    
            }                  
           
        } catch (SQLException ex) {
             Logger.getLogger(OperacaoMenu.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }//GEN-LAST:event_formWindowClosing

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed

        boolean auth = false;        
        try {
            ResultSet logOut = dba.execQry("SELECT autorizar FROM supervisao_controle WHERE id_operador = 1");
            if(logOut.next()){
                String out = logOut.getString("autorizar");
                if(out.equals("S")){auth = true;}
            }
            if(auth){
                dba.execute("UPDATE usuario SET status = 1 WHERE (ramal = " + ramalUsuario + ")");
                ZonedDateTime logout = ZonedDateTime.now();
                String HoraLogout = logout.format(DateTimeFormatter.ISO_LOCAL_TIME);
                boolean ponto = dba.execute("UPDATE controle_ponto SET hora_logout = '"+HoraLogout+"' WHERE (ssid = '" + idlog + "')");
                if(ponto){
                    JOptionPane.showMessageDialog(this, "Hora de logout registrada.\n"+HoraLogout);
                }
                
                dba.closeConnnection();
                SipConnector sip = new SipConnector();
                api.logout(ramalUsuario);
                sip.Logout();
                this.setVisible(false);
                this.dispose();
                System.exit(0);
            }else{
                JOptionPane.showMessageDialog(this, "Espere a Supervisão liberar o Login!", "ARES :: Teleconectividade", JOptionPane.ERROR_MESSAGE);    
            }                  
           
        } catch (SQLException ex) {
             Logger.getLogger(OperacaoMenu.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void sys1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sys1ActionPerformed
        JOptionPane.showMessageDialog(this, "Feito por Alexandre Magalhães.", "ARES :: Teleconectividade", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_sys1ActionPerformed

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
                if ("System".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OperacaoMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OperacaoMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OperacaoMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OperacaoMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            new OperacaoMenu(nomeUsuario, ramalUsuario).setVisible(true);            
        });
        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JMenu mConfig1;
    private javax.swing.JMenu mSetores1;
    private javax.swing.JTextField menuInfo;
    private javax.swing.JMenuItem opVendas;
    private javax.swing.JMenuItem rVendas;
    private javax.swing.JMenu sys1;
    // End of variables declaration//GEN-END:variables

  
}
