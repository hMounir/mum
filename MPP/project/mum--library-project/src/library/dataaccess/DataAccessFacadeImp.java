package library.dataaccess;

import java.util.List;

public class DataAccessFacadeImp<T> implements DataAccessFacade<T> {
	private StorageUtility<T> storage;
	public DataAccessFacadeImp(Class<T> typeClass) {
		storage=new StorageUtility<>(typeClass.getSimpleName());

	}

	@Override
	public T addNew(T element) {
		// TODO Auto-generated method stub
		List<T> prs=getAll();
		prs.add(element);
		storage.write(prs);
		return element;
	}



	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub

		return  storage.read();
	}

	@Override
	public void update(List<T> list) {
		// TODO Auto-generated method stub
		storage.write(list);

	}

}
