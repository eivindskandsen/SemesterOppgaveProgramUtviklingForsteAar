package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderJobj implements FileOpener {
    public static DataCollection readJobjFile(Path path) throws IOException, InvalidPrisException, InvalidNameException, javax.naming.InvalidNameException, InvalidDelException{
        DataCollection plist = new DataCollection();
            try(InputStream inn = Files.newInputStream(path);
            ObjectInputStream oInn = new ObjectInputStream(inn)){
            plist = (DataCollection) oInn.readObject();



            } catch (ClassNotFoundException e) {
                e.printStackTrace();

        }
            System.out.print(plist);
        return plist;
    }
}
