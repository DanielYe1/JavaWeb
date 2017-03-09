package main.Controller;

import java.io.*;

/**
 * Created by daniel.ye on 08/03/17.
 */
public class DataAccess {

    private DataWriter writer;

    public DataAccess(DataWriter writer) {
        this.writer = writer;
    }

    public void println(String message) {
        writer.println(message);
    }

    public void close(){
        writer.close();
    }
}
