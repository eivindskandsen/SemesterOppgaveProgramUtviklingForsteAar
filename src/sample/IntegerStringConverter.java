package sample;

import javafx.scene.control.Alert;

public class IntegerStringConverter extends javafx.util.converter.IntegerStringConverter{
    public static boolean success = true;


    public Integer fraString(String s) {
        try{
            Integer resultat = super.fromString(s);
            success = true;
            return resultat;
        }catch (NumberFormatException e){
            Alert alarm = new Alert(Alert.AlertType.ERROR);
            alarm.setTitle("FEIL!");
            alarm.setHeaderText("Ugyldig nummer!");
            alarm.setContentText("Vennligst skriv inn ett gyldig nummer");
            alarm.showAndWait();

            success = false;
            return 0;
        }
    }
}
