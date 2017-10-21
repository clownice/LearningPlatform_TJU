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
 * Kprepertory entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see edu.tju.dao.Kprepertory
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class KprepertoryDAO {
	private static final Logger log = LoggerFactory
			.getLogger(KprepertoryDAO.class);
	// property constants
	public static final String KPNAME = "kpname";
	public static final String CONTEXT = "context";
	public static final String RPICTURE = "rpicture";
	public static final String CHAPTER = "chapter";
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

	public void save(Kprepertory transientInstance) {
		log.debug("saving Kprepertory instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Kprepertory persistentInstance) {
		log.debug("deleting Kprepertory instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Kprepertory findById(java.lang.Integer id) {
		log.debug("getting Kprepertory instance with id: " + id);
		try {
			Kprepertory instance = (Kprepertory) getCurrentSession().get(
					"edu.tju.dao.Kprepertory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Kprepertory instance) {
		log.debug("finding Kprepertory instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("edu.tju.dao.Kprepertory")
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
		log.debug("finding Kprepertory instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Kprepertory as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByKpname(Object kpname) {
		return findByProperty(KPNAME, kpname);
	}

	public List findByContext(Object context) {
		return findByProperty(CONTEXT, context);
	}

	public List findByRpicture(Object rpicture) {
		return findByProperty(RPICTURE, rpicture);
	}

	public List findByChapter(Object chapter) {
		return findByProperty(CHAPTER, chapter);
	}

	public List findBySubject(Object subject) {
		return findByProperty(SUBJECT, subject);
	}

	public List findByBelong(Object belong) {
		return findByProperty(BELONG, belong);
	}

	public List findAll() {
		log.debug("finding all Kprepertory instances");
		try {
			String queryString = "from Kprepertory";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Kprepertory merge(Kprepertory detachedInstance) {
		log.debug("merging Kprepertory instance");
		try {
			Kprepertory result = (Kprepertory) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Kprepertory instance) {
		log.debug("attaching dirty Kprepertory instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Kprepertory instance) {
		log.debug("attaching clean Kprepertory instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static KprepertoryDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (KprepertoryDAO) ctx.getBean("KprepertoryDAO");
	}
}