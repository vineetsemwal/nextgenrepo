package jdk8features.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String args[]){
        IPrint printer1=(msg)->System.out.println(msg);
        Consumer<String>printer2=(msg)->System.out.println(msg);
        printer1.print("welcome1");
        printer2.accept("welcome2");

        IMultiplyConcat bi1=(msg,times)->{
          String result="";
          for(int i=0;i<times;i++){
              result=result+msg;
          }
          System.out.println(result);
        };

        bi1.concatAndPrint("welcome",4);

        BiConsumer<String,Integer>bi2=(msg,times)->{
            String result="";
            for(int i=0;i<times;i++){
                result=result+msg;
            }
            System.out.println(result);
        };
        bi2.accept("hello",5);

    }

}
