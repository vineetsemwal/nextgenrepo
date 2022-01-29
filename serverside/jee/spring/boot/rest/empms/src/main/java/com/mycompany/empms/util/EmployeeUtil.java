package com.mycompany.empms.util;

import com.mycompany.empms.dto.EmployeeDetails;
import com.mycompany.empms.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeUtil {

   public EmployeeDetails toEmployeeDetails(Employee employee){
       EmployeeDetails details = new EmployeeDetails();
       details.setId(employee.getId());
       details.setName(employee.getName());
       details.setAge(employee.getAge());
       return details;
   }

}
