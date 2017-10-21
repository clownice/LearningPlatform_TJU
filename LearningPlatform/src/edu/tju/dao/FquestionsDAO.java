package edu.tju.dao;

import edu.etju.model.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Fquestions entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.tju.dao.Fquestions
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class FquestionsDAO {
	private static final Logger log = LoggerFactory
			.getLogger(FquestionsDAO.class);
	// property constants
	public static final String CONTEXT = "context";
	public static final String ASKER = "asker";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Fquestions transientInstance) {
		log.debug("saving Fquestions instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Fquestions persistentInstance) {
		log.debug("deleting Fquestions instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Fquestions findById(java.lang.Integer id) {
		log.debug("getting Fquestions instance with id: " + id);
		try {
			Fquestions instance = (Fquestions) getCurrentSession().get(
					"edu.tju.dao.Fquestions", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Fquestions instance) {
		log.debug("finding Fquestions instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("edu.tju.dao.Fquestions")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Fquestions instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Fquestions as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContext(Object context) {
		return findByProperty(CONTEXT, context);
	}

	public List findByAsker(Object asker) {
		return findByProperty(ASKER, asker);
	}

	public List findAll() {
		log.debug("finding all Fquestions instances");
		try {
			String queryString = "from Fquestions";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Fquestions merge(Fquestions detachedInstance) {
		log.debug("merging Fquestions instance");
		try {
			Fquestions result = (Fquestions) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Fquestions instance) {
		log.debug("attaching dirty Fquestions instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Fquestions instance) {
		log.debug("attaching clean Fquestions instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FquestionsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FquestionsDAO) ctx.getBean("FquestionsDAO");
	}
}