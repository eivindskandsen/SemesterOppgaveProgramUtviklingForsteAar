package sample;

public class Regex {
    public static boolean regexName(String name) {
        String regexName = "[A-Za-z+_. ]+";
        return name.mathces(regexName);
    }
}
