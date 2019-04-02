package library.dataaccess;

import library.business.CheckOutRecordEntry;
import library.business.LibraryMember;

import java.util.ArrayList;
import java.util.List;


public class MembersDataAccess extends DataAccessFacadeImp<LibraryMember>{


    public MembersDataAccess(Class<LibraryMember> typeClass) {
        super(typeClass);
    }
    
    public boolean checkId(String memberId) {
		List<LibraryMember> libs=getAll();
		
		for(LibraryMember lib:libs) {
			if(lib.getMemberId().equals(memberId)) return true;
		}
		return false;
	}

    public List<CheckOutRecordEntry> getCheckoutEntriesByMemberId(String memberId){
    	List<CheckOutRecordEntry> entries=new ArrayList<>();
    	List<LibraryMember> members= getAll();
    	for(LibraryMember member:members) {
    		if(member.getMemberId().equals(memberId))
    			entries.addAll(member.getCheckOutRecord().getCheckOutRecordEntries());
    	}
    	return entries;
    }
    
    public List<CheckOutRecordEntry> getCheckoutEntries(){
    	List<CheckOutRecordEntry> entries=new ArrayList<>();
    	List<LibraryMember> members= getAll();
    	for(LibraryMember member:members) {
    			if(member.getCheckOutRecord()!=null)entries.addAll(member.getCheckOutRecord().getCheckOutRecordEntries());
    	}
    	return entries;
    }
}
