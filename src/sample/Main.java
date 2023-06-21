package sample;

import Database.Db;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Model.Models;

import java.awt.*;


public class Main extends Application {
    Db db = new Db();


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("views/loginView.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("views/OPD/opdDashboard.fxml"));
        primaryStage.setTitle("ATU Clinic");
        primaryStage.setScene(new Scene(root, 1000, 600));
//        primaryStage.setScene(new Scene(root, 1900, 1000));
        primaryStage.show();
        db.connect();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
