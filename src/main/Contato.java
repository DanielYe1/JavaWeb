package main;

import main.Controller.Adder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by daniel.ye on 08/03/17.
 */
@WebServlet(name = "Contato", urlPatterns = "/contato")
public class Contato extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("nome"));
        Adder adder = new Adder("file.txt");
    }
}
