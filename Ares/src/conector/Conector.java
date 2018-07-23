/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alexandre
 */
public class Conector {
    private Statement stm;
    private Connection con;
    
    private Statement conectarMySql() throws ClassNotFoundException, SQLException {
        try {

            String driver = "com.mysql.jdbc.Driver";
            String dataBaseName = "teleconectividade?useTimezone=true&serverTimezone=UTC";
            String url = "jdbc:mysql://10.81.32.11:3306/";
            String usuario = "root";
            String senha = "masterkey";
            
            Class.forName(driver).newInstance();
            con = (Connection) DriverManager.getConnection(url + dataBaseName, usuario, senha);
            stm = con.createStatement();
            return stm;
        } catch (InstantiationException ex) {
            throw new SQLException(ex.getMessage());
        } catch (IllegalAccessException ex) {
            throw new SQLException(ex.getMessage());
        }
    }
    
    private Statement conectarPostGreSql() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String local = "10.81.32.50";
        String banco = "totalipdb";
        String usuario = "integracao";
        String senha = "";
        con = DriverManager.getConnection("jdbc:postgresql://"
                + local + "/" + banco
                + "?charSet=LATIN1", usuario,
                senha);
        //stmt = conn.createStatement();
        return con.createStatement();
        //return stmt;
    }
    
    public void desconectar() throws SQLException {
        con.close();
    }
    
    public Statement conectar() throws ClassNotFoundException, SQLException {
        return this.conectarMySql();
    }
    
    public Statement conectarP() throws ClassNotFoundException, SQLException {
        return this.conectarPostGreSql();
    }
}
