package main.Controller;

import javax.print.attribute.standard.PrinterName;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by daniel.ye on 08/03/17.
 */
public class Adder {

    BufferedWriter writer;

    public Adder(String fileName) throws FileNotFoundException {
        writer = new BufferedWriter(new PrintWriter(fileName));
    }

}
