package exceptionhandling;

public class InvalidStringException extends RuntimeException{
    public InvalidStringException(String msg){
        super(msg);
    }
}
