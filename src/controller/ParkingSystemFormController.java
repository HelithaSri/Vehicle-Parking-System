package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Bus;
import model.CargoLorry;
import model.VehicleData;
import model.van;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class ParkingSystemFormController {


    public static String no;
    public static String type;
    public static int i = 0;

    /* public void t(){

         for (int j=0; j< vehicleData.length;j++){
             vehicleData[j] = new VehicleData(number, type, weight, noPassenger);
             System.out.println("done");

         }

     }
 */
    public static ArrayList<VehicleData> vehiclesArrayList = new ArrayList<VehicleData>();
    public JFXComboBox cmbVehicle;
    public JFXComboBox cmbDriver;
    public Label lblParkingNo;
    public Label lblDate;
    public Label lblTime;
    public JFXTextField lblVehicleType;
    public AnchorPane MainContext;
    public JFXButton btnParkVehicleId;
    public JFXButton btnOnDeliveryShiftId;
   /* String[][] vehicle = {
            {"NA-3434", "Bus"},
            {"KA-4563", "Van"},
            {"58-3567", "Van"},
            {"GF-4358", "Van"},
            {"CCB-3568", "Van"},
            {"LM-6679", "Van"},
            {"QA-3369", "Van"},
            {"KB-3668", "Cargo Lorry"},
            {"JJ-9878", "Cargo Lorry"},
            {"GH-5772", "Cargo Lorry"},
            {"XY-4456", "Cargo Lorry"},
            {"YQ-3536", "Cargo Lorry"},
            {"CBB-3566", "Cargo Lorry"},
            {"QH-3444", "Cargo Lorry"}
    };*/

    static van v1 = new van();
    static Bus b1 = new Bus();
    static CargoLorry l1 = new CargoLorry();

    private final ObservableList parentDriversList = FXCollections.observableArrayList();

    private final ObservableList parentVehiclesList = FXCollections.observableArrayList();

    public String slotNo;
    public String dateTime;
    public String name;

    public String getDateAndTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        return formatter.format(date);
    }

    public void btnParkVehicle(ActionEvent actionEvent) throws InterruptedException, IOException {
        try {

            if (type.equals("Van")) {
                v1.park(no, type);
            } else if (type.equals("Bus")) {
                b1.park(no, type);
            } else if (type.equals("Cargo Lorry")) {
                l1.park(no, type);
            }
        } catch (Exception e) {
            System.out.println("Pleace Select Vehicle....");
        }
        /*no = String.valueOf(cmbVehicle.getValue());
        type = lblVehicleType.getText();*/
        slotNo = lblParkingNo.getText();
        dateTime = getDateAndTime();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ManagementForm.fxml"));
        Parent parent = loader.load();
        ManagementFormController controller = loader.getController();
        controller.setData(no,type,slotNo,dateTime);
        controller.trigger();
        clearField();

    }


    public void btnOnDeliveryShift(ActionEvent actionEvent) throws IOException {
        try {

            if (type.equals("Van")) {
                v1.leavePark(no, type);
            } else if (type.equals("Bus")) {
                b1.leavePark(no, type);
            } else if (type.equals("Cargo Lorry")) {
                l1.leavePark(no, type);
            }
        } catch (Exception e) {
            System.out.println("Pleace Select Vehicle and Driver ....");
        }

        name = String.valueOf(cmbDriver.getValue());
        dateTime = getDateAndTime();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ManagementForm.fxml"));
        Parent parent = loader.load();
        ManagementFormController controller = loader.getController();
        controller.setDatatoDelivery(no,type,name,dateTime);
        controller.triggerDelivery();
        clearField();
    }

    public void btnManagementLogIn(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/LoginForm.fxml"));
        Parent parent = loader.load();
        LoginFormController controller = loader.getController();
        Stage stage = new Stage();
        controller.getStage((Stage) MainContext.getScene().getWindow());
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);



    }

    public void LocalTime() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH : mm a");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void LocalDate() {
        SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        lblDate.setText(DateFormatter.format(date));
    }

    /*public void setCmbVehicle() {
        for (int i = 0; i < vehicle.length; i++) {
            cmbVehicle.getItems().addAll(vehicle[i][0]);
        }
    } //cmb vehicle set*/

    public void cmbVehicleOnAction(ActionEvent actionEvent) {

        /*for (int i = 0; i < vehicle.length; i++) {
            for (int j = 0; j < vehicle[1].length; j++) {
                if (vehicle[i][0].equals(String.valueOf(cmbVehicle.getValue()))) {
                    lblVehicleType.setText(vehicle[i][1]);

                    break;
                }

                //System.out.println("Test : " + " " + test.get(0).getVehicleType());


                no = String.valueOf(cmbVehicle.getValue());

                type = lblVehicleType.getText();
                //System.out.println("s" + type);
                setParkingNo();
                break;
            }
        }*/

        for (int i = 0; i < test.size(); i++) {
            for (int h=0;h<test.size();h++) {
                if (test.get(h).getVehicleNumber().equals(String.valueOf(cmbVehicle.getValue()))){
                    //System.out.println("Test : " + " " + test.get(h).getVehicleNumber()+" "+test.get(h).getVehicleType());
                    lblVehicleType.setText(test.get(h).getVehicleType());
                    break;
                }
            }
            no = String.valueOf(cmbVehicle.getValue());
            type = lblVehicleType.getText();
            setParkingNo();
            break;
        }

       /* for (int b=0; b<=vehicleData.length;b++){ // WORK
            try {
                vehicleData[b]=vehiclesArrayList.get(b);
            } catch (Exception e) {
                System.out.println("no index");
            }
        }*/

       /* for (int b=0; b<=vehicleData.length;b++){
            if (vehicleData[b].getVehicleNumber().equals(no)){
                lblVehicleType.setText(vehicleData[b].getVehicleType());
                break;
            }
        }*/
    }

    // ArrayList<VehicleData> vehicles = new ArrayList<VehicleData>();

    public void cmbDriverOnAction(ActionEvent actionEvent) {

    }


    //VehicleData[] vehicleData = new VehicleData[15];

    public void setParkingNo() { //Set Slot & disable btn

        if (type.equals("Van")) {
            lblParkingNo.setText(v1.setSlot(no, type));
            /*
             * if Vehicle is parked, then "Park Vehicle" btn is Disable &
             * if Vehicle is not parked, them "Park Vehicle" btn is Enable
             */
            if (v1.setSlot(no, type).equals("Parked")) {
                btnParkVehicleId.setDisable(true);
                btnOnDeliveryShiftId.setDisable(false);
            } else {
                btnOnDeliveryShiftId.setDisable(true);
                btnParkVehicleId.setDisable(false);
            }

        } else if (type.equals("Bus")) {
            lblParkingNo.setText(b1.setSlot(no, type));

            if (b1.setSlot(no, type).equals("Parked")) {
                btnParkVehicleId.setDisable(true);
                btnOnDeliveryShiftId.setDisable(false);
            } else {
                btnOnDeliveryShiftId.setDisable(true);
                btnParkVehicleId.setDisable(false);
            }

        } else if (type.equals("Cargo Lorry")) {
            lblParkingNo.setText(l1.setSlot(no, type));

            if (l1.setSlot(no, type).equals("Parked")) {
                btnParkVehicleId.setDisable(true);
                btnOnDeliveryShiftId.setDisable(false);
            } else {
                btnOnDeliveryShiftId.setDisable(true);
                btnParkVehicleId.setDisable(false);
            }
        }
        /*else {
            System.out.println("no select");
        }*/
    }

    public void getData(ArrayList<VehicleData> vehicles) {
        vehiclesArrayList = vehicles;
    }

    public void clearField() {

        cmbDriver.setValue("");
        cmbVehicle.setValue("");
        lblVehicleType.clear();
        lblParkingNo.setText("");
        cmbVehicle.requestFocus();
    }

    ArrayList<VehicleData> test;
    public void initialize() {
        LocalTime();
        LocalDate();
        //setCmbVehicle();

        cmbDriver.setItems(parentDriversList);//add data to Driver cmb
        Bindings.bindContentBidirectional(parentDriversList, AddDriverFormController.getDriversList());

        cmbVehicle.setItems(parentVehiclesList);//add data to Vehicle cmb
        Bindings.bindContentBidirectional(parentVehiclesList, AddVehicleFormController.getVehiclesList());
        test = new ArrayList<>(parentVehiclesList);


    }
    /*public void returnType(){
        for (int h = 0 ; h < vehicles.size();h++){
            if (no.equals(vehicles.get(i).getVehicleNumber())){
                System.out.println(true);
            }else {
                System.out.println(false);
            }
        }
    }*/
}