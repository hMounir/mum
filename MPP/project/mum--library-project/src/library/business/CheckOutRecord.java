package library.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckOutRecord  implements Serializable {
	private List<CheckOutRecordEntry> checkOutRecordEntries;

	public CheckOutRecord() {
		checkOutRecordEntries=new ArrayList<CheckOutRecordEntry>();
	}

	public List<CheckOutRecordEntry> getCheckOutRecordEntries() {
		return checkOutRecordEntries;
	}
	
	

}
