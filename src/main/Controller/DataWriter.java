package main.Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by daniel.ye on 09/03/17.
 */
public class DataWriter {

    private PrintWriter printWriter;

    public DataWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public void println(String message) {
        printWriter.println(message);
        printWriter.flush();
    }

    public void close() {
        printWriter.close();
    }
}
