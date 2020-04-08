package sample;

public class ParsePc {
    public static Pc parsePc(String str) throws InvalidPcFormatException, InvalidNameException, InvalidPrisException, InvalidDelException, javax.naming.InvalidNameException {
        String[] strs = str.split(PcFormater.DELIMITER);
        if(strs.length != 3){
            throw new InvalidPcFormatException("Feil bruk av spesialtegn");
        }

        String navn = strs[0], del = strs[1];
        int pris;
        try{
            pris = Integer.parseInt(strs[2]);
        }catch(NumberFormatException e){
            throw new InvalidPcFormatException("Ugyldig pris");
        }
        return new Pc(navn, del, pris);
    }
}
