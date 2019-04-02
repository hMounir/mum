package library.ui;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import library.business.Address;
import library.business.Admin;
import library.business.LibraryMember;
import library.dataaccess.AdminDataAccess;
import library.dataaccess.MembersDataAccess;
import library.ui.util.MessagesUtil;
import library.ui.util.PageNavigator;

import java.util.List;
import java.util.function.Function;

public class AddMemberController extends BaseController{

    @FXML
    private TextField memberId;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField street;

    @FXML
    private TextField city;

    @FXML
    private TextField state;

    @FXML
    private TextField zip;

    @FXML
    private TextField telephone;

    @FXML
    private TableColumn<LibraryMember,String> idColumn;

    @FXML
    private TableColumn<LibraryMember,String> firstNameColumn;

    @FXML
    private TableColumn<LibraryMember,String> lastNameColumn;

    @FXML
    private TableColumn<LibraryMember,String> streetColumn;

    @FXML
    private TableColumn<LibraryMember,String> cityColumn;

    @FXML
    private TableView<LibraryMember> libraryMemberTableView;

    private ObservableList<LibraryMember> list;

    public void initialize(){
        initializeTable();
    }

    private void initializeTable() {
        list = FXCollections.observableArrayList();
        libraryMemberTableView.setItems(list);
        columnConfigColumn(idColumn, (obj) -> obj.getMemberId()!=null ? obj.getMemberId():"");
        columnConfigColumn(firstNameColumn, (obj) -> obj.getFirstName()!=null ? obj.getFirstName():"");
        columnConfigColumn(lastNameColumn, (obj) -> obj.getLastName()!=null ? obj.getLastName():"");
        columnConfigColumn(streetColumn, (obj) -> obj.getAddress()!=null ? obj.getAddress().getStreet():"");
        columnConfigColumn(cityColumn, (obj) -> obj.getAddress()!=null ? obj.getAddress().getCity():"");
        list.addAll(systemController.getAllMembers());
    }

    private void columnConfigColumn(final TableColumn<LibraryMember, String> tableColumn, Function<LibraryMember, String> getter) {
        tableColumn.setCellValueFactory(column -> new SimpleStringProperty(getter.apply(column.getValue())));
        tableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void addMember(){
        try {
            Address address = new Address(street.getText(), city.getText(), state.getText(), zip.getText());
            LibraryMember libraryMember = new LibraryMember(firstName.getText(),
                    lastName.getText(),telephone.getText(),address,memberId.getText());
            systemController.addMember(libraryMember,PageNavigator.getLoggedInUser());
            list.add(libraryMember);
            MessagesUtil.showInfoMsg("Transaction success","Member data saved successfully");
            memberId.clear();
            firstName.clear();
            lastName.clear();
            street.clear();
            city.clear();
            state.clear();
            zip.clear();
            telephone.clear();
        }catch (Exception ex){
            if(ex.getMessage().equalsIgnoreCase("AddressMisInput")){
                MessagesUtil.showErrorMsg("Data MisInput","Address data are empty");
            }else if(ex.getMessage().equalsIgnoreCase("MemberMisInput")){
                MessagesUtil.showErrorMsg("Data MisInput","Member data are empty");
            }else if(ex.getMessage().equalsIgnoreCase("MemberExists")){
                MessagesUtil.showInfoMsg("Save Error","Member already exists");
            }else if(ex.getMessage().equalsIgnoreCase("MemberAlreadyExists")){
                MessagesUtil.showInfoMsg("Save Error","Member already exists");
            }else{
                MessagesUtil.showInfoMsg("Save Error","Something happened while saving member data");
            }
        }
    }
}
