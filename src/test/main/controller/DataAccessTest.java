package main.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

/**
 * Created by daniel.ye on 09/03/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class DataAccessTest {

    @Mock
    DataWriter writer;

    @Mock
    DataReader reader;

    @InjectMocks
    DataAccess dataAccess;

    @Test
    public void deveria_escrever_string_no_arquivo() {
        DataAccess dataAccess = new DataAccess(writer, reader);
        dataAccess.println("message");
        doNothing().when(writer).println("message");
        verify(writer).println("message");
    }

    @Test
    public void deveria_fechar_arquivo() {
        dataAccess.close();
        verify(writer).close();
    }

    @Test
    public void deveria_retornar_com_o_reader_se_existe_proximo_valor_a_ser_lido(){
        dataAccess.hasNext();
        verify(reader).hasNext();
    }

}