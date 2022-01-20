package genericdemo;

public class Store<E> {
    private E value;
    public void add(E e){
        this.value=e;
    }
    public E getValue(){
        return value;
    }

}
