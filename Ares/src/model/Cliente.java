    package model;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Cliente {
    private String nome, cpf, contato, nomeMae, email;
    private ZonedDateTime dataNasc;
    private Endereco endereco;
    private boolean statusCrivo;

    public Cliente(String nome, String cpf, String contato, String nomeMae, String email, ZonedDateTime dataNasc, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
        this.nomeMae = nomeMae;
        this.email = email;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ZonedDateTime getDataNasc() {
        return dataNasc;
    }
    
    public String getDataNascString() {
        String data;
        data = this.dataNasc.format(DateTimeFormatter.ISO_LOCAL_DATE);
        return data;
    }

    public void setDataNasc(ZonedDateTime dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isStatusCrivo() {
        return statusCrivo;
    }

    public void setStatusCrivo(boolean statusCrivo) {
        this.statusCrivo = statusCrivo;
    }
    
    public int isStatusCrivoint() {
        if(statusCrivo)
            return 1;
        return 0;
    }
}
