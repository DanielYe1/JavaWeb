package main.controller;

import main.model.Turma;
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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/atualiza-nota")
public class AtualizaNota extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AtualizaNota() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            Connection conexao = Conexao.getConexao();


            PreparedStatement stmt = conexao.prepareStatement("select turmas.id as id from turmas join instrutores i on" +
                    " turmas.instrutores_id = i.id where instrutores_id = ?;");
            stmt.setString(1, (String) request.getSession().getAttribute("id"));
            ResultSet resultado = stmt.executeQuery();
            List<Integer> turmas = new ArrayList<>();
            while (resultado.next()){
                turmas.add(resultado.getInt("id"));
            }

            if(!turmas.contains(Integer.parseInt(request.getParameter("turmas_id")))) {
                request.setAttribute("message", "Somente professores da turma podem atualizar nota da turma");
                RequestDispatcher dispatcher = request.getRequestDispatcher("sucesso.jsp");
                dispatcher.forward(request, response);
            }


            stmt = conexao.prepareStatement("update matriculas set " +
                    " nota = ? where turmas_id = ? and alunos_id = ?");
            stmt.setInt(1, Integer.parseInt(request.getParameter("nota")));
            stmt.setInt(2, Integer.parseInt(request.getParameter("turmas_id")));
            stmt.setInt(3, Integer.parseInt(request.getParameter("alunos_id")));

            stmt.executeUpdate();

            request.setAttribute("message", "A nota foi atualizada com sucesso.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("sucesso.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }
}