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
public class VendaDependente {
    private int idvenda;
    private String plano, numero, portabilidade, email, tipo;

    public int getIdvenda() {
        return idvenda;
    }

    public VendaDependente(int idvenda, String plano, String numero, String portabilidade, String email, String tipo) {
        this.idvenda = idvenda;
        this.plano = plano;
        this.numero = numero;
        this.portabilidade = portabilidade;
        this.email = email;
        this.tipo = tipo;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPortabilidade() {
        return portabilidade;
    }

    public void setPortabilidade(String portabilidade) {
        this.portabilidade = portabilidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
