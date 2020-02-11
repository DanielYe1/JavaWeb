package main.controller;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;

import static main.controller.FileUploadCurso.criaPastaERedireciona;

@WebServlet("/upload-instrutor")
public class FileUploadInstrutor extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        String path = request.getServletContext().getRealPath("") + "/images/instrutor/";

        MultipartRequest m = new MultipartRequest(request, path);
        criaPastaERedireciona(request, response, path);
    }
}