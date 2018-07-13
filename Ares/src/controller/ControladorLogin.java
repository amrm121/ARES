package controller;

import model.Usuario;
import data.DataBaseAcess;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorLogin {
    private static ControladorLogin instance;
    private DataBaseAcess dba;
    
    private ControladorLogin() throws SQLException {
        dba = DataBaseAcess.getInstance();
    }
    
    public static ControladorLogin getInstance() throws SQLException {
        if(instance == null)
            instance = new ControladorLogin();
        
        return instance;
    }
    
    public boolean getLogedIn(String ramal){
        boolean answ = false;
        try {            
            String qry = "SELECT status FROM usuario WHERE ramal = '"+ramal+"'";
            ResultSet rs = dba.execQry(qry);
            if(rs.next()){
                int st = rs.getInt("status");
                if(st == 2) answ = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answ;
    }
    
    public void logIn(String ramal){
         try {            
            String qry = "UPDATE usuario SET status = 2 WHERE ramal = "+ramal;
            dba.execute(qry);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getNomeID(String ramal){        
        String answ = "";
        String qry = "SELECT nome, idtipo_usuario FROM usuario WHERE ramal = '"+ramal+"'";
        ResultSet rs;
        try {
            rs = dba.execQry(qry);
        if(rs.next()){
            String nome = rs.getString("nome");
            int idt = rs.getInt("idtipo_usuario");
            answ = nome + ";" + idt;
        }else{answ = "ERRO";}
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answ;
    }
}