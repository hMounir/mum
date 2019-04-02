package library.ui.util;

import javafx.fxml.FXMLLoader;
import library.business.User;
import library.ui.BaseController;

import java.io.IOException;

/**
 * Utility class for controlling navigation between pages.
 *
 * All methods on the navigator are static to facilitate
 * simple access from anywhere in the application.
 */
public class PageNavigator {

    /** The main application layout controller. */
    private static BaseController baseController;
    private static User user;

    /**
     * Stores the main controller for later use in navigation tasks.
     *
     * @param baseController the main application layout controller.
     */
    public static void setBaseController(BaseController baseController,User user) {
        PageNavigator.baseController = baseController;
        PageNavigator.user = user;
    }

    public static void loadPage(String fxml) {
        try {
            baseController.setPage(FXMLLoader.load(PageNavigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User getLoggedInUser(){
        return user;
    }
}