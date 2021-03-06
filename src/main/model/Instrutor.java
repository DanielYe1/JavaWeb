package main.model;

public class Instrutor {
    private int id;
    private String nome;
    private String email;
    private int valorHora;
    private String login;
    private String senha;
    private String experiencia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return   "<tr>"+"<td>"+ id +"</td>" +
                "<td>"+ nome +"</td>" +
                "<td>"+ email +"</td>" +
                "<td>"+ valorHora +"</td>" +
                "<td>"+ login +"</td>" +
                "<td>"+ senha +"</td>" +
                "<td>"+ experiencia +"</td>" + "</tr>";
    }

    public Instrutor(int id, String nome, String email, int valorHora, String login, String senha, String experiencia) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.valorHora = valorHora;
        this.login = login;
        this.senha = senha;
        this.experiencia = experiencia;
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

    public int getValorHora() {
        return valorHora;
    }

    public void setValorHora(int valorHora) {
        this.valorHora = valorHora;
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


    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
}
