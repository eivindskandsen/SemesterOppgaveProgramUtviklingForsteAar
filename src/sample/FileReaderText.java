package sample;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderText implements FileOpener{
    public static DataCollection readTextFile(Path path) throws IOException, InvalidPrisException, InvalidNameException, javax.naming.InvalidNameException, InvalidDelException {
        DataCollection plist = new DataCollection();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                    Pc pc = ParsePc.parsePc(line);
                    plist.addElement(pc);
                }
            }
        return plist;
    }
}
