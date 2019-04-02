package library.business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckOutRecordEntry implements Serializable {
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private CheckOutRecord checkOutRecord;
	private BookCopy bookCopy;
	public CheckOutRecordEntry(LocalDate checkoutDate, LocalDate dueDate,CheckOutRecord checkOutRecord,BookCopy bookCopy) {
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.checkOutRecord=this.checkOutRecord;
		this.bookCopy=bookCopy;
	}
	public CheckOutRecord getCheckOutRecord() {
		return checkOutRecord;
	}
	public BookCopy getBookCopy() {
		return bookCopy;
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	
	

}
