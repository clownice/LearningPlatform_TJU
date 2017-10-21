package edu.etju.model;

/**
 * SaqrepertoryId entity. @author MyEclipse Persistence Tools
 */

public class SaqrepertoryId implements java.io.Serializable {

	// Fields

	private Integer saqid;
	private String saqname;
	private String context;
	private String answer;
	private String chapter;
	private String subject;
	private Teacher teacher;
	private Integer belong;

	// Constructors

	/** default constructor */
	public SaqrepertoryId() {
	}

	/** full constructor */
	public SaqrepertoryId(Integer saqid, String saqname, String context,
			String answer, String chapter, String subject, Teacher teacher,
			Integer belong) {
		this.saqid = saqid;
		this.saqname = saqname;
		this.context = context;
		this.answer = answer;
		this.chapter = chapter;
		this.subject = subject;
		this.teacher = teacher;
		this.belong = belong;
	}

	// Property accessors

	public Integer getSaqid() {
		return this.saqid;
	}

	public void setSaqid(Integer saqid) {
		this.saqid = saqid;
	}

	public String getSaqname() {
		return this.saqname;
	}

	public void setSaqname(String saqname) {
		this.saqname = saqname;
	}

	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
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

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Integer getBelong() {
		return this.belong;
	}

	public void setBelong(Integer belong) {
		this.belong = belong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SaqrepertoryId))
			return false;
		SaqrepertoryId castOther = (SaqrepertoryId) other;

		return ((this.getSaqid() == castOther.getSaqid()) || (this.getSaqid() != null
				&& castOther.getSaqid() != null && this.getSaqid().equals(
				castOther.getSaqid())))
				&& ((this.getSaqname() == castOther.getSaqname()) || (this
						.getSaqname() != null && castOther.getSaqname() != null && this
						.getSaqname().equals(castOther.getSaqname())))
				&& ((this.getContext() == castOther.getContext()) || (this
						.getContext() != null && castOther.getContext() != null && this
						.getContext().equals(castOther.getContext())))
				&& ((this.getAnswer() == castOther.getAnswer()) || (this
						.getAnswer() != null && castOther.getAnswer() != null && this
						.getAnswer().equals(castOther.getAnswer())))
				&& ((this.getChapter() == castOther.getChapter()) || (this
						.getChapter() != null && castOther.getChapter() != null && this
						.getChapter().equals(castOther.getChapter())))
				&& ((this.getSubject() == castOther.getSubject()) || (this
						.getSubject() != null && castOther.getSubject() != null && this
						.getSubject().equals(castOther.getSubject())))
				&& ((this.getTeacher() == castOther.getTeacher()) || (this
						.getTeacher() != null && castOther.getTeacher() != null && this
						.getTeacher().equals(castOther.getTeacher())))
				&& ((this.getBelong() == castOther.getBelong()) || (this
						.getBelong() != null && castOther.getBelong() != null && this
						.getBelong().equals(castOther.getBelong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSaqid() == null ? 0 : this.getSaqid().hashCode());
		result = 37 * result
				+ (getSaqname() == null ? 0 : this.getSaqname().hashCode());
		result = 37 * result
				+ (getContext() == null ? 0 : this.getContext().hashCode());
		result = 37 * result
				+ (getAnswer() == null ? 0 : this.getAnswer().hashCode());
		result = 37 * result
				+ (getChapter() == null ? 0 : this.getChapter().hashCode());
		result = 37 * result
				+ (getSubject() == null ? 0 : this.getSubject().hashCode());
		result = 37 * result
				+ (getTeacher() == null ? 0 : this.getTeacher().hashCode());
		result = 37 * result
				+ (getBelong() == null ? 0 : this.getBelong().hashCode());
		return result;
	}

}