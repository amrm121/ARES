/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import au.com.bytecode.opencsv.CSVWriter;
import data.DataBaseAcess;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import model.Venda;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexandre Magalhães at amrm@cin.ufpe.br
 */
public class RelatorioVendas extends javax.swing.JFrame {
   DataBaseAcess dba;
   private List<Venda> vendas = new ArrayList<>();
    public RelatorioVendas() {
        initComponents();
       try {
           dba = DataBaseAcess.getInstance();
       } catch (SQLException ex) {
           Logger.getLogger(RelatorioVendas.class.getName()).log(Level.SEVERE, null, ex);
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

        voltarB = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        attVendas = new javax.swing.JButton();
        exportar = new javax.swing.JButton();
        vDia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ARES :: TELECONECTIVIDADE");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        voltarB.setText("Voltar");
        voltarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarBActionPerformed(evt);
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

        vDia.setText("Visualizar Vendas Dia");
        vDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vDiaActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(vDia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(voltarB))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voltarB)
                    .addComponent(attVendas)
                    .addComponent(exportar)
                    .addComponent(vDia))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void showVendas(){
        ZonedDateTime times = ZonedDateTime.now();
        String hora = times.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String qry = "SELECT * FROM vendas WHERE dataVenda = '"+hora+"'";
       
       HashMap<String, Double> planos = new HashMap<>();
       String qry2 = "SELECT * FROM protocolo";
       HashMap<Integer, String> pTable = new HashMap<>();
       String qry1 = "SELECT descricao, valor FROM plano";
       try {
           ResultSet rs = dba.execQry(qry2);
           while(rs.next()){
               if(rs.getString("protocolo") != null){
                   pTable.put(rs.getInt("idvendas"), rs.getString("protocolo"));
               }else{
                   pTable.put(rs.getInt("idvendas"), "");
               }
               
           }
           rs.close();
       } catch (SQLException ex) {
           Logger.getLogger(RelatorioVendas.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
           ResultSet rs = dba.execQry(qry1);
           while(rs.next()){
               planos.put(rs.getString("descricao"), rs.getDouble("valor"));
           }
           rs.close();
       } catch (SQLException ex) {
           Logger.getLogger(RelatorioVendas.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
           ResultSet rs = dba.execQry(qry);
           System.out.println(rs.first());
           while(rs.next()) {
            /*private int pedido, score, qtdChips;
            private double valorPlano;
            private String nomeOperador, dataVenda, protocolo, regiaoVenda, plano, nomeCliente, 
            cpf, contato, dataNasc, nomeMae, cepEnd,  crivo, fidelizado,
            redeSociais, cidade, estado, nomeRua, nRua, complemento, bairro, cep, pontosRef,
            pAutorizadas, tipoBoleto, email, portabilidade, nPortabilidade, dataVenc, aceite;*/
            double prz =  planos.get(rs.getString("planoEscolhido"));
            DecimalFormat df = new DecimalFormat(".##");
               Venda v = new Venda(rs.getInt("idVendas"), rs.getInt("score"), 
                rs.getInt("quantidadeChipsAEnviar"), Double.parseDouble(df.format(prz)) , rs.getString("nomeOperador"),
                rs.getString("dataVenda"), pTable.get(rs.getInt("idVendas")), rs.getString("regiaoVenda"), rs.getString("planoEscolhido"), 
                rs.getString("nomeCliente"), rs.getString("cpfCliente"), rs.getString("telefone1Cliente")+", "+rs.getString("telefone2Cliente"), 
                rs.getString("dataNascCliente"), rs.getString("nomeMaeCliente"), rs.getString("cepCliente"), rs.getString("statusCrivo"), rs.getString("fidelizadaAno"),
                rs.getString("optouAppsDataFree"), rs.getString("cidadeCliente"), rs.getString("estadoCliente"), rs.getString("logradouroCliente"),
                rs.getString("numeroCliente"), rs.getString("complementoCliente"), rs.getString("bairroCliente"), rs.getString("cepCliente"),
                rs.getString("pontoReferencia1") + ", "+rs.getString("pontoReferencia2"), rs.getString("nomePessoaAutorizada1") +", "+rs.getString("nomePessoaAutorizada2"),
                rs.getString("boletoDigital"), rs.getString("email"), rs.getString("optouPortabilidade"), rs.getString("PortabilidadeDDD"), rs.getString("dataVencimento"), rs.getString("aceite"));
               vendas.add(v);
           }
       } catch (SQLException ex) {
           Logger.getLogger(RelatorioVendas.class.getName()).log(Level.SEVERE, null, ex);  
       }
       String[] columns = new String [] {
                "PEDIDO", "NOME OPERADOR", "DATA DA VENDA" ,"PROTOCOLO", "REGIÃO VENDA", "PLANO", 
           "NOME DO CLIENTE", "CPF", "CONTATO", 
            "DATA NASCIMENTO", "NOME DA MÃE", "CEP DO ENDEREÇO", "SCORE", "CRIVO APROVADO?", "FIDELIZADO 12 MESES?", "VALOR DO PLANO", 
            "REDE SOCIAIS", "CIDADE", "ESTADO",
            "NOME DA RUA / AV", "Nº", 
           "COMPLEMENTO", "BAIRRO", "CEP", "2 PONTOS DE REFERÊNCIA", 
           "NOME DE 2 PESSOAS AUTORIZADAS PARA RECEBER O CHIP", "CHIPS", "TIPO DE CONTA (IMPRESSA OU ON LINE?)", 
           "E-MAIL", "PORTABILIDADE?", "Nº DA PORTABILIDADE COM DDD", "DATA DE VENCIMENTO", "ACEITE"
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
        
        
        System.out.println(columns.length + "   " + columnsDBNames.length + " " + vendas.size());
        /*if(j == 29){//35 aceite 32 portabilidade 30 boleto/email fatura 29 qtdchips
                       rows[i][j-1] = (Integer) rs.getInt(j);
                       }
                       else if(j == 30){
                       int a = (Integer) rs.getInt(j);
                       if(a == 1) rows[i][j-1] = "DIGITAL";
                       else rows[i][j-1] = "BOLETO";
                       }
                       else if(j == 32 || j == 35 || j == 43){
                       int a = (Integer) rs.getInt(j);
                       if(a == 1) rows[i][j-1] = "SIM";
                       else rows[i][j-1] = "NAO";
                       }
                       else{
                       rows[i][j-1] = rs.getString(j);
                       }*/  
       
       try {
           ResultSet rs = dba.execQry(qry);
           
           Object[][] rows = new Object[vendas.size()][columns.length];
           
            for(int i = 0 ; i < vendas.size() ; i++) {
                   for(int j = 1 ; j <= columns.length ; j++) {
                       switch (j) {
                           case 1:
                               rows[i][j-1] = vendas.get(i).getPedido();
                               break;
                           case 2:
                               rows[i][j-1] = vendas.get(i).getNomeOperador();
                               break;
                           case 3:
                               rows[i][j-1] = vendas.get(i).getDataVenda();
                               break;
                           case 4:
                               rows[i][j-1] = vendas.get(i).getProtocolo();
                               break;
                           case 5:
                               rows[i][j-1] = vendas.get(i).getRegiaoVenda();
                               break;
                           case 6:
                               rows[i][j-1] = vendas.get(i).getPlano();
                               break;
                           case 7:
                               rows[i][j-1] = vendas.get(i).getNomeCliente();
                               break;
                           case 8:
                               rows[i][j-1] = vendas.get(i).getCpf();
                               break;
                           case 9:
                               rows[i][j-1] = vendas.get(i).getContato();
                               break;
                           case 10:
                               rows[i][j-1] = vendas.get(i).getDataNasc();
                               break;
                           case 11:
                               rows[i][j-1] = vendas.get(i).getNomeMae();
                               break;
                           case 12:
                               rows[i][j-1] = vendas.get(i).getCepEnd();
                               break;
                           case 13:
                               rows[i][j-1] = vendas.get(i).getScore();
                               break;
                           case 14:
                               rows[i][j-1] = vendas.get(i).getCrivo();
                               break;
                           case 15:
                               rows[i][j-1] = vendas.get(i).getFidelizado();
                               break;
                           case 16:
                               rows[i][j-1] = vendas.get(i).getValorPlano();
                               break;
                           case 17:
                               rows[i][j-1] = vendas.get(i).getRedeSociais();
                               break;
                           case 18:
                               rows[i][j-1] = vendas.get(i).getCidade();
                               break;
                           case 19:
                               rows[i][j-1] = vendas.get(i).getEstado();
                               break;
                           case 20:
                               rows[i][j-1] = vendas.get(i).getNomeRua();
                               break;
                           case 21:
                               rows[i][j-1] = vendas.get(i).getnRua();
                               break;
                           case 22:
                               rows[i][j-1] = vendas.get(i).getComplemento();
                               break;
                           case 23:
                               rows[i][j-1] = vendas.get(i).getBairro();
                               break;
                           case 24:
                               rows[i][j-1] = vendas.get(i).getCepEnd();
                               break;
                           case 25:
                               rows[i][j-1] = vendas.get(i).getPontosRef();
                               break;
                           case 26:
                               rows[i][j-1] = vendas.get(i).getpAutorizadas();
                               break;
                           case 27:
                               rows[i][j-1] = vendas.get(i).getQtdChips();
                               break;
                           case 28:
                               rows[i][j-1] = vendas.get(i).getTipoBoleto();
                               break;
                           case 29:
                               rows[i][j-1] = vendas.get(i).getEmail();
                               break;
                           case 30:
                               rows[i][j-1] = vendas.get(i).getPortabilidade();
                               break;
                           case 31:
                               rows[i][j-1] = vendas.get(i).getnPortabilidade();
                               break;
                           case 32:
                               rows[i][j-1] = vendas.get(i).getDataVenc();
                               break;
                           case 33:
                              rows[i][j-1] = vendas.get(i).getAceite();
                              break;
                       }
                       
                    }
           }
            
        DefaultTableModel tableModel = new DefaultTableModel(rows, columns);
        jTable1.setModel(tableModel);
                    
       } catch (SQLException ex) {
           Logger.getLogger(RelatorioVendas.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       showVendas();
    }//GEN-LAST:event_formWindowOpened

    private void voltarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarBActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_voltarBActionPerformed

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
            String[] columns = new String [] {
            "PEDIDO", "NOME OPERADOR", "DATA DA VENDA" ,"PROTOCOLO", "REGIÃO VENDA", "PLANO", 
           "NOME DO CLIENTE", "CPF", "CONTATO", 
            "DATA NASCIMENTO", "NOME DA MÃE", "CEP DO ENDEREÇO", "SCORE", "CRIVO APROVADO?", "FIDELIZADO 12 MESES?", "VALOR DO PLANO", 
            "REDE SOCIAIS", "CIDADE", "ESTADO",
            "NOME DA RUA / AV", "Nº", 
           "COMPLEMENTO", "BAIRRO", "CEP", "2 PONTOS DE REFERÊNCIA", 
           "NOME DE 2 PESSOAS AUTORIZADAS PARA RECEBER O CHIP", "CHIPS", "TIPO DE CONTA (IMPRESSA OU ON LINE?)", 
           "E-MAIL", "PORTABILIDADE?", "Nº DA PORTABILIDADE COM DDD", "DATA DE VENCIMENTO", "ACEITE"
            };
                String qry = "SELECT * FROM vendas";
                ResultSet rs = dba.execQry(qry);
                ff = fileC.getSelectedFile();
                
                String fn = ff.getCanonicalPath();
                CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(fn+".csv"), "UTF-16"));
                String[] headers = new String[33];
                String[] rows = new String[33];
                List<String[]> ss = new ArrayList<>();
                
                for(int i = 0; i < 33; i++){
                    headers[i] = jTable1.getColumnName(i);
                    //System.out.println(jTable1.getColumnName(i-1));
                    
                   // writer.writeNext("\""+jTable1.getColumnName(i-1)+"\"");
                    /*for(int j = 1; j <= 33; j++){
                        //System.out.println(jTable1.getValueAt(j, i-1).toString());
                        if(jTable1.getValueAt(j, i-1) != null)
                            writer.writeNext(jTable1.getValueAt(j, i-1).toString()+",");
                    }*/
                   // writer.writeNext("\n");
                    //writer.flush();
                }
                ss.add(headers);
                for(int i = 0 ; i < vendas.size() ; i++) {
                   for(int j = 1 ; j <= columns.length ; j++) {
                       switch (j) {
                           case 1:
                               rows[j-1] = vendas.get(i).getPedido()+"";
                               break;
                           case 2:
                               rows[j-1] = vendas.get(i).getNomeOperador()+"";
                               break;
                           case 3:
                               rows[j-1] = vendas.get(i).getDataVenda();
                               break;
                           case 4:
                               rows[j-1] = vendas.get(i).getProtocolo();
                               break;
                           case 5:
                               rows[j-1] = vendas.get(i).getRegiaoVenda();
                               break;
                           case 6:
                               rows[j-1] = vendas.get(i).getPlano();
                               break;
                           case 7:
                               rows[j-1] = vendas.get(i).getNomeCliente();
                               break;
                           case 8:
                               rows[j-1] = vendas.get(i).getCpf();
                               break;
                           case 9:
                               rows[j-1] = vendas.get(i).getContato();
                               break;
                           case 10:
                               rows[j-1] = vendas.get(i).getDataNasc();
                               break;
                           case 11:
                               rows[j-1] = vendas.get(i).getNomeMae();
                               break;
                           case 12:
                               rows[j-1] = vendas.get(i).getCepEnd();
                               break;
                           case 13:
                               rows[j-1] = vendas.get(i).getScore()+"";
                               break;
                           case 14:
                               rows[j-1] = vendas.get(i).getCrivo();
                               break;
                           case 15:
                               rows[j-1] = vendas.get(i).getFidelizado();
                               break;
                           case 16:
                               rows[j-1] = vendas.get(i).getValorPlano()+"";
                               break;
                           case 17:
                               rows[j-1] = vendas.get(i).getRedeSociais();
                               break;
                           case 18:
                               rows[j-1] = vendas.get(i).getCidade();
                               break;
                           case 19:
                               rows[j-1] = vendas.get(i).getEstado();
                               break;
                           case 20:
                               rows[j-1] = vendas.get(i).getNomeRua();
                               break;
                           case 21:
                               rows[j-1] = vendas.get(i).getnRua();
                               break;
                           case 22:
                               rows[j-1] = vendas.get(i).getComplemento();
                               break;
                           case 23:
                               rows[j-1] = vendas.get(i).getBairro();
                               break;
                           case 24:
                               rows[j-1] = vendas.get(i).getCepEnd();
                               break;
                           case 25:
                               rows[j-1] = vendas.get(i).getPontosRef();
                               break;
                           case 26:
                               rows[j-1] = vendas.get(i).getpAutorizadas();
                               break;
                           case 27:
                               rows[j-1] = vendas.get(i).getQtdChips()+"";
                               break;
                           case 28:
                               rows[j-1] = vendas.get(i).getTipoBoleto();
                               break;
                           case 29:
                               rows[j-1] = vendas.get(i).getEmail();
                               break;
                           case 30:
                               rows[j-1] = vendas.get(i).getPortabilidade();
                               break;
                           case 31:
                               rows[j-1] = vendas.get(i).getnPortabilidade();
                               break;
                           case 32:
                               rows[j-1] = vendas.get(i).getDataVenc();
                               break;
                           case 33:
                              rows[j-1] = vendas.get(i).getAceite();
                              break;
                       }
                       
                    }
                   ss.add(rows);
                   rows = new String[33];
           }

                writer.writeAll(ss);
                ff = new File(fn+".csv");
                writer.close();
                //e.toExcel(jTable1, ff);
            } catch (IOException | SQLException ex) {
                Logger.getLogger(RelatorioVendas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //recepcao.gcr@gmail.com
        
    }//GEN-LAST:event_exportarActionPerformed

    private void vDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vDiaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_vDiaActionPerformed

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
            java.util.logging.Logger.getLogger(RelatorioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RelatorioVendas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attVendas;
    private javax.swing.JButton exportar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton vDia;
    private javax.swing.JButton voltarB;
    // End of variables declaration//GEN-END:variables
}
