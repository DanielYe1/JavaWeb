package main.model;

public class Nota {
    private int idAluno;
    private String curso;
    private int idTurma;
    private int nota;

    public Nota(String curso, int idTurma, int nota, int idAluno) {
        this.idAluno = idAluno;
        this.curso = curso;
        this.idTurma = idTurma;
        this.nota = nota;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "<tr>"+"<td>"+ idAluno +"</td>" +
                "<td>"+ idTurma +"</td>" +
                "<td>"+ curso +"</td>" +
                "<td>"+ nota +"</td>" + "</tr>";
    }
}
