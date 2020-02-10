package main.controller;

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

@WebServlet("/atualiza-aluno")
public class AtualizaAluno extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AtualizaAluno() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("get teste");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            Connection conexao = Conexao.getConexao();

            PreparedStatement stmt = conexao.prepareStatement("update alunos set cpf = ?, nome = ?, email = ?, " +
                    "celular = ?, login = ?, senha = ?, endereco = ?, cidade = ?, bairro = ?, cep = ?, comentario = ?, " +
                    "aprovado = ?) where id = ?");
            stmt.setString(1, request.getParameter("cpf"));
            stmt.setString(2, request.getParameter("nome"));
            stmt.setString(3, request.getParameter("email"));
            stmt.setString(4, request.getParameter("celular"));
            stmt.setString(5, request.getParameter("login"));
            stmt.setString(6, request.getParameter("senha"));
            stmt.setString(7, request.getParameter("endereco"));
            stmt.setString(8, request.getParameter("cidade"));
            stmt.setString(9, request.getParameter("bairro"));
            stmt.setString(10, request.getParameter("cep"));
            stmt.setString(11, request.getParameter("comentario"));
            stmt.setString(12, request.getParameter("aprovado"));
            if (request.getParameter("id") == null) {
                stmt.setString(13, (String) request.getSession().getAttribute("id"));
            } else {
                stmt.setString(13, request.getParameter("id"));
            }

            stmt.executeUpdate();

            request.setAttribute("message", "O Aluno foi atualizado com sucesso.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("sucesso.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }
}