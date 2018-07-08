package model;

public class Usuario {
    private int idUsuario, idCargoUsuario, status;
    private String nome, senha, ramalLogin;

    //Construtor para login
    public Usuario() {
        status = 1;
    }

    //Construtor para cadastro de novos funcionários
    public Usuario(int idCargoUsuario, String nome, String senha, String ramalLogin) {
        this.idCargoUsuario = idCargoUsuario;
        this.nome = nome;
        this.senha = senha;
        this.ramalLogin = ramalLogin;
        status = 1;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdCargoUsuario() {
        return idCargoUsuario;
    }

    public int getStatus() {
        return status;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getRamalLogin() {
        return ramalLogin;
    }

    public void setIdCargoUsuario(int idCargoUsuario) throws IllegalArgumentException {
        if(idCargoUsuario <= 0 || idCargoUsuario > 4)
            throw new IllegalArgumentException("Código não corresponde a um cargo válido");
        this.idCargoUsuario = idCargoUsuario;
    }

    public void setStatus(int status) throws IllegalArgumentException {
        if(status != 1 && status != 2)
            throw new IllegalArgumentException("Status inválido");
        this.status = status;
    }

    public void setNome(String nome) throws IllegalArgumentException {
       /* if(nome == null || !nome.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException("Nome inválido");*/
        this.nome = nome;
    }

    public void setSenha(String senha) throws IllegalArgumentException {
        if(senha == null)
            throw new IllegalArgumentException("Senhas vazias não são permitidas");
        this.senha = senha;
    }

    public void setRamalLogin(String ramalLogin) throws IllegalArgumentException {
        if(ramalLogin == null || !ramalLogin.matches("[0-9]+"))
            throw new IllegalArgumentException("Ramal inválido");
        this.ramalLogin = ramalLogin;
    }
}