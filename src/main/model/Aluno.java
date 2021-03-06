package main.model;

public class Aluno {
    private int id;
    private String cpf;
    private String nome;
    private String email;
    private String celular;
    private String login;
    private String senha;
    private String endereco;
    private String cidade;
    private String bairro;
    private String cep;
    private String comentario;
    private char aprovado;

    public Aluno(int id, String cpf, String nome, String email, String celular, String login, String senha, String endereco, String cidade, String bairro, String cep, String comentario, char aprovado) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.login = login;
        this.senha = senha;
        this.endereco = endereco;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.comentario = comentario;
        this.aprovado = aprovado;
    }

    @Override
    public String toString() {
        return "<tr>" + "<td>" + id + "</td>" +
                "<td>" + cpf + "</td>" +
                "<td>" + nome + "</td>" +
                "<td>" + email + "</td>" +
                "<td>" + celular + "</td>" +
                "<td>" + login + "</td>" +
                "<td>" + senha + "</td>" +
                "<td>" + endereco + "</td>" +
                "<td>" + cidade + "</td>" +
                "<td>" + bairro + "</td>" +
                "<td>" + cep + "</td>" +
                "<td>" + comentario + "</td>" +
                "<td>" + aprovado + "</td>" + "</tr>"
                ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public char isAprovado() {
        return aprovado;
    }

    public void setAprovado(char aprovado) {
        this.aprovado = aprovado;
    }


}
