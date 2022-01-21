package jdk8features.lambda;

import emp.Student;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args){
        IStudentSupplier supplier1=()->new Student();

        Student student1 =supplier1.newStudent();
        System.out.println("object from supplier="+student1);
       ISupplyRandomNumber supplier2=()->10;
       int randomNumber1=supplier2.randomNumber();
        System.out.println("number from supplier"+randomNumber1);

        Supplier<Student>supplier3=()->new Student();
        Student student2=supplier3.get();
        System.out.println("new student obect from supplier3"+student2);
        Supplier<Integer>supplier4=()->20;
        int randomNumber2=supplier4.get();
        System.out.println("random number from supplier 4"+randomNumber2);


    }

}
