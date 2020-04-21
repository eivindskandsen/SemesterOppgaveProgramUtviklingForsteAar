package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
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
    private Button btnSave;

    @FXML
    private Button butttonSlett;

    @FXML
    private TableView<Pc> tableView;

    @FXML
    private TableColumn<Pc, String> navnColumn;

    @FXML
    private TableColumn<Pc, String> delColumn;

    @FXML
    private TableColumn<Pc, Integer> prisColumn;


    ObservableList<Pc> etArray= FXCollections.observableArrayList();
    DataCollection collection= new DataCollection();
    IntegerStringConverter integerStringConverter= new IntegerStringConverter();

    public void initialize(URL url, ResourceBundle resourceBundle){
        collection.attachTableView(tableView);
        prisColumn.setCellFactory(TextFieldTableCell.forTableColumn(integerStringConverter));
    }

    private void resetTextFields(){
        txtNavn.setText("");
        txtDel.setText("");
        txtPris.setText("");
    }

    private Pc createPcFromGUI(){
        String innNavn=txtNavn.getText();
        String innDel=txtDel.getText();
        String innPris=txtPris.getText();

        Pc enPc= null;

        try {
            int intPris = Integer.parseInt(innPris);

            enPc = new Pc(innNavn, innDel, intPris);


        }catch(InvalidDelException e){
            e.printStackTrace();
            txtDel.setText(e.getMessage());
        }catch(InvalidPrisException e){
            e.printStackTrace();
            txtPris.setText(e.getMessage());
        } catch (javax.naming.InvalidNameException e) {
            e.printStackTrace();
            txtNavn.setText(e.getMessage())  ;
        }catch(NumberFormatException e){
            e.printStackTrace();
            txtPris.setText("Feil i konvertering");
        } 

        return enPc;

    }



    public void actionButtonLeggTil(javafx.event.ActionEvent actionEvent) {
        Pc nyPc = createPcFromGUI();{
            if(nyPc != null){

                collection.addElement(nyPc);
                resetTextFields();
            }
        }
    }
    @FXML
    void actionButtonSlett(ActionEvent event) {

            Pc component= tableView.getSelectionModel().getSelectedItem();
            collection.deleteElement(component);

    }



    public void endreNavn(TableColumn.CellEditEvent<Pc, String> cellEditEvent) {
        System.out.println(cellEditEvent.getNewValue());
        try {
            cellEditEvent.getRowValue().setNavn(cellEditEvent.getNewValue());
        } catch (javax.naming.InvalidNameException e) {
            System.out.println(e.getMessage());
        }
        tableView.refresh();


    }


    public void endreDel(TableColumn.CellEditEvent<Pc, String> cellEditEvent){
        System.out.println(cellEditEvent.getNewValue());
        try{
            cellEditEvent.getRowValue().setDel(cellEditEvent.getNewValue());
        }catch (InvalidDelException e){
            System.out.println(e.getMessage());
        }
    }

    public void endrePris(TableColumn.CellEditEvent<Pc, Integer> cellEditEvent){
        System.out.println(cellEditEvent.getNewValue());
        if(integerStringConverter.wasSuccessful()) {
            try {
                cellEditEvent.getRowValue().setPris(cellEditEvent.getNewValue());
            } catch (InvalidPrisException e) {
                System.out.println(e.getMessage());
            }
        }
    }



    public void save() {
        FileChooser save = new FileChooser();
        FileChooser.ExtensionFilter saveTxt = new FileChooser.ExtensionFilter("Txt File (*.txt)", "*.txt");
        save.getExtensionFilters().addAll(saveTxt);
        File fil = save.showSaveDialog(null);
        String star = PcFormater.formatPc((Pc) collection);
        System.out.print(star);
        try {
            WriterText.save(fil.toPath(), star);
        } catch (IOException e) {
            System.out.print("Noe gikk galt" + e.getMessage());
        }
    }



    }


