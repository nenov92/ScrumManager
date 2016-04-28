package main.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Miroslav Nenov
 * Utility class that generates sessionFactory object
 * used to create sessions to the database 
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			// read xml configuration file
			Configuration configuration = new Configuration();
			configuration.configure("/config/hibernate.cfg.xml");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}