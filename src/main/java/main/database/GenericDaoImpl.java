package main.database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


/**
 * @author Miroslav Nenov
 *
 * @param <T> object of any type
 */
public class GenericDaoImpl<T> implements GenericDaoInterface<T> {

	// Hibernate session to the database
	private Session currentSession;
	private Class<T> entityClass;

	// default empty constructor
	public GenericDaoImpl() {
	}

	public GenericDaoImpl(Session globalSession, Class<T> entityClass) {
		setCurrentSession(globalSession);
		this.setEntityClass(entityClass);
	}

	/**
	 * getter and setter methods
	 */
	
	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/* (non-Javadoc)
	 * @see main.database.GenericDaoInterface#createOrUpdate(java.lang.Object)
	 * method to store object in the database
	 */
	@Override
	public void createOrUpdate(T object) {
		getCurrentSession().saveOrUpdate(object);
	}

	/* (non-Javadoc)
	 * @see main.database.GenericDaoInterface#delete(java.lang.Object)
	 * method to delete object from the database
	 */
	@Override
	public void delete(T object) {
		getCurrentSession().delete(object);
	}

	/* (non-Javadoc)
	 * @see main.database.GenericDaoInterface#findByBlackboardEntryName(java.lang.String)
	 * load object by its name
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findByBlackboardEntryName(String name) {
		Criteria criteria = getCurrentSession().createCriteria(this.entityClass).add(Restrictions.eq("name", name));
		return (T) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see main.database.GenericDaoInterface#findByBlackboardEntryNameRegex(java.lang.String)
	 * load object which partially fulfills the name restriction 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByBlackboardEntryNameRegex(String regex) {
		Criteria criteria = getCurrentSession().createCriteria(this.entityClass).add(Restrictions.like("name", regex));
		return criteria.list();
	}

}
