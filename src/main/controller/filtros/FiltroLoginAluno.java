package main.controller.filtros;

import main.model.repositorio.Conexao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "FiltroLoginAluno", urlPatterns = {"/centralAluno.jsp", "/matricula.jsp", "/atualizaAluno.jsp", "/uploadImagemAluno.jsp"})
public class FiltroLoginAluno implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        Connection conexao = Conexao.getConexao();

        boolean aprovado = false;
        try {
            PreparedStatement stmt = conexao.prepareStatement("select * from alunos where id = ? and aprovado = 's'");
            stmt.setString(1, (String) request.getSession().getAttribute("id"));
            ResultSet resultado = stmt.executeQuery();
            List<Integer> turmas = new ArrayList<>();

            aprovado = resultado.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (session.getAttribute("id") == null) {
            response.sendRedirect("login.jsp");
        } else {
            if (session.getAttribute("aluno") != null && aprovado) {
                chain.doFilter(request, response);
            } else {
                request.setAttribute("message", "A página só pode ser acessada por aluno");
                RequestDispatcher dispatcher = request.getRequestDispatcher("sucesso.jsp");
                dispatcher.forward(request, response);
            }
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }


}
