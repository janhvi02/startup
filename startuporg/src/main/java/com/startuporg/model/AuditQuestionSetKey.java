package com.startuporg.model;

import javax.persistence.Column;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class AuditQuestionSetKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int srno;

	private String processarea;

	private String questioncategory;

	public int getSrno() {
		return srno;
	}

	public void setSrno(int srno) {
		this.srno = srno;
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

	public AuditQuestionSetKey(int srno, String processarea, String questioncategory) {
		super();
		this.srno = srno;
		this.processarea = processarea;
		this.questioncategory = questioncategory;
	}

	public AuditQuestionSetKey() {
		super();
		// TODO Auto-generated constructor stub
	}

}
