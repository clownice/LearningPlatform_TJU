package edu.etju.model;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer aid;
	private Classmemeber classmemeber;
	private String sid;
	private String susername;
	private String spassword;
	private String icon;
	private String saname;
	private String school;
	private String college;
	private String icard;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Integer aid) {
		this.aid = aid;
	}

	/** full constructor */
	public Student(Integer aid, Classmemeber classmemeber, String sid,
			String susername, String spassword, String icon, String saname,
			String school, String college, String icard) {
		this.aid = aid;
		this.classmemeber = classmemeber;
		this.sid = sid;
		this.susername = susername;
		this.spassword = spassword;
		this.icon = icon;
		this.saname = saname;
		this.school = school;
		this.college = college;
		this.icard = icard;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Classmemeber getClassmemeber() {
		return this.classmemeber;
	}

	public void setClassmemeber(Classmemeber classmemeber) {
		this.classmemeber = classmemeber;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSusername() {
		return this.susername;
	}

	public void setSusername(String susername) {
		this.susername = susername;
	}

	public String getSpassword() {
		return this.spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getSaname() {
		return this.saname;
	}

	public void setSaname(String saname) {
		this.saname = saname;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getIcard() {
		return this.icard;
	}

	public void setIcard(String icard) {
		this.icard = icard;
	}

}