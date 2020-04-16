package sample;

import java.util.regex.Matcher;

public class Regex {
    public static boolean regexName(String name) {
        String regexName = "[A-Za-z0-9+_. ]+";

        return name.matches(regexName);
    }

    public static boolean regexDel(String del){
        String regexDel= "[A-Za-z+_. ]+";

        return del.matches(regexDel);
    }
}
