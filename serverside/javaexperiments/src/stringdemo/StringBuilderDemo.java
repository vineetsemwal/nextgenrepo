package stringdemo;

public class StringBuilderDemo {

    public static void main(String args[]){
        StringBuilder builder = new StringBuilder();
        for(int i=1;i<=100;i++){
            builder.append(i);
        }

        System.out.println(builder);

    }
}
