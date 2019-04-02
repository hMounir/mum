package library.business;

import library.dataaccess.BookDataAccess;
import library.dataaccess.MembersDataAccess;
import library.userexception.BookException;
import library.userexception.MemberException;

import java.io.Serializable;
import java.time.LocalDate;

public class LibraryMember extends Person  implements Serializable {
	private String memberId;
    private CheckOutRecord checkOutRecord;

	public LibraryMember(String firstName, String lastName, String phone, Address address, String memberId) {
		super(firstName, lastName, phone, address);
		this.memberId = memberId;

	}

	public void setCheckOutRecord(CheckOutRecord checkOutRecord) {
		this.checkOutRecord = checkOutRecord;
	}

	public String getMemberId() {
		return memberId;
	}

	public CheckOutRecord getCheckOutRecord() {
		return checkOutRecord;
	}

	
	

	public void checkout(String isbn,String memberId) throws BookException, MemberException {
		BookDataAccess bookDA=new BookDataAccess(Book.class);
		MembersDataAccess member=new MembersDataAccess(LibraryMember.class);
		if(member.checkId(memberId)) {
			if(bookDA.checkBook(isbn)) {
				if(bookDA.isAvailable(isbn)) {
					BookCopy bCopy=bookDA.getAvailableCopy(isbn);
					CheckOutRecord check=new CheckOutRecord();
					bCopy.setAvailable(false);
					check.getCheckOutRecordEntries().add(new CheckOutRecordEntry(LocalDate.now(), LocalDate.now().plusDays(bCopy.getBook().getMaxCheckoutLength()), check, bCopy));
					this.checkOutRecord=check;
					member.addNew(this);
					bookDA.unvailableCopy(bCopy);
				}
				else {
					throw new BookException("Book copy unavailable !!");
				}
			}else {
				throw new BookException("Book not found !!");
			}
		}else {
			throw new MemberException("Member not found !!");
		}
	}
	

}
