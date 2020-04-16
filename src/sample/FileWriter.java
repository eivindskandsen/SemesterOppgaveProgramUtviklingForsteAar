package sample;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileWriter {

    public static void save(Path path, String star) throws IOException{}

    public static void saveJobj (List<?> obj, Path path) throws IOException{}
}
