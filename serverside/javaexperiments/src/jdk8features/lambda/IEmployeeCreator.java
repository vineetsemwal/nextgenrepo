package jdk8features.lambda;

import emp.Employee;

@FunctionalInterface
public interface IEmployeeCreator {

    Employee newEmployee(int id, String name, byte age);

}
