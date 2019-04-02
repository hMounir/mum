package library.dataaccess;

import library.business.*;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        addUser();
//        addAdmin();
//        addBook();
//        addMember();

//		DataAccessFacade<User> p=new DataAccessFacadeImp<User>(User.class);
//////		p.addNew(new User( "K", "123", AuthorizationLevel.BOTH));
//////		p.addNew(new User( "h", "123", AuthorizationLevel.LIBRARIAN));
////		List<User> all=p.getAll();
////
////		AdminDataAccess<Admin> adminDataAccessFacade = new AdminDataAccess<>(Admin.class);
////		adminDataAccessFacade.addNew(new Admin( "Karim", "said","121212",new Address("12","12","12","23"), all.get(0)));
////
////
////
////		System.out.println(all);
		/*p.addNew(new Person("asd","adddd","666666",new Address("sd", "fds", "asdasdasdas", "asdds")));

		System.out.println(p.getAll());*/

//        DataAccessFacade<Book> p = new DataAccessFacadeImp<Book>(Book.class);
//        Book book = new Book("444", "Efective Java", 10);
//        List<Author> authors = new ArrayList<>();
//        authors.add(new Author("test", "test", "111", null, "writer"));
//        book.setAuthors(authors);
//
//        List<BookCopy> bookCopies = new ArrayList<>();
//        bookCopies.add(new BookCopy(5, true, book));
//        book.setBookCopies(bookCopies);
//
//        p.addNew(book);
    }

    public static void addUser() {
        DataAccessFacade<User> p = new DataAccessFacadeImp<User>(User.class);
        List<User> userList = p.getAll();
        if(userList == null || userList.isEmpty()){
            p.addNew(new User("K", "123", AuthorizationLevel.BOTH));
            p.addNew(new User("h", "123", AuthorizationLevel.LIBRARIAN));
        }
    }

    public static void addAdmin() {
        DataAccessFacade<User> userDataAccessFacade = new DataAccessFacadeImp<User>(User.class);
        DataAccessFacade<Admin> adminDataAccessFacade = new DataAccessFacadeImp<Admin>(Admin.class);

        List<User> userList = userDataAccessFacade.getAll();
        if(!userList.isEmpty()){
            adminDataAccessFacade.addNew(new Admin( "Karim", "Said","1212123434",new Address("4th north street","FairField","IA","52557"), userList.get(0)));
            adminDataAccessFacade.addNew(new Admin( "Hisham", "Mounir","1212123434",new Address("4th north street","FairField","IA","52557"), userList.get(1)));
        }
    }

    public static void addBook() {
        DataAccessFacade<Book> bookDataAccessFacade = new DataAccessFacadeImp<Book>(Book.class);
        List<Book> bookList = bookDataAccessFacade.getAll();
        if(bookList == null || bookList.isEmpty()){
            Book book1 = new Book("555", "Effective Java", 10);
            Book book2 = new Book("333", "How to Program Java", 10);
            List<Author> authors = new ArrayList<>();
            authors.add(new Author("Josh", "Senior", "111", null, "writer"));
            book1.setAuthors(authors);

            List<BookCopy> bookCopies = new ArrayList<>();
            bookCopies.add(new BookCopy(5, true, book1));
            bookCopies.add(new BookCopy(15, true, book2));
            book1.setBookCopies(bookCopies);
            book2.setBookCopies(bookCopies);

            bookDataAccessFacade.addNew(book1);
            bookDataAccessFacade.addNew(book2);
        }
    }

    public static void addMember() {
        DataAccessFacade<LibraryMember> libraryMemberDataAccessFacade = new DataAccessFacadeImp<LibraryMember>(LibraryMember.class);
        libraryMemberDataAccessFacade.addNew(new LibraryMember("Hisham","Mounir","121212",null,"1"));
    }
}
