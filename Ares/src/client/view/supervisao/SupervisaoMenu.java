/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view.supervisao;


import auxiliar.RandomString;
import client.view.RelatorioVendas;
import client.view.VendasDependentes;
import controller.SipConnector;
import javax.swing.JOptionPane;
import data.*;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import client.view.adm.GraficoVendaCrivo;
import client.view.operacao.RankingVendas;
import java.io.IOException;
import org.jfree.ui.RefineryUtilities;
/**
 *
 * @author Alexandre Magalhães
 */
public class SupervisaoMenu extends javax.swing.JFrame {
    private DataBaseAcess dba;
    private APIAcess api;
    static private String nome;
    static private String ramal;
    private String dataLogin = ZonedDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    ZonedDateTime date = ZonedDateTime.now();
    private String dataDia = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    private String HoraLogin = date.format(DateTimeFormatter.ISO_LOCAL_TIME);
    private String idlog, c;
    private final RandomString session;
    /**
     * Creates new form SupervisaoMenu
     * @param nome
     * @param ramal
     */
    public SupervisaoMenu(String nome, String ramal) {
        this.nome = nome;
        this.ramal = ramal;
        try {
            api = APIAcess.getInstance();
            dba = DataBaseAcess.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(SupervisaoMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        session = new RandomString(8, ThreadLocalRandom.current());
        idlog  = session.toString().substring(session.toString().indexOf("@")+1);
        this.c = "";
        try {
            ResultSet rs = dba.execQry("SELECT autorizar FROM supervisao_controle");
            while(rs.next()){
                this.c = rs.getString("autorizar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupervisaoMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(c);
        initComponents();
        if(c.equalsIgnoreCase("N")){
            logC.setBackground(Color.red);
            logC.setText("Não Liberado");
        }else if(c.equalsIgnoreCase("S")){
            logC.setBackground(Color.green);
            logC.setText("Logout Liberado");
        }
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grafico = new javax.swing.JButton();
        menuInfo = new javax.swing.JTextField();
        rankBut = new javax.swing.JButton();
        logC = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MenuBar1 = new javax.swing.JMenuBar();
        mSetores1 = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        supPonto = new javax.swing.JMenu();
        supPA = new javax.swing.JMenuItem();
        gerarPonto = new javax.swing.JMenuItem();
        vendasControle = new javax.swing.JMenu();
        visualisarVendas = new javax.swing.JMenuItem();
        supDep = new javax.swing.JMenuItem();
        supVendas = new javax.swing.JMenuItem();
        rVendas = new javax.swing.JMenuItem();
        mConfig1 = new javax.swing.JMenu();
        sys1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ARES :: TELECONECTIVIDADE");
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

        grafico.setText("Gráfico Vendas x Crivos");
        grafico.setBorderPainted(false);
        grafico.setDoubleBuffered(true);
        grafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficoActionPerformed(evt);
            }
        });
        getContentPane().add(grafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 160, 30));

        menuInfo.setEditable(false);
        menuInfo.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(menuInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 259, 400, -1));

        rankBut.setText("Ranking PA's");
        rankBut.setBorderPainted(false);
        rankBut.setDoubleBuffered(true);
        rankBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankButActionPerformed(evt);
            }
        });
        getContentPane().add(rankBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 160, 30));

        logC.setBackground(new java.awt.Color(255, 0, 51));
        logC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logCActionPerformed(evt);
            }
        });
        getContentPane().add(logC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel2.setText("Clique para alterar o status de Logoff:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/resources/bg.jpg"))); // NOI18N
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mSetores1.setText("Supervisão");
        mSetores1.add(jSeparator2);

        supPonto.setText("Controle de Ponto");

        supPA.setText("PA's Logadas");
        supPA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supPAActionPerformed(evt);
            }
        });
        supPonto.add(supPA);

        gerarPonto.setText("Visualizar/Gerar Planilha de Ponto");
        gerarPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarPontoActionPerformed(evt);
            }
        });
        supPonto.add(gerarPonto);

        mSetores1.add(supPonto);

        vendasControle.setText("Controle de Vendas");

        visualisarVendas.setText("Visualizar/Exportar Vendas Lançadas");
        visualisarVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualisarVendasActionPerformed(evt);
            }
        });
        vendasControle.add(visualisarVendas);

        supDep.setText("Visualizar Dependentes");
        supDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supDepActionPerformed(evt);
            }
        });
        vendasControle.add(supDep);

        supVendas.setText("Vendas x Planos/Aproveitamento por Região");
        supVendas.setActionCommand("");
        supVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supVendasActionPerformed(evt);
            }
        });
        vendasControle.add(supVendas);

        mSetores1.add(vendasControle);

        rVendas.setText("Juntar Planilhas");
        rVendas.setEnabled(false);
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
    }// </editor-fold>//GEN-END:initComponents

    private void rVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rVendasActionPerformed
    
    }//GEN-LAST:event_rVendasActionPerformed

    private void sys1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sys1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_sys1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        menuInfo.setText(ramal+" : "+nome + " | Logado às: " + dataLogin);
        try {            
            boolean ponto = dba.execute("INSERT INTO controle_ponto (ssid, ramal, nome, data, hora_login) "
                    + "VALUES ('"+idlog+"', '"+ramal+"', '"+nome+"', '"+dataDia+"', '"+HoraLogin+"')"
            );            
            if(ponto){
               JOptionPane.showMessageDialog(this, "Hora de login registrada.\n"+HoraLogin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupervisaoMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        try {
           dba.execute("UPDATE usuario SET status = 1 WHERE ramal = '" + ramal + "'");
           ZonedDateTime logout = ZonedDateTime.now();
           String HoraLogout = logout.format(DateTimeFormatter.ISO_LOCAL_TIME);
           boolean ponto = dba.execute("UPDATE controle_ponto SET hora_logout = '"+HoraLogout+"' WHERE (ssid = '" + idlog + "')");         
           if(ponto){
               JOptionPane.showMessageDialog(this, "Hora de logout registrada.\n"+HoraLogout);
           }
        } catch (SQLException ex) {
            Logger.getLogger(SupervisaoMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dba.closeConnnection();
        SipConnector sip = new SipConnector();
        api.logout(ramal);
        sip.Logout();
        dba.closeConnnection();
        this.setVisible(false);
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void visualisarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualisarVendasActionPerformed
       // TODO add your handling code here:
       RelatorioVendas v = new RelatorioVendas();
       v.setVisible(true);        
    }//GEN-LAST:event_visualisarVendasActionPerformed

    private void supDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supDepActionPerformed
        // TODO add your handling code here:
        VendasDependentes v = new VendasDependentes();
        v.setVisible(true);
    }//GEN-LAST:event_supDepActionPerformed

    private void supVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supVendasActionPerformed
        // TODO add your handling code here:
        FaturamentoCrivoDia f = new FaturamentoCrivoDia();
        f.setVisible(true);
    }//GEN-LAST:event_supVendasActionPerformed

    private void supPAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supPAActionPerformed
        // TODO add your handling code here:
        PaLogadas v = new PaLogadas();
        v.setVisible(true);
    }//GEN-LAST:event_supPAActionPerformed

    private void gerarPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarPontoActionPerformed
        // TODO add your handling code here:
        PlanilhaPonto v = new PlanilhaPonto();        
        v.setVisible(true);
    }//GEN-LAST:event_gerarPontoActionPerformed

    private void logCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logCActionPerformed
        try {
            // TODO add your handling code here:
           ResultSet rs = dba.execQry("SELECT autorizar FROM supervisao_controle");
           while(rs.next()){
               c = rs.getString("autorizar");
           }
        } catch (SQLException ex) {
            Logger.getLogger(SupervisaoMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(c.equalsIgnoreCase("N")){
            try {
                dba.execute("UPDATE supervisao_controle SET autorizar = 'S'");
            } catch (SQLException ex) {
                Logger.getLogger(SupervisaoMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            logC.setBackground(Color.green);
            logC.setText("Login Liberado");
        }else if(c.equalsIgnoreCase("S")){
            try {
                dba.execute("UPDATE supervisao_controle SET autorizar = 'N'");
            } catch (SQLException ex) {
                Logger.getLogger(SupervisaoMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            logC.setBackground(Color.red);
            logC.setText("Não Liberado");
        }
    }//GEN-LAST:event_logCActionPerformed

    private void graficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficoActionPerformed
        // TODO add your handling code here:
        GraficoVendaCrivo v;
        ZonedDateTime times = ZonedDateTime.now();
        String hora = times.format(DateTimeFormatter.ISO_LOCAL_DATE);
        v = new GraficoVendaCrivo("ARES :: Teleconectividade", "Vendas x Crivo " + hora);
        //v.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        v.setUndecorated(true);
        v.pack();
        RefineryUtilities.centerFrameOnScreen( v );
        v.setVisible(true);
    }//GEN-LAST:event_graficoActionPerformed

    private void rankButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankButActionPerformed
        // TODO add your handling code here:
        RankingVendas v = new RankingVendas();
        v.setVisible(true);
    }//GEN-LAST:event_rankButActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SupervisaoMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupervisaoMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupervisaoMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupervisaoMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SupervisaoMenu(nome, ramal).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar1;
    private javax.swing.JMenuItem gerarPonto;
    private javax.swing.JButton grafico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToggleButton logC;
    private javax.swing.JMenu mConfig1;
    private javax.swing.JMenu mSetores1;
    private javax.swing.JTextField menuInfo;
    private javax.swing.JMenuItem rVendas;
    private javax.swing.JButton rankBut;
    private javax.swing.JMenuItem supDep;
    private javax.swing.JMenuItem supPA;
    private javax.swing.JMenu supPonto;
    private javax.swing.JMenuItem supVendas;
    private javax.swing.JMenu sys1;
    private javax.swing.JMenu vendasControle;
    private javax.swing.JMenuItem visualisarVendas;
    // End of variables declaration//GEN-END:variables
}
