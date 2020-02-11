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

@WebServlet("/upload-aluno")
public class FileUploadAlunos extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String path = request.getServletContext().getRealPath("") + "/images/aluno/";
        FileUploadCurso.criaPastaERedireciona(request, response, path);
    }
}