/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author Alexandre
 */
public class Operador {
    private String ramal, nome;
    private int status, tipo;

    public String getRamal() {
        return ramal;
    }

    public String getNome() {
        return nome;
    }

    public int getStatus() {
        return status;
    }

    public int getTipo() {
        return tipo;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
}
