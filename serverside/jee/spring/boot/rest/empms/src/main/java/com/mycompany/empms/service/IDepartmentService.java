package com.mycompany.empms.service;

import com.mycompany.empms.dto.AddDepartmentRequest;
import com.mycompany.empms.dto.DepartmentDetails;
import com.mycompany.empms.entity.Department;
import com.mycompany.empms.exceptions.DepartmentNotFoundException;

public interface IDepartmentService {

    DepartmentDetails add(AddDepartmentRequest requestData);

    Department findById(long deptId) throws DepartmentNotFoundException;

}
