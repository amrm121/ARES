package data;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseAcess {
    private static DataBaseAcess instance;
    private Connection con = null;
    private Statement stm = null;
    private final String url, usr, pswd;
    
    private DataBaseAcess() throws SQLException {
        this.url = "jdbc:mysql://10.81.32.11:3306/teleconectividade?useTimezone=true&serverTimezone=UTC";
        this.pswd = "masterkey";
        this.usr = "root";
        this.con = DriverManager.getConnection(url, usr, pswd);
        this.stm = con.createStatement();    
    }
    
    public ResultSet execQry(String qry) throws SQLException{       
        ResultSet rs = stm.executeQuery(qry);    
        return rs;
    }
    
    public boolean execute(String qry) throws SQLException{
        boolean ok;        
        ok = stm.execute(qry); 
        return !ok;
    }
    
    public static DataBaseAcess getInstance() throws SQLException {
        if(instance == null)
            instance = new DataBaseAcess();
        
        return instance;
    }
    
    public void closeConnnection(){
        if(instance != null){
            try {
                if(!stm.isClosed()){
                    stm.close();
                }
                if(!con.isClosed()){
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseAcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
