package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.naming.InvalidNameException;

public class Pc {
    private SimpleStringProperty Navn= new SimpleStringProperty("");
    private SimpleStringProperty Del= new SimpleStringProperty("");
    private SimpleIntegerProperty Pris= new SimpleIntegerProperty(0);

    Pc(String navn, String del, int pris){

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


}
