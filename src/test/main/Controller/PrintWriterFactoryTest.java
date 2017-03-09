package main.Controller;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by daniel.ye on 09/03/17.
 */
public class PrintWriterFactoryTest {

    @Test
    public void deveria_criar_arquivo() throws IOException {
        PrintWriterFactory factory = new PrintWriterFactory();
        PrintWriter writer = factory.createWriter("temp/test.txt");
        writer.println("message");
        writer.close();
        Scanner scanner = new Scanner(new FileReader("temp/test.txt"));
        assertThat(scanner.next(), equalTo("message"));
    }

}