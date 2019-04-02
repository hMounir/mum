package library.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainPageController extends BaseController{

    @FXML
    private Button addMember;

    @FXML
    private Button checkoutBook;

    @FXML
    private Button addBookCopy;

    @FXML
    private Button addBook;

    public void initialize(){
        addMember.setVisible(isUserAdmin());
        checkoutBook.setVisible(isUserLibrarian());
        addBookCopy.setVisible(isUserAdmin());
        addBook.setVisible(isUserAdmin());
    }
}