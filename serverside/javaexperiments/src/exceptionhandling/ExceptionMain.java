package exceptionhandling;

public class ExceptionMain {

    public static void main(String args[]) {
        Concat concat = new Concat();
        String result = concat.add("hi", null);
        System.out.println("result=" + result);

    }
}
