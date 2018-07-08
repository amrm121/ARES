package controller;

import model.Usuario;
import data.DataBaseAcess;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladorLogin {
    private Usuario usuario;
    private static ControladorLogin instance;
    private DataBaseAcess dba;
    
    private ControladorLogin() throws SQLException {
        dba = DataBaseAcess.getInstance();
        usuario = new Usuario();
    }
    
    public static ControladorLogin getInstance() throws SQLException {
        if(instance == null)
            instance = new ControladorLogin();
        
        return instance;
    }
    
    public boolean login(Usuario user) throws SQLException{        
        boolean answ = false;
        String ramal = user.getRamalLogin();
        String pass = user.getSenha();
        String qry = "SELECT nome, login, senha FROM usuario WHERE login = '"+ramal+"' AND senha = '"+pass+"'";
        ResultSet rs = dba.execQry(qry);
        if(rs.next()){
            usuario.setNome(rs.getString("nome"));
            answ = true;
        }
        return answ;
    }

    public String getName(){
        return usuario.getNome();
    }
    
    public Usuario getUsuarioCorrente() {
        return usuario;
    }
}