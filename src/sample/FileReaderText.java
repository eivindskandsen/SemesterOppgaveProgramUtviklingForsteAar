package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileReaderText implements FileOpener{
    public static DataCollection readTextFile(Path path) throws IOException, InvalidPrisException, InvalidNameException, javax.naming.InvalidNameException, InvalidDelException {
        DataCollection plist = new DataCollection();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String string;
            while ((string = reader.readLine()) != null) {
                string = string.replaceAll("(\\[)|(, )|(])","");
                System.out.print(string);
                String [] splittLinje = string.split(",");

                if(splittLinje.length == 3){

                    String navn = splittLinje[0];
                    String del = splittLinje[1];
                    int pris = Integer.parseInt(splittLinje[2]);

                    Pc p = new Pc(navn, del, pris);
                    plist.addElement(p);
                }
                else{

                }
            }
        }
        return plist;
    }
}
