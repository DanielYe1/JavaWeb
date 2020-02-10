package main.controller;

import main.model.Nota;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/valor")
public class ListaValor extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListaValor() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            Connection conexao = Conexao.getConexao();

            String selectSQL = "select sum(carga_horaria*valor_hora) as valor from instrutores join turmas t on instrutores.id = t.instrutores_id where instrutores_id = 1;";
            PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();

            resultado.next();

            float valor = Integer.parseInt(resultado.getString("valor"));
            request.setAttribute("valor", valor);
            RequestDispatcher dispatcher = request.getRequestDispatcher("valorProfessor.jsp");

            dispatcher.forward(request, response);
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }
}