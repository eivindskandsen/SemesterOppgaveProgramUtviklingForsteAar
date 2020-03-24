package sample;

public class PcValidator {
    static boolean isValidName(String navn) {
        if (navn.isEmpty() || navn.length() > 50 || !Regex.regexName(navn)) {
            return false;
        }else{
            return true;
        }
    }
}
