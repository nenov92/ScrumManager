package main.database;

public interface GenericDaoInterface<T> {

	public void createOrUpdate(T object);

	public void delete(T object);

	public T findBySymbolName(String name);
}