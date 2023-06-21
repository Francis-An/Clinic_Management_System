package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;

public class patientModel {
    private int id;
    private String fname;
    private String lname;
    private String dob;
//    private SimpleStringProperty gender;
    private String address;
    private String phone;
//    private SimpleStringProperty gname;
//    private SimpleStringProperty gphone;
//    private SimpleStringProperty gaddress;
//    private SimpleStringProperty ocupation;
//    private SimpleStringProperty temperature;
    private String pulse;
//    private SimpleStringProperty breath;
    private String weight;
//    private SimpleStringProperty height;

//    public patientModel(SimpleIntegerProperty id, SimpleStringProperty fname, SimpleStringProperty lname,
//                        SimpleStringProperty dob, SimpleStringProperty gender, SimpleStringProperty address,
//                        SimpleStringProperty phone, SimpleStringProperty gname, SimpleStringProperty gphone,
//                        SimpleStringProperty gaddress, SimpleStringProperty ocupation, SimpleStringProperty temperature,
//                        SimpleStringProperty pulse, SimpleStringProperty breath, SimpleStringProperty weight, SimpleStringProperty height) public patientModel(SimpleIntegerProperty id, SimpleStringProperty fname, SimpleStringProperty lname,
public patientModel(int id, String fname, String lname,
                    String dob, String address, String phone,
                    String pulse, String weight)
    {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
//        this.gender = gender;
        this.address = address;
        this.phone = phone;
//        this.gname = gname;
//        this.gphone = gphone;
//        this.gaddress = gaddress;
//        this.ocupation = ocupation;
//        this.temperature = temperature;
        this.pulse = pulse;
//        this.breath = breath;
        this.weight = weight;
//        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
