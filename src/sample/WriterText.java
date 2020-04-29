package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class WriterText implements FileWriter {
    public static void save(String str, Path path) throws IOException{
        Files.write(path, str.getBytes());
    }
}
