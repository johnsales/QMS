package edu.miu.mpp.qms.dao;

import java.util.ArrayList;
import java.util.List;

import edu.miu.mpp.qms.business.Professor;
import edu.miu.mpp.qms.business.Quiz;
import edu.miu.mpp.qms.business.Student;
import edu.miu.mpp.qms.business.User;

public class LoadData {

	//temp data without database
	private static List<User> userList = new ArrayList<>();
	private static List<Quiz> quizzes = new ArrayList<>();
	private static List<Professor> professorList = new ArrayList<>();
	private static List<Student> studentList = new ArrayList<>();
	
	public static List<User> getUsers() {
		return userList;
	}
}
