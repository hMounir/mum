package library.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import library.business.Admin;
import library.business.Book;
import library.dataaccess.AdminDataAccess;
import library.dataaccess.BookDataAccess;
import library.ui.util.MessagesUtil;
import library.ui.util.PageNavigator;

import java.util.List;

public class BookInfoDialogController {

    @FXML
    private Label ISBN;

    @FXML
    private Label title;

    @FXML
    private Label maxCheckoutLength;

    private AddBookCopyController addBookCopyController;

    public void initialize(){
        if(addBookCopyController.getBook()!=null){
            ISBN.setText(addBookCopyController.getBook().getISBN());
            title.setText(addBookCopyController.getBook().getTitle());
            maxCheckoutLength.setText(String.valueOf(addBookCopyController.getBook().getMaxCheckoutLength()));
        }
    }

    public void confirm(ActionEvent event){
        addBookCopyController.systemController.addBookCopy(addBookCopyController.getBook());
        ObservableList<Book> list = FXCollections.observableArrayList();
        list.addAll(addBookCopyController.systemController.getAllBooks());
        getAddBookCopyController().setList(list);
        getAddBookCopyController().getBooksList().setItems(list);
        getAddBookCopyController().getIsbn().setText("");
        cancel(event);
        MessagesUtil.showInfoMsg("Transaction Success","Book copied successfully");
    }

    public void cancel(ActionEvent event){
        Node  source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public AddBookCopyController getAddBookCopyController() {
        return addBookCopyController;
    }

    public void setAddBookCopyController(AddBookCopyController addBookCopyController) {
        this.addBookCopyController = addBookCopyController;
    }
}
