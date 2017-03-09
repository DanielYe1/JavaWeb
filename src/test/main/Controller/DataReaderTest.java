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

    @Test
    public void deveria_retornar_se_possui_ou_nao_proximo_valor(){
        DataReader dataReader = new DataReader("temp/oneValue.txt");
        assertThat(dataReader.hasNext(),equalTo(true));
        String line = dataReader.readln();
        assertThat(dataReader.hasNext(),equalTo(false));
    }

}