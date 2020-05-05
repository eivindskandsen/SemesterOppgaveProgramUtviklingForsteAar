package sample;

import javafx.collections.ObservableList;

public class TestData {

    public static void addTestData(ObservableList<Pc> liste){
        try {
            Pc nummer1 = new Pc("GTX 500", "Skjermkort", 250);
            Pc nummer2=new Pc("Samsung 300", "Skjerm", 300);
            Pc nummer3= new Pc("Intel I7", "CPU", 500);
            Pc nummer4= new Pc("Logitech", "Tastatur", 200);
            Pc nummer5= new Pc("Razor", "Mus", 150);

            liste.addAll(nummer1, nummer2, nummer3, nummer4, nummer5);

        }catch(InvalidDelException e){
            System.out.println(e);
        }catch(InvalidPrisException e){
            System.out.println(e);
        }catch(javax.naming.InvalidNameException e){
            System.out.println(e);
        }



    }



}
