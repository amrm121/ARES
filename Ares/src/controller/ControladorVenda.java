package controller;

import data.DataBaseAcess;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Endereco;
import model.Usuario;
import model.Venda;

public class ControladorVenda {
   private static DataBaseAcess dba;
   private static ControladorVenda instance;
   private static ControladorLogin controladorLogin;
   
   private ControladorVenda() {
       try {
           dba = DataBaseAcess.getInstance();
       } catch (SQLException ex) {
           Logger.getLogger(ControladorVenda.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public static ControladorVenda getInstance() {
       if(instance == null)
           instance = new ControladorVenda();
       
       return instance;
   }
   public void enviarVendaParaDB(Venda venda) {
       String qryVenda;
       qryVenda = "INSERT INTO `teleconectividade`.`vendas` (`idusuario`, `data_venda`, `idplano`, `cliente`, `cpf`, "
               + "`contato`, `datanasc`, `nome_mae`, `cep_endereco`, `endereco`, `numero`, `bairro`, `cidade`, "
               + "`complemento`, `ponto_ref1`, `ponto_ref2`, `pessoa_autorizada1`, `pessoa_autorizada2`, "
               + "`telefonepessoaautorizada1`, `telefonepessoaautorizada2`, `idtipo_conta`, `email`, `portabilidade`, "
               + "`portabilidade_ddd`, `data_vencimento`, `idcampanha`, `idstatus_crivo`, `status_venda`, "
               + "`contadigital`, `protocolo`) VALUES ('"+controladorLogin.getUsuarioCorrente().getIdUsuario()+"', "
               + "'"+venda.getDataVendaString()+"', "
               + "'"+venda.getIdPlano()+"', '"+venda.getCliente().getNome()+"', '"+venda.getCliente().getCpf()+"', "
               + "'"+venda.getCliente().getContato()+"', '"+venda.getCliente().getDataNascString()+"', '"+venda.getCliente().getNomeMae()+"', "
               + "'"+venda.getCliente().getEndereco().getCep()+"', '"+venda.getCliente().getEndereco().getLogradouro()+"', "
               + "'"+venda.getCliente().getEndereco().getNumero()+"', '"+venda.getCliente().getEndereco().getBairro()+"', "
               + "'"+venda.getCliente().getEndereco().getCidade()+"', '"+venda.getCliente().getEndereco().getComplemento()+"', "
               + "'"+venda.getCliente().getEndereco().getPonto_ref1()+"', '"+venda.getCliente().getEndereco().getPonto_ref2()+"', "
               + "'"+venda.getNomePessoaAutorizada1()+"', '"+venda.getNomePessoaAutorizada2()+"', '"+venda.getTelefonePessoaAutorizada1()+"', "
               + "'"+venda.getTelefonePessoaAutorizada2()+"', '"+venda.getUsuarioOperador().getIdCargoUsuario()+"', "
               + "'"+venda.getCliente().getEmail()+"', '"+venda.getPortabilidade()+"', '"+venda.getPortabilidade_ddd()+"', "
               + "'"+venda.getDataVencimento()+"', '"+venda.getIdCampanha()+"', '"+venda.getCliente().isStatusCrivoint()+"', "
               + "'"+venda.getStatusVenda()+"', '"+venda.isFaturaEDigitalint()+"', '"+venda.getProtocoloOperadora()+"')";

       
   }
   
   public void efetuarVenda(String uf, String cidade, String bairro, String logradouro, int numero, 
           String cep, String complemento, String nome, String cpf, String contato, String nomeMae, String email, 
           ZonedDateTime dataNasc, int idPlano, ZonedDateTime dataVenda, String nomePessoaAutorizada1, String nomePessoaAutorizada2, 
           String telefonePessoaAutorizada1, String telefonePessoaAutorizada2, String portabilidade, String portabilidade_ddd, 
           String protocoloOperadora, boolean faturaEDigital, String statusVenda, 
           String ufAlt, String cidadeAlt, String bairroAlt, String logradouroAlt, int numeroAlt, 
           String cepAlt, String complementoAlt, String dataVencimento, int idCampanha) {
       
       Endereco endereco = new Endereco(uf, cidade, bairro, logradouro, numero, cep, complemento);
       Endereco enderecoAlternativo = new Endereco(ufAlt, cidadeAlt, bairroAlt, logradouroAlt, numeroAlt, cepAlt, complementoAlt);
       Cliente cliente = new Cliente(nome, cpf, contato, nomeMae, email, dataNasc, endereco);
       Venda venda = new Venda(idPlano, dataVenda, cliente, controladorLogin.getUsuarioCorrente(), nomePessoaAutorizada1, nomePessoaAutorizada2, telefonePessoaAutorizada1, 
            telefonePessoaAutorizada2, portabilidade, portabilidade_ddd, protocoloOperadora, enderecoAlternativo, 
               faturaEDigital, statusVenda, dataVencimento, idCampanha);
              
   }
}
