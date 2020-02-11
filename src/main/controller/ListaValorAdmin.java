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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/valor-admin")
public class ListaValorAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListaValorAdmin() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            Connection conexao = Conexao.getConexao();

            String selectSQL = "select instrutores_id as idInstrutor, count(*) as qtTurmas, sum(carga_horaria*valor_hora)" +
                    " as valor from instrutores join turmas t on instrutores.id = t.instrutores_id group by instrutores_id;";
            PreparedStatement preparedStatement = conexao.prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();

            List<Integer[]> valores = new ArrayList<>();
            while (resultado.next()) {
                Integer[] val = new Integer[3];
                val[0] = Integer.parseInt(resultado.getString("IdInstrutor"));
                val[1] = Integer.parseInt(resultado.getString("qtTurmas"));
                val[2] = Integer.parseInt(resultado.getString("valor"));
                valores.add(val);
            }
            request.setAttribute("valores", valores);

            RequestDispatcher dispatcher = request.getRequestDispatcher("valores.jsp");

            dispatcher.forward(request, response);
        } catch (Exception e) {

            out.println("Erro: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }
}