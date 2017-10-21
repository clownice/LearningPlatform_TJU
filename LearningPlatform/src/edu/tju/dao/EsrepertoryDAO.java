package edu.tju.dao;

import edu.etju.model.Esrepertory;

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
 * Esrepertory entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see edu.tju.dao.Esrepertory
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class EsrepertoryDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EsrepertoryDAO.class);
	// property constants
	public static final String ENAME = "ename";
	public static final String SOM = "som";
	public static final String TITLE = "title";
	public static final String OPTIONCONTEXT = "optioncontext";
	public static final String ANSWER = "answer";
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
	
	
	
	//select exact exercise where eid=eid
	public Esrepertory showExercise(int eid){
		Session session = sessionFactory.getCurrentSession();
		Transaction ts= session.beginTransaction();
		
		String sql = "from Esrepertory where eid=?";
		Query query = session.createQuery(sql).setInteger(0, eid);
		
		List list = query.list();
		Esrepertory exercise = new Esrepertory();
		ts.commit();
		session.close();
		if(!list.isEmpty()){
			exercise = (Esrepertory)list.get(0);
			return exercise;
		
		}
		else
			return null;
	}
	
	//select cout(number) exercise on Page page 
	public List showAllSelectionExercise(int page, int number){
		int beginnumber = (page - 1) * number;

		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		String sql2 = "select eid from esrepertory where som=1 limit ?,1";
		Query query2 = session.createSQLQuery(sql2).setInteger(0, beginnumber);
		
		
		int beginid = (Integer) query2.list().get(0);
		System.out.println(beginid + number);
		String sql = "from Esrepertory where som=1 and eid >= ?";
		Query query  = session.createQuery(sql).setMaxResults(number);
		
		query.setInteger(0, beginid);
		System.out.println(query);
		List list = query.list();
		//Esrepertory es = (Esrepertory) query.list().get(0);
		//System.out.println(es.getTitle());
		ts.commit();
		session.close();
		if(!list.isEmpty()){
			return list;
		}
		else
			return null;
		
	}
	
	
	public void save(Esrepertory transientInstance) {
		log.debug("saving Esrepertory instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Esrepertory persistentInstance) {
		log.debug("deleting Esrepertory instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Esrepertory findById(java.lang.Integer id) {
		log.debug("getting Esrepertory instance with id: " + id);
		try {
			Esrepertory instance = (Esrepertory) getCurrentSession().get(
					"edu.tju.dao.Esrepertory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Esrepertory instance) {
		log.debug("finding Esrepertory instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("edu.tju.dao.Esrepertory")
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
		log.debug("finding Esrepertory instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Esrepertory as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEname(Object ename) {
		return findByProperty(ENAME, ename);
	}

	public List findBySom(Object som) {
		return findByProperty(SOM, som);
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByOptioncontext(Object optioncontext) {
		return findByProperty(OPTIONCONTEXT, optioncontext);
	}

	public List findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
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
		log.debug("finding all Esrepertory instances");
		try {
			String queryString = "from Esrepertory";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Esrepertory merge(Esrepertory detachedInstance) {
		log.debug("merging Esrepertory instance");
		try {
			Esrepertory result = (Esrepertory) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Esrepertory instance) {
		log.debug("attaching dirty Esrepertory instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Esrepertory instance) {
		log.debug("attaching clean Esrepertory instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EsrepertoryDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (EsrepertoryDAO) ctx.getBean("EsrepertoryDAO");
	}
}