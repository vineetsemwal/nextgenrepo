package com.mycompany.testdemo;

public class Calculator {

    private Adder adder;
    public Calculator(Adder adder){
        this.adder=adder;
    }

    public int add(int num1, int num2){
        System.out.println("inside Calculator add");
       int result=adder.add(num1,num2);
        return result;
    }




    public int addBy10(int num){
        System.out.println("inside addBy10");
        int result=add(num,10);
        return result;
    }

    String add(String str1, String str2){
        someThing1();
        try {
            someThing2();
        }catch(UnsupportedOperationException e){
            System.out.println("it is ok, currently not completed"+e.getClass().getSimpleName());
        }
        if(str1==null ||str2==null){
         throw new InvalidStringException();
        }
        return str1+str2;
    }

   public void someThing1()
    {
        System.out.println("inside something1");
       // throw new UnsupportedOperationException("unsupported right now");
    }


    public void someThing2()
    {
        System.out.println("inside something2");
         throw new UnsupportedOperationException("unsupported right now");
    }
}
