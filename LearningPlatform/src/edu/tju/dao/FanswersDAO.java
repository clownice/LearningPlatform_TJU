package edu.tju.dao;

import edu.etju.model.Fanswers;
import java.sql.Timestamp;
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
 * Fanswers entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.tju.dao.Fanswers
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class FanswersDAO {
	private static final Logger log = LoggerFactory
			.getLogger(FanswersDAO.class);
	// property constants
	public static final String CONTEXT = "context";
	public static final String REPLYER = "replyer";

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

	public void save(Fanswers transientInstance) {
		log.debug("saving Fanswers instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Fanswers persistentInstance) {
		log.debug("deleting Fanswers instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Fanswers findById(java.lang.Integer id) {
		log.debug("getting Fanswers instance with id: " + id);
		try {
			Fanswers instance = (Fanswers) getCurrentSession().get(
					"edu.tju.dao.Fanswers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Fanswers instance) {
		log.debug("finding Fanswers instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("edu.tju.dao.Fanswers")
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
		log.debug("finding Fanswers instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Fanswers as model where model."
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

	public List findByReplyer(Object replyer) {
		return findByProperty(REPLYER, replyer);
	}

	public List findAll() {
		log.debug("finding all Fanswers instances");
		try {
			String queryString = "from Fanswers";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Fanswers merge(Fanswers detachedInstance) {
		log.debug("merging Fanswers instance");
		try {
			Fanswers result = (Fanswers) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Fanswers instance) {
		log.debug("attaching dirty Fanswers instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Fanswers instance) {
		log.debug("attaching clean Fanswers instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FanswersDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FanswersDAO) ctx.getBean("FanswersDAO");
	}
}