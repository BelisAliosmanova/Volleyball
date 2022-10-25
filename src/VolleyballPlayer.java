public class VolleyballPlayer implements Trainable, Restable{
    private String name;
    private int age;
    private String position;
    private int skills;//1-10
    private int condition;//1-5

    public void train(){
        if(this.condition>1 && this.skills<10) {
            System.out.println(this.name +" is training...");
            this.skills++;
            this.condition--;
        } else{
            System.out.println(this.name + " cannot train...");
        }
    }
    public void rest(){
        if(this.condition<5) {
            System.out.println(this.name + " is resting...");
            this.condition++;
        } else{
            System.out.println(this.name + " cannot rest...");
        }
    }
    public VolleyballPlayer(){
        this.name = "noName";
        this.age = 0;
        this.position = "noPosition";
        this.skills = 0;
        this.condition = 0;
    }

    public VolleyballPlayer(String name, int age, String position, int skills, int condition) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.skills = skills;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSkills() {
        return skills;
    }
    public void setSkills(int skills) {
        if(skills>=1 && skills<=10) {
            this.skills = skills;
        } else{
            System.out.println("Incorrect skills input!!!");
        }
    }
    public int getCondition() {
        return condition;
    }
    public void setCondition(int condition) {
        if(condition>=1 && condition<=5) {
            this.condition = condition;
        } else{
            System.out.println("Incorrect condition input!!!");
        }
    }

    @Override
    public String toString() {
        return "VolleyballPlayer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", skills=" + skills +
                ", condition=" + condition +
                '}';
    }
}
