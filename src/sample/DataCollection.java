package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;


public class DataCollection {
    private ObservableList<Pc> list= FXCollections.observableArrayList();

public void attachTableView(TableView tv) { tv.setItems(list);}

    public void addElement(Pc obj) {list.add(obj);}

    public ObservableList<Pc> getList() {
        return list;
    }
}
