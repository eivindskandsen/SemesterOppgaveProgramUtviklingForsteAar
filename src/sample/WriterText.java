package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterText implements FileWriter {
    public static void save(Path path, List<?> obj) throws IOException{
        Files.write(path, obj.toString().getBytes());
    }

    public void writeFile(){

    }
}
