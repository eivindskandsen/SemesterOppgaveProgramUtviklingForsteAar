package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


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
    private TableView<?> tableView;

    @FXML
    private TableColumn<Pc, String> navnColumn;

    @FXML
    private TableColumn<Pc, String> delColumn;

    @FXML
    private TableColumn<Pc, Integer> prisColumn;


    ArrayList<Pc> etArray= new ArrayList<>();
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

    private Pc createPersonFromGUI(){
        String innNavn=txtNavn.getText();
        String innDel=txtDel.getText();
        String innPris=txtPris.getText();

        Pc enPc= null;

        try{
            int intPris=Integer.parseInt(innPris);

            enPc= new Pc(innNavn, innDel, intPris);
        }catch(InvalidNameException e){
            e.printStackTrace();
            txtNavn.setText(e.getMessage());
        }catch(InvalidDelException e){
            e.printStackTrace();
            txtDel.setText(e.getMessage());
        }catch(InvalidPrisException e){
            e.printStackTrace();
            txtPris.setText(e.getMessage());
        } catch (javax.naming.InvalidNameException e) {
            e.printStackTrace();
        }


    }

    @FXML
    private Button buttonLeggTil (ActionEvent event){
        Pc nyPc =
    }

}
