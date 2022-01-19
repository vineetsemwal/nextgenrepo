package exceptionhandling;

public class Concat {

    public  String add(String str1, String str2){
            if (str1 == null || str2 == null) {
                throw new InvalidStringException("str1 or st2 is null");
            }
            return str1 + str2;

    }

}
