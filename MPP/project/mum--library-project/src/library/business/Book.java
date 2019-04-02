package library.business;

import library.dataaccess.BookDataAccess;
import library.userexception.BookException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable{
	private String ISBN;
	private String title;
	private int maxCheckoutLength;
	private List<BookCopy> bookCopies;
	private List<Author>authors;
	public Book(String iSBN, String title, int maxCheckoutLength) {
		this.ISBN = iSBN;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
		this.bookCopies=new ArrayList<>();
		this.authors=new ArrayList<>();
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setBookCopies(List<BookCopy> bookCopies) {
		this.bookCopies = bookCopies;
	}

	public String getISBN() {
		return ISBN;
	}
	public String getTitle() {
		return title;
	}
	public int getMaxCheckoutLength() {
		return maxCheckoutLength;
	}
	public List<BookCopy> getBookCopies() {
		return bookCopies;
	}
	public int getCountAvailableCopies() {
		BookDataAccess book=new BookDataAccess(Book.class);
		try {
			return book.getCountOfAvailableCopies(getISBN());
		} catch (BookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", maxCheckoutLength=" + maxCheckoutLength + ", bookCopies="
				+ bookCopies + ", authors=" + authors + "]";
	}
	

}
