package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import model.Driver;

import java.io.IOException;
import java.util.ArrayList;


public class AddDriverFormController {


    public static ObservableList driversList = FXCollections.observableArrayList();

    public JFXButton cancleBtn;
    public JFXTextField driverName;
    public JFXTextField nic;
    public JFXTextField licenseNo;
    public JFXTextField contactNo;
    public JFXTextField address;
    public JFXButton addDriverId;
    public String name;
    public String drivernic;
    public String licenseNum;
    public String driveraddress;
    public int drivercontactNum;

    public static ObservableList getDriversList() {
        return driversList;
    }

    public void cancleBtnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancleBtn.getScene().getWindow();
        stage.close();
    }

    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {

        name = driverName.getText();
        drivernic = nic.getText();
        licenseNum = licenseNo.getText();
        driveraddress = address.getText();

        try {
            drivercontactNum = Integer.parseInt(contactNo.getText());
        } catch (NumberFormatException e) {
            System.out.println("contact number is not string");
        }

        ArrayList<Driver> drivers = new ArrayList<Driver>();

        Driver drivers1 = new Driver(name, drivernic, licenseNum, driveraddress, drivercontactNum);
        drivers.add(drivers1);
        clearField();

        // System.out.println(drivers);

        for (Driver temp : drivers) {
            driversList.add(temp);
        }

    }

    public void clearField() {
        driverName.clear();
        nic.clear();
        licenseNo.clear();
        contactNo.clear();
        address.clear();
    }

}
