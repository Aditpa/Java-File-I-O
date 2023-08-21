import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TeamOutputStream {

    BufferedReader reader;


    {
        try {
            reader = new BufferedReader(new FileReader("persons.txt"));
            String person;
            while ((person=reader.readLine()) !=null){
            System.out.println(person);
            }
            reader.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
