package edu.tju.dao;

import edu.etju.model.*;
import java.util.List;
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
 * Irepertory entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.tju.dao.Irepertory
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class IrepertoryDAO {
	private static final Logger log = LoggerFactory
			.getLogger(IrepertoryDAO.class);
	// property constants
	public static final String INAME = "iname";
	public static final String CONTEXT = "context";
	public static final String CHAPTE = "chapte";
	public static final String SUBJECT = "subject";
	public static final String BELONG = "belong";

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

	public void save(Irepertory transientInstance) {
		log.debug("saving Irepertory instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Irepertory persistentInstance) {
		log.debug("deleting Irepertory instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Irepertory findById(java.lang.Integer id) {
		log.debug("getting Irepertory instance with id: " + id);
		try {
			Irepertory instance = (Irepertory) getCurrentSession().get(
					"edu.tju.dao.Irepertory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Irepertory instance) {
		log.debug("finding Irepertory instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("edu.tju.dao.Irepertory")
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
		log.debug("finding Irepertory instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Irepertory as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIname(Object iname) {
		return findByProperty(INAME, iname);
	}

	public List findByContext(Object context) {
		return findByProperty(CONTEXT, context);
	}

	public List findByChapte(Object chapte) {
		return findByProperty(CHAPTE, chapte);
	}

	public List findBySubject(Object subject) {
		return findByProperty(SUBJECT, subject);
	}

	public List findByBelong(Object belong) {
		return findByProperty(BELONG, belong);
	}

	public List findAll() {
		log.debug("finding all Irepertory instances");
		try {
			String queryString = "from Irepertory";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Irepertory merge(Irepertory detachedInstance) {
		log.debug("merging Irepertory instance");
		try {
			Irepertory result = (Irepertory) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Irepertory instance) {
		log.debug("attaching dirty Irepertory instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Irepertory instance) {
		log.debug("attaching clean Irepertory instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IrepertoryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IrepertoryDAO) ctx.getBean("IrepertoryDAO");
	}
}