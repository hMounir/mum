package library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import library.dataaccess.Main;

import java.io.IOException;

public class MainApp extends Application {

    public static Stage parentWindow;

    public static void main(String[] args){
        Main.addUser();
        Main.addAdmin();
//        Main.addBook();
        launch(args);
    }

    public void start(Stage stage) throws IOException {
        parentWindow = stage;
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(MainApp.class.getResourceAsStream("/login.fxml"));
        Scene scene = new Scene(rootNode);

        //set icon of the application
        Image applicationIcon = new Image(getClass().getResourceAsStream("/images/logo.png"));
        MainApp.parentWindow.getIcons().add(applicationIcon);

        MainApp.parentWindow.setTitle("MUM MPP Project");
        MainApp.parentWindow.setScene(scene);
        MainApp.parentWindow.setResizable(false);
        MainApp.parentWindow.show();
    }
}
