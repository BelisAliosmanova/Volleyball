import java.util.ArrayList;
import java.util.Random;

public class VolleyballTeam implements Trainable, Restable{
    private String name;
    private String stadium;
    private String trainer;
    private ArrayList<VolleyballPlayer> volleyballPlayers;
    private double strength;

    public void calculateStrength(){
        this.strength=0;
        for (VolleyballPlayer volleyballPlayer:volleyballPlayers) {
            this.strength+=volleyballPlayer.getSkills();
        }
        this.strength/=volleyballPlayers.size();
        System.out.println("The average team skill for team  "+this.name + " is " +this.strength);
    }
    public void train(){
        System.out.println("THE WHOLE TEAM IS TRAINING -> team: "+this.name);
        for (VolleyballPlayer volleyballPlayer:volleyballPlayers) {
            volleyballPlayer.train();
        }
    }
    public void rest(){
        System.out.println("THE WHOLE TEAM IS RESTING -> team: "+this.name);
        for (VolleyballPlayer volleyballPlayer:volleyballPlayers) {
            volleyballPlayer.rest();
        }
    }
    public void playMatch(VolleyballTeam volleyballTeam1, VolleyballTeam volleyballTeam2){
        Random random = new Random();
        int random1 = random.nextInt(25)+1;
        int random2 = random.nextInt(25)+1;
        volleyballTeam1.strength+=random1;
        volleyballTeam2.strength+=random2;
        if(volleyballTeam1.strength==volleyballTeam2.strength){
            System.out.println("Results from the match --> THE MATCH ENDED IN A DRAW!");
        } else if(volleyballTeam1.strength>volleyballTeam2.strength){
            System.out.println("Results from the match --> VOLLEYBALL TEAM "+volleyballTeam1.name+" WON!!!");
        } else{
            System.out.println("Results from the match --> VOLLEYBALL TEAM "+volleyballTeam2.name+" WON!!!");
        }
    }

    public VolleyballTeam(String name, String stadium, String trainer, ArrayList<VolleyballPlayer> volleyballPlayers) {
        this.name = name;
        this.stadium = stadium;
        this.trainer = trainer;
        this.volleyballPlayers = volleyballPlayers;
    }

    public VolleyballTeam() {
        this.name = "noName";
        this.stadium = "noStadium";
        this.trainer = "noTrainer";
        this.volleyballPlayers = new ArrayList<VolleyballPlayer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public ArrayList<VolleyballPlayer> getVolleyballPlayers() {
        return volleyballPlayers;
    }

    public void setVolleyballPlayers(ArrayList<VolleyballPlayer> volleyballPlayers) {
        this.volleyballPlayers = volleyballPlayers;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "VolleyballTeam{" +
                "name='" + name + '\'' +
                ", stadium='" + stadium + '\'' +
                ", trainer='" + trainer + '\'' +
                ", volleyballPlayers=" + volleyballPlayers +
                ", strength=" + strength +
                '}';
    }
}
