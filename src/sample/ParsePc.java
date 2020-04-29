package sample;

import java.io.IOException;

public class ParsePc {
    public static Pc parsePc(String str) throws InvalidPcFormatException, InvalidPrisException, InvalidDelException, javax.naming.InvalidNameException, InvalidNameException {
        String[] strs = str.split(PcFormater.DELIMITER);
        if (strs.length != 3) throw new InvalidPcFormatException("Feil bruk av spesialtegn");

        if (!Regex.regexName(strs[0])) throw new InvalidNameException("Det er feil på et navn/fler av navnene i filen");

        if(!Regex.regexDel(strs[1])) throw new InvalidDelException("Feil i navnet på en del/fler av delene i filen");

        String navn = strs[0];
        String del = strs[1];
        int pris;
        try {
            pris = Integer.parseInt(strs[2]);
        } catch (NumberFormatException e) {
            throw new InvalidPcFormatException("Ugyldig pris");
        }
        return new Pc(navn, del, pris);
    }
}
