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