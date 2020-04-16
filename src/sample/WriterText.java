package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterText implements FileWriter {
    public static void save(Path path, String star) throws IOException{
        Files.write(path, star.getBytes());
    }

    public void writeFile(){

    }
}
