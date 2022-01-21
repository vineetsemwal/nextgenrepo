package jdk8features.lambda;

public class LambdaDemo1 {

    public static void main(String args[]){
      IPrint printer1=new IPrint(){
          @Override
          public void print(String msg) {
              System.out.println("printing message "+msg);
          }
      };

      printer1.print("welcome1");

      IPrint printer2=msg->System.out.println("printing message "+msg);
      printer2.print("welcom2");

        IPrint printer3=msg->{
            System.out.println("printing message "+msg);
        };
        printer3.print("welcome3");

    }
}
