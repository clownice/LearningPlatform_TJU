package edu.etju.model;

/**
 * Vrepertory entity. @author MyEclipse Persistence Tools
 */

public class Vrepertory implements java.io.Serializable {

	// Fields

	private Integer vid;
	private Teacher teacher;
	private String vname;
	private String context;
	private String vaddress;
	private String chapter;
	private String subject;
	private Integer belong;

	// Constructors

	/** default constructor */
	public Vrepertory() {
	}

	/** minimal constructor */
	public Vrepertory(Integer vid) {
		this.vid = vid;
	}

	/** full constructor */
	public Vrepertory(Integer vid, Teacher teacher, String vname,
			String context, String vaddress, String chapter, String subject,
			Integer belong) {
		this.vid = vid;
		this.teacher = teacher;
		this.vname = vname;
		this.context = context;
		this.vaddress = vaddress;
		this.chapter = chapter;
		this.subject = subject;
		this.belong = belong;
	}

	// Property accessors

	public Integer getVid() {
		return this.vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getVname() {
		return this.vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getVaddress() {
		return this.vaddress;
	}

	public void setVaddress(String vaddress) {
		this.vaddress = vaddress;
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