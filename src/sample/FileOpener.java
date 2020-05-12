package sample;

import sun.security.provider.ParameterCache;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public interface FileOpener {
    public static ArrayList<Pc> readTextFile(Path path) throws IOException{
        return null;
    }
    public static ArrayList<Pc> readJobjFile(Path path) throws IOException, InvalidPrisException, InvalidNameException, javax.naming.InvalidNameException, InvalidDelException, ClassNotFoundException{
        return null;
    }
}
