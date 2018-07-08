package model;

import data.DataBaseAcess;

public class Endereco {
    private String pais, uf, cidade, bairro, logradouro, cep, complemento, 
            ponto_ref1, ponto_ref2;
    private int numero;

    public Endereco(String cep) {
        this.cep = cep;
        this.pais = "Brasil";
    }

    public Endereco(String uf, String cidade, String bairro, String logradouro, int numero, String cep, String complemento) {
        this.pais = "Brasil";
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
    }

    public String getPais() {
        return pais;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) throws IllegalArgumentException {
        if(uf.length() > 2 || uf == null)
            throw new IllegalArgumentException("UF inválida");
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws IllegalArgumentException {
        if(!cidade.matches("[A-Za-z]+") || cidade == null)
            throw new IllegalArgumentException("Cidade inválida");
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws IllegalArgumentException {
        if(bairro == null || !bairro.matches("[A-Za-z]+"))
            throw new IllegalArgumentException("Bairro inválido");
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) throws IllegalArgumentException {
        if(logradouro == null)
            throw new IllegalArgumentException("Logradouro inválido");
           
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws IllegalArgumentException {
        if(numero <= 0)
            throw new IllegalArgumentException("Números negativos não são válidos");
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) throws IllegalArgumentException {
        if(cep == null || !cep.matches("[0-9]+"))
            throw new IllegalArgumentException("Cep inválido. Certifique-se de digitar apenas números");
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) throws IllegalArgumentException {
        if(complemento == null)
            throw new IllegalArgumentException();
        this.complemento = complemento;
    }

    public String getPonto_ref1() {
        return ponto_ref1;
    }

    public void setPonto_ref1(String ponto_ref1) {
        this.ponto_ref1 = ponto_ref1;
    }

    public String getPonto_ref2() {
        return ponto_ref2;
    }

    public void setPonto_ref2(String ponto_ref2) {
        this.ponto_ref2 = ponto_ref2;
    }
    
    
}
