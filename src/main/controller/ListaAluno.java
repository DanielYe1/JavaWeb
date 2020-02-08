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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/aluno")
public class ListaAluno extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListaAluno() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
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