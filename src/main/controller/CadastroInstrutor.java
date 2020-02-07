package main.controller;

import main.model.repositorio.Conexao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/cadastroinstrutor")
public class CadastroInstrutor extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CadastroInstrutor() {
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

            PreparedStatement stmt = conexao.prepareStatement("insert into instrutores(nome, email, valor_hora, login, senha, experiencia) values(?,?,?,?,?,?,?)");
            stmt.setString(1, request.getParameter("nome"));
            stmt.setString(2, request.getParameter("email"));
            stmt.setInt(3, Integer.parseInt(request.getParameter("valor_hora")));
            stmt.setString(4, request.getParameter("login"));
            stmt.setString(5, request.getParameter("senha"));
            stmt.setString(6, request.getParameter("experiencia"));

            int i = stmt.executeUpdate();

            System.out.println("salvei "+i);
            out.println("O Instrutor " + request.getParameter("nome") + " foi cadastrado com sucesso.");
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }
}