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

@WebServlet("/cadastro-aluno")
public class CadastroAluno extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CadastroAluno() {
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

            PreparedStatement stmt = conexao.prepareStatement("insert into alunos(cpf, nome, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, request.getParameter("cpf"));
            stmt.setString(2, request.getParameter("nome"));
            stmt.setString(3, request.getParameter("email"));
            stmt.setString(4, request.getParameter("celular"));
            stmt.setString(5, request.getParameter("login"));
            stmt.setString(6, (String) request.getAttribute("senha"));
            stmt.setString(7, request.getParameter("endereco"));
            stmt.setString(8, request.getParameter("cidade"));
            stmt.setString(9, request.getParameter("bairro"));
            stmt.setString(10, request.getParameter("cep"));
            stmt.setString(11, request.getParameter("comentario"));
            String aprovado = request.getParameter("aprovado");
            if(aprovado == null) {
                stmt.setString(12, "n");
            }else{
                stmt.setString(12, aprovado);
            }

            stmt.executeUpdate();

            request.setAttribute("message", "O Aluno foi cadastrado com sucesso.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("sucesso.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }
}