package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class docDashboardController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton dashboardBtn;

    @FXML
    private JFXButton patientBtn;

    @FXML
    private JFXButton consultBtn;

    @FXML
    private JFXButton logoutBtn;

    @FXML
    private JFXButton labBtn;

    @FXML
    private TableView<?> COL;

    @FXML
    private TableColumn<?, ?> tableItems;

    @FXML
    private Pane pniStatus;

    @FXML
    private JFXButton lblStatus;

    @FXML
    public JFXButton lblStatusMini;

    @FXML
    private GridPane pnPatient;

    @FXML
    private GridPane pnDashboard;

    @FXML
    private GridPane pnConsult;

    @FXML
    private GridPane pnLab;


    public docDashboardController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleClicks(javafx.event.ActionEvent event) throws IOException {
        if(event.getSource() == dashboardBtn){
            System.out.println("Hello dashboard");
            lblStatus.setText("Dashboard");
            lblStatusMini.setText("/home/dashboard");
            pniStatus.setBackground(new Background(new BackgroundFill(Color.rgb(63,48,99), CornerRadii.EMPTY, Insets.EMPTY)));
            pnDashboard.toFront();

        }
        else if(event.getSource() == patientBtn){
            System.out.println("Hello Patient");
            lblStatus.setText("Patients");
            lblStatusMini.setText("/home/patients");
            pniStatus.setBackground(new Background(new BackgroundFill(Color.rgb(43,63,99), CornerRadii.EMPTY, Insets.EMPTY)));
            pnPatient.toFront();

        }else if(event.getSource() == consultBtn){
            System.out.println("Hello Consult");
            lblStatus.setText("Consultation & Diagnoses");
            lblStatusMini.setText("/home/consultation");
            pniStatus.setBackground(new Background(new BackgroundFill(Color.rgb(43,99,63), CornerRadii.EMPTY, Insets.EMPTY)));
            pnConsult.toFront();

        }else if(event.getSource() == labBtn){
            System.out.println("Hello Technician");
            lblStatus.setText("Laboratory");
            lblStatusMini.setText("/home/lab");
            pniStatus.setBackground(new Background(new BackgroundFill(Color.rgb(99,48,63), CornerRadii.EMPTY, Insets.EMPTY)));
            pnLab.toFront();

        }else if(event.getSource() == logoutBtn){
            System.out.println("You have lout");
            lblStatus.setText("Logout");
            lblStatusMini.setText("/home/logout");
            pniStatus.setBackground(new Background(new BackgroundFill(Color.rgb(99,63,43), CornerRadii.EMPTY, Insets.EMPTY)));
            ((Node)event.getSource()).getScene().getWindow().hide();
            loadWindow("/sample/views/loginView.fxml","ATU Clinic");
            check("Your have successfully logout");
        }
    }
    public void check(String text){
        Notifications notification = Notifications.create();
        notification.title("Success");
        notification.text(text);
        notification.hideAfter(Duration.seconds(5));
        notification.position(Pos.BASELINE_RIGHT);
        notification.show();
    }

    private void loadWindow(String location, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(location));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();

    }
}
