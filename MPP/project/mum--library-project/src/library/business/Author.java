package library.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Author extends Person implements Serializable {

    private String credentials;
    private List<Book> books;

    public Author() {
    }

    public Author(String firstName, String lastName, String phone, Address address, String credentials) {
        super(firstName, lastName, phone, address);
        this.credentials = credentials;
        this.books=new ArrayList<>();
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }
    @Override
	public String toString() {
		return "Author [credentials=" + credentials + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((credentials == null) ? 0 : credentials.hashCode());
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
		Author other = (Author) obj;
		if (credentials == null) {
			if (other.credentials != null)
				return false;
		} else if (!credentials.equals(other.credentials))
			return false;
		return true;
	}
    
    
    
}
