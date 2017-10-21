package edu.tju.dao;

import edu.etju.model.*;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Vrepertory entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.tju.dao.Vrepertory
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class VrepertoryDAO {
	private static final Logger log = LoggerFactory
			.getLogger(VrepertoryDAO.class);
	// property constants
	public static final String VNAME = "vname";
	public static final String CONTEXT = "context";
	public static final String VADDRESS = "vaddress";
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

	public List getAllVideos(){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Vrepertory");
		List videos = query.list();
		ts.commit();
		session.close();
		return videos;
	}
	
	public Vrepertory getVideo(int vid){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String sql = "from Vrepertory where vid = ?";
		Query query = session.createQuery(sql).setInteger(0,vid);
		Vrepertory video = new Vrepertory();
		List list = query.list();
		ts.commit();
		session.close();
		if(list.size() != 0){
			video = (Vrepertory) list.get(0);
			return video;
		}
		else
			return null;
	}
	
	public void save(Vrepertory transientInstance) {
		log.debug("saving Vrepertory instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Vrepertory persistentInstance) {
		log.debug("deleting Vrepertory instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vrepertory findById(java.lang.Integer id) {
		log.debug("getting Vrepertory instance with id: " + id);
		try {
			Vrepertory instance = (Vrepertory) getCurrentSession().get(
					"edu.tju.dao.Vrepertory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Vrepertory instance) {
		log.debug("finding Vrepertory instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("edu.tju.dao.Vrepertory")
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
		log.debug("finding Vrepertory instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Vrepertory as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByVname(Object vname) {
		return findByProperty(VNAME, vname);
	}

	public List findByContext(Object context) {
		return findByProperty(CONTEXT, context);
	}

	public List findByVaddress(Object vaddress) {
		return findByProperty(VADDRESS, vaddress);
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
		log.debug("finding all Vrepertory instances");
		try {
			String queryString = "from Vrepertory";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Vrepertory merge(Vrepertory detachedInstance) {
		log.debug("merging Vrepertory instance");
		try {
			Vrepertory result = (Vrepertory) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Vrepertory instance) {
		log.debug("attaching dirty Vrepertory instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vrepertory instance) {
		log.debug("attaching clean Vrepertory instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VrepertoryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (VrepertoryDAO) ctx.getBean("VrepertoryDAO");
	}
}