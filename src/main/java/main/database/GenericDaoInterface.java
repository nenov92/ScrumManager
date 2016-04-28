package main.database;

import java.util.List;

/**
 * @author Miroslav Nenov
 * Interface class for the Data Access Object
 * @param <T>
 */
public interface GenericDaoInterface<T> {

	public void createOrUpdate(T object);

	public void delete(T object);

	public T findByBlackboardEntryName(String name);

	public List<T> findByBlackboardEntryNameRegex(String regex);
}