package main.controller;

import com.oreilly.servlet.MultipartRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/upload-curso")
public class FileUploadCurso extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String path = request.getServletContext().getRealPath("") + "/images/curso/";
        criaPastaERedireciona(request, response, path);
    }

    static void criaPastaERedireciona(HttpServletRequest request, HttpServletResponse response, String path) throws IOException, ServletException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        MultipartRequest m = new MultipartRequest(request, path);

        request.setAttribute("message", "A foto foi postada com sucesso.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("sucesso.jsp");
        dispatcher.forward(request, response);
    }
}