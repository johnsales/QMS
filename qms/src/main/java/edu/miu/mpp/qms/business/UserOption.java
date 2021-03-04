package edu.miu.mpp.qms.business;

public class UserOption {

	private Options option;
	private Student student;
	
	public UserOption(Options option, Student student) {
		this.option = option;
		this.student = student;
	}
	
	public Options getOption() {
		return option;
	}
	public void setOption(Options option) {
		this.option = option;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	
}
