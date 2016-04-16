package main.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
public class SessionUtil {

	private static SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
	private static Session INSTANCE = null;

	private SessionUtil() {
	}
	
	public static void closeSession() {
		if (INSTANCE.isOpen()) {
			INSTANCE.close();
		}
	}

	public static synchronized Session getINSTANCE() {
		if (INSTANCE == null || !INSTANCE.isOpen()) {
			INSTANCE = sessionFactory.openSession();
		}
		return INSTANCE;
	}

	public static void beginTransaction() {
		if (!INSTANCE.getTransaction().isActive()) {
			INSTANCE.beginTransaction();
		}
	}

	public static void commitTransaction() {
		if (INSTANCE.isOpen() && INSTANCE.getTransaction().isActive() && !INSTANCE.getTransaction().wasRolledBack()) {
			INSTANCE.getTransaction().commit();
		}
	}

	public static void rollbackTransaction() {
		INSTANCE.getTransaction().rollback();
	}

}