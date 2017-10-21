package edu.etju.model;

import java.util.Date;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer aid;
	private String ausername;
	private String apassword;
	private Date rtime;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(Integer aid) {
		this.aid = aid;
	}

	/** full constructor */
	public Admin(Integer aid, String ausername, String apassword, Date rtime) {
		this.aid = aid;
		this.ausername = ausername;
		this.apassword = apassword;
		this.rtime = rtime;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAusername() {
		return this.ausername;
	}

	public void setAusername(String ausername) {
		this.ausername = ausername;
	}

	public String getApassword() {
		return this.apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}

	public Date getRtime() {
		return this.rtime;
	}

	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}

}