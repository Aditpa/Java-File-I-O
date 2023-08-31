import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        File filePath = new File("src/main/resources/data.cvs");
        File teamsFile = new File("src/main/resources/teams.csv");


        try {
            Person person1 = new Person("johny", "Rock", 23);
            PersonOutputStream personOutputStream = new PersonOutputStream(filePath);
            personOutputStream.writePerson(person1);
            personOutputStream.flushAndClose();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        List<Person>team=new ArrayList<>();
        team.add(new Person("johny","bonny",99));
        team.add(new Person("johny1","bonny",99));
        team.add(new Person("johny2","bonny",99));
        team.add(new Person("johny3","bonny",99));


        List<Person>team2=new ArrayList<>();
        team.add(new Person("johny","Gucci",99));
        team.add(new Person("johny1","Gucci",99));
        team.add(new Person("johny2","Gucci",99));
        team.add(new Person("johny3","Gucci",99));

        try {
            TeamOutputStream teamOutputStream = new TeamOutputStream(teamsFile);
            teamOutputStream.writeTeam(team);
            teamOutputStream.writeTeam(team2);
            teamOutputStream.flushAndClose();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
        List<List<Person>> teamList=new ArrayList<>();
        TeamInputStream teamInputStream = new TeamInputStream(teamsFile);
        List<Person> currentTeam;
        while ((currentTeam=teamInputStream.nextTeam()) !=null){
            teamList.add(currentTeam);
        }
            System.out.println("Read " + teamList.size() + " teams!");
            System.out.println("Team sizes: " + teamList.stream().map(List::size).toList());
            System.out.println("teamList = " + teamList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

