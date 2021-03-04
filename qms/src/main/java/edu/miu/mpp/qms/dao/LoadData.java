package edu.miu.mpp.qms.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.miu.mpp.qms.business.Options;
import edu.miu.mpp.qms.business.Professor;
import edu.miu.mpp.qms.business.Question;
import edu.miu.mpp.qms.business.Quiz;
import edu.miu.mpp.qms.business.User;

public class LoadData {

	//temp data without database
	private static List<User> userList = new ArrayList<>();
	private static List<Quiz> quizzes = new ArrayList<>();
	
	public static List<User> getUsers() {
		return userList;
	}
	
	public static List<Quiz> getQuizzes() {
		Professor p1 = new Professor("abc", "abc", "pf 1", "last name");
		Professor p2 = new Professor("abc", "abc", "pf 2", "pf 2");

		
		
		Quiz quiz1 =  new Quiz(1L, LocalDateTime.of(2021, 1, 10,10,00), LocalDateTime.of(2021, 1, 10,12,00), 2.0, p1);
		Quiz quiz2 =  new Quiz(1L, LocalDateTime.of(2021, 1, 10,10,00), LocalDateTime.of(2021, 1, 10,12,00), 2.0, p2);
		
		
		Question question1 = new Question("Question 1", "1", quiz1);
		Options option1 = new Options("Option 1", false, question1);
		Options option2 = new Options("Option 2", true, question1);
		Options option3 = new Options("Option 3", false, question1);
		Options option4 = new Options("Option 4", false, question1);
		
		Question question2 = new Question("Question 2", "2", quiz1);
		Options option5 = new Options("Option 1", false, question2);
		Options option6 = new Options("Option 2", false, question2);
		Options option7 = new Options("Option 3", true, question2);
		Options option8 = new Options("Option 4", false, question2);
		
		Question question3 = new Question("Question 3", "3", quiz2);
		Options option9 = new Options("Option 1", false, question3);
		Options option10 = new Options("Option 2", false, question3);
		Options option11 = new Options("Option 3", true, question3);
		Options option12 = new Options("Option 4", false, question3);
		
		Question question4 = new Question("Question 4", "4", quiz2);
		Options option13 = new Options("Option 1", false, question4);
		Options option14 = new Options("Option 2", false, question4);
		Options option15 = new Options("Option 3", true, question4);
		Options option16 = new Options("Option 4", false, question4);
		
		quizzes.add(quiz1);
		quizzes.add(quiz2);
		
		return quizzes;
	}

}
