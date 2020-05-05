package sample;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WriteJobj implements FileWriter {
    public static void saveJobj (List<?> obj, Path path) throws IOException{

        try(OutputStream stream = Files.newOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(stream);){
            for(Object ut : obj) {
            out.writeObject(ut);
            }
        }
    }
}
