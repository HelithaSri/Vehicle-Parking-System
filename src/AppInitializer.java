import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Bus;
import model.CargoLorry;
import model.van;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL resource = getClass().getResource("view/ParkingSystemForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        scene.getStylesheets().add("styles/Style.css");
        /*primaryStage.initStyle(StageStyle.TRANSPARENT); //Use For Boarder TRANSPARENT
        scene.setFill(Color.TRANSPARENT);*/
        primaryStage.setScene(scene);
        primaryStage.setTitle("Vehicle Parking System");
        primaryStage.show();
    }
}
