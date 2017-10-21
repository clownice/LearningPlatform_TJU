package edu.etju.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Fquestions entity. @author MyEclipse Persistence Tools
 */

public class Fquestions implements java.io.Serializable {

	// Fields

	private Integer qid;
	private Classmemeber classmemeber;
	private String context;
	private Integer asker;
	private Timestamp posttime;
	private Set fanswerses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Fquestions() {
	}

	/** minimal constructor */
	public Fquestions(Integer qid) {
		this.qid = qid;
	}

	/** full constructor */
	public Fquestions(Integer qid, Classmemeber classmemeber, String context,
			Integer asker, Timestamp posttime, Set fanswerses) {
		this.qid = qid;
		this.classmemeber = classmemeber;
		this.context = context;
		this.asker = asker;
		this.posttime = posttime;
		this.fanswerses = fanswerses;
	}

	// Property accessors

	public Integer getQid() {
		return this.qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public Classmemeber getClassmemeber() {
		return this.classmemeber;
	}

	public void setClassmemeber(Classmemeber classmemeber) {
		this.classmemeber = classmemeber;
	}

	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getAsker() {
		return this.asker;
	}

	public void setAsker(Integer asker) {
		this.asker = asker;
	}

	public Timestamp getPosttime() {
		return this.posttime;
	}

	public void setPosttime(Timestamp posttime) {
		this.posttime = posttime;
	}

	public Set getFanswerses() {
		return this.fanswerses;
	}

	public void setFanswerses(Set fanswerses) {
		this.fanswerses = fanswerses;
	}

}