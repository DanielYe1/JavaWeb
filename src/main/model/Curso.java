package main.model;

public class Curso {
    private int id;
    private String nome;
    private String requisito;
    private String ementa;
    private int cargaHoraria;
    private double preco;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "<tr>"+"<td>"+ id +"</td>" +
                "<td>"+ nome +"</td>" +
                "<td>"+ requisito +"</td>" +
                "<td>"+ ementa +"</td>" +
                "<td>"+ cargaHoraria +"</td>" +
                "<td>"+ preco +"</td>" + "</tr>";
    }

    public Curso(int id, String nome, String requisito, String ementa, int cargaHoraria, double preco) {
        this.id = id;
        this.nome = nome;
        this.requisito = requisito;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
        this.preco = preco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
