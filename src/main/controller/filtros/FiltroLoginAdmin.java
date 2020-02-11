package main.controller.filtros;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebFilter(filterName = "FiltroLoginAdmin", urlPatterns = {"/centralAdmin.jsp", "/admin", "/deletarAdmin.jsp",
        "/tabelasCadastro.jsp", "/tabelasAtualiza.jsp", "/listaNotasPorTurma.jsp", "/valor-admin",
        "/uploadImagemAdmin.jsp", "/deleta-aluno", "/deleta-curso", "/deleta-instrutor", "/deleta-matricula", "/deleta-turma"})
public class FiltroLoginAdmin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();

        if (session.getAttribute("id") == null) {
            response.sendRedirect("login.jsp");
        } else {
            if (session.getAttribute("admin") != null) {
                chain.doFilter(request, response);
            }else{
                request.setAttribute("message", "A página só pode ser acessada por administradores");
                RequestDispatcher dispatcher = request.getRequestDispatcher("sucesso.jsp");
                dispatcher.forward(request, response);
            }
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }


}
