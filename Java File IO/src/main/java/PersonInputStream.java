import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PersonInputStream {

     BufferedWriter writer;

    {
        try {
            writer = new BufferedWriter(new FileWriter("person.txt"));
            writer.write("Name: Adit, Age: 23");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
