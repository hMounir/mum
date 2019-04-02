package library.dataaccess;

public class AdminDataAccess<Admin> extends DataAccessFacadeImp<Admin>{

    public AdminDataAccess(Class<Admin> typeClass) {
        super(typeClass);
    }
}
