package mapex;

public class CompositeKey implements Comparable<CompositeKey>{

   private String firstName;

   private String lastName;

   private String joinedKey;

   public CompositeKey(String firstName, String lastName){
       this.firstName=firstName;
       this.lastName=lastName;
       joinedKey=firstName+lastName;
   }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int compareTo(CompositeKey that) {
        return joinedKey.compareTo(that.joinedKey);
    }

    @Override
    public boolean equals(Object obj) {
       if(this==obj){
           return true;
       }
       if(obj==null || !(obj.getClass().equals(CompositeKey.class))){
           return false;
       }
       CompositeKey that=(CompositeKey)obj;
       return joinedKey.equals(that.joinedKey);
    }

    @Override
    public int hashCode() {
        return joinedKey.hashCode();
    }

    @Override
    public String toString() {
        return firstName+"-"+lastName;
    }
}
