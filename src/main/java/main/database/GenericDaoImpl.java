package main.database;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class GenericDaoImpl<T> implements GenericDaoInterface<T> {

	private Session currentSession;
	private Class<T> entityClass;

	public GenericDaoImpl() {
	}

	public GenericDaoImpl(Session globalSession, Class<T> entityClass) {
		setCurrentSession(globalSession);
		this.setEntityClass(entityClass);
	}

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

	@Override
	public void createOrUpdate(T object) {
		getCurrentSession().saveOrUpdate(object);
	}

	@Override
	public void delete(T object) {
		getCurrentSession().delete(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findBySymbolName(String name) {
		Criteria criteria = getCurrentSession().createCriteria(this.entityClass).add(Restrictions.eq("name", name));
		return (T) criteria.uniqueResult();
	}

}
