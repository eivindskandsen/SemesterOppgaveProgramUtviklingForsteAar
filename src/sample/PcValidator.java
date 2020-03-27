package sample;

public class PcValidator {
    static boolean isValidName(String navn) {
        if (navn.isEmpty() || navn.length() > 50 || !Regex.regexName(navn)) {
            return false;
        }
            return true;

    }

    static boolean isValidDel(String del){
        if(del.isEmpty()|| del.length()> 50 || !Regex.regexDel(del)){
            return false;
        }
        return true;
    }

    static boolean isValidPris(int pris){
        if(pris<0){
            return false;
        }
        return true;
    }
}
