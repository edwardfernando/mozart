package mozart.common.filter;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.context.ManagedSessionContext;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;

public class HibernateSessionRequestFilter extends OpenSessionInViewFilter {

	@Override
	protected Session getSession(SessionFactory sessionFactory)
	        throws DataAccessResourceFailureException {
		Session session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		ManagedSessionContext.bind(session);
		session.beginTransaction();
		return session;
	}

	@Override
	protected void closeSession(org.hibernate.Session session, SessionFactory sessionFactory) {
		ManagedSessionContext.unbind(sessionFactory);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

}
