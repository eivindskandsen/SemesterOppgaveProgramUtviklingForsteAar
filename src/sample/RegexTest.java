package sample;

import static org.junit.jupiter.api.Assertions.*;

class RegexTest {

    @org.junit.jupiter.api.Test
    void regexName() {
        assertTrue(Regex.regexName("Eivind"));
        assertTrue(Regex.regexName("Eivind Skandsen"));

        assertFalse(Regex.regexName(""));
        assertFalse(Regex.regexName("1246721"));
    }

    @org.junit.jupiter.api.Test
    void regexDel() {
        assertTrue(Regex.regexName("Skjerm"));
        assertTrue(Regex.regexName("Skjerm kort"));

        assertFalse(Regex.regexName(""));
        assertFalse(Regex.regexName("1246721"));
    }
}