/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view.adm;

import auxiliar.RandomString;
import client.view.*;
import client.view.operacao.OpVendas;
import client.view.operacao.Vendas;
import controller.ControladorLogin;
import data.DataBaseAcess;
import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author suporteti
 */
public class AdmMenu extends javax.swing.JFrame {
    static private String nomeUsuario;
    static private String ramalUsuario;
    private DataBaseAcess dba;
    private String dataLogin = ZonedDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    ZonedDateTime date = ZonedDateTime.now();
    private String dataDia = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    private String HoraLogin = date.format(DateTimeFormatter.ISO_LOCAL_TIME);
    private ControladorLogin clog;
    private String idlog;
    private final RandomString session;

    public AdmMenu(String nome, String ramal) {
        this.setLocationRelativeTo(null);
        try {
            this.dba = DataBaseAcess.getInstance();
            this.clog = ControladorLogin.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(AdmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        AdmMenu.nomeUsuario = nome;
        AdmMenu.ramalUsuario = ramal;    
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
        jLabel1 = new javax.swing.JLabel();
        MenuBar1 = new javax.swing.JMenuBar();
        GerarRelatorioVendas = new javax.swing.JMenu();
        RelatorioDeVendas = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mConfig1 = new javax.swing.JMenu();
        sys1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Teleconectividade :: Ares");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuInfo.setEditable(false);
        menuInfo.setBackground(new java.awt.Color(204, 204, 204));
        menuInfo.setBorder(null);
        getContentPane().add(menuInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 259, 400, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/resources/bg.jpg"))); // NOI18N
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        GerarRelatorioVendas.setText("Relatório");

        RelatorioDeVendas.setText("Relatório de vendas");
        RelatorioDeVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioDeVendasActionPerformed(evt);
            }
        });
        GerarRelatorioVendas.add(RelatorioDeVendas);

        MenuBar1.add(GerarRelatorioVendas);

        jMenu2.setText("Supervisão");
        MenuBar1.add(jMenu2);

        mConfig1.setText("Configurações");
        mConfig1.setEnabled(false);
        MenuBar1.add(mConfig1);

        sys1.setText("Sobre");
        sys1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sys1MouseClicked(evt);
            }
        });
        MenuBar1.add(sys1);

        setJMenuBar(MenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        menuInfo.setText(ramalUsuario+" : "+nomeUsuario + " | Logado às: " + dataLogin);
        try {            
            boolean ponto = dba.execute("INSERT INTO controle_ponto (ssid, ramal, data, hora_login) "
                    + "VALUES ('"+idlog+"', '"+ramalUsuario+"', '"+dataDia+"', '"+HoraLogin+"')"
            );            
            if(ponto){
               JOptionPane.showMessageDialog(this, "Hora de login registrada.\n"+HoraLogin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
           dba.isClosed();
           dba.execute("UPDATE usuario SET status = 1 WHERE (ramal = " + ramalUsuario + ")");
           ZonedDateTime logout = ZonedDateTime.now();
           String HoraLogout = logout.format(DateTimeFormatter.ISO_LOCAL_TIME);
           boolean ponto = dba.execute("UPDATE controle_ponto SET hora_logout = '"+HoraLogout+"' WHERE (ssid = '" + idlog + "')");         
           if(ponto){
               JOptionPane.showMessageDialog(this, "Hora de logout registrada.\n"+HoraLogout);
           }
        } catch (SQLException ex) {
            Logger.getLogger(AdmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        dba.closeConnnection();
        this.setVisible(false);
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void RelatorioDeVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioDeVendasActionPerformed
        //ConfiguracaoRelatorioVendas c = new ConfiguracaoRelatorioVendas();
        //c.setVisible(true);
        RelatorioVendas a = new RelatorioVendas();
        a.setVisible(true);
        OpVendas z = new OpVendas("20002");
        z.setVisible(true);
      
    }//GEN-LAST:event_RelatorioDeVendasActionPerformed

    private void sys1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sys1MouseClicked
        // TODO add your handling code here:
        Vendas v = new Vendas(ramalUsuario, nomeUsuario);
        v.setVisible(true);
    }//GEN-LAST:event_sys1MouseClicked

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
            java.util.logging.Logger.getLogger(AdmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            new AdmMenu(nomeUsuario, ramalUsuario).setVisible(true);            
        });
        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu GerarRelatorioVendas;
    private javax.swing.JMenuBar MenuBar1;
    private javax.swing.JMenuItem RelatorioDeVendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu mConfig1;
    private javax.swing.JTextField menuInfo;
    private javax.swing.JMenu sys1;
    // End of variables declaration//GEN-END:variables

  
}
