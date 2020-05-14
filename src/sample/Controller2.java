package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Controller2 implements Initializable {



    @FXML
    private TableView<Pc> utvalgListe;

    @FXML
    private TableView<Pc> valgtListe;

    @FXML
    private TextField txtTotalPris;

    @FXML
    private Button saveValgt;

    @FXML
    private Button loadValgt;

    @FXML
    private Label txtError;

    @FXML
    private TextField txtFilter;

    DataCollection collection2= new DataCollection();
    DataCollection collection3=new DataCollection();



    public void hentKomponentListe(){
        Path path = Paths.get("superBruker2.txt");
        try{
        collection2.addAll(FileReaderText.readTextFile(path).getList());
        }catch (IOException | InvalidPrisException | InvalidNameException | InvalidDelException | javax.naming.InvalidNameException e){
            txtError.setText("Noe gikk galt");
        }
        collection2.attachTableView(utvalgListe);
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
        if (utvalgListe.getSelectionModel().getSelectedItem() != null) {
            Pc component = utvalgListe.getSelectionModel().getSelectedItem();
            collection3.addElement(component);

        }
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

    public void saveValgt() {
        FileChooser saveValgt = new FileChooser();
        FileChooser.ExtensionFilter saveTxt = new FileChooser.ExtensionFilter("Txt File (*.txt)", "*.txt");
        saveValgt.getExtensionFilters().addAll(saveTxt);
        File fil = saveValgt.showSaveDialog(null);

        String str = PcFormater.formatPCer(collection3.getList());
        try{
            WriterText.save(str, fil.toPath());
        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }
    }

    public void loadValgt(){
        FileChooser load = new FileChooser();
        load.setTitle("Select file");
        //Velger hvilke type filer du kan velge mellom
        FileChooser.ExtensionFilter loadTxt = new FileChooser.ExtensionFilter("Txt File (*.txt)", "*.txt");

        load.getExtensionFilters().addAll(loadTxt);
        // AApner opp vinduet der du kan velge filer
        File fil = load.showOpenDialog(null);

        try{
            collection3.addAll(FileReaderText.readTextFile(fil.toPath()).getList());
        } catch (IOException | InvalidNameException | javax.naming.InvalidNameException | InvalidPrisException | InvalidDelException e) {
            txtError.setText(e.getMessage());
        }
    }

    @FXML
    private void search(KeyEvent e){
        if(e.getCode() == (KeyCode.ENTER)){

            ObservableList<Pc> filtrertListe = collection2.getList().stream().filter(i -> ((i.getNavn().contains(txtFilter.getText())) || (i.getDel().contains(txtFilter.getText())) || (Integer.toString(i.getPris()).equals(txtFilter.getText())))).collect(Collectors.toCollection(FXCollections::observableArrayList));
            utvalgListe.setItems(filtrertListe);

        }
    }
}