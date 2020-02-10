package main.controller;

import main.model.Aluno;
import main.model.Curso;
import main.model.Instrutor;
import main.model.Turma;
import main.model.repositorio.Conexao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin")
public class ListaAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListaAdmin() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            selectAlunos(request);
            selectCursos(request);
            selectInstrutor(request);
            selectTurma(request);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/lista.jsp");

            dispatcher.forward(request, response);
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }

    static void selectTurma(HttpServletRequest request) throws SQLException, ParseException {
        Connection conexao = Conexao.getConexao();

        String selectSQL = "SELECT * FROM turmas";
        PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
        ResultSet resultado = preparedStatement.executeQuery();

        List<Turma> turmas = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        while (resultado.next()) {
            turmas.add(new Turma(
                    Integer.parseInt(resultado.getString("id")),
                    Integer.parseInt(resultado.getString("instrutores_id")),
                    Integer.parseInt(resultado.getString("cursos_id")),
                    dateFormat.parse(resultado.getString("data_inicio")),
                    dateFormat.parse(resultado.getString("data_final")),
                    Integer.parseInt(resultado.getString("carga_horaria"))
            ));
        }

        request.setAttribute("turmas", turmas);
    }

    static void selectInstrutor(HttpServletRequest request) throws SQLException {
        Connection conexao = Conexao.getConexao();

        String selectSQL = "SELECT * FROM instrutores";
        PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
        ResultSet resultado = preparedStatement.executeQuery();

        List<Instrutor> instrutores = new ArrayList<>();
        while (resultado.next()) {
            instrutores.add(new Instrutor(
                    Integer.parseInt(resultado.getString("id")),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    Integer.parseInt(resultado.getString("valor_hora")),
                    resultado.getString("login"),
                    resultado.getString("senha"),
                    resultado.getString("experiencia")
            ));
        }

        request.setAttribute("instrutores", instrutores);
    }

    static void selectCursos(HttpServletRequest request) throws SQLException {
        Connection conexao = Conexao.getConexao();

        String selectSQL = "SELECT * FROM cursos";
        PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
        ResultSet resultado = preparedStatement.executeQuery();

        List<Curso> cursos = new ArrayList<>();
        while (resultado.next()) {
            cursos.add(new Curso(
                    Integer.parseInt(resultado.getString("id")),
                    resultado.getString("nome"),
                    resultado.getString("requisito"),
                    resultado.getString("ementa"),
                    Integer.parseInt(resultado.getString("carga_horaria")),
                    Float.parseFloat(resultado.getString("preco"))
            ));
        }

        request.setAttribute("cursos", cursos);
    }

    static void selectAlunos(HttpServletRequest request) throws SQLException {
        Connection conexao = Conexao.getConexao();

        String selectSQL = "SELECT * FROM alunos";
        PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
        ResultSet resultado = preparedStatement.executeQuery();

        List<Aluno> alunos = new ArrayList<>();
        while (resultado.next()) {
            alunos.add(new Aluno(
                    Integer.parseInt(resultado.getString("id")),
                    resultado.getString("cpf"),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("celular"),
                    resultado.getString("login"),
                    resultado.getString("senha"),
                    resultado.getString("endereco"),
                    resultado.getString("cidade"),
                    resultado.getString("bairro"),
                    resultado.getString("cep"),
                    resultado.getString("comentario"),
                    resultado.getString("aprovado").charAt(0)));
        }

        request.setAttribute("alunos", alunos);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }
}