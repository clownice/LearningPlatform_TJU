package edu.etju.model;

/**
 * Esrepertory entity. @author MyEclipse Persistence Tools
 */

public class Esrepertory implements java.io.Serializable {

	// Fields

	private Integer eid;
	private Teacher teacher;
	private String ename;
	private Integer som;
	private String title;
	private String optioncontext;
	private String answer;
	private String chapter;
	private String subject;
	private Integer belong;

	// Constructors

	/** default constructor */
	public Esrepertory() {
	}

	/** minimal constructor */
	public Esrepertory(Integer eid) {
		this.eid = eid;
	}

	/** full constructor */
	public Esrepertory(Integer eid, Teacher teacher, String ename, Integer som,
			String title, String optioncontext, String answer, String chapter,
			String subject, Integer belong) {
		this.eid = eid;
		this.teacher = teacher;
		this.ename = ename;
		this.som = som;
		this.title = title;
		this.optioncontext = optioncontext;
		this.answer = answer;
		this.chapter = chapter;
		this.subject = subject;
		this.belong = belong;
	}

	// Property accessors

	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getSom() {
		return this.som;
	}

	public void setSom(Integer som) {
		this.som = som;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOptioncontext() {
		return this.optioncontext;
	}

	public void setOptioncontext(String optioncontext) {
		this.optioncontext = optioncontext;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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