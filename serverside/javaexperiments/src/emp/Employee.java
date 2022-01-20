package emp;

public class Employee {

    private int id;
    private String name;
    private byte age;


    public Employee(int id, String name, byte age){
        this.id=id;
        setName(name);
        setAge(age);
    }

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }
    public String getName(){
     return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return id+"-"+name+"-"+age;
    }
}
