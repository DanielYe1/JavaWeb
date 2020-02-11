package main.controller.filtros;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FiltroLoginInstrutor", urlPatterns = {"/centralInstrutor.jsp", "/atualizaInstrutor.jsp", "/notasInstrutor.jsp", "/valor"})
public class FiltroLoginInstrutor implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();

        if (session.getAttribute("id") == null) {
            response.sendRedirect("login.jsp");
        } else {
            if (session.getAttribute("instrutor") != null) {
                chain.doFilter(request, response);
            }else{
                request.setAttribute("message", "A página só pode ser acessada por instrutores");
                RequestDispatcher dispatcher = request.getRequestDispatcher("sucesso.jsp");
                dispatcher.forward(request, response);
            }
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }


}
