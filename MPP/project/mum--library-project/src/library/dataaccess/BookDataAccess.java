package library.dataaccess;

import library.business.Book;
import library.business.BookCopy;
import library.userexception.BookException;

import java.util.List;

public class BookDataAccess extends DataAccessFacadeImp<Book> {

	public BookDataAccess(Class<Book> typeClass) {
		super(typeClass);
		// TODO Auto-generated constructor stub
	}
	
	public boolean checkBook(String isbn) {
		List<Book> books=getAll();
		for(Book book:books) {
			if(book.getISBN().equals(isbn)) {
				return true;
			}
		}


		return false;
	}
	
	public boolean isAvailable(String isbn) {
		List<Book> books=getAll();
		for(Book book:books) {
			if(book.getISBN().equals(isbn)) {
				for(BookCopy copy:book.getBookCopies()) {
					if(copy.getIsAvailable()) { 
						return true;
						}
				}
			}
		}


		return false;
	}
	
	public BookCopy getAvailableCopy(String isbn) throws BookException {
		List<Book> books=getAll();
		for(Book book:books) {
			if(book.getISBN().equals(isbn)) {
				for(BookCopy copy:book.getBookCopies()) {
					if(copy.getIsAvailable()) { 
						return copy;
						}
				}
			}
		}
		throw new BookException("there is no available book copy ");

	}

	public void unvailableCopy(BookCopy bCopy) {
		// TODO Auto-generated method stub
		List<Book> books=getAll();
		for(Book book:books) {
			if(book.getISBN().equals(bCopy.getBook().getISBN())) {
				for(BookCopy copy:book.getBookCopies()) {
					if(copy.getCopyNum()==bCopy.getCopyNum()) { 
						copy.setAvailable(false);
						}
				}
			}
		}
		update(books);
	}
	
	public Book getBookByIsbn(String isbn) throws BookException {
		List<Book> books=getAll();
		Book result= books.stream().filter(f->f.getISBN().equals(isbn))
		.findAny()
		.orElse(null);
		if(result==null) throw new BookException("Book not found !!");
		return result;
	}
	
	public int getCountOfAvailableCopies(String isbn) throws BookException {
		Book book=getBookByIsbn(isbn);
		int count=0;
		
		for(BookCopy copy:book.getBookCopies()) {
			if(copy.getIsAvailable())count++;
		}
		return count;
	}

}
