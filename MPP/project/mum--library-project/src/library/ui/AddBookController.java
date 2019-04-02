package library.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import library.business.Author;
import library.business.Book;
import library.business.BookCopy;
import library.ui.util.MessagesUtil;

import java.util.ArrayList;
import java.util.List;

public class AddBookController extends BaseController{

    @FXML
    private TextField isbn;

    @FXML
    private TextField title;

    @FXML
    private TextField authors;

    @FXML
    private TextField maximumCheckoutLength;

    @FXML
    private TextField numberOfCopies;

    public void addBook(){
        try {
            if(isbn.getText() == null || authors.getText() == null || title.getText() == null
                    || authors.getText() == null || maximumCheckoutLength.getText() == null || numberOfCopies.getText() == null) {
                MessagesUtil.showErrorMsg("Data MisInput","Please enter all the input fields");
                return;
            }
            Book book1 = new Book(isbn.getText(), title.getText(), Integer.valueOf(maximumCheckoutLength.getText()));
            List<Author> authors = new ArrayList<>();
            authors.add(new Author(this.authors.getText(), "Senior", "111", null, "writer"));
            book1.setAuthors(authors);

            List<BookCopy> bookCopies = new ArrayList<>();
            for (int i = 0; i < Integer.valueOf(numberOfCopies.getText()); i++) {
                bookCopies.add(new BookCopy(i+1, true, book1));
            }
            book1.setBookCopies(bookCopies);

            systemController.addBook(book1);
            isbn.setText("");
            title.setText("");
            this.authors.setText("");
            maximumCheckoutLength.setText("");
            numberOfCopies.setText("");
            MessagesUtil.showInfoMsg("Transaction successful","Book added successfully");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
