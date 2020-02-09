package main.controller;

import main.model.Instrutor;
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

@WebServlet("/instrutor")
public class ListaInstrutor extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListaInstrutor() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Connection conexao = Conexao.getConexao();

            String selectSQL = "SELECT * FROM instrutores";
            PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();

            List<Instrutor> instrutores = new ArrayList<>();
            while (resultado.next()) {
                instrutores.add(new Instrutor(
                        Integer.parseInt(resultado.getString("id")),
                        resultado.getString("nome"),
                        resultado.getString("email"),
                        Integer.parseInt(resultado.getString("valor_hora")),
                        resultado.getString("login"),
                        resultado.getString("senha"),
                        resultado.getString("experiencia")
                ));
            }

            request.setAttribute("instrutores", instrutores);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/instrutores.jsp");

            dispatcher.forward(request, response);
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }
}