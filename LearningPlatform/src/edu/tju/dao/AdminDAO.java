package edu.tju.dao;

import edu.etju.model.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
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
 * A data access object (DAO) providing persistence and search support for Admin
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see edu.tju.dao.Admin
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class AdminDAO {
	private static final Logger log = LoggerFactory.getLogger(AdminDAO.class);
	// property constants
	public static final String AUSERNAME = "ausername";
	public static final String APASSWORD = "apassword";

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
	
	public Admin checkAdmin(int aid){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String sql = "from Admin where aid =?";
		
		Query query = session.createQuery(sql);
		System.out.print(query.toString());
		query.setInteger(0, aid);
		System.out.print(query.toString());
		List list = query.list();
		Admin admin = new Admin();
		ts.commit();
		session.close();
		if(list.size() != 0){
			admin = (Admin) list.get(0);
			return admin;
		}
		else
			return null;
	}
	
	public void save(Admin transientInstance) {
		log.debug("saving Admin instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Admin persistentInstance) {
		log.debug("deleting Admin instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Admin findById(java.lang.Integer id) {
		log.debug("getting Admin instance with id: " + id);
		try {
			Admin instance = (Admin) getCurrentSession().get(
					"edu.tju.dao.Admin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Admin instance) {
		log.debug("finding Admin instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("edu.tju.dao.Admin")
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
		log.debug("finding Admin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Admin as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAusername(Object ausername) {
		return findByProperty(AUSERNAME, ausername);
	}

	public List findByApassword(Object apassword) {
		return findByProperty(APASSWORD, apassword);
	}

	public List findAll() {
		log.debug("finding all Admin instances");
		try {
			String queryString = "from Admin";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Admin merge(Admin detachedInstance) {
		log.debug("merging Admin instance");
		try {
			Admin result = (Admin) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Admin instance) {
		log.debug("attaching dirty Admin instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Admin instance) {
		log.debug("attaching clean Admin instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdminDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AdminDAO) ctx.getBean("AdminDAO");
	}
}