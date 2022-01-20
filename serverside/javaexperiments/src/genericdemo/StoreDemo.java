package genericdemo;

public class StoreDemo {

    public static void main(String args[]){
        Store<String> store=new Store<>();
        store.add("hello");
        String val=store.getValue();

    }
}
