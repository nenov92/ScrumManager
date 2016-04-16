package main.database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * The MIT License
 * 
 * Copyright 2016 Miroslav Nenov <m.nenov92 at gmail.com>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be 
 * included in all copies or substantial portions of the Software. 
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE 
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
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

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findBySymbolNameRegex(String regex) {
		Criteria criteria = getCurrentSession().createCriteria(this.entityClass).add(Restrictions.like("name", regex));
		return criteria.list();
	}

}
