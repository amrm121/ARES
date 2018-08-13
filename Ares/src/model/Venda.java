package model;

public class Venda {
    private int pedido, score, qtdChips;
    private double valorPlano;
    private String nomeOperador, dataVenda, protocolo, regiaoVenda, plano, nomeCliente, 
            cpf, contato, dataNasc, nomeMae, cepEnd,  crivo, fidelizado,
            redeSociais, cidade, estado, nomeRua, nRua, complemento, bairro, cep, pontosRef,
            pAutorizadas, tipoBoleto, email, portabilidade, nPortabilidade, dataVenc, aceite;
    /*      "PEDIDO", "NOME OPERADOR", "DATA DA VENDA" ,"PROTOCOLO" , 
            "REGIÃO VENDA", "PLANO", 
            "NOME DO CLIENTE", "CPF", "CONTATO", 
            "DATA NASCIMENTO", "NOME DA MÃE", 
            "CEP DO ENDEREÇO", "SCORE", "CRIVO APROVADO?", 
            "FIDELIZADO 12 MESES?", "VALOR DO PLANO", 
            "REDE SOCIAIS", "CIDADE", "ESTADO",
            "NOME DA RUA / AV", "Nº", 
            "COMPLEMENTO", "BAIRRO", "CEP", "2 PONTOS DE REFERÊNCIA", 
            "NOME DE 2 PESSOAS AUTORIZADAS PARA RECEBER O CHIP", "CHIPS", 
            "TIPO DE CONTA (IMPRESSA OU ON LINE?)", 
            "E-MAIL", "PORTABILIDADE?", "Nº DA PORTABILIDADE COM DDD", 
            "DATA DE VENCIMENTO", "ACEITE"
            };*/    

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getQtdChips() {
        return qtdChips;
    }

    public void setQtdChips(int qtdChips) {
        this.qtdChips = qtdChips;
    }

    public double getValorPlano() {
        return valorPlano;
    }

    public void setValorPlano(double valorPlano) {
        this.valorPlano = valorPlano;
    }

    public String getNomeOperador() {
        return nomeOperador;
    }

    public void setNomeOperador(String nomeOperador) {
        this.nomeOperador = nomeOperador;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getRegiaoVenda() {
        return regiaoVenda;
    }

    public void setRegiaoVenda(String regiaoVenda) {
        this.regiaoVenda = regiaoVenda;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getCepEnd() {
        return cepEnd;
    }

    public void setCepEnd(String cepEnd) {
        this.cepEnd = cepEnd;
    }

    public String getCrivo() {
        return crivo;
    }

    public void setCrivo(String crivo) {
        this.crivo = crivo;
    }

    public String getFidelizado() {
        return fidelizado;
    }

    public void setFidelizado(String fidelizado) {
        this.fidelizado = fidelizado;
    }

    public String getRedeSociais() {
        return redeSociais;
    }

    public void setRedeSociais(String redeSociais) {
        this.redeSociais = redeSociais;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getnRua() {
        return nRua;
    }

    public void setnRua(String nRua) {
        this.nRua = nRua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPontosRef() {
        return pontosRef;
    }

    public void setPontosRef(String pontosRef) {
        this.pontosRef = pontosRef;
    }

    public String getpAutorizadas() {
        return pAutorizadas;
    }

    public void setpAutorizadas(String pAutorizadas) {
        this.pAutorizadas = pAutorizadas;
    }

    public String getTipoBoleto() {
        return tipoBoleto;
    }

    public void setTipoBoleto(String tipoBoleto) {
        this.tipoBoleto = tipoBoleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPortabilidade() {
        return portabilidade;
    }

    public void setPortabilidade(String portabilidade) {
        this.portabilidade = portabilidade;
    }

    public String getnPortabilidade() {
        return nPortabilidade;
    }

    public void setnPortabilidade(String nPortabilidade) {
        this.nPortabilidade = nPortabilidade;
    }

    public String getDataVenc() {
        return dataVenc;
    }

    public void setDataVenc(String dataVenc) {
        this.dataVenc = dataVenc;
    }

    public String getAceite() {
        return aceite;
    }

    public void setAceite(String aceite) {
        this.aceite = aceite;
    }
    

    /*@Override
    public String toString() {
        return "{" + "nomeOperador=" + nomeOperador + ", dataVenda=" + dataVenda + ", regiaoVenda=" + regiaoVenda + 
                ", planoEscolhido=" + planoEscolhido + ", nomeCliente=" + nomeCliente + ", cpfCliente=" + cpfCliente + 
                ", telefone1Cliente=" + telefone1Cliente + ", telefone2Cliente=" + telefone2Cliente + ", dataNascCliente=" + 
                dataNascCliente + ", nomeMaeCliente=" + nomeMaeCliente + ", cepCliente=" + cepCliente + ", cidadeCliente=" + 
                cidadeCliente + ", estadoCliente=" + estadoCliente + ", logradouroCliente=" + logradouroCliente + ", numeroCliente=" + 
                numeroCliente + ", complementoCliente=" + complementoCliente + ", bairroCliente=" + bairroCliente + ", pontoReferencia1=" + 
                pontoReferencia1 + ", pontoReferencia2=" + pontoReferencia2 + ", nomePessoaAutorizada1=" + nomePessoaAutorizada1 + ", "
                + "nomePessoaAutorizada2=" + nomePessoaAutorizada2 + ", telefonePessoaAutorizada1=" + telefonePessoaAutorizada1 + ", "
                + "telefonePessoaAutorizada2=" + telefonePessoaAutorizada2 + ", email=" + email + ", portabilidadeDDD=" 
                + portabilidadeDDD + ", dataVencimento=" + dataVencimento + ", cepAlternativo=" + cepAlternativo + ", estadoAlternativo=" 
                + estadoAlternativo + ", cidadeAlternativa=" + cidadeAlternativa + ", bairroAlternativo=" + bairroAlternativo + 
                ", logradouroAlternativo=" + logradouroAlternativo + ", numeroAlternativo=" + numeroAlternativo + ", complementoAlternativo=" 
                + complementoAlternativo + ", entregaAlternativa=" + entregaAlternativa + ", optouPortabilidade=" + optouPortabilidade + 
                ", aceitoCrivo=" + aceitoCrivo + ", fidelizadaAno=" + fidelizadaAno + ", optouAppsDataFree=" + optouAppsDataFree + 
                ", boletoDigital=" + boletoDigital + ", vendaAceitaCliente=" + vendaAceitaCliente + ", qtdChipsEnviar=" + qtdChipsEnviar + '}';
    }*/

    @Override
    public String toString() {
        return "pedido=" + pedido + ", score=" + score + ", qtdChips=" + qtdChips + ", valorPlano=" + valorPlano + ", nomeOperador=" + nomeOperador + ", dataVenda=" + dataVenda + ", protocolo=" + protocolo + ", regiaoVenda=" + regiaoVenda + ", plano=" + plano + ", nomeCliente=" + nomeCliente + ", cpf=" + cpf + ", contato=" + contato + ", dataNasc=" + dataNasc + ", nomeMae=" + nomeMae + ", cepEnd=" + cepEnd + ", crivo=" + crivo + ", fidelizado=" + fidelizado + ", redeSociais=" + redeSociais + ", cidade=" + cidade + ", estado=" + estado + ", nomeRua=" + nomeRua + ", nRua=" + nRua + ", complemento=" + complemento + ", bairro=" + bairro + ", cep=" + cep + ", pontosRef=" + pontosRef + ", pAutorizadas=" + pAutorizadas + ", tipoBoleto=" + tipoBoleto + ", email=" + email + ", portabilidade=" + portabilidade + ", nPortabilidade=" + nPortabilidade + ", dataVenc=" + dataVenc + ", aceite=" + aceite;
    }

    public Venda(int pedido, int score, int qtdChips, double valorPlano, String nomeOperador, String dataVenda, String protocolo, String regiaoVenda, String plano, String nomeCliente, String cpf, String contato, String dataNasc, String nomeMae, String cepEnd, String crivo, String fidelizado, String redeSociais, String cidade, String estado, String nomeRua, String nRua, String complemento, String bairro, String cep, String pontosRef, String pAutorizadas, String tipoBoleto, String email, String portabilidade, String nPortabilidade, String dataVenc, String aceite) {
        this.pedido = pedido;
        this.score = score;
        this.qtdChips = qtdChips;
        this.valorPlano = valorPlano;
        this.nomeOperador = nomeOperador;
        this.dataVenda = dataVenda;
        this.protocolo = protocolo;
        this.regiaoVenda = regiaoVenda;
        this.plano = plano;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.contato = contato;
        this.dataNasc = dataNasc;
        this.nomeMae = nomeMae;
        this.cepEnd = cepEnd;
        this.crivo = crivo;
        this.fidelizado = fidelizado;
        this.redeSociais = redeSociais;
        this.cidade = cidade;
        this.estado = estado;
        this.nomeRua = nomeRua;
        this.nRua = nRua;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.pontosRef = pontosRef;
        this.pAutorizadas = pAutorizadas;
        this.tipoBoleto = tipoBoleto;
        this.email = email;
        this.portabilidade = portabilidade;
        this.nPortabilidade = nPortabilidade;
        this.dataVenc = dataVenc;
        this.aceite = aceite;
    }
    
    
    
        
        
}
