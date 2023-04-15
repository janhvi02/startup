package com.startuporg.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class QuestionCategoryKey implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String processarea;
	
    
	private String questioncategory;
	
    // No-argument constructor
	public QuestionCategoryKey() {
		super();
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

	public QuestionCategoryKey(String processarea, String questioncategory) {
		super();
		this.processarea = processarea;
		this.questioncategory = questioncategory;
	}

	
    // Override equals() method
    @Override
	public boolean equals(Object obj) {
        if (this == obj) return true; // same object reference
        if (obj == null || getClass() != obj.getClass()) return false; // null or different class
        QuestionCategoryKey that = (QuestionCategoryKey) obj; // cast to same class
        return Objects.equals(processarea, that.processarea) && Objects.equals(questioncategory, that.questioncategory); // compare fields
    }

    // Override hashCode() method
    @Override
	public int hashCode() {
        return Objects.hash(processarea, questioncategory); // generate hash code based on fields
    }
}