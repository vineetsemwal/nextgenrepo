package emp;

public class Manager extends Employee{

    private String teamName;

    public Manager(int id, String name, int age, String teamName){
        super(id,name,(byte)age);
        this.teamName = teamName;

    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
