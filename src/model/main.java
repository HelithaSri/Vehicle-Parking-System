package model;

import controller.ParkingSystemFormController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static ObservableList driversList = FXCollections.observableArrayList();

    public static void main(String[] args) throws IOException {

        /*van v1 = new van();

        v1.park("ca-20","van");
        v1.park("ca-212","van");
        //v1.leavePark("ca-22","van");*/

        ArrayList<VehicleData> vehicles = new ArrayList<VehicleData>();

        VehicleData Vehicles1 = new VehicleData("CP 6454", "Bus", 150, 10);
        vehicles.add(Vehicles1);

        VehicleData Vehicles2 = new VehicleData("CP 950", "Van", 150, 10);
        vehicles.add(Vehicles2);

        for (int i=0; i<vehicles.size();i++){
            if (vehicles.get(i).getVehicleNumber().equals("CP 950")){
                System.out.println(vehicles.get(i).getVehicleType());
            }
        }

        for (VehicleData temp : vehicles) {
            driversList.add(temp);
        }

        System.out.println(driversList.get(0));


    }
}
