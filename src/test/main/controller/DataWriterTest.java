package main.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintWriter;

import static org.mockito.Mockito.verify;

/**
 * Created by daniel.ye on 09/03/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class DataWriterTest {

    @InjectMocks
    DataWriter dataWriter;

    @Mock
    PrintWriter printWriter;

    @Test
    public void deveria_printar_mensagem_recebida(){
        dataWriter.println("message");
        verify(printWriter).println("message");
    }

    @Test
    public void deveria_fechar_arquivo(){
        dataWriter.close();
        verify(printWriter).close();
    }

}