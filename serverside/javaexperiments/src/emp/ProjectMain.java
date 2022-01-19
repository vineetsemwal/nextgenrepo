package emp;

public class ProjectMain {

    public static void main(String args[]){
        Employee employees[]=new Employee[5];
       Employee emp1=new Employee(1,"rajeev",(byte)25);
       Employee emp2=new Employee(2,"vinay",(byte)26);
       Manager emp3=new Manager(3,"remjith",(byte)27,"devteam");
       employees[0]=emp1;
       employees[1]=emp2;
       employees[2]=emp3;
       for(Employee iterated: employees ){
           if(iterated==null){
               continue;
           }
           System.out.println("employee "+iterated.getId()+" "+iterated.getName()+" "+iterated.getAge());
           boolean isManager=iterated instanceof Manager;
           if(isManager){
             Manager manager=(Manager) iterated;
               System.out.println("manager="+manager.getTeamName());
           }
       }

    }

}
