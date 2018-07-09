package model;

public class Venda {
    private String nomeOperador, dataVenda, regiaoVenda, planoEscolhido, nomeCliente, cpfCliente, telefone1Cliente, 
            telefone2Cliente, dataNascCliente, 
                nomeMaeCliente, cepCliente, cidadeCliente, estadoCliente, logradouroCliente, numeroCliente, 
            complementoCliente, bairroCliente, 
                pontoReferencia1, pontoReferencia2, nomePessoaAutorizada1, nomePessoaAutorizada2, 
            telefonePessoaAutorizada1, telefonePessoaAutorizada2, 
                email, portabilidadeDDD, dataVencimento, cepAlternativo, estadoAlternativo, 
            cidadeAlternativa, bairroAlternativo, logradouroAlternativo, 
                numeroAlternativo, complementoAlternativo; 
    
        private int entregaAlternativa, optouPortabilidade, aceitoCrivo, fidelizadaAno, optouAppsDataFree, boletoDigital, 
            vendaAceitaCliente, qtdChipsEnviar;

    public Venda(String nomeOperador, String dataVenda, String regiaoVenda, String planoEscolhido, String nomeCliente, 
            String cpfCliente, String telefone1Cliente, String telefone2Cliente, String dataNascCliente, String nomeMaeCliente, int aceitoCrivo, 
            int fidelizadaAno, int optouAppsDataFree, String cepCliente, String cidadeCliente, String estadoCliente, String logradouroCliente, String numeroCliente, 
            String complementoCliente, String bairroCliente, String pontoReferencia1, String pontoReferencia2, 
            String nomePessoaAutorizada1, String nomePessoaAutorizada2, String telefonePessoaAutorizada1, String telefonePessoaAutorizada2, int qtdChipsEnviar, 
            int boletoDigital, String email, int optouPortabilidade, String portabilidadeDDD, String dataVencimento, int vendaAceitaCliente, String cepAlternativo, String estadoAlternativo, 
            String cidadeAlternativa, String bairroAlternativo, String logradouroAlternativo, String numeroAlternativo, 
            String complementoAlternativo, int entregaAlternativa) {
        this.nomeOperador = nomeOperador;
        this.dataVenda = dataVenda;
        this.regiaoVenda = regiaoVenda;
        this.planoEscolhido = planoEscolhido;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.telefone1Cliente = telefone1Cliente;
        this.telefone2Cliente = telefone2Cliente;
        this.dataNascCliente = dataNascCliente;
        this.nomeMaeCliente = nomeMaeCliente;
        this.cepCliente = cepCliente;
        this.cidadeCliente = cidadeCliente;
        this.estadoCliente = estadoCliente;
        this.logradouroCliente = logradouroCliente;
        this.numeroCliente = numeroCliente;
        this.complementoCliente = complementoCliente;
        this.bairroCliente = bairroCliente;
        this.pontoReferencia1 = pontoReferencia1;
        this.pontoReferencia2 = pontoReferencia2;
        this.nomePessoaAutorizada1 = nomePessoaAutorizada1;
        this.nomePessoaAutorizada2 = nomePessoaAutorizada2;
        this.telefonePessoaAutorizada1 = telefonePessoaAutorizada1;
        this.telefonePessoaAutorizada2 = telefonePessoaAutorizada2;
        this.email = email;
        this.portabilidadeDDD = portabilidadeDDD;
        this.dataVencimento = dataVencimento;
        this.cepAlternativo = cepAlternativo;
        this.estadoAlternativo = estadoAlternativo;
        this.cidadeAlternativa = cidadeAlternativa;
        this.bairroAlternativo = bairroAlternativo;
        this.logradouroAlternativo = logradouroAlternativo;
        this.numeroAlternativo = numeroAlternativo;
        this.complementoAlternativo = complementoAlternativo;
        this.entregaAlternativa = entregaAlternativa;
        this.optouPortabilidade = optouPortabilidade;
        this.aceitoCrivo = aceitoCrivo;
        this.fidelizadaAno = fidelizadaAno;
        this.optouAppsDataFree = optouAppsDataFree;
        this.boletoDigital = boletoDigital;
        this.vendaAceitaCliente = vendaAceitaCliente;
        this.qtdChipsEnviar = qtdChipsEnviar;
    }

    @Override
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
    }
    
    
    
        
        
}
