package edu.etju.model;

/**
 * Kprepertory entity. @author MyEclipse Persistence Tools
 */

public class Kprepertory implements java.io.Serializable {

	// Fields

	private Integer kpid;
	private Teacher teacher;
	private String kpname;
	private String context;
	private String rpicture;
	private String chapter;
	private String subject;
	private Integer belong;

	// Constructors

	/** default constructor */
	public Kprepertory() {
	}

	/** minimal constructor */
	public Kprepertory(Integer kpid) {
		this.kpid = kpid;
	}

	/** full constructor */
	public Kprepertory(Integer kpid, Teacher teacher, String kpname,
			String context, String rpicture, String chapter, String subject,
			Integer belong) {
		this.kpid = kpid;
		this.teacher = teacher;
		this.kpname = kpname;
		this.context = context;
		this.rpicture = rpicture;
		this.chapter = chapter;
		this.subject = subject;
		this.belong = belong;
	}

	// Property accessors

	public Integer getKpid() {
		return this.kpid;
	}

	public void setKpid(Integer kpid) {
		this.kpid = kpid;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getKpname() {
		return this.kpname;
	}

	public void setKpname(String kpname) {
		this.kpname = kpname;
	}

	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getRpicture() {
		return this.rpicture;
	}

	public void setRpicture(String rpicture) {
		this.rpicture = rpicture;
	}

	public String getChapter() {
		return this.chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
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