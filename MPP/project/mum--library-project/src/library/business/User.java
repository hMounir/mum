package library.business;

import library.dataaccess.DataAccessFacade;
import library.dataaccess.DataAccessFacadeImp;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private String id;
    private String password;
    private AuthorizationLevel authorizationLevel;

    

    public User(String id, String password, AuthorizationLevel authorizationLevel) {
        this.id = id;
        this.password = password;
        this.authorizationLevel = authorizationLevel;
    }

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public AuthorizationLevel getAuthorizationLevel() {
        return authorizationLevel;
    }


    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equalsIgnoreCase(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equalsIgnoreCase(other.password))
			return false;
		return true;
	}

	public void login() throws Exception {
		DataAccessFacade<User> user=new DataAccessFacadeImp<User>(User.class);
		List<User> all =user.getAll();
		boolean loginFailed = true;
		for(User us:all) {
			if(us.equals(this)) {
				this.authorizationLevel = us.getAuthorizationLevel();
				loginFailed = false;
				break;
			}
		}
		if(loginFailed){
			throw new Exception("WrongLogin");
		}
    }
}