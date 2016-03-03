package main.database;

import java.util.List;

public interface GenericDaoInterface<T> {

	public void createOrUpdate(T object);

	public void delete(T object);

	public T findBySymbolName(String name);

	public List<T> findBySymbolNameRegex(String regex);
}