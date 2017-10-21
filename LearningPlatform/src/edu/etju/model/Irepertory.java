package edu.etju.model;

/**
 * Irepertory entity. @author MyEclipse Persistence Tools
 */

public class Irepertory implements java.io.Serializable {

	// Fields

	private Integer iid;
	private Teacher teacher;
	private String iname;
	private String context;
	private String chapte;
	private String subject;
	private Integer belong;

	// Constructors

	/** default constructor */
	public Irepertory() {
	}

	/** minimal constructor */
	public Irepertory(Integer iid) {
		this.iid = iid;
	}

	/** full constructor */
	public Irepertory(Integer iid, Teacher teacher, String iname,
			String context, String chapte, String subject, Integer belong) {
		this.iid = iid;
		this.teacher = teacher;
		this.iname = iname;
		this.context = context;
		this.chapte = chapte;
		this.subject = subject;
		this.belong = belong;
	}

	// Property accessors

	public Integer getIid() {
		return this.iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getIname() {
		return this.iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getChapte() {
		return this.chapte;
	}

	public void setChapte(String chapte) {
		this.chapte = chapte;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getBelong() {
		return this.belong;
	}

	public void setBelong(Integer belong) {
		this.belong = belong;
	}

}