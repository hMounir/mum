package library.business;

import java.io.Serializable;

public class BookCopy  implements Serializable {
	private int copyNum;
	private boolean isAvailable;
	private Book book;

	public BookCopy(int copyNum,boolean isAvailable,Book book) {
		this.copyNum = copyNum;
		this.isAvailable=isAvailable;
		this.book=book;
	}

	public Book getBook() {
		return book;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getCopyNum() {
		return copyNum;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}
	@Override
	public String toString() {
		return "BookCopy [copyNum=" + copyNum + ", isAvailable=" + isAvailable + "]";
	}

}
