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
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("(\\[)|(])","");
                String [] splittLinje = line.split(",");

                if(splittLinje.length == 3){

                    String navn = splittLinje[0];
                    String del = splittLinje[1];
                    int pris = Integer.parseInt(splittLinje[2].replaceAll("( )",""));
                    System.out.print(line);
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
