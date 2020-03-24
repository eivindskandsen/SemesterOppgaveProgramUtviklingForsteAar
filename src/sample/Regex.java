package sample;

import java.util.regex.Matcher;

public class Regex {
    public static boolean regexName(String name) {
        String regexName = "[A-Za-z+_. ]+";

        return name.matches(regexName);
    }
}
