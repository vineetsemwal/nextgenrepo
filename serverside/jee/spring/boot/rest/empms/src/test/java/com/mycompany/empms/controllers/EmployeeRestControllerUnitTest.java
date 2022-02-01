package com.mycompany.empms.controllers;

import com.mycompany.empms.dto.EmployeeDetails;
import com.mycompany.empms.exceptions.EmployeeNotFoundException;
import com.mycompany.empms.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeRestControllerUnitTest {

    @Mock
    IEmployeeService employeeService;

    @InjectMocks
    @Spy
    EmployeeRestController controller;

    @Test
    public void testFetchById_1()throws Exception {
        long id=10;
        EmployeeDetails response=mock(EmployeeDetails.class);
        when(employeeService.findEmployeeDetailsById(id)).thenReturn(response);
        EmployeeDetails found=controller.fetchById(id);
        assertEquals(response, found);
        verify(employeeService).findEmployeeDetailsById(id);
    }

}