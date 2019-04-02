package library.dataaccess;

import java.util.List;

public interface DataAccessFacade<T> {
	
	
	T addNew(T element);
	List<T> getAll();
	void update(List<T> list);


}
