package sample;

import java.util.ArrayList;
import java.util.List;

public class PcFormater {
    public static String DELIMITER = ";";

    public static String formatPc(Pc p){
        return p.getNavn()+DELIMITER+p.getDel()+DELIMITER+p.getPris();
    }
    public static String formatPCer(ArrayList<Pc> pclist){
        StringBuffer str = new StringBuffer();
        for (Pc p : pclist){
            str.append(formatPc(p));
            str.append("\n");
        }
        return str.toString();
    }
}
