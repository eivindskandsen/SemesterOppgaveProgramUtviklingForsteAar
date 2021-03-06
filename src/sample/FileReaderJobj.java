package sample;

import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileReaderJobj implements FileOpener {
    public static DataCollection readJobjFile(Path path) throws IOException, InvalidPrisException, InvalidNameException, javax.naming.InvalidNameException, InvalidDelException, ClassNotFoundException{
        DataCollection plist = new DataCollection();
            try(InputStream inn = Files.newInputStream(path);
            ObjectInputStream s = new ObjectInputStream(inn)){
                plist.addAll((ObservableList<Pc>) s.readObject());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();

        }
        return plist;
    }
}
