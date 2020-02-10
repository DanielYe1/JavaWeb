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

@WebServlet("/atualiza/instrutor")
public class AtualizaInstrutor extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AtualizaInstrutor() {
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

            PreparedStatement stmt = conexao.prepareStatement("update instrutores set nome = ?, email = ?, valor_hora = ?," +
                    " login = ?, senha = ?, experiencia = ? where id = ?");
            stmt.setString(1, request.getParameter("nome"));
            stmt.setString(2, request.getParameter("email"));
            stmt.setInt(3, Integer.parseInt(request.getParameter("valor_hora")));
            stmt.setString(4, request.getParameter("login"));
            stmt.setString(5, request.getParameter("senha"));
            stmt.setString(6, request.getParameter("experiencia"));
            if (request.getParameter("id") == null) {
                stmt.setString(7, (String) request.getSession().getAttribute("id"));
            } else {
                stmt.setString(7, request.getParameter("id"));
            }

            int i = stmt.executeUpdate();

            System.out.println("salvei " + i);
            out.println("O Instrutor " + request.getParameter("nome") + " foi cadastrado com sucesso.");
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }
}