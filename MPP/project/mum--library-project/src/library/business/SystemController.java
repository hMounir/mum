package library.business;

import library.dataaccess.AdminDataAccess;
import library.dataaccess.BookDataAccess;
import library.dataaccess.MembersDataAccess;
import library.ui.util.PageNavigator;
import library.userexception.BookException;
import library.userexception.MemberException;

import java.util.ArrayList;
import java.util.List;

public class SystemController {

    private MembersDataAccess membersDataAccess = new MembersDataAccess(LibraryMember.class);
    private BookDataAccess bookDataAccess = new BookDataAccess(Book.class);

    public Admin findAdmin(User user){
        List<Admin> adminList = new AdminDataAccess(Admin.class).getAll();
        return adminList.stream()
                .filter(x -> PageNavigator.getLoggedInUser().equals(x.getUser()))
                .findAny()
                .orElse(null);
    }

    public User login(String id, String password) throws Exception{
        System.out.println(id);
        if(id.isEmpty() || password.isEmpty()){
            throw new Exception("MisInput");
        }
        User user = new User(id,password);
        user.login();
        return user;
    }

    public List<CheckOutRecordEntry> getCheckoutEntries(){
        return membersDataAccess.getCheckoutEntries();
    }

    public void checkoutBook(String memberId,String isbn) throws Exception{
        if (memberId == null || memberId.isEmpty()) {
            throw new Exception("MemberIDMisInput");
        }
        if (isbn == null || isbn.isEmpty()) {
            throw new Exception("ISBNMisInput");
        }

        if (!membersDataAccess.checkId(memberId)) {
            throw new Exception("MemberExists");
        }

        if (!bookDataAccess.checkBook(isbn)) {
            throw new Exception("BookExists");
        }

        List<LibraryMember> members = membersDataAccess.getAll();
        LibraryMember member = members.stream()
                .filter(x -> x.getMemberId().equals(memberId))
                .findAny()
                .orElse(null);

        if (member != null) {
            member.checkout(isbn, memberId);
        }
    }

    public List<Book> getAllBooks(){
        return bookDataAccess.getAll();
    }

    public void addBookCopy(Book book){
        Admin admin = findAdmin(PageNavigator.getLoggedInUser());
        admin.addNewBookCopy(book);
    }

    public List<LibraryMember> getAllMembers(){
        return membersDataAccess.getAll();
    }

    public void addMember(LibraryMember libraryMember,User user) throws Exception{
        if (libraryMember.getAddress().getStreet().equals("") || libraryMember.getAddress().getCity().equals("")
                || libraryMember.getAddress().getState().equals("") || libraryMember.getAddress().getZip().equals("")) {
            throw new Exception("AddressMisInput");
        }
        if (libraryMember.getMemberId().equals("")
                || libraryMember.getFirstName().equals("") || libraryMember.getLastName().equals("")
                || libraryMember.getPhone().equals("")) {
            throw new Exception("MemberMisInput");
        }
        if (membersDataAccess.checkId(libraryMember.getMemberId())) {
            throw new MemberException("MemberExists");
        }

        Admin admin = findAdmin(user);
        admin.addNewLibrarianMember(libraryMember);
    }

    public boolean checkBook(String isbn){
        return bookDataAccess.checkBook(isbn);
    }

    public Book getBookByIsbn(String isbn) throws BookException {
        return bookDataAccess.getBookByIsbn(isbn);
    }

    public void addBook(Book book){
        new BookDataAccess(Book.class).addNew(book);
    }
    
    
    public void addAuthor(Author author,User user) throws Exception {
        Admin admin = findAdmin(user);
        
        for(Author auth:admin.getAllAuthor()) {
        	if(auth.equals(author)) {
        		throw new Exception("Author alrady exists");
        	}
        }
        admin.addAuthor(author);
    }
}
