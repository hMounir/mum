package library.ui;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import library.business.CheckOutRecordEntry;
import library.ui.util.MessagesUtil;
import library.userexception.BookException;
import library.userexception.MemberException;

import java.util.function.Function;

public class CheckoutBookController extends BaseController {

    @FXML
    private TextField memberId;

    @FXML
    private TextField isbn;

    @FXML
    private TableView<CheckOutRecordEntry> checkoutList;
    @FXML
    private TableColumn<CheckOutRecordEntry, String> bookCopyCol;
    @FXML
    private TableColumn<CheckOutRecordEntry, String> checkoutDateCol;
    @FXML
    private TableColumn<CheckOutRecordEntry, String> dueDateCol;

    private ObservableList<CheckOutRecordEntry> list;

    public void initialize() {
        initializeTable();
    }

    private void initializeTable() {
        list = FXCollections.observableArrayList();
        checkoutList.setItems(list);
        columnConfigColumn(bookCopyCol, (checkOutRecordEntry) -> checkOutRecordEntry.getBookCopy() != null ? String.valueOf(checkOutRecordEntry.getBookCopy().getCopyNum()) : "0");
        columnConfigColumn(checkoutDateCol, (checkOutRecordEntry) -> checkOutRecordEntry.getCheckoutDate() != null ? checkOutRecordEntry.getCheckoutDate().toString() : "");
        columnConfigColumn(dueDateCol, (checkOutRecordEntry) -> checkOutRecordEntry.getDueDate() != null ? checkOutRecordEntry.getDueDate().toString() : "");
        list.addAll(systemController.getCheckoutEntries());
    }

    private void columnConfigColumn(final TableColumn<CheckOutRecordEntry, String> tableColumn, Function<CheckOutRecordEntry, String> getter) {
        tableColumn.setCellValueFactory(column -> new SimpleStringProperty(getter.apply(column.getValue())));
        tableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void checkout() {
        try {
            systemController.checkoutBook(memberId.getText(),isbn.getText());
            memberId.setText("");
            isbn.setText("");
            list = FXCollections.observableArrayList();
            list.addAll(systemController.getCheckoutEntries());
            checkoutList.setItems(list);
            MessagesUtil.showInfoMsg("Transaction successful", "The book checked out successfully");

        } catch (Exception e) {
            e.printStackTrace();
            if(e.getMessage().equals("MemberIDMisInput")){
                MessagesUtil.showErrorMsg("Data MisInput", "Please enter the member id");
            }else if(e.getMessage().equals("ISBNMisInput")){
                MessagesUtil.showErrorMsg("Data MisInput", "Please enter the book isbn");
            }else if(e.getMessage().equals("MemberExists")){
                MessagesUtil.showErrorMsg("Data MisInput", "Please check the member exists");
            }else if(e.getMessage().equals("BookExists")){
                MessagesUtil.showErrorMsg("Data MisInput", "Please check the book exists");
            }
            else if (e instanceof BookException || e instanceof MemberException){
                MessagesUtil.showErrorMsg(e.getMessage(), "Data save error");
            }else {
                MessagesUtil.showErrorMsg("Transaction error", "Data save error");
            }
        }
    }
}
