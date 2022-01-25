package com.mycompany.testdemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorUnitTest1 {
    Calculator spy;
    Adder adder;

/*
    @BeforeAll
    public static void oneTimeInit() {
        System.out.println("inside oneTimeInit");
    }*/

    @BeforeEach
    public void setup() {
        System.out.println("inside setup");
        adder = mock(Adder.class);
        System.out.println(adder);
        Calculator calculator = new Calculator(adder);
        spy = spy(calculator);
    }

    @AfterEach
    public void clear() {
        System.out.println("inside clear");
    }

    /**
     * scenaio : when numbers are positive
     * input: num1=5, num2=7
     * expectation : 12
     */
    @Test
    public void testAdd_1() {
        System.out.println("inside testAdd_1");
        when(adder.add(5, 7)).thenReturn(12);
        int result = spy.add(5, 7);
        assertEquals(12, result);
        verify(adder).add(5, 7);
    }

    @Test
    public void testAddBy10_1() {
        int num1 = 5;
        doReturn(15).when(spy).add(num1, 10);
        int result = spy.addBy10(num1);
        assertEquals(15, result);
        verify(spy).add(num1, 10);
    }


    /**
     * scenario: when one of the string is null
     * expectation : InvalidStringException occurs
     */
    @Test
    public void testAdd_string_1() {
        System.out.println("inside testAdd_string_1");
        String str1 = null;
        String str2 = "hello";
        //use donothing when you are mocking void methods
        doNothing().when(spy).someThing1();
        //use doThrow when you want to mock a void method throwing exception
        doThrow(UnsupportedOperationException.class).when(spy).someThing2();
        Executable executable = () -> spy.add(str1, str2);
        assertThrows(InvalidStringException.class, executable);
        verify(spy).someThing1();
        verify(spy).someThing2();
    }




}