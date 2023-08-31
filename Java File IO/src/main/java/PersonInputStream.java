import java.io.*;

public class PersonInputStream {

    private final BufferedReader reader;

    public PersonInputStream(BufferedReader bufferedReader) {
        this.reader = bufferedReader;
    }

    public PersonInputStream(File file) {
        try {
            this.reader =new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Person nextPerson(){
        String line;

        try {
            if((line= reader.readLine()) !=null){
                String[] parts=line.split(",");
                if(parts.length !=3 ){
                    throw new IOException();
                }
                return new Person(parts[0],parts[1],Integer.parseInt(parts[2]) );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void close() throws IOException {
        reader.close();
    }

}
