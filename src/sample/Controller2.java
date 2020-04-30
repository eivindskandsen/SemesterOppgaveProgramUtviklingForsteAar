package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {



    @FXML
    private TableView<?> utvalgListe;

    @FXML
    private TableView<?> valgtListe;



    DataCollection collection2= new DataCollection();

    ObservableList<Pc> ettArray = sample.Controller.collection.getList();

    public void hentKomponentListe(){
        for(Pc komponent : ettArray){
            collection2.addElement(komponent);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        collection2.attachTableView(utvalgListe);

    }

    @FXML
    void hentData(ActionEvent event) {
        hentKomponentListe();

    }
}