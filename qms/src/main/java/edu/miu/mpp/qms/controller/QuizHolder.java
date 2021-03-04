package edu.miu.mpp.qms.controller;

import edu.miu.mpp.qms.business.Quiz;

public final class QuizHolder {

	private Quiz quiz;
	private final static QuizHolder INSTANCE = new QuizHolder();

	private QuizHolder() {
	}

	public static QuizHolder getInstance() {
	    return INSTANCE;
	  }

	public void setQuiz(Quiz q) {
		this.quiz = q;
	}

	public Quiz getQuiz() {
		return this.quiz;
	}
}