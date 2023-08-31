import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TeamOutputStream {


    private final FileWriter writer;
    private final PersonOutputStream personOutputStream;

    public TeamOutputStream(File file) throws IOException {
        writer = new FileWriter(file);
        personOutputStream = new PersonOutputStream(writer);
    }

    public void writeTeam(List<Person> team) throws IOException {
        writer.write(String.format("; TeamLength: %d\n", team.size()));
        for (Person person : team) {
            personOutputStream.writePerson(person);
        }
    }

    public void flushAndClose() throws IOException {
        personOutputStream.flushAndClose();
    }



}
