import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TeamInputStream {


    private final BufferedReader bufferedReader;
    private final PersonInputStream personInputStream;

    public TeamInputStream(File file) throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(file));
        personInputStream= new PersonInputStream(bufferedReader);
    }
    public List<Person> nextTeam() throws IOException {
        String prefix="; TeamLength: ";
        String line;
        if((line =bufferedReader.readLine()) !=null && !line.isBlank() && line.startsWith(prefix)){
            try{
                int teamSize = Integer.parseInt(line.substring(prefix.length()));
                List<Person> team= new ArrayList<>();
                for(int i =0; i < teamSize; i++){
                    team.add(personInputStream.nextPerson());
                }
                return team;
            }catch (NumberFormatException e) {
                throw new IOException("Team length identifier malformed: " + line);
            }

        }
        return null;
    }
    public void close() throws IOException {
        personInputStream.close();
    }

}
