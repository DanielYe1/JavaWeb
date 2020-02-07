package main.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by daniel.ye on 09/03/17.
 */
public class PrintWriterFactory {

    public PrintWriter createWriter(String fileName) throws IOException {
        return new PrintWriter(new FileWriter(fileName,true));
    }


}
