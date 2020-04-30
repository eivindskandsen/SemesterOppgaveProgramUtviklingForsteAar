package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Superbruker");
        primaryStage.setScene(new Scene(root, 750, 600));
        primaryStage.show();

        Stage anotherStage=new Stage();


        Parent root2 = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        anotherStage.setTitle("Kunde");
        anotherStage.setScene(new Scene(root2, 600, 600));
        anotherStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
