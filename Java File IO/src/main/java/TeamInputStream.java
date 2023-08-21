import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TeamInputStream {

    String[] persons={"Name : A, Age: 15","Name : B, Age: 15","Name : C, Age: 15"};

    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("persons.txt"));
            writer.write("Writing to File.");
            for(String person:persons){
                writer.write("\n"+ person);
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
