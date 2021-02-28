package edu.miu.mpp.qms.business;

import java.util.Collection;

public class Student extends User {

	private int StudentId;
	private Collection<Result> result;

	public Student(String username, String password, String name, String lname, int StudentId) {
		super(username, password, name, lname);
		this.StudentId = StudentId;
	}

	public void doQuiz(Quiz quiz) {

	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public Collection<Result> getResult() {
		return result;
	}

	public void setResult(Collection<Result> result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + StudentId;
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (StudentId != other.StudentId)
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		return true;
	}
}
