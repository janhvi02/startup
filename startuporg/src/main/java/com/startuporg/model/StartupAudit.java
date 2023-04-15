package com.startuporg.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class StartupAudit {

	/*
	 * audit_Srno longint (primarykey) auditdate date auditorteam vc(255) auditee
	 * vc(255) processarea vc(100) questioncategory vc(100) question vc(255)
	 * actualscore double remark vc(999) evidenceupload vc(999)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int audit_srno;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date auditdate;
	@Column
	private String auditorteam;
	@Column
	private String auditee;
	@Column(length = 100)
	private String processarea;
	@Column(length = 100)
	private String questioncategory;
	@Column(length = 255)
	private String question;

	@Column
	private double actualscore;
	@Column
	private double weight;

	@Column
	private double maxscore;

	@Column
	private String remark;
	@Column
	private String evidenceupload;

	public long getAudit_srno() {
		return audit_srno;
	}

	public void setAudit_srno(int audit_srno) {
		this.audit_srno = audit_srno;
	}

	public Date getAuditdate() {
		return auditdate;
	}

	public void setAuditdate(Date auditdate) {
		this.auditdate = auditdate;
	}

	public String getAuditorteam() {
		return auditorteam;
	}

	public void setAuditorteam(String auditorteam) {
		this.auditorteam = auditorteam;
	}

	public String getAuditee() {
		return auditee;
	}

	public void setAuditee(String auditee) {
		this.auditee = auditee;
	}

	public double getActualscore() {
		return actualscore;
	}

	public void setActualscore(double actualscore) {
		this.actualscore = actualscore;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEvidenceupload() {
		return evidenceupload;
	}

	public void setEvidenceupload(String evidenceupload) {
		this.evidenceupload = evidenceupload;
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

	public String getProcessarea() {
		return processarea;
	}

	public void setProcessarea(String processarea) {
		this.processarea = processarea;
	}

	public String getQuestioncategory() {
		return questioncategory;
	}

	public void setQuestioncategory(String questioncategory) {
		this.questioncategory = questioncategory;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setMaxscore(double maxscore) {
		this.maxscore = maxscore;
	}

	public StartupAudit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StartupAudit(int audit_srno, Date auditdate, String auditorteam, String auditee, String processarea,
			String questioncategory, String question, double actualscore, double weight, double maxscore, String remark,
			String evidenceupload) {
		super();
		this.audit_srno = audit_srno;
		this.auditdate = auditdate;
		this.auditorteam = auditorteam;
		this.auditee = auditee;
		this.processarea = processarea;
		this.questioncategory = questioncategory;
		this.question = question;
		this.actualscore = actualscore;
		this.weight = weight;
		this.maxscore = maxscore;
		this.remark = remark;
		this.evidenceupload = evidenceupload;
	}

}
