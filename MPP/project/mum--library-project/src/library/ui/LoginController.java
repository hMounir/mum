package library.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import library.MainApp;
import library.business.SystemController;
import library.business.User;
import library.ui.util.MessagesUtil;
import library.ui.util.PageNavigator;

import java.io.IOException;


public class LoginController{

    @FXML
    private TextField idTextField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public void login(){
        try {
            SystemController systemController = new SystemController();

            User user = systemController.login(idTextField.getText(),passwordField.getText());
            MessagesUtil.showInfoMsg("Login Success","Logged in successfully");
            Scene scene = new Scene(loadMainPane("/mainPage.fxml",user));
            MainApp.parentWindow.setScene(scene);
            MainApp.parentWindow.setResizable(false);
            MainApp.parentWindow.show();
            //For page center
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            MainApp.parentWindow.setX((primScreenBounds.getWidth() - MainApp.parentWindow.getWidth()) / 2);
            MainApp.parentWindow.setY((primScreenBounds.getHeight() - MainApp.parentWindow.getHeight()) / 2);
        }catch (Exception ex){
            ex.printStackTrace();
            if(ex.getMessage().equals("MisInput")){
                MessagesUtil.showErrorMsg("Input MisMatch","Please enter the required login input");
            }else{
                MessagesUtil.showErrorMsg("Login Error","You entered the wrong credentials");
            }
        }
    }

    /**
     * Loads the main layout fxml layout.
     * Sets up the page switching pageNavigator.
     * Loads the main page into the fxml layout.
     *
     * @return the loaded pane.
     * @throws IOException if the pane could not be loaded.
     */
    private Pane loadMainPane(String fxmlFile,User user) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane mainPane = (Pane) loader.load(
                MainApp.class.getResourceAsStream("/layout/main.fxml")
        );

        BaseController mainController = loader.getController();
        PageNavigator.setBaseController(mainController,user);
        PageNavigator.loadPage(fxmlFile);
        return mainPane;
    }
}
