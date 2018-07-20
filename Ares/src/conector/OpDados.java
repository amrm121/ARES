/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conector;

import java.sql.Statement;
import model.Operador;

/**
 *
 * @author Alexandre
 */
public class OpDados extends Conector{
    
    public void logar(Operador a) throws Exception{

        //abrindo a conexão
        Statement conex = conectar();
        //instrução sql correspondente a inserção do aluno
        String qry = "UPDATE usuario SET status = 2 WHERE ramal = "+a.getRamal();
        //executando a instrução sql
        conex.execute(qry);
        //fechando a conexão com o banco de dados
        desconectar();

    }
    
}
