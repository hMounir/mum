package library.business;

import library.dataaccess.BookDataAccess;
import library.dataaccess.DataAccessFacade;
import library.dataaccess.DataAccessFacadeImp;
import library.dataaccess.MembersDataAccess;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Person implements Serializable {


	private List<Book> books;
	private List<LibraryMember>libraryMembers;
	private User user;
 

    public Admin(String firstName, String lastName, String phone, Address address,User user) {
        super(firstName, lastName, phone, address);
        this.books=new ArrayList<>();
        this.libraryMembers=new ArrayList<>();
        this.user=user;
    }

	public User getUser() {
		return user;
	}

	public void addNewLibrarianMember(LibraryMember libraryMember) throws Exception{
		MembersDataAccess memberAccess = new MembersDataAccess(LibraryMember.class);

		boolean isExists=MemberIsExists(libraryMember);
		if(!isExists) {
			libraryMembers.add(libraryMember);
			memberAccess.addNew(libraryMember);
		}
		else {
			throw new Exception("MemberAlreadyExists");
		}

	}
    
    private boolean MemberIsExists(LibraryMember libraryMember) {
		MembersDataAccess memberAccess = new MembersDataAccess(LibraryMember.class);
    	if(libraryMembers == null || libraryMembers.isEmpty())
    		return false;
		return memberAccess.checkId(libraryMember.getMemberId());
    }
    

    public void addNewBookCopy(Book book) {
		BookDataAccess bookAccess = new BookDataAccess(Book.class);
    	List<Book> books=bookAccess.getAll();
    	
    	for(Book bk:books) {
    		if(bk.getISBN().equals(book.getISBN())) {
    			bk.getBookCopies().add(new BookCopy(bk.getBookCopies().size()+1, true, bk));
    		}
    	}
		bookAccess.update(books);
    }
    
    public void addAuthor(Author author) {
		DataAccessFacade<Author> authAccess = new DataAccessFacadeImp<Author>(Author.class);

    	authAccess.addNew(author);
    }
    public List<Author> getAllAuthor(){
		DataAccessFacade<Author> authAccess = new DataAccessFacadeImp<Author>(Author.class);
    	return authAccess.getAll();
    }
}
