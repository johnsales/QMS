package edu.miu.mpp.qms.business;

import java.util.Collection;

public class Professor extends User {

	private Collection<Quiz> quiz;

	public Professor(String username, String password, String name, String lname, UserType userType ) {
		super(username, password, name, lname, userType);
	}


	public void getReport(Quiz quiz) {

	}

	public void createQuiz() {

	}

	public void updateQuiz() {

	}


	@Override
	public String toString() {
		return "Professor [quiz=" + quiz + ", getId()=" + getId() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getName()=" + getName() + ", getLname()=" + getLname()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
