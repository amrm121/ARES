/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import auxiliar.RandomString;
import controller.ControladorLogin;
import data.DataBaseAcess;
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
public class Menu extends javax.swing.JFrame {
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

    public Menu(String nome, String ramal) {
        this.setLocationRelativeTo(null);
        try {
            this.dba = DataBaseAcess.getInstance();
            this.clog = ControladorLogin.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Menu.nomeUsuario = nome;
        Menu.ramalUsuario = ramal;    
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
    private void initComponents() {//GEN-BEGIN:initComponents

        menuInfo = new javax.swing.JTextField();
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
        menuInfo.setAutoscrolls(false);
        menuInfo.setBorder(null);
        getContentPane().add(menuInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 265, 400, -1));

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

        rVendas.setText("Vendas Agendadas");
        rVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rVendasActionPerformed(evt);
            }
        });
        mSetores1.add(rVendas);

        MenuBar1.add(mSetores1);

        mConfig1.setText("Configurações");
        MenuBar1.add(mConfig1);

        sys1.setText("Sobre");
        MenuBar1.add(sys1);

        setJMenuBar(MenuBar1);

        pack();
        setLocationRelativeTo(null);
    }//GEN-END:initComponents

    private void opVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opVendasActionPerformed
       
         
       
    }//GEN-LAST:event_opVendasActionPerformed

    private void rVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rVendasActionPerformed
        try {
            dba.execQry("SELECT * FROM vw_consumer_geracao_ordem");
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_rVendasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
        menuInfo.setText(ramalUsuario+" : "+nomeUsuario + "     |     Logado às: " + dataLogin);
        try {
            System.out.println("insert");
           boolean ponto = dba.execute("INSERT INTO controle_ponto (ssid, ramal, data, hora_login) "
                    + "VALUES ('"+idlog+"', '"+ramalUsuario+"', '"+dataDia+"', '"+HoraLogin+"')"
            );            
           if(ponto){
               JOptionPane.showMessageDialog(this, "Hora de login registrada.");
           }
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
           dba.execute("UPDATE usuario SET status = 1 WHERE (ramal = " + ramalUsuario + ")");
           ZonedDateTime logout = ZonedDateTime.now();
           String HoraLogout = logout.format(DateTimeFormatter.ISO_LOCAL_TIME);
           System.out.println(HoraLogout + "  TESTE");
           boolean ponto = dba.execute("UPDATE controle_ponto SET hora_logout = '"+HoraLogout+"' WHERE (ssid = '" + idlog + "')");         
           if(ponto){
               JOptionPane.showMessageDialog(this, "Hora de logout registrada.");
           }
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        dba.closeConnnection();
        this.setVisible(false);
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            new Menu(nomeUsuario, ramalUsuario).setVisible(true);            
        });
        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu mConfig1;
    private javax.swing.JMenu mSetores1;
    private javax.swing.JTextField menuInfo;
    private javax.swing.JMenuItem opVendas;
    private javax.swing.JMenuItem rVendas;
    private javax.swing.JMenu sys1;
    // End of variables declaration//GEN-END:variables

  
}