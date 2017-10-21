package edu.etju.model;

import java.sql.Timestamp;

/**
 * Fanswers entity. @author MyEclipse Persistence Tools
 */

public class Fanswers implements java.io.Serializable {

	// Fields

	private Integer answerid;
	private Fquestions fquestions;
	private String context;
	private Integer replyer;
	private Timestamp answertime;

	// Constructors

	/** default constructor */
	public Fanswers() {
	}

	/** minimal constructor */
	public Fanswers(Integer answerid) {
		this.answerid = answerid;
	}

	/** full constructor */
	public Fanswers(Integer answerid, Fquestions fquestions, String context,
			Integer replyer, Timestamp answertime) {
		this.answerid = answerid;
		this.fquestions = fquestions;
		this.context = context;
		this.replyer = replyer;
		this.answertime = answertime;
	}

	// Property accessors

	public Integer getAnswerid() {
		return this.answerid;
	}

	public void setAnswerid(Integer answerid) {
		this.answerid = answerid;
	}

	public Fquestions getFquestions() {
		return this.fquestions;
	}

	public void setFquestions(Fquestions fquestions) {
		this.fquestions = fquestions;
	}

	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getReplyer() {
		return this.replyer;
	}

	public void setReplyer(Integer replyer) {
		this.replyer = replyer;
	}

	public Timestamp getAnswertime() {
		return this.answertime;
	}

	public void setAnswertime(Timestamp answertime) {
		this.answertime = answertime;
	}

}