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
            String role = Conexao.autenticaUsuario(user, request.getParameter("senha"));
            PrintWriter out = response.getWriter();
            if(role.equals("nada")){
                out.println("Dados errados");
                request.getRequestDispatcher("login.jsp");
            }

            HttpSession session = request.getSession();
            switch (role) {
                case ("admin"):
                    session.setAttribute("admin", true);
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("/login/admin.jsp").forward(request, response);
                    break;
                case ("instrutor"):
                    session.setAttribute("instrutor", true);
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("/login/instrutor.jsp").forward(request, response);
                    break;
                case ("aluno"):
                    session.setAttribute("aluno", true);
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("/login/aluno.jsp").forward(request, response);
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}