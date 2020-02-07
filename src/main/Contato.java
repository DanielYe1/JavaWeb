package main;

import main.controller.DataAccess;
import main.controller.DataReader;
import main.controller.DataWriter;
import main.controller.PrintWriterFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by daniel.ye on 08/03/17.
 */
@WebServlet(name = "Contato", urlPatterns = "/contato")
public class Contato extends HttpServlet {


    @Override
    public void init() throws ServletException {
        super.init();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriterFactory factory = new PrintWriterFactory();
        String fileName = "/home/daniel/development/repos/JavaWeb/src/main/contatos.txt";
        DataAccess dataAccess = new DataAccess(new DataWriter(factory.createWriter(fileName)), new DataReader(fileName));
        String contactData = String.format("nome:%s - email:%s - mensagem:%s", request.getParameter("nome"), request.getParameter("email"), request.getParameter("mensagem"));
        dataAccess.println(contactData);
        dataAccess.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriterFactory factory = new PrintWriterFactory();
        String fileName = "/home/daniel/development/repos/JavaWeb/src/main/contatos.txt";
        DataAccess dataAccess = new DataAccess(new DataWriter(factory.createWriter(fileName)), new DataReader(fileName));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        while (dataAccess.hasNext()) {
            out.println(dataAccess.readln());
            out.println("</br>");
        }
    }

}
