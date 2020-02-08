package main.controller;

import main.model.Aluno;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/turmas")
public class ListaTurmas extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListaTurmas() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Connection conexao = Conexao.getConexao();

            String selectSQL = "SELECT * FROM turmas";
            PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();

            List<Turma> turmas = new ArrayList<>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            while (resultado.next()) {
                turmas.add(new Turma(
                        Integer.parseInt(resultado.getString("id")),
                        Integer.parseInt(resultado.getString("instrutores_id")),
                        Integer.parseInt(resultado.getString("cursos_id")),
                        dateFormat.parse(resultado.getString("data_matricula")),
                        dateFormat.parse(resultado.getString("data_final")),
                        Integer.parseInt(resultado.getString("carga_horaria"))
                        ));
            }

            request.setAttribute("turmas", turmas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");

            dispatcher.forward(request, response);
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }
}