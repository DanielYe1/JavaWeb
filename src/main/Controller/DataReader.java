package main.Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by daniel.ye on 09/03/17.
 */
public class DataReader {

    Scanner scanner;

    public DataReader(String fileName){
        try {
            scanner = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException error) {
            System.out.println("Arquivo nao encontrado");
        }
    }

    public String readln() {
        return scanner.nextLine();
    }

    public boolean hasNext(){
        return scanner.hasNext();
    }
}
