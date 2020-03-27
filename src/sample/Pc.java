package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.omg.CORBA.DynAnyPackage.Invalid;

import javax.naming.InvalidNameException;

public class Pc {
    private SimpleStringProperty Navn= new SimpleStringProperty("");
    private SimpleStringProperty Del= new SimpleStringProperty("");
    private SimpleIntegerProperty Pris= new SimpleIntegerProperty(0);

    Pc(String navn, String del, int pris) throws InvalidNameException, InvalidDelException, InvalidPrisException {
        setNavn(navn);
        setDel(del);
        setPris(pris);

    }

    public String getNavn(){
        return Navn.getValue();
    }

    public void setNavn(String navn) throws InvalidNameException {
        if(!PcValidator.isValidName(navn)){
            throw new InvalidNameException("Navn ikke godkjent");
        }else{
            this.Navn.setValue(navn);
        }

    }

    public String getDel(){
        return Del.getValue();
    }

    public void setDel(String del) throws InvalidDelException{
        if(!PcValidator.isValidDel(del)){
            throw new InvalidDelException("Navn på del ikke godkjent");
        }else{
            this.Del.setValue(del);
        }
    }

    public int getPris(){
        return Pris.getValue();
    }

    public void setPris(int pris) throws InvalidPrisException{
        if(!PcValidator.isValidPris(pris)){
            throw new InvalidPrisException("Pris ikke godkjent");
        }else{
            this.Pris.setValue(pris);
        }
    }


}
