import java.io.*;

public class PersonOutputStream {

    FileWriter writer;

    public PersonOutputStream(FileWriter  writer) {
        this.writer = writer;
    }
    public PersonOutputStream(File file) throws IOException {
        this.writer= new FileWriter(file);
    }


    public void writePerson(Person person) throws IOException {
        writer.write(person.getFirstName()+", "+person.getLastName()+", "+person.getAge());
    }

    public void flushAndClose() throws IOException {
        writer.flush();
        writer.close();
    }
}
