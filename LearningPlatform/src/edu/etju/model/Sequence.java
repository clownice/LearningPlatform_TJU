package edu.etju.model;

/**
 * Sequence entity. @author MyEclipse Persistence Tools
 */

public class Sequence implements java.io.Serializable {

	// Fields

	private SequenceId id;

	// Constructors

	/** default constructor */
	public Sequence() {
	}

	/** full constructor */
	public Sequence(SequenceId id) {
		this.id = id;
	}

	// Property accessors

	public SequenceId getId() {
		return this.id;
	}

	public void setId(SequenceId id) {
		this.id = id;
	}

}