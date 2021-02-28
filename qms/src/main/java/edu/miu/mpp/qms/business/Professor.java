package edu.miu.mpp.qms.business;

import java.util.Collection;

public class Professor extends User {

	private Collection<Quiz> quiz;

	public Professor(String username, String password, String name, String lname) {
		super(username, password, name, lname);
	}


	public void getReport(Quiz quiz) {

	}

	public void createQuiz() {

	}

	public void updateQuiz() {

	}

}
