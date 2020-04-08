package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.util.ArrayList;


public class Controller {
    @FXML
    private Label lblNavn;

    @FXML
    private Label lblDel;

    @FXML
    private Label lblPris;

    @FXML
    private TextField txtNavn;

    @FXML
    private TextField txtDel;

    @FXML
    private TextField txtPris;

    @FXML
    private Button buttonLeggTil;

    @FXML
    private TableColumn<Pc, String> navnColumn;

    @FXML
    private TableColumn<Pc, String> delColumn;

    @FXML
    private TableColumn<Pc, Integer> prisColumn;


    ArrayList<Pc> etArray= new ArrayList<>();
    DataCollection collection= new DataCollection();
}
