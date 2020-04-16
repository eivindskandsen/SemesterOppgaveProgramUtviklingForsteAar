
import sample.Regex;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


class RegexTest {

    @org.junit.jupiter.api.Test
    void regexName() {

          assertTrue(Regex.regexName("Eivind"));
        assertTrue(Regex.regexName("Eivind Skandsen"));

        assertFalse(Regex.regexName(""));
        assertFalse(Regex.regexName(";"));

        assertTrue(Regex.regexName("Eivind123"));
        assertTrue(Regex.regexName("Eivind Skandsen123"));

        assertFalse(Regex.regexName(""));
        assertFalse(Regex.regexName("%&¤#(/"));

    }

    @org.junit.jupiter.api.Test
    void regexDel() {
        assertTrue(Regex.regexDel("Skjerm"));
        assertTrue(Regex.regexDel("Skjerm kort"));


        assertFalse(Regex.regexDel(""));
        assertFalse(Regex.regexDel(";"));



        assertFalse(Regex.regexDel(""));
        assertFalse(Regex.regexDel("12345"));

    }
}