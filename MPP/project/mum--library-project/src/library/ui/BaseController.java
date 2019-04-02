package library.ui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import library.business.AuthorizationLevel;
import library.business.SystemController;
import library.ui.util.MessagesUtil;
import library.ui.util.PageNavigator;

public class BaseController {

    protected SystemController systemController = new SystemController();
    
    /** Holder of a switchable page. */
    @FXML
    private VBox pageHolder;

    /**
     * Replaces the page displayed in the page holder with a new page.
     *
     * @param node the vista node to be swapped in.
     */
    public void setPage(Node node) {
        pageHolder.getChildren().setAll(node);
    }

    public void mainPage(){
        PageNavigator.loadPage("/mainPage.fxml");
    }

    public boolean isUserAdmin(){
        return PageNavigator.getLoggedInUser().getAuthorizationLevel() == AuthorizationLevel.ADMIN || PageNavigator.getLoggedInUser().getAuthorizationLevel() == AuthorizationLevel.BOTH;
    }

    public boolean isUserLibrarian(){
        return PageNavigator.getLoggedInUser().getAuthorizationLevel() == AuthorizationLevel.LIBRARIAN || PageNavigator.getLoggedInUser().getAuthorizationLevel() == AuthorizationLevel.BOTH;
    }

    public void addMember(){
        System.out.println(PageNavigator.getLoggedInUser().getAuthorizationLevel());
        if(PageNavigator.getLoggedInUser().getAuthorizationLevel() == AuthorizationLevel.ADMIN || PageNavigator.getLoggedInUser().getAuthorizationLevel() == AuthorizationLevel.BOTH){
            PageNavigator.loadPage("/addMember.fxml");
        }else{
            MessagesUtil.showErrorMsg("Permission error","You can't access this, please check with the library system");
        }
    }

    public void checkoutBook(){
        if(PageNavigator.getLoggedInUser().getAuthorizationLevel() == AuthorizationLevel.LIBRARIAN || PageNavigator.getLoggedInUser().getAuthorizationLevel() == AuthorizationLevel.BOTH) {
            PageNavigator.loadPage("/checkoutBook.fxml");
        }else{
            MessagesUtil.showErrorMsg("Permission error","You can't access this, please check with the library system");
        }
    }

    public void addBookCopy(){
        if(PageNavigator.getLoggedInUser().getAuthorizationLevel() == AuthorizationLevel.ADMIN || PageNavigator.getLoggedInUser().getAuthorizationLevel() == AuthorizationLevel.BOTH) {
            PageNavigator.loadPage("/addBookCopy.fxml");
        }else{
            MessagesUtil.showErrorMsg("Permission error","You can't access this, please check with the library system");
        }
    }

    public void addBook(){
        if(PageNavigator.getLoggedInUser().getAuthorizationLevel() == AuthorizationLevel.ADMIN || PageNavigator.getLoggedInUser().getAuthorizationLevel() == AuthorizationLevel.BOTH) {
            PageNavigator.loadPage("/addBook.fxml");
        }else{
            MessagesUtil.showErrorMsg("Permission error","You can't access this, please check with the library system");
        }
    }

    public void exit(){
        Platform.exit();
    }

    public void showAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("MUM Library System");
        alert.setTitle("About");
        WebView webView = new WebView();
        webView.getEngine().loadContent("<html>Thia ia MUM MPP Library Project</html>");
        webView.setPrefSize(150, 60);
        alert.getDialogPane().setContent(webView);;
        alert.showAndWait();
    }
}
