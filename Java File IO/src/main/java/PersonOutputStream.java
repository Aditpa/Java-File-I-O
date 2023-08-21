import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PersonOutputStream {

    BufferedReader reader;


    {
        try {
            reader = new BufferedReader(new FileReader("person.txt"));
            System.out.println(reader.readLine());
            reader.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
