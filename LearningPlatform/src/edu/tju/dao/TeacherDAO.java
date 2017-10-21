package edu.tju.dao;

import edu.etju.model.*;

import java.util.List;
import java.util.Set;

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
 * Teacher entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.tju.dao.Teacher
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TeacherDAO {
	private static final Logger log = LoggerFactory.getLogger(TeacherDAO.class);
	// property constants
	public static final String TID = "tid";
	public static final String TUSERNAME = "tusername";
	public static final String TPASSWORD = "tpassword";
	public static final String ICON = "icon";
	public static final String TANAME = "taname";
	public static final String SCHOOL = "school";
	public static final String COLLEGE = "college";
	public static final String ICARD = "icard";

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

	public Teacher checkTeacher(String tid){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String sql = "from Teacher where tid = ?";
		Query query = session.createQuery(sql).setString(0, tid);
		System.out.print(query.toString());
		List list = query.list();
		Teacher teacher = new Teacher();
		ts.commit();
		session.close();
		if(list.size() != 0){
			teacher = (Teacher) list.get(0);
			return teacher;
		}
		else
			return null;
	}
	
	public void save(Teacher transientInstance) {
		log.debug("saving Teacher instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Teacher persistentInstance) {
		log.debug("deleting Teacher instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Teacher findById(java.lang.Integer id) {
		log.debug("getting Teacher instance with id: " + id);
		try {
			Teacher instance = (Teacher) getCurrentSession().get(
					"edu.tju.dao.Teacher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Teacher instance) {
		log.debug("finding Teacher instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("edu.tju.dao.Teacher")
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
		log.debug("finding Teacher instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Teacher as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTid(Object tid) {
		return findByProperty(TID, tid);
	}

	public List findByTusername(Object tusername) {
		return findByProperty(TUSERNAME, tusername);
	}

	public List findByTpassword(Object tpassword) {
		return findByProperty(TPASSWORD, tpassword);
	}

	public List findByIcon(Object icon) {
		return findByProperty(ICON, icon);
	}

	public List findByTaname(Object taname) {
		return findByProperty(TANAME, taname);
	}

	public List findBySchool(Object school) {
		return findByProperty(SCHOOL, school);
	}

	public List findByCollege(Object college) {
		return findByProperty(COLLEGE, college);
	}

	public List findByIcard(Object icard) {
		return findByProperty(ICARD, icard);
	}

	public List findAll() {
		log.debug("finding all Teacher instances");
		try {
			String queryString = "from Teacher";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Teacher merge(Teacher detachedInstance) {
		log.debug("merging Teacher instance");
		try {
			Teacher result = (Teacher) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Teacher instance) {
		log.debug("attaching dirty Teacher instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Teacher instance) {
		log.debug("attaching clean Teacher instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TeacherDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TeacherDAO) ctx.getBean("TeacherDAO");
	}
}