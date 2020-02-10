package main.controller;

import main.model.Curso;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cursos")
public class ListaCursos extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListaCursos() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            Connection conexao = Conexao.getConexao();

            String selectSQL = "select * from cursos where id in " +
                    "(select distinct cursos_id from turmas where data_final > NOW());";
            PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();

            List<Curso> cursos = new ArrayList<>();
            while (resultado.next()) {
                cursos.add(new Curso(
                        Integer.parseInt(resultado.getString("id")),
                        resultado.getString("nome"),
                        resultado.getString("requisito"),
                        resultado.getString("ementa"),
                        Integer.parseInt(resultado.getString("carga_horaria")),
                        Float.parseFloat(resultado.getString("preco"))
                ));
            }

            request.setAttribute("cursos", cursos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/cursos.jsp");




            dispatcher.forward(request, response);
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }
}