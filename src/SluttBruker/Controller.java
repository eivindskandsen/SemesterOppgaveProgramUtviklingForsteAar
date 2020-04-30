package SluttBruker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ObservableList list = FXCollections.observableArrayList();

    @FXML
    private TableView<?> utvalgListe;

    @FXML
    private TableView<?> valgtListe;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}