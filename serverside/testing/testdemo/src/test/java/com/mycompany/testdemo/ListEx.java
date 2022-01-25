package com.mycompany.testdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.List;

public class ListEx {

    @Test
    public void testExperiment(){
        List<Integer> list= mock(List.class);
       when(list.get(0)).thenReturn(11);
        int result=list.get(0);
        Assertions.assertEquals(11, result);
         verify(list).get(0);
    }
}
