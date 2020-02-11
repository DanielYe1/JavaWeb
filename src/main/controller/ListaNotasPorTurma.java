package main.controller;

import main.model.Nota;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/notas-turma")
public class ListaNotasPorTurma extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListaNotasPorTurma() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            Connection conexao = Conexao.getConexao();

            String selectSQL = "select c.nome as curso, t.id as turmas_id, alunos_id as idAluno, m.nota as nota from alunos " +
                    "join matriculas m on alunos.id = m.alunos_id join turmas t on m.turmas_id = t.id " +
                    "join cursos c on t.cursos_id = c.id where turmas_id = ?;";
            PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
            preparedStatement.setString(1, (String) request.getParameter("idTurma"));
            ResultSet resultado = preparedStatement.executeQuery();

            List<Nota> notas = new ArrayList<>();
            while (resultado.next()) {
                notas.add(new Nota(
                        resultado.getString("curso"),
                        Integer.parseInt(resultado.getString("idAluno")),
                        Integer.parseInt(resultado.getString("turmas_id")),
                        Integer.parseInt(resultado.getString("nota"))
                ));
            }

            request.setAttribute("notas", notas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/notas.jsp");

            dispatcher.forward(request, response);
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }
}