package emp;

public class IdentityEqualityEx {

    public static void main(String args[]){
        Employee emp1=new Employee(1,"sripad",(byte)26);
        Employee emp2=new Employee(1,"sripad",(byte)26);
        System.out.println("emp1 hash="+emp1.hashCode());
        System.out.println("emp2 hash="+emp2.hashCode());

        boolean isSame=emp1==emp2;
        boolean isEqual=emp1.equals(emp2);
        System.out.println("issamee="+isSame);
        System.out.println("isEqual="+isEqual);
    }


}
