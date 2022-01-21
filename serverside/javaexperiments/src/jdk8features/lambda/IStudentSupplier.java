package jdk8features.lambda;

import emp.Student;

@FunctionalInterface
public interface IStudentSupplier {

    Student  newStudent();

}
