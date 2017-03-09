package main.Controller;

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

    @InjectMocks
    DataAccess dataAccess;

    @Test
    public void deveria_escrever_string_no_arquivo() {
        DataAccess dataAccess = new DataAccess(writer);
        dataAccess.println("message");
        doNothing().when(writer).println("message");
        verify(writer).println("message");
    }

    @Test
    public void deveria_fechar_arquivo(){
        dataAccess.close();
        verify(writer).close();
    }

}