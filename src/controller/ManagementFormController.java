package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.sun.glass.ui.Pixels;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import view.tm.InParkingTm;
import view.tm.OnDeliveryTm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ManagementFormController {

    public AnchorPane tableContext;
    public JFXButton cancleBtn;
    public JFXButton logOut;
    public AnchorPane mainContext;
    public JFXComboBox cmbId;
    public TableView<InParkingTm> vehicleId;
    public TableView<OnDeliveryTm> deliveryTableId;
    public TableColumn vehicleNumber;
    public TableColumn vehicleParkingSlot;
    public TableColumn vehicleTypes;
    public TableColumn vehicleParkedTime;

    public TableColumn deliveryVehicleNumber;
    public TableColumn deliveryVehicleType;
    public TableColumn deliveryVehicleName;
    public TableColumn deliveryLeftTime;

    String[] vehicleType = {
            "Van",
            "Bus",
            "CargoLorry"
    };
    private String no;
    private String type;
    private String slotNo;
    private String dateTime;
    private String name;

    public void clearWindow(Stage stage) {
        stage.close();
    }

    public void logOutBtn(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ParkingSystemForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) mainContext.getScene().getWindow();
        window.setScene(new Scene(load));

    }

    public void addVehicleAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);

    }

    public void addDriverAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }

    public void cmbAction(ActionEvent actionEvent) throws IOException {
        if (cmbId.getValue().equals("On Delivery")) {
            logOut.setVisible(false);
            vehicleId.setVisible(false);
            deliveryTableId.setVisible(true);

        } else {
            logOut.setVisible(true);
            vehicleId.setVisible(true);
            deliveryTableId.setVisible(false);
        }
    }

    public void setCmbVehicle() {
        cmbId.getItems().addAll(vehicleType);

    }

    public void setData(String no, String type, String slotNo, String dateTime){
        this.no=no;
        this.type=type;
        this.slotNo=slotNo;
        this.dateTime=dateTime;
    }

    public void trigger() {
        /*InParkingTm inParkingTm = new InParkingTm(no,type,slotNo,dateTime);
        if (tmArrayList.add(inParkingTm)){
            loadData();
            System.out.println("table update");
        }else{
            System.out.println("table not update");
        }*/
        tmArrayList.add(new InParkingTm(no,type,slotNo,dateTime));
    }

    /*{
        //tmArrayList.add(new InParkingTm("no","type","slotNo","dateTime"));
        //tmArrayList.add(new InParkingTm(no,type,slotNo,dateTime));
    }*/
    static ArrayList<InParkingTm> tmArrayList = new ArrayList();

    static ArrayList<OnDeliveryTm> tmArrayListDelivery = new ArrayList();

    private void loadData(){
        /*ObservableList<InParkingTm> tmObservableList = FXCollections.observableArrayList();
        for (InParkingTm temp: tmArrayList) {
            tmObservableList.add(new InParkingTm(temp.getVehicleNumber(),temp.getVehicleType(), temp.getParkingSlotNo(), temp.getParkingTime()));
        }
        vehicleId.setItems(tmObservableList);*/
    }

    public void initialize() {

        cmbId.getItems().addAll("In Parking", "On Delivery");
        cmbId.setValue("In Parking");

        vehicleId.setItems(FXCollections.observableArrayList(tmArrayList));

        vehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        vehicleTypes.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        vehicleParkingSlot.setCellValueFactory(new PropertyValueFactory<>("parkingSlotNo"));
        vehicleParkedTime.setCellValueFactory(new PropertyValueFactory<>("parkingTime"));

        deliveryTableId.setItems(FXCollections.observableArrayList(tmArrayListDelivery));

        deliveryVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        deliveryVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        deliveryVehicleName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        deliveryLeftTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));

    }

    public void setDatatoDelivery(String no, String type, String name, String dateTime) {
        this.no=no;
        this.type=type;
        this.name=name;
        this.dateTime=dateTime;
    }

    public void triggerDelivery() {
        tmArrayListDelivery.add(new OnDeliveryTm(no,type,name,dateTime));
    }
}