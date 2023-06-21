package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.Property;
//import javafx.Initializable
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import Model.patientModel;

import Database.Db;

public class opdDashboardController implements Initializable {

    Db db = new Db();

    @FXML
    private JFXButton dashboardBtn;

    @FXML
    private JFXButton registerPatientBtn;

    @FXML
    private JFXButton consultBtn;

    @FXML
    private JFXButton logoutBtn;

    @FXML
    private JFXButton labBtn;

    @FXML
    private JFXButton patientBtn;

    @FXML
    private GridPane pnConsult;

    @FXML
    private GridPane pnDashboard;

    @FXML
    private GridPane pnRegisterPatient;

    @FXML
    private JFXTextField pFirstNameTF;

    @FXML
    private JFXTextField pLastNameTF;

    @FXML
    private JFXTextField genderTF;

    @FXML
    private JFXTextField pAddressTF;

    @FXML
    private JFXTextField pPhoneTF;

    @FXML
    private JFXTextField gNameFT;

    @FXML
    private JFXTextField gAddressTF;

    @FXML
    private JFXTextField gPhoneTF;

    @FXML
    private JFXTextField occupationTF;

    @FXML
    private JFXTextField temperatureTF;

    @FXML
    private JFXTextField pulseTF;

    @FXML
    private JFXTextField breathingTF;

    @FXML
    private JFXTextField bloodTF;

    @FXML
    private JFXTextField weightTF;

    @FXML
    private JFXTextField heightTF;

    @FXML
    private JFXButton registerButton;

    @FXML
    private JFXDatePicker dateTF;

    @FXML
    private GridPane pnPatient;

    @FXML
    private TableView<patientModel> tableId;

    @FXML
    private TableColumn<patientModel, Integer> idCol;

    @FXML
    private TableColumn<?, ?> fnameCol;

    @FXML
    private TableColumn<?, ?> lnameCol;

    @FXML
    private TableColumn<?, ?> dobCol;

    @FXML
    private TableColumn<?, ?> phoneCol;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TableColumn<?, ?> weightCol;

    @FXML
    private TableColumn<?, ?> bloodCol;

    @FXML
    private FontAwesomeIconView searchBtn;

    @FXML
    private Pane pniStatus;

    @FXML
    private JFXButton lblStatus;

    @FXML
    private JFXButton lblStatusMini;
//    private Object patientModel;


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
            lblStatus.setText("Booked Appointment with doctor");
            lblStatusMini.setText("/home/consultation");
            pniStatus.setBackground(new Background(new BackgroundFill(Color.rgb(43,99,63), CornerRadii.EMPTY, Insets.EMPTY)));
            pnConsult.toFront();

        }else if(event.getSource() == labBtn){
            System.out.println("Hello Technician");
            lblStatus.setText("Laboratory");
            lblStatusMini.setText("/home/lab");
            pniStatus.setBackground(new Background(new BackgroundFill(Color.rgb(99,48,63), CornerRadii.EMPTY, Insets.EMPTY)));
//            pnLab.toFront();

        }else if(event.getSource() == logoutBtn){
            System.out.println("You have lout");
            lblStatus.setText("Logout");
            lblStatusMini.setText("/home/logout");
            pniStatus.setBackground(new Background(new BackgroundFill(Color.rgb(99,63,43), CornerRadii.EMPTY, Insets.EMPTY)));
            ((Node)event.getSource()).getScene().getWindow().hide();
            loadWindow("/sample/views/loginView.fxml","ATU Clinic");
            check("Your have successfully logout");
        }
        else if(event.getSource() == registerPatientBtn){
            System.out.println("register patients");
            lblStatus.setText("Register Patients");
            lblStatusMini.setText("/home/register");
            pniStatus.setBackground(new Background(new BackgroundFill(Color.rgb(43,63,99), CornerRadii.EMPTY, Insets.EMPTY)));
            pnRegisterPatient.toFront();
        }else if(event.getSource() == registerButton){
            System.out.println("You have register a patient");
            String fname = pFirstNameTF.getText();
            String lname = pLastNameTF.getText();
            LocalDate dob = dateTF.getValue();
            String address = pAddressTF.getText();
            String phone = pPhoneTF.getText();
            String gName = gNameFT.getText();
            String gPhone = gPhoneTF.getText();
            String gAddress = gAddressTF.getText();
            String occupation = occupationTF.getText();
//            Vital Information
            String temperature = temperatureTF.getText();
            String pulse = pulseTF.getText();
            String breath = breathingTF.getText();
            String weight = weightTF.getText();
            String height = heightTF.getText();
            String gender = genderTF.getText();

            try {
                db.connect();
                PreparedStatement patients = db.con.prepareStatement("insert into patients(" +
                        "fname,lname,dob,address,phone,gname,gphone,gaddress,occupation,temperature,pulse,breath,weight,height,gender) " +
                        "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                patients.setString(1,fname);
                patients.setString(2,lname);
                patients.setString(3, String.valueOf(dob));
                patients.setString(4,address);
                patients.setString(5,phone);
                patients.setString(6, gName);
                patients.setString(7,gPhone);
                patients.setString(8, gAddress);
                patients.setString(9, occupation);
                patients.setString(10, temperature);
                patients.setString(11,pulse);
                patients.setString(12,breath);
                patients.setString(13,weight);
                patients.setString(14,height);
                patients.setString(15,gender);
                patients.executeUpdate();
//                db.con.close();
                int i = patients.executeUpdate();
                if(i == 1){
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setHeaderText("Success");
                    successAlert.setContentText("You have successfully register the patient");
                    successAlert.showAndWait();

                }



            }
            catch (SQLException | ClassNotFoundException ex){
                System.out.println(ex);
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setContentText("Ooooooh! something went wrong, the patient was unable to register!");
                errorAlert.showAndWait();
            }



        }

    }

    private void loadWindow(String location, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(location));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();

    }

    public void check(String text){
        Notifications notification = Notifications.create();
        notification.title("Success");
        notification.text(text);
        notification.hideAfter(Duration.seconds(5));
        notification.position(Pos.BASELINE_RIGHT);
        notification.show();
    }


    @Override
    public  void  initialize(URL location, ResourceBundle resource) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        fnameCol.setCellValueFactory(new PropertyValueFactory<>("fname"));
        lnameCol.setCellValueFactory(new PropertyValueFactory<>("lname"));
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        weightCol.setCellValueFactory(new PropertyValueFactory<>("weight"));
        bloodCol.setCellValueFactory(new PropertyValueFactory<>("pulse"));
//        dobCol.setCellValueFactory(new PropertyValueFactory<>("gphone"));
//        dobCol.setCellValueFactory(new PropertyValueFactory<>("gaddress"));
//        dobCol.setCellValueFactory(new PropertyValueFactory<>("occupation"));
//        dobCol.setCellValueFactory(new PropertyValueFactory<>("temperature"));
//        dobCol.setCellValueFactory(new PropertyValueFactory<>("pulse"));
//        dobCol.setCellValueFactory(new PropertyValueFactory<>("breath"));
//        dobCol.setCellValueFactory(new PropertyValueFactory<>("weight"));
//        dobCol.setCellValueFactory(new PropertyValueFactory<>("height"));
        tableId.setItems(patientModels);
    }

    private ObservableList<patientModel> patientModels = FXCollections.observableArrayList(
            new patientModel(1,"Annor","Yeboah","12-23","Techiman","032838","23","232"),
            new patientModel(1,"Kofi","Yeboah","12-23","Techiman","032838","23","232"),
            new patientModel(1,"Kofi","Yeboah","12-23","Techiman","032838","23","232")
    );




    }






