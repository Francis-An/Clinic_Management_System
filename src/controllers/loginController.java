package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.management.Notification;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.lang.Object;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import  Database.Db;

public class loginController {
    Db db = new Db();

    @FXML
    private ImageView imgLogo;

    @FXML
    private JFXTextField textUsername;

    @FXML
    private JFXPasswordField textPassword;

    @FXML
    private JFXButton signBtn;




    @FXML
    public void login(ActionEvent actionEvent) throws IOException {
        String username = textUsername.getText();
        String password = textPassword.getText();

        try {
            db.connect();
            PreparedStatement pst = db.con.prepareStatement("select * from users where username=? and password=?");
            pst.setString(1,username);
            pst.setString(2,password);
        }
        catch (SQLException | ClassNotFoundException ex){
            error("Something went wrong!");
        }

//        rs = pst.executeQuery();

        if (username.equals("doctor") && password.equals("doctor")){
            System.out.println("Welcome Admin");
            ((Node)actionEvent.getSource()).getScene().getWindow().hide();
//            loadWindow("mainView.fxml","ATU Clinic");
//            Stage stage = new Stage();
            try{
                loadWindow("/sample/views/Doctor/mainView.fxml","ATU Clinic");
//
                check("Welcome Doctor");
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        else if (username.equals("") && password.equals("")){
            error("Username and password is required to access this system");
        }else if (username.equals("")){
            error("Username is required to access this system");
        }else if (password.equals("")){
            error("Password is required to access this system");
        }
        else if(username.equals("opd") && password.equals("opd")){
            ((Node)actionEvent.getSource()).getScene().getWindow().hide();
            try{
                loadWindow("/sample/views/OPD/opdDashboard.fxml","ATU Clinic");
//
                check("Welcome OPD");
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        else {
            error("Wrong input, check and try again");
        }

    }

    private void loadWindow(String location, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(location));
        Scene scene = new Scene(root,1900,1000);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();

    }



    public void error(String text){
        Notifications notification = Notifications.create();
        notification.title("Error");
        notification.text(text);
        notification.hideAfter(Duration.seconds(5));
        notification.position(Pos.BASELINE_RIGHT);
        notification.show();
    }

    public void check(String text){
        Notifications notification = Notifications.create();
        notification.title("Success");
        notification.text(text);
        notification.hideAfter(Duration.seconds(5));
        notification.position(Pos.BASELINE_RIGHT);
        notification.show();
    }


}
