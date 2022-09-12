package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;



public class LoginFormController{

    public JFXButton closeButton;
    public JFXButton cancleBtn;
    public JFXButton loginBtnId;
    public Label attemptsLbl;
    public JFXTextField txtfldUserName;
    public JFXPasswordField txtfldPassword;
    public AnchorPane logInContext;
    private Stage stage = null;

    public void closeButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void cancleBtnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancleBtn.getScene().getWindow();
        stage.close();

    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {

        if (txtfldPassword.getText().equals("") & txtfldUserName.getText().equals("")) {

            URL resource = getClass().getResource("../view/ManagementForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) logInContext.getScene().getWindow();
            window.setScene(new Scene(load));
            WindowClose();
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            window.setX((primScreenBounds.getWidth() - window.getWidth()) / 2);
            window.setY((primScreenBounds.getHeight() - window.getHeight()) / 2);
        } else {
            attemptsLbl.setText("Invalid Username or Password");
        }
    }

    void getStage(Stage stage) {
        this.stage = stage;
    }

    public void WindowClose() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ManagementForm.fxml"));
        Parent parent = loader.load();
        ManagementFormController controller = (ManagementFormController) loader.getController();
        controller.clearWindow(stage);
    }
}
