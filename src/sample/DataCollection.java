package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import sun.nio.cs.ext.PCK;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class DataCollection {
    public transient ObservableList<Pc> list= FXCollections.observableArrayList();

    public void attachTableView(TableView tv) { tv.setItems(list);}

    public void addElement(Pc obj) {list.add(obj);}

    public void deleteElement(Pc obj){list.remove(obj);}

    public int calculatePrice(){

    int totalPris=0;
        for (Pc komponent: list){
            totalPris=totalPris+ komponent.getPris();
        }
        return totalPris;
    }

    public ObservableList<Pc> getList() {
        return list;
    }

    public void writeObject(ObjectOutputStream s) throws IOException{
        s.defaultWriteObject();
        s.writeObject(new ArrayList<>(list));
    }

    public void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException{
        List<Pc> plist = (List<Pc>) s.readObject();
        list = FXCollections.observableArrayList();
        list.addAll(plist);
    }



}
