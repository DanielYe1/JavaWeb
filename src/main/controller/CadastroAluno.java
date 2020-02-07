package main.controller;

import main.model.Aluno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/cadAluno")
public class CadastroAluno extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CadastroAluno() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cadAluno.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        try {

            Aluno aluno = new Aluno(
                    request.getParameter("cpf"),
                    request.getParameter("nome"),
                    request.getParameter("email"),
                    request.getParameter("celular"),
                    request.getParameter("login"),
                    request.getParameter("senha"),
                    request.getParameter("endereco"),
                    request.getParameter("cidade"),
                    request.getParameter("bairro"),
                    request.getParameter("cep"),
                    request.getParameter("comentario"),
                    request.getParameter("aprovado").charAt(0)
            );



            request.setAttribute("mensagem", "O Aluno " + aluno.getNome()
                    + " foi cadastrado com sucesso.");
            request.getRequestDispatcher("cadAluno.jsp").forward(request,
                    response);
        } catch (Exception e) {
            request.setAttribute("mensagem", "Erro: " + e.getMessage());
            request.getRequestDispatcher("cadAluno.jsp").forward(request,
                    response);
        }
    }
}