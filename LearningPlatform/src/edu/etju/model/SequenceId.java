package edu.etju.model;

/**
 * SequenceId entity. @author MyEclipse Persistence Tools
 */

public class SequenceId implements java.io.Serializable {

	// Fields

	private String tablename;
	private Integer idgenerator;

	// Constructors

	/** default constructor */
	public SequenceId() {
	}

	/** full constructor */
	public SequenceId(String tablename, Integer idgenerator) {
		this.tablename = tablename;
		this.idgenerator = idgenerator;
	}

	// Property accessors

	public String getTablename() {
		return this.tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public Integer getIdgenerator() {
		return this.idgenerator;
	}

	public void setIdgenerator(Integer idgenerator) {
		this.idgenerator = idgenerator;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SequenceId))
			return false;
		SequenceId castOther = (SequenceId) other;

		return ((this.getTablename() == castOther.getTablename()) || (this
				.getTablename() != null && castOther.getTablename() != null && this
				.getTablename().equals(castOther.getTablename())))
				&& ((this.getIdgenerator() == castOther.getIdgenerator()) || (this
						.getIdgenerator() != null
						&& castOther.getIdgenerator() != null && this
						.getIdgenerator().equals(castOther.getIdgenerator())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTablename() == null ? 0 : this.getTablename().hashCode());
		result = 37
				* result
				+ (getIdgenerator() == null ? 0 : this.getIdgenerator()
						.hashCode());
		return result;
	}

}