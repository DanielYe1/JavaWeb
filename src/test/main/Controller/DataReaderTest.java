package main.Controller;

import org.junit.Test;
import org.mockito.InjectMocks;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by daniel.ye on 09/03/17.
 */
public class DataReaderTest {

    @Test
    public void deveria_ler_uma_linha_inteira_do_arquivo(){
        DataReader dataReader = new DataReader("temp/contatos.txt");
        String line = dataReader.readln();
        assertThat(line,equalTo("nome:teste - email:1r1r - mensagem:241"));
    }

}