package main.controller;

import main.model.repositorio.Conexao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        try {
            String user = request.getParameter("login");
            String[] role = Conexao.autenticaUsuario(user, request.getParameter("senha"));
            PrintWriter out = response.getWriter();
            if (role == null) {
                out.println("Dados errados");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

            HttpSession session = request.getSession();
            switch (role[0]) {
                case ("admin"):
                    session.setAttribute("admin", true);
                    session.setAttribute("user", user);
                    session.setAttribute("id", role[1]);
                    request.getRequestDispatcher("/centralAdmin.jsp").forward(request, response);
                    break;
                case ("instrutor"):
                    session.setAttribute("instrutor", true);
                    session.setAttribute("user", user);
                    session.setAttribute("id", role[1]);
                    request.getRequestDispatcher("/centralInstrutor.jsp").forward(request, response);
                    break;
                case ("aluno"):
                    session.setAttribute("aluno", true);
                    session.setAttribute("user", user);
                    session.setAttribute("id", role[1]);
                    request.getRequestDispatcher("/centralAluno.jsp").forward(request, response);
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}