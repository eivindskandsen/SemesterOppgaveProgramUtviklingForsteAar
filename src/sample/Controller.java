package sample;




import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class Controller implements Initializable {
    @FXML
    private Label lblNavn;

    @FXML
    private Label lblDel;

    @FXML
    private Label lblPris;

    @FXML
    public Label txtError;

    @FXML
    private TextField txtNavn;

    @FXML
    private TextField txtDel;

    @FXML
    private TextField txtPris;

    @FXML
    private TextField txtTotalPris;

    @FXML
    private TextField txtFilter;

    @FXML
    private Button buttonLeggTil;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnLoad;

    @FXML
    private Button butttonSlett;

    @FXML
    private Button totalPris;

    @FXML
    private TableView<Pc> tableView;

    @FXML
    private TableColumn<Pc, String> navnColumn;

    @FXML
    private TableColumn<Pc, String> delColumn;

    @FXML
    private TableColumn<Pc, Integer> prisColumn;

    private ThreadLoad task;



    static DataCollection collection= new DataCollection();
    IntegerStringConverter integerStringConverter= new IntegerStringConverter();


    public void initialize(URL url, ResourceBundle resourceBundle){
        collection.attachTableView(tableView);
        prisColumn.setCellFactory(TextFieldTableCell.forTableColumn(integerStringConverter));

        Path path = Paths.get("superBruker2.txt");
        try{
            collection.addAll(FileReaderText.readTextFile(path).getList());
        } catch (IOException | InvalidNameException | javax.naming.InvalidNameException | InvalidPrisException | InvalidDelException e) {
            txtError.setText(e.getMessage());
        }

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

    @FXML
    void actionTotalPris(ActionEvent event) {
        Integer totalPris=collection.calculatePrice();

        txtTotalPris.setText(totalPris.toString());

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
        tableView.refresh();
    }

    public void endrePris(TableColumn.CellEditEvent<Pc, Integer> cellEditEvent){
        System.out.println(cellEditEvent.getNewValue());
        if(integerStringConverter.wasSuccessful()) {
            try {
                cellEditEvent.getRowValue().setPris(cellEditEvent.getNewValue());
            } catch (InvalidPrisException e) {
                System.out.println(e.getMessage());
            }
            tableView.refresh();
        }
    }



    public void save() {
        Path path = Paths.get("superBruker.Jobj");
        Path path2 = Paths.get("superBruker2.txt");
        String str = PcFormater.formatPCer(collection.getList());
        try{
            //Lagrer til Binary fil
            ArrayList<Pc> pcr = new ArrayList<>(collection.getList());
            WriteJobj.saveJobj(pcr, path);
            //Lagrer til tekst fil, siden jeg ikke fikk til aa bruke binary filen 
            WriterText.save(str, path2);
        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }
    }

    public void load() throws InvalidPrisException, InvalidNameException, InvalidDelException, javax.naming.InvalidNameException, IOException {
        Path path = Paths.get("superBruker2.txt");
        task = new ThreadLoad(FileReaderText.readTextFile(path).getList());
        task.setOnSucceeded(this::threadDone);
        task.setOnFailed(this::threadFailed);
        Thread th = new Thread(task);
        th.setDaemon(true);
        buttonLeggTil.setDisable(true);
        btnSave.setDisable(true);
        btnLoad.setDisable(true);
        butttonSlett.setDisable(true);
        totalPris.setDisable(true);
        tableView.setDisable(true);
        txtFilter.setDisable(true);
        th.start();
    }

    private void threadDone(WorkerStateEvent e){
        collection.addAll(task.getValue());
        buttonLeggTil.setDisable(false);
        btnSave.setDisable(false);
        btnLoad.setDisable(false);
        butttonSlett.setDisable(false);
        totalPris.setDisable(false);
        tableView.setDisable(false);
        txtFilter.setDisable(false);
    }

    private void threadFailed(WorkerStateEvent e){
       txtError.setText(e.getSource().getMessage());
        buttonLeggTil.setDisable(false);
        btnSave.setDisable(false);
        btnLoad.setDisable(false);
        butttonSlett.setDisable(false);
        totalPris.setDisable(false);
        tableView.setDisable(false);
        txtFilter.setDisable(false);
    }

    @FXML
    private void search(KeyEvent e){
        if(e.getCode() == (KeyCode.ENTER)){

            ObservableList<Pc> filtrertListe = collection.getList().stream().filter(i -> ((i.getNavn().contains(txtFilter.getText())) || (i.getDel().contains(txtFilter.getText())) || (Integer.toString(i.getPris()).equals(txtFilter.getText())))).collect(Collectors.toCollection(FXCollections::observableArrayList));
            tableView.setItems(filtrertListe);
        }

    }
}


