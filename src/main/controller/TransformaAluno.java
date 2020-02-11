package main.controller;

import main.model.Aluno;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/transforma-aluno")
public class TransformaAluno extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TransformaAluno() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        try {
            Connection conexao = Conexao.getConexao();

            String selectSQL = "select * from alunos where aprovado != 's';";
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("/transformaAluno.jsp");

            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            Connection conexao = Conexao.getConexao();

            PreparedStatement stmt = conexao.prepareStatement("update alunos set aprovado='s' where id = ?");
            stmt.setString(1, request.getParameter("id"));

            stmt.executeUpdate();

            request.setAttribute("message", "O aluno foi aceito com sucesso.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("sucesso.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }
}