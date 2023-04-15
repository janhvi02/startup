package com.startuporg.model;

import javax.persistence.*;


@Entity
@Table
public class AuditQuestionSet {

	@EmbeddedId
	private AuditQuestionSetKey auditQuestionSetKey;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "processarea", referencedColumnName = "processarea", insertable = false, updatable = false),
		@JoinColumn(name = "questioncategory", referencedColumnName = "questioncategory", insertable = false, updatable = false)
	})
	private QuestionCategory questionCategory;
	
	@Column(columnDefinition = "VARCHAR(100)")
	private String question;
	
	@Column
	private double weight;
	
	@Column
	private double maxscore;

	public AuditQuestionSetKey getAuditQuestionSetKey() {
		return auditQuestionSetKey;
	}

	public void setAuditQuestionSetKey(AuditQuestionSetKey auditQuestionSetKey) {
		this.auditQuestionSetKey = auditQuestionSetKey;
	}

	

	public QuestionCategory getQuestionCategory() {
		return questionCategory;
	}

	public void setQuestionCategory(QuestionCategory questionCategory) {
		this.questionCategory = questionCategory;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getMaxscore() {
		return maxscore;
	}

	public void setMaxscore(double maxscore) {
		this.maxscore = maxscore;
	}


	public AuditQuestionSet(AuditQuestionSetKey auditQuestionSetKey, QuestionCategory questionCategory, String question,
			double weight, double maxscore) {
		super();
		this.auditQuestionSetKey = auditQuestionSetKey;
		this.questionCategory = questionCategory;
		this.question = question;
		this.weight = weight;
		this.maxscore = maxscore;
	}

	public AuditQuestionSet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
