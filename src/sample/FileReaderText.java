package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileReaderText implements FileOpener{
    public static ArrayList<Pc> readTextFile(Path path) throws IOException, InvalidPrisException, InvalidNameException, javax.naming.InvalidNameException, InvalidDelException {
        ArrayList<Pc> plist = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String string;
            while ((string = reader.readLine()) != null) {
                Pc p = ParsePc.parsePc(string);
                plist.add(p);
            }
        }
        return plist;
    }
}
