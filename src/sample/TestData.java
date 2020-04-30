package sample;

import javafx.collections.ObservableList;

public class TestData {

    public void addTestData(ObservableList<Pc> liste){
        try {
            Pc nummer1 = new Pc("GTX 500", "Skjermkort", 250);
            Pc nummer2=new Pc("Samsung 300", "Skjerm", 300);
            Pc nummer3= new Pc("Intel I7", "CPU", 500);

            liste.addAll(nummer1, nummer2, nummer3);

        }catch(InvalidDelException e){
            System.out.println(e);
        }catch(InvalidPrisException e){
            System.out.println(e);
        }catch(javax.naming.InvalidNameException e){
            System.out.println(e);
        }



    }



}
