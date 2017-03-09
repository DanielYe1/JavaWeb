package test;

import main.Controller.Adder;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by daniel.ye on 08/03/17.
 */
public class AdderTest {

    public void deveria_criar_arquivo() throws FileNotFoundException {
        Adder adder = new Adder("arq.txt");
    }

}