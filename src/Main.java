import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        //Reading volleyball players from VolleyballPlayersTeam1.csv
        ArrayList<VolleyballPlayer> volleyballPlayersTeam1;
        volleyballPlayersTeam1 = loadPlayersList("VolleyballPlayersTeam1.csv");
        for (VolleyballPlayer volleyballPlayer:volleyballPlayersTeam1) {
            System.out.println(volleyballPlayer);
        }

        //Reading info about team1 from VolleyballTeam1.csv and setting players
        VolleyballTeam volleyballTeam1 = loadTeam("VolleyballTeam1.csv");
        volleyballTeam1.setVolleyballPlayers(volleyballPlayersTeam1);
        volleyballTeam1.calculateStrength();
        System.out.println(volleyballTeam1);

        //Reading volleyball players from VolleyballPlayersTeam2.csv
        ArrayList<VolleyballPlayer> volleyballPlayersTeam2;
        volleyballPlayersTeam2 = loadPlayersList("VolleyballPlayersTeam2.csv");
        for (VolleyballPlayer volleyballPlayer:volleyballPlayersTeam2) {
            System.out.println(volleyballPlayer);
        }

        //Reading info about team2 from VolleyballTeam2.csv and setting players
        VolleyballTeam volleyballTeam2 = loadTeam("VolleyballTeam2.csv");
        volleyballTeam2.setVolleyballPlayers(volleyballPlayersTeam2);
        volleyballTeam2.calculateStrength();
        System.out.println(volleyballTeam2);

        //testing the methods train and rest
        volleyballTeam1.rest();
        volleyballTeam2.train();

        //testing playMatch method
        volleyballTeam1.playMatch(volleyballTeam1, volleyballTeam2);

        //saving the new info about players and teams
        saveToCSVVolleyballPlayers(volleyballPlayersTeam1, "resultsFromTeam1Players.csv");
        saveToCSVVolleyballPlayers(volleyballPlayersTeam2, "resultsFromTeam2Players.csv");
        saveToCSVVolleyballTeam(volleyballTeam1, "resultsTeam1.csv");
        saveToCSVVolleyballTeam(volleyballTeam2, "resultsTeam2.csv");
    }
    public static ArrayList<VolleyballPlayer> loadPlayersList(String file){
        ArrayList<VolleyballPlayer> volleyballPlayers = new ArrayList<>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            String [] tempArr;
            while((line = bufferedReader.readLine()) !=null){
                VolleyballPlayer volleyballPlayer = new VolleyballPlayer();
                tempArr = line.split(",");
                volleyballPlayer.setName(tempArr[0]);
                volleyballPlayer.setPosition(tempArr[1]);
                volleyballPlayer.setAge(Integer.parseInt(tempArr[2]));
                volleyballPlayer.setSkills(Integer.parseInt(tempArr[3]));
                volleyballPlayer.setCondition(Integer.parseInt(tempArr[4]));
                volleyballPlayers.add(volleyballPlayer);
            }
            bufferedReader.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return volleyballPlayers;
    }
    public static VolleyballTeam loadTeam(String file){
        VolleyballTeam volleyballTeam = new VolleyballTeam();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            String [] tempArr;
            while((line = bufferedReader.readLine()) !=null){
                tempArr = line.split(",");
                volleyballTeam.setName(tempArr[0]);
                volleyballTeam.setStadium(tempArr[1]);
                volleyballTeam.setTrainer(tempArr[2]);
            }
            bufferedReader.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return volleyballTeam;
    }
    public static void saveToCSVVolleyballPlayers(ArrayList<VolleyballPlayer>volleyballPlayers, String file){
        try{
            PrintWriter writer = new PrintWriter(file);
            for (VolleyballPlayer player:volleyballPlayers) {
                writer.println(player.toString());
            }
            writer.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public static void saveToCSVVolleyballTeam(VolleyballTeam volleyballTeam, String file){
        try{
            PrintWriter writer = new PrintWriter(file);
            writer.println(volleyballTeam.toString());
            writer.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}