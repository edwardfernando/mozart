package mozart.common.filter;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.internal.ManagedSessionContext;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;

public class HibernateSessionRequestFilter extends OpenSessionInViewFilter {

	protected Session getSession(SessionFactory sessionFactory)
	        throws DataAccessResourceFailureException {
		Session session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		ManagedSessionContext.bind(session);
		session.beginTransaction();
		return session;
	}

	protected void closeSession(org.hibernate.Session session, SessionFactory sessionFactory) {
		ManagedSessionContext.unbind(sessionFactory);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

}
