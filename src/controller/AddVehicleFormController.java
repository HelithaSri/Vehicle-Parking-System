package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import model.Driver;
import model.Vehicle;
import model.VehicleData;

import java.io.IOException;
import java.util.ArrayList;

public class AddVehicleFormController {
    static int count = 0;
    public JFXButton cancleBtn;
    public JFXButton addVehicleId;
    public JFXTextField vehicleNumber;
    public JFXTextField vehicleWeight;
    public JFXTextField vehicleNoOfPassengers;
    public JFXComboBox cmbVehicleTypeId;


    public String number;
    public String type;
    public int weight;
    public int noPassenger;

    //public VehicleData[] vehicleData = new VehicleData[15];

    public static ObservableList vehicleList = FXCollections.observableArrayList();

   // public  ArrayList<VehicleData> vehicles = new ArrayList<VehicleData>();

    public void cancleBtnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancleBtn.getScene().getWindow();
        stage.close();
    }

    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {

        number = vehicleNumber.getText();
        type =(String) cmbVehicleTypeId.getValue();
        try {
            weight = Integer.parseInt(vehicleWeight.getText());
            noPassenger = Integer.parseInt(vehicleNoOfPassengers.getText());
        } catch (NumberFormatException e) {
            System.out.println("Enter only numbers for the Max weight & Number of Passengers Fields");
        }


        ArrayList<VehicleData> vehicles = new ArrayList<VehicleData>();

        VehicleData vehicleData = new VehicleData(number, type, weight, noPassenger);

        vehicles.add(vehicleData);


        for (VehicleData temp : vehicles) {
            vehicleList.add(temp);
        }

        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ParkingSystemForm.fxml"));
        Parent parent = loader.load();
        ParkingSystemFormController controller = loader.getController();
        controller.getData(vehicles);*/
        clearField();

    }

    public static ObservableList getVehiclesList() {
        return vehicleList;
    }


    public void vehicleTypeOnAction(ActionEvent actionEvent) {

    }

    /*
    * add items to VehicleType Combobox
    * */
    public void setCmbVehicleTypes(){
        String[] vehicleTypes = { "Van", "Cargo Lorry", "Bus"};
        for (int i = 0; i < vehicleTypes.length; i++) {
            cmbVehicleTypeId.getItems().addAll(vehicleTypes[i]);
        }
    }

    public void initialize() {
        setCmbVehicleTypes();
    }
    
    public void clearField() {
        vehicleNumber.clear();
        vehicleWeight.clear();
        vehicleNoOfPassengers.clear();
        cmbVehicleTypeId.setValue("");
        vehicleNumber.requestFocus();
       
    }
}