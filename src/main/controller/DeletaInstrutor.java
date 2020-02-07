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

@WebServlet("/deleta/instrutor")
public class DeletaInstrutor extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeletaInstrutor() {
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

            PreparedStatement stmt = conexao.prepareStatement("delete from instrutores where id = ?");
            stmt.setString(1, request.getParameter("id"));

            int i = stmt.executeUpdate();

            System.out.println("atualizei "+i);
            out.println("O instrutor " + request.getParameter("nome") + " foi deletado com sucesso.");
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }
}