package main;

import main.Controller.DataAccess;
import main.Controller.DataWriter;
import main.Controller.PrintWriterFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by daniel.ye on 08/03/17.
 */
@WebServlet(name = "Contato", urlPatterns = "/contato")
public class Contato extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriterFactory factory = new PrintWriterFactory();
        DataAccess dataAccess = new DataAccess(new DataWriter(factory.createWriter("/opt/development/workspaces/Catalogo/temp/contatos.txt")));
        String contactData = String.format("nome:%s - email:%s - mensagem:%s", request.getParameter("nome"), request.getParameter("email"), request.getParameter("mensagem"));
        dataAccess.println(contactData);
        dataAccess.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Scanner scanner = new Scanner(new FileReader("/opt/development/workspaces/Catalogo/temp/contatos.txt"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        while(scanner.hasNext()){
            out.println(scanner.nextLine());
            out.println("</br>");
        }
    }

}
