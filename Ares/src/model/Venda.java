package model;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Venda {
    private int idvendas, idUsuarioOperador, idPlano, idCampanha;
    private ZonedDateTime dataVenda;
    private Cliente cliente;
    private Usuario usuarioOperador;
    private String nomePessoaAutorizada1, nomePessoaAutorizada2, 
            telefonePessoaAutorizada1, telefonePessoaAutorizada2, portabilidade, 
            portabilidade_ddd, protocoloOperadora, statusVenda, dataVencimento;
    private Endereco enderecoAlternativoDeEntrega;
    private boolean faturaEDigital;

    public Venda(int idPlano, ZonedDateTime dataVenda, Cliente cliente, Usuario usuarioOperador, 
            String nomePessoaAutorizada1, String nomePessoaAutorizada2, String telefonePessoaAutorizada1, 
            String telefonePessoaAutorizada2, String portabilidade, String portabilidade_ddd, 
            String protocoloOperadora, Endereco enderecoAlternativoDeEntrega, boolean faturaEDigital, String statusVenda, 
            String dataVencimento, int idCampanha) {
        this.idPlano = idPlano;
        this.idUsuarioOperador = usuarioOperador.getIdUsuario();
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.usuarioOperador = usuarioOperador;
        this.nomePessoaAutorizada1 = nomePessoaAutorizada1;
        this.nomePessoaAutorizada2 = nomePessoaAutorizada2;
        this.telefonePessoaAutorizada1 = telefonePessoaAutorizada1;
        this.telefonePessoaAutorizada2 = telefonePessoaAutorizada2;
        this.portabilidade = portabilidade;
        this.portabilidade_ddd = portabilidade_ddd;
        this.protocoloOperadora = protocoloOperadora;
        this.enderecoAlternativoDeEntrega = enderecoAlternativoDeEntrega;
        this.faturaEDigital = faturaEDigital;
        this.statusVenda = statusVenda;
        this.dataVencimento = dataVencimento;
        this.idCampanha = idCampanha;
    }

    public Venda(int idVenda, int idPlano, ZonedDateTime dataVenda, 
            Cliente cliente, Usuario usuarioOperador, String nomePessoaAutorizada1, 
            String telefonePessoaAutorizada1, String portabilidade, String portabilidade_ddd, 
            String protocoloOperadora, Endereco enderecoAlternativoDeEntrega, boolean faturaEDigital, String statusVenda,
            String dataVencimento, int idCampanha) {
        this.idvendas = idVenda;
        this.idUsuarioOperador = usuarioOperador.getIdUsuario();
        this.idPlano = idPlano;
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.usuarioOperador = usuarioOperador;
        this.nomePessoaAutorizada1 = nomePessoaAutorizada1;
        this.telefonePessoaAutorizada1 = telefonePessoaAutorizada1;
        this.portabilidade = portabilidade;
        this.portabilidade_ddd = portabilidade_ddd;
        this.protocoloOperadora = protocoloOperadora;
        this.enderecoAlternativoDeEntrega = enderecoAlternativoDeEntrega;
        this.faturaEDigital = faturaEDigital;
        this.statusVenda = statusVenda;
        this.dataVencimento = dataVencimento;
        this.idCampanha = idCampanha;
    }

    public Venda(int idVenda, int idPlano, ZonedDateTime dataVenda, Cliente cliente, Usuario usuarioOperador, 
            String portabilidade, String portabilidade_ddd, String protocoloOperadora, Endereco enderecoAlternativoDeEntrega, 
            boolean faturaEDigital, String statusVenda, String dataVencimento, int idCampanha) {
        this.idvendas = idVenda;
        this.idPlano = idPlano;
        this.idUsuarioOperador = usuarioOperador.getIdUsuario();
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.usuarioOperador = usuarioOperador;
        this.portabilidade = portabilidade;
        this.portabilidade_ddd = portabilidade_ddd;
        this.protocoloOperadora = protocoloOperadora;
        this.enderecoAlternativoDeEntrega = enderecoAlternativoDeEntrega;
        this.faturaEDigital = faturaEDigital;
        this.statusVenda = statusVenda;
        this.dataVencimento = dataVencimento;
        this.idCampanha = idCampanha;
    }

    public int getIdvendas() {
        return idvendas;
    }

    public int getIdUsuarioOperador() {
        return idUsuarioOperador;
    }

    public int getIdPlano() {
        return idPlano;
    }

    public ZonedDateTime getDataVenda() {
        return dataVenda;
    }
    
    public String getDataVendaString() {
        String data = this.dataVenda.format(DateTimeFormatter.ISO_LOCAL_DATE);
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Usuario getUsuarioOperador() {
        return usuarioOperador;
    }

    public String getNomePessoaAutorizada1() {
        return nomePessoaAutorizada1;
    }

    public String getNomePessoaAutorizada2() {
        return nomePessoaAutorizada2;
    }

    public String getTelefonePessoaAutorizada1() {
        return telefonePessoaAutorizada1;
    }

    public String getTelefonePessoaAutorizada2() {
        return telefonePessoaAutorizada2;
    }

    public String getPortabilidade() {
        return portabilidade;
    }

    public String getPortabilidade_ddd() {
        return portabilidade_ddd;
    }

    public String getProtocoloOperadora() {
        return protocoloOperadora;
    }

    public Endereco getEnderecoAlternativoDeEntrega() {
        return enderecoAlternativoDeEntrega;
    }

    public boolean isFaturaEDigital() {
        return faturaEDigital;
    }
    
    public int isFaturaEDigitalint() {
        if(faturaEDigital)
            return 1;
        return 0;
    }

    public void setIdvendas(int idvendas) {
        this.idvendas = idvendas;
    }

    public void setIdUsuarioOperador(int idUsuarioOperador) {
        this.idUsuarioOperador = idUsuarioOperador;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    public void setDataVenda(ZonedDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setUsuarioOperador(Usuario usuarioOperador) {
        this.usuarioOperador = usuarioOperador;
    }

    public void setNomePessoaAutorizada1(String nomePessoaAutorizada1) {
        this.nomePessoaAutorizada1 = nomePessoaAutorizada1;
    }

    public void setNomePessoaAutorizada2(String nomePessoaAutorizada2) {
        this.nomePessoaAutorizada2 = nomePessoaAutorizada2;
    }

    public void setTelefonePessoaAutorizada1(String telefonePessoaAutorizada1) {
        this.telefonePessoaAutorizada1 = telefonePessoaAutorizada1;
    }

    public void setTelefonePessoaAutorizada2(String telefonePessoaAutorizada2) {
        this.telefonePessoaAutorizada2 = telefonePessoaAutorizada2;
    }

    public void setPortabilidade(String portabilidade) {
        this.portabilidade = portabilidade;
    }

    public void setPortabilidade_ddd(String portabilidade_ddd) {
        this.portabilidade_ddd = portabilidade_ddd;
    }

    public void setProtocoloOperadora(String protocoloOperadora) {
        this.protocoloOperadora = protocoloOperadora;
    }

    public void setEnderecoAlternativoDeEntrega(Endereco enderecoAlternativoDeEntrega) {
        this.enderecoAlternativoDeEntrega = enderecoAlternativoDeEntrega;
    }

    public void setFaturaEDigital(boolean faturaEDigital) {
        this.faturaEDigital = faturaEDigital;
    }

    public String getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(String statusVenda) {
        this.statusVenda = statusVenda;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public int getIdCampanha() {
        return idCampanha;
    }

    public void setIdCampanha(int idCampanha) {
        this.idCampanha = idCampanha;
    }
    
    
}
