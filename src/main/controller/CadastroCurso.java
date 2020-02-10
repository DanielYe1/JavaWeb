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

@WebServlet("/cadastro-curso")
public class CadastroCurso extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CadastroCurso() {
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

            PreparedStatement stmt = conexao.prepareStatement("insert into cursos(nome, requisito, ementa, carga_horaria, preco) values(?,?,?,?,?)");
            stmt.setString(1, request.getParameter("nome"));
            stmt.setString(2, request.getParameter("requisito"));
            stmt.setString(3, request.getParameter("ementa"));
            stmt.setInt(4, Integer.parseInt(request.getParameter("carga_horaria")));
            stmt.setFloat(5, Float.parseFloat(request.getParameter("preco")));

            stmt.executeUpdate();

            request.setAttribute("message", "O curso foi cadastrado com sucesso.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("sucesso.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }
}