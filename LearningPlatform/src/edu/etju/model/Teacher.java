package edu.etju.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer aid;
	private String tid;
	private String tusername;
	private String tpassword;
	private String icon;
	private String taname;
	private String school;
	private String college;
	private String icard;
	private Set classmemebers = new HashSet(0);
	private Set vrepertories = new HashSet(0);
	private Set esrepertories = new HashSet(0);
	private Set saqrepertories = new HashSet(0);
	private Set irepertories = new HashSet(0);
	private Set kprepertories = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Integer aid) {
		this.aid = aid;
	}

	/** full constructor */
	public Teacher(Integer aid, String tid, String tusername, String tpassword,
			String icon, String taname, String school, String college,
			String icard, Set classmemebers, Set vrepertories,
			Set esrepertories, Set saqrepertories, Set irepertories,
			Set kprepertories) {
		this.aid = aid;
		this.tid = tid;
		this.tusername = tusername;
		this.tpassword = tpassword;
		this.icon = icon;
		this.taname = taname;
		this.school = school;
		this.college = college;
		this.icard = icard;
		this.classmemebers = classmemebers;
		this.vrepertories = vrepertories;
		this.esrepertories = esrepertories;
		this.saqrepertories = saqrepertories;
		this.irepertories = irepertories;
		this.kprepertories = kprepertories;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTusername() {
		return this.tusername;
	}

	public void setTusername(String tusername) {
		this.tusername = tusername;
	}

	public String getTpassword() {
		return this.tpassword;
	}

	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTaname() {
		return this.taname;
	}

	public void setTaname(String taname) {
		this.taname = taname;
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

	public Set getClassmemebers() {
		return this.classmemebers;
	}

	public void setClassmemebers(Set classmemebers) {
		this.classmemebers = classmemebers;
	}

	public Set getVrepertories() {
		return this.vrepertories;
	}

	public void setVrepertories(Set vrepertories) {
		this.vrepertories = vrepertories;
	}

	public Set getEsrepertories() {
		return this.esrepertories;
	}

	public void setEsrepertories(Set esrepertories) {
		this.esrepertories = esrepertories;
	}

	public Set getSaqrepertories() {
		return this.saqrepertories;
	}

	public void setSaqrepertories(Set saqrepertories) {
		this.saqrepertories = saqrepertories;
	}

	public Set getIrepertories() {
		return this.irepertories;
	}

	public void setIrepertories(Set irepertories) {
		this.irepertories = irepertories;
	}

	public Set getKprepertories() {
		return this.kprepertories;
	}

	public void setKprepertories(Set kprepertories) {
		this.kprepertories = kprepertories;
	}

}