package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


import javax.naming.InvalidNameException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Pc implements Serializable {
    private transient SimpleStringProperty Navn= new SimpleStringProperty("");
    private transient SimpleStringProperty Del= new SimpleStringProperty("");
    private transient SimpleIntegerProperty Pris= new SimpleIntegerProperty(0);

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

    public String toString(){
        return Navn.getValue()+", "+Del.getValue()+", "+Pris.getValue()+"\n";
    }

    private void writeObj(ObjectOutputStream s) throws IOException{
        s.defaultWriteObject();
        s.writeUTF(Navn.getValue());
        s.writeUTF(Del.getValue());
        s.writeInt(Pris.getValue());
    }

    public void readObj(ObjectInputStream s) throws IOException{
        String Navn = s.readUTF();
        String Del = s.readUTF();
        int Pris = s.readInt();

        this.Navn = new SimpleStringProperty(Navn);
        this.Del = new SimpleStringProperty(Del);
        this.Pris = new SimpleIntegerProperty(Pris);
    }

}
