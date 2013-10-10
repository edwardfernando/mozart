package mozart.api.dao;

import java.util.List;

import mozart.common.db.util.HibernateUtil;
import mozart.common.exception.MozartException;
import mozart.common.pagination.FilterableDao;
import mozart.common.pagination.FilterableQuery;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

public abstract class AbstractDAO<T> implements FilterableDao {

	protected abstract Class<T> getModel();

	public final Session getSession() {
		return SessionFactoryUtils.getSession(HibernateUtil.getSessionFactory(), true);
	}

	@SuppressWarnings("unchecked")
	public List<T> loadAll() {
		Session session = getSession();
		try {
			session.beginTransaction();
			return session.createQuery(
			    "from " + getModel().getName() + " domain order by domain.id asc").list();
		} catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public T loadById(Long id) {
		Session session = getSession();
		try {
			Query query = session.createQuery("from " +
			                                  getModel().getName() +
			                                  " domain where domain.id =:id");
			query.setLong("id", id);
			return (T) query.uniqueResult();
		} catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	public Long save(T obj) {
		Session session = getSession();
		try {
			return (Long) session.save(obj);
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	public void update(T obj) {
		Session session = getSession();
		try {
			session.update(obj);
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	public void delete(T obj) {
		Session session = getSession();
		try {
			session.delete(obj);
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	public Object execUnique(String query) {
		Session session = getSession();
		try {
			return session.createQuery(query).uniqueResult();
		} catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	public Object execUnique(String query, Object[] parameters) throws MozartException {
		Session session = getSession();
		try {
			Query object = session.createQuery(query);
			setParameters(object, parameters);
			return object.uniqueResult();
		} catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	public Object execList(String query) {
		Session session = getSession();
		try {
			return session.createQuery(query).list();
		} catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	public Object execList(String query, Object[] parameters) throws MozartException {
		Session session = getSession();
		try {
			Query object = session.createQuery(query);
			setParameters(object, parameters);
			return object.list();
		} catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	public Object execUnique(Query query, Session session) {
		try {
			return query.uniqueResult();
		} catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	public Object execList(Query query, Session session) {
		try {
			return query.list();
		} catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	@Override
	public List<?> filter(FilterableQuery query) {
		query.setFilterableDao(this);
		return query.execute();
	}

	// @Override
	// public Long count(FilterableQuery query) {
	// query.setFilterableDao(this);
	// return query.count();
	// }

	private void setParameters(Query query, Object... parameters) throws MozartException {
		if (parameters == null || parameters.length == 0) {
			return;
		}

		for (int i = 0; i < parameters.length; i++) {
			if (parameters[i] == null) {
				throw new MozartException("Query Parameter at position " + (i + 1) + " is null");
			}
			query.setParameter(i, parameters[i]);
		}
	}
}
