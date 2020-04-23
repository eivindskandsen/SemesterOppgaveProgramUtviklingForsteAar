package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.Collection;


public class DataCollection {
    private transient ObservableList<Pc> list= FXCollections.observableArrayList();

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
}
