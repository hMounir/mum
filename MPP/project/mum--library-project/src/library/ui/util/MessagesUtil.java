package library.ui.util;

import javafx.scene.control.Alert;

public class MessagesUtil {

    public static void showErrorMsg(String headerText,String msg){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(headerText);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void showInfoMsg(String headerText,String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(headerText);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
