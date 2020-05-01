package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {



    @FXML
    private TableView<Pc> utvalgListe;

    @FXML
    private TableView<Pc> valgtListe;

    @FXML
    private TextField txtTotalPris;



    DataCollection collection2= new DataCollection();
    DataCollection collection3=new DataCollection();

    ObservableList<Pc> ettArray = sample.Controller.collection.getList();

    public void hentKomponentListe(){
        for(Pc komponent : ettArray){
            collection2.addElement(komponent);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        collection2.attachTableView(utvalgListe);
        collection3.attachTableView(valgtListe);

    }

    @FXML
    void hentData(ActionEvent event) {
        hentKomponentListe();

    }

    @FXML
    void leggTilIValgt(ActionEvent event) {
        Pc component= utvalgListe.getSelectionModel().getSelectedItem();
        collection3.addElement(component);

    }

    @FXML
    void slettFraValgt(ActionEvent event) {
        Pc component= valgtListe.getSelectionModel().getSelectedItem();
        collection3.deleteElement(component);
    }

    @FXML
    void regnUtTotalPris(ActionEvent event) {
        Integer totalPris=collection3.calculatePrice();
        txtTotalPris.setText(totalPris.toString());
    }
}