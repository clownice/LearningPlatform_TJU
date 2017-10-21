package edu.etju.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Classmemeber entity. @author MyEclipse Persistence Tools
 */

public class Classmemeber implements java.io.Serializable {

	// Fields

	private String cid;
	private Teacher teacher;
	private Timestamp ctime;
	private String cplace;
	private Set students = new HashSet(0);
	private Set fquestionses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classmemeber() {
	}

	/** minimal constructor */
	public Classmemeber(String cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Classmemeber(String cid, Teacher teacher, Timestamp ctime,
			String cplace, Set students, Set fquestionses) {
		this.cid = cid;
		this.teacher = teacher;
		this.ctime = ctime;
		this.cplace = cplace;
		this.students = students;
		this.fquestionses = fquestionses;
	}

	// Property accessors

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Timestamp getCtime() {
		return this.ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public String getCplace() {
		return this.cplace;
	}

	public void setCplace(String cplace) {
		this.cplace = cplace;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public Set getFquestionses() {
		return this.fquestionses;
	}

	public void setFquestionses(Set fquestionses) {
		this.fquestionses = fquestionses;
	}

}