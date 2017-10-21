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
 * Student entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.tju.dao.Student
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class StudentDAO {
	private static final Logger log = LoggerFactory.getLogger(StudentDAO.class);
	// property constants
	public static final String SID = "sid";
	public static final String SUSERNAME = "susername";
	public static final String SPASSWORD = "spassword";
	public static final String ICON = "icon";
	public static final String SANAME = "saname";
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
	
	public Student checkStudent(String sid){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String sql = "from Student where sid = ?";
		Query query = session.createQuery(sql).setString(0, sid);
		List list = query.list();
		Student student = new Student();
		ts.commit();
		session.close();
		if(list.size() != 0){
			student = (Student) list.get(0);
			return student;
		}
		else
			return null;
	}
	
	public void save(Student transientInstance) {
		log.debug("saving Student instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Student persistentInstance) {
		log.debug("deleting Student instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Student findById(java.lang.Integer id) {
		log.debug("getting Student instance with id: " + id);
		try {
			Student instance = (Student) getCurrentSession().get(
					"edu.tju.dao.Student", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Student instance) {
		log.debug("finding Student instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("edu.tju.dao.Student")
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
		log.debug("finding Student instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Student as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySid(Object sid) {
		return findByProperty(SID, sid);
	}

	public List findBySusername(Object susername) {
		return findByProperty(SUSERNAME, susername);
	}

	public List findBySpassword(Object spassword) {
		return findByProperty(SPASSWORD, spassword);
	}

	public List findByIcon(Object icon) {
		return findByProperty(ICON, icon);
	}

	public List findBySaname(Object saname) {
		return findByProperty(SANAME, saname);
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
		log.debug("finding all Student instances");
		try {
			String queryString = "from Student";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Student merge(Student detachedInstance) {
		log.debug("merging Student instance");
		try {
			Student result = (Student) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Student instance) {
		log.debug("attaching dirty Student instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Student instance) {
		log.debug("attaching clean Student instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StudentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StudentDAO) ctx.getBean("StudentDAO");
	}
}