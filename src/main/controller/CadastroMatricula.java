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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@WebServlet("/cadastro/matricula")
public class CadastroMatricula extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CadastroMatricula() {
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

            PreparedStatement stmt = conexao.prepareStatement("insert into matriculas(turmas_id, alunos_id, data_matricula, nota) values(?,?,?,?)");
            stmt.setInt(1, Integer.parseInt(request.getParameter("turmas_id")));
            stmt.setInt(2, Integer.parseInt(request.getParameter("alunos_id")));
            stmt.setDate(3, Date.valueOf(request.getParameter("data_matricula")));
            stmt.setInt(4, Integer.parseInt(request.getParameter("nota")));

            int i = stmt.executeUpdate();

            System.out.println("salvei "+i);
            out.println("A Matricula " + request.getParameter("nome") + " foi cadastrado com sucesso.");
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }
}