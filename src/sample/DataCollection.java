package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.text.TableView;

public class DataCollection {
    private ObservableList<Pc> list= FXCollections.observableArrayList();

public void attachTableView(TableView tv) { tv.setItems(list)}
    }
