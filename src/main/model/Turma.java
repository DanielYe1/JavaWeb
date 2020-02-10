package main.model;

import java.util.Date;

public class Turma {
    private int id;
    private int idInstrutor;
    private int idCurso;
    private Date dataInicio;
    private Date dataFinal;

    @Override
    public String toString() {
        return "<tr>"+"<td>"+ id +"</td>" +
                "<td>"+ idInstrutor +"</td>" +
                "<td>"+ idCurso +"</td>" +
                "<td>"+ dataInicio +"</td>" +
                "<td>"+ dataFinal +"</td>" + "</tr>";
    }

    public Turma(int id, int idInstrutor, int idCurso, Date dataInicio, Date dataFinal, int cargaHoraria) {
        this.id = id;
        this.idInstrutor = idInstrutor;
        this.idCurso = idCurso;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.cargaHoraria = cargaHoraria;
    }

    private int cargaHoraria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(int idInstrutor) {
        this.idInstrutor = idInstrutor;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
