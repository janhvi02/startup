package com.startuporg.model;

import javax.persistence.*;

@Entity
@Table
public class QuestionCategory {
	@EmbeddedId
    private QuestionCategoryKey questionCategoryKey;

	
	public QuestionCategory(QuestionCategoryKey questionCategoryKey) {
		super();
		this.questionCategoryKey = questionCategoryKey;
	}


	public QuestionCategoryKey getQuestionCategoryKey() {
		return questionCategoryKey;
	}


	public void setQuestionCategoryKey(QuestionCategoryKey questionCategoryKey) {
		this.questionCategoryKey = questionCategoryKey;
	}


	public QuestionCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
