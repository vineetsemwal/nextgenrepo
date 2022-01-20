package emp;

public class Employee implements Comparable<Employee>{

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

    @Override
    public int hashCode() {
        return id;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj ==this){
            return true;
        }

        if(obj==null || !obj.getClass().equals(Employee.class)){
            return false;
        }
        Employee that=(Employee) obj;
        return id==that.id;
    }

    @Override
    public int compareTo(Employee other) {
       int compareCode=id-other.id;
       return compareCode;

    }
}
