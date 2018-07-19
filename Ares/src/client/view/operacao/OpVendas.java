/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view.operacao;

import client.view.*;
import au.com.bytecode.opencsv.CSVWriter;
import data.DataBaseAcess;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import model.Venda;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author suporteti
 */
public class OpVendas extends javax.swing.JFrame {
   DataBaseAcess dba;
   private static String ramal;
   
    public OpVendas(String ramal) {
        this.ramal = ramal;
        initComponents();
       try {
           dba = DataBaseAcess.getInstance();
       } catch (SQLException ex) {
           Logger.getLogger(OpVendas.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        attVendas = new javax.swing.JButton();
        exportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ARES :: TELECONECTIVIDADE");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setAutoscrolls(false);
        jTable1.setIntercellSpacing(new java.awt.Dimension(1, 0));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        attVendas.setText("Atualizar");
        attVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attVendasActionPerformed(evt);
            }
        });

        exportar.setText("Exportar para Planilha");
        exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(attVendas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportar)
                        .addGap(211, 211, 211)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(attVendas)
                    .addComponent(exportar))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void showVendas(){
        String qry = "SELECT * FROM vendas WHERE ramal ='"+ ramal+"'";
       List<Venda> vendas = new ArrayList<>();
       try {
           ResultSet rs = dba.execQry(qry);           
           while(rs.next()) {
               Venda v = new Venda(rs.getString("nomeOperador"), rs.getString("dataVenda"), rs.getString("regiaoVenda"), 
                     rs.getString("planoEscolhido"), rs.getString("nomeCliente"), rs.getString("cpfCliente"), rs.getString("telefone1Cliente"), 
                     rs.getString("telefone2Cliente"), rs.getString("dataNascCliente"), rs.getString("nomeMaeCliente"), rs.getString("statusCrivo"), 
                     rs.getInt("fidelizadaAno"), rs.getInt("optouAppsDataFree"), rs.getString("cepCliente"), rs.getString("cidadeCliente"), 
                     rs.getString("estadoCliente"), rs.getString("logradouroCliente"), rs.getString("numeroCliente"), rs.getString("complementoCliente"), 
                     rs.getString("bairroCliente"), rs.getString("pontoReferencia1"), rs.getString("pontoReferencia2"), rs.getString("nomePessoaAutorizada1"), 
                     rs.getString("nomePessoaAutorizada2"), rs.getString("telefonePessoaAutorizada1"), rs.getString("telefonePessoaAutorizada2"), 
                     rs.getInt("quantidadeChipsAEnviar"), rs.getInt("boletoDigital"), rs.getString("email"), rs.getInt("optouPortabilidade"), 
                     rs.getString("portabilidadeDDD"), rs.getString("dataVencimento"), rs.getInt("aceite"), rs.getString("cepAlternativo"), 
                     rs.getString("estadoAlternativo"), rs.getString("cidadeAlternativa"), rs.getString("bairroAlternativo"), 
                     rs.getString("logradouroAlternativo"), rs.getString("numeroAlternativo"), rs.getString("complementoAlternativo"), rs.getInt("enderecoAlternativo"));
               vendas.add(v); 
           }
       } catch (SQLException ex) {
           Logger.getLogger(OpVendas.class.getName()).log(Level.SEVERE, null, ex);  
       }
       String[] columns = new String [] {
                "idVenda", "Nome do operador", "Ramal" ,"Data da venda", "Região da venda", "Plano escolhido", 
            "Nome", "CPF", "Telefone 1", "Telefone 2", "Data de nascimento", "Nome da mãe", "Status do Crivo", 
           "Fidelização Ano", "Optou redes sociais", "CEP", "Cidade", "Estado", "Logradouro", "Numero", "Complemento", 
           "Bairro", "Ponto de referência 1", "Ponto de referência 2", "Nome pessoa autorizada 1", 
           "Nome pessoa autorizada 2", "Telefone pessoa autorizada 1", "Telefone pessoa autorizada 2", 
           "Quantidade chips", "Boleto Digital", "Email", "Optou portabilidade", "DDD da portabilidadel", 
           "Data de vencimento", "Estado da venda", "CEP (Alternativo)", "Estado (Alternativo)", 
           "Cidade (Alternativa)", "Bairro (Alternativo)", "Logradouro (Alternativo)", "Numero (Alternativo)", 
           "Complemento (Alternativo)", "Endereco de entrega alternativo"
            };
       
        String[] columnsDBNames = new String[] { //Array de apoio de nomes das colunas no banco
                    "idvendas", "ramal" ,"nomeOperador", "dataVenda", "regiaoVenda", 
                    "planoEscolhido", "nomeCliente", "cpfCliente", "telefone1Cliente",
                    "telefone2Cliente", "dataNascCliente", "nomeMaeCliente", "statusCrivo", 
                    "fidelizadaAno", "optouAppsDataFree", "cepCliente", "cidadeCliente", 
                    "estadoCliente", "logradouroCliente", "numeroCliente", "complementoCliente", 
                    "bairroCliente", "pontoReferencia1", "pontoReferencia2", "nomePessoaAutorizada1", 
                    "nomePessoaAutorizada2", "telefonePessoaAutorizada1", "telefonePessoaAutorizada2", 
                    "quantidadeChipsAEnviar", "boletoDigital", "email", "optouPortabilidade", 
                    "portabilidadeDDD", "dataVencimento", "aceite", "cepAlternativo", 
                    "estadoAlternativo", "cidadeAlternativa", "bairroAlternativo", 
                    "logradouroAlternativo", "numeroAlternativo", "complementoAlternativo", "enderecoAlternativo"
           };
        
        
        //System.out.println(columns.length + "   " + columnsDBNames.length);
       
       
       try {
           ResultSet rs = dba.execQry(qry);
           
           Object[][] rows = new Object[vendas.size()][44];
           
            for(int i = 0 ; rs.next() ; i++) {
                   for(int j = 1 ; j <= 43 ; j++) {
                       if(j == 29 || j == 30 || j == 32 || j == 35 || j == 43)
                            rows[i][j-1] = (Integer) rs.getInt(j);
                        else
                            rows[i][j-1] = rs.getString(j);
                    }
           }
            
        DefaultTableModel tableModel = new DefaultTableModel(rows, columns);
        jTable1.setModel(tableModel);
                    
       } catch (SQLException ex) {
           Logger.getLogger(OpVendas.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       showVendas();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void attVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attVendasActionPerformed
        // TODO add your handling code here:
       showVendas();
    }//GEN-LAST:event_attVendasActionPerformed

    private void exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarActionPerformed
        JFileChooser fileC = new JFileChooser();
        int status = fileC.showSaveDialog(this);
        File ff;
        if(status == JFileChooser.APPROVE_OPTION){
            try {
                String qry = "SELECT * FROM vendas WHERE ramal ='"+ ramal+"'";
                ResultSet rs = dba.execQry(qry);
                ff = fileC.getSelectedFile();
                String fn = ff.getCanonicalPath();
                CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(fn+".csv"), "UTF-16"));
                writer.writeAll(rs, true);
                writer.close();
                //ff = new File(fn+".csv");
                //e.toExcel(jTable1, ff);
            } catch (IOException ex) {
                Logger.getLogger(OpVendas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(OpVendas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_exportarActionPerformed

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
            java.util.logging.Logger.getLogger(OpVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new OpVendas(ramal).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attVendas;
    private javax.swing.JButton exportar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
