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
import java.sql.Date;
import java.sql.PreparedStatement;

@WebServlet("/cadastro/turma")
public class AtualizaTurma extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AtualizaTurma() {
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

            PreparedStatement stmt = conexao.prepareStatement("update turmas set instrutores_id = ?, cursos_id = ?, " +
                    "data_inicio = ?, data_final = ?, carga_horaria = ? where id = ?");
            stmt.setInt(1, Integer.parseInt(request.getParameter("instrutores_id")));
            stmt.setInt(2, Integer.parseInt(request.getParameter("cursos_id")));
            stmt.setDate(3, Date.valueOf(request.getParameter("data_matricula")));
            stmt.setDate(4, Date.valueOf(request.getParameter("data_final")));
            stmt.setInt(5, Integer.parseInt(request.getParameter("carga_horaria")));
            stmt.setString(6, request.getParameter("id"));

            int i = stmt.executeUpdate();

            System.out.println("salvei "+i);
            out.println("A Turma " + request.getParameter("nome") + " foi cadastrado com sucesso.");
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }
}