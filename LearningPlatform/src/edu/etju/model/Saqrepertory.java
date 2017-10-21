package edu.etju.model;

/**
 * Saqrepertory entity. @author MyEclipse Persistence Tools
 */

public class Saqrepertory implements java.io.Serializable {

	// Fields

	private SaqrepertoryId id;
	private Teacher teacher;

	// Constructors

	/** default constructor */
	public Saqrepertory() {
	}

	/** minimal constructor */
	public Saqrepertory(SaqrepertoryId id) {
		this.id = id;
	}

	/** full constructor */
	public Saqrepertory(SaqrepertoryId id, Teacher teacher) {
		this.id = id;
		this.teacher = teacher;
	}

	// Property accessors

	public SaqrepertoryId getId() {
		return this.id;
	}

	public void setId(SaqrepertoryId id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}