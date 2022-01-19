package exp.calcy;

public class Hello {

    public static void main(String[] args) {
        String s1=new String("hello");
        String s2=new String("hello");
        boolean isSame=s1==s2;
        boolean isEqual=s1.equals(s2);
        System.out.println("same objects="+isSame +" is equal="+isEqual);

    }
}
