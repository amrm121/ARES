package client.view.adm;

import data.DataBaseAcess;
import java.awt.ComponentOrientation;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GraficoVendaCrivo extends ApplicationFrame{
	private DataBaseAcess dba;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
        public GraficoVendaCrivo( String applicationTitle , String chartTitle ) {
        super( applicationTitle );        
        
        JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Planos",            
         "Crivos x Bruto",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
        
        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setDisplayToolTips(true);
        chartPanel.setVerticalAxisTrace(true);
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) ); 
        JButton a = new JButton("Voltar");
       
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a(evt, chartPanel);
            }
        });
        //chartPanel.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        
        chartPanel.add(a);
        //setContentPane(setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE));
        chartPanel.validate();
        setContentPane( chartPanel ); 
       }
        private void a(java.awt.event.ActionEvent evt, ChartPanel az) {
            az.setVisible(false);
            this.dispose();
        }
        private CategoryDataset createDataset(){
            try {
                dba = DataBaseAcess.getInstance();
            } catch (SQLException ex) {
                Logger.getLogger(GraficoVendaCrivo.class.getName()).log(Level.SEVERE, null, ex);
            }
            ZonedDateTime logout = ZonedDateTime.now();
            logout.format(DateTimeFormatter.ISO_LOCAL_DATE);
            String qry = "SELECT planoEscolhido, optouAppsDataFree, quantidadeChipsAEnviar, statusCrivo FROM vendas WHERE dataVenda = '"+logout+"'";
            String qry1 = "SELECT descricao FROM plano";
            ResultSet rs, rs1;
            ArrayList<String> pl = new ArrayList<>();
            HashMap<String, Integer> hmc = new HashMap<>();
            HashMap<String, Integer> hmb = new HashMap<>();
            try {
                rs1 = dba.execQry(qry1);
                while(rs1.next()){
                    pl.add(rs1.getString("descricao"));
                    hmc.put(rs1.getString("descricao"), 0);
                    hmb.put(rs1.getString("descricao"), 0);
                }
            } catch (SQLException ex) {
                Logger.getLogger(GraficoVendaCrivo.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                
                rs = dba.execQry(qry);
               
                while(rs.next()){
                    String plano = rs.getString("planoEscolhido");
                    if(rs.getString("statusCrivo").equalsIgnoreCase("sim")){
                         hmc.replace(plano, hmc.get(plano)+1);
                         hmb.replace(plano, hmb.get(plano)+1);
                    }else{
                        hmb.replace(plano, hmb.get(plano)+1);
                    }
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(GraficoVendaCrivo.class.getName()).log(Level.SEVERE, null, ex);
            }            
                final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
                //final XYSeriesCollection data = new XYSeriesCollection(null);
                int tt = 0;
                int t1 = 0;
                for(String z: pl){
                    //for(int i = 0; i < hmb.size(); i++){
                        if(hmb.get(z) > 0){
                            int k = hmb.get(z);
                            dataset.addValue( k , z , "Brutos" ); 
                            tt+= k;
                           // System.out.println(tt + " k:" + k + z);
                        }
                    //}
                    //for(int i = 0; i < hmc.size(); i++){
                        if(hmc.get(z) > 0){
                            dataset.addValue( hmc.get(z) , z , "Crivos" ); 
                            t1+= (Integer)hmc.get(z);
                        }
                    //}
                }
                dataset.addValue(tt, "Total", "Total Bruto");
                dataset.addValue(t1, "Total", "Total Crivadas");
                
		String type = "Crivos x Vendas Total";
		
		
		return dataset;
	}
        public static void main( String[ ] args ) {
        GraficoVendaCrivo chart = new GraficoVendaCrivo("Car Usage Statistics", 
         "Which car do you like?");
         chart.pack( );        
        RefineryUtilities.centerFrameOnScreen( chart );        
        chart.setVisible( true ); 
        }
       

	/*public static void main(String[] args) throws FileNotFoundException, IOException {
            
	}*/

}
