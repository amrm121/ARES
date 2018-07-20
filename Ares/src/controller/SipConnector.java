/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexandre
 */
public class SipConnector {
    private String ramal;
    private String senha;
    
    public SipConnector(String ramal, String senha){
        this.ramal = ramal;
        this.senha = senha;
    }
    
    public SipConnector(){

    }
    
    public void Login(){
            try {
                URI q = new URI("sip:-ramal="+this.ramal+"%20-senha="+this.senha);
                java.awt.Desktop.getDesktop().browse(q);
                
                
            } catch (URISyntaxException ex) {
                Logger.getLogger(SipConnector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SipConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void Logout(){
        try {
                URI q = new URI("sip:-fechar");
                java.awt.Desktop.getDesktop().browse(q);
            } catch (URISyntaxException ex) {
                Logger.getLogger(SipConnector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SipConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
