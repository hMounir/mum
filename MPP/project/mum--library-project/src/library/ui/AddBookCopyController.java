package library.ui;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import library.business.Book;
import library.ui.util.MessagesUtil;

import java.util.function.Function;

public class AddBookCopyController extends BaseController{

    @FXML
    private TextField isbn;

    @FXML
    private TableView booksList;

    @FXML
    private TableColumn<Book, String> isbnCol;
    @FXML
    private TableColumn<Book, String> titleCol;
    @FXML
    private TableColumn<Book, String> copiesNumCol;
    @FXML
    private TableColumn<Book, String> bookdueDaysCol;
    @FXML
    private TableColumn<Book, String> availableCopies;
    private ObservableList<Book> list;
    private Book book;

    public void initialize() {
        initializeTable();
    }
    public void initializeTable(){
        list = FXCollections.observableArrayList();
        booksList.setItems(list);
        columnConfigColumn(isbnCol, (Book) -> Book.getISBN()!=null ? Book.getISBN():"");
        columnConfigColumn(titleCol, (Book) -> Book.getTitle()!=null ? Book.getTitle():"");
        columnConfigColumn(copiesNumCol, (Book) -> Book.getBookCopies() == null ? "0" : String.valueOf(Book.getBookCopies().size()));
        columnConfigColumn(bookdueDaysCol, (Book) ->  String.valueOf(Book.getMaxCheckoutLength()));
        columnConfigColumn(availableCopies, (Book) ->  String.valueOf(Book.getCountAvailableCopies()));
        list.addAll(systemController.getAllBooks());
    }

    private void columnConfigColumn(final TableColumn<Book, String> tableColumn, Function<Book, String> getter) {
        tableColumn.setCellValueFactory(column -> new SimpleStringProperty(getter.apply(column.getValue())));
        tableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void lookup(){
        try {
            if(isbn.getText()== null){
                MessagesUtil.showErrorMsg("Data MisInput","Please enter the book ISBN");
                return;
            }
            boolean checkBook = systemController.checkBook(isbn.getText());
            if(!checkBook){
                MessagesUtil.showErrorMsg("Data MisInput","Please check the book exists");
                return;
            }
            book = systemController.getBookByIsbn(isbn.getText());

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/bookInfoDialog.fxml"));
            BookInfoDialogController dialogController = new BookInfoDialogController();
            dialogController.setAddBookCopyController(this);
            fxmlLoader.setController(dialogController);
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Confirm found book");
            stage.showAndWait();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Book getBook() {
        return book;
    }

    public TableView getBooksList() {
        return booksList;
    }

    public ObservableList<Book> getList() {
        return list;
    }

    public void setList(ObservableList<Book> list) {
        this.list = list;
    }

    public TextField getIsbn() {
        return isbn;
    }
}
