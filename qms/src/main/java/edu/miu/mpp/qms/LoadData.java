package edu.miu.mpp.qms;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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
	private static List<Professor> professorList = new ArrayList<>();
	
	public static List<User> getUsers() {
		return userList;
	}
	
   static List<Quiz> getQuizzes() {
		Professor p1 = new Professor("abc", "abc", "pf 1", "last name");
		
		Quiz quiz1 =  new Quiz(1L, LocalDateTime.of(2021, 1, 10,10,00), LocalDateTime.of(2021, 1, 10,12,00), 2.0, p1);
		
		Question question1 = new Question("Is Functional programming useful ?", "1", quiz1);
		Options option1 = new Options("Yes very useful", false, question1);
		Options option2 = new Options("Yes a little", true, question1);
		Options option3 = new Options("No it does not", false, question1);
		Options option4 = new Options("It depends", false, question1);	
		question1.setOptions(Arrays.asList(option1,option2,option3,option4));
		
		Question question2 = new Question("Put and Get rule", "2", quiz1);
		Options option5 = new Options("super wildcard for read", false, question2);
		Options option6 = new Options("extends wildcard for read", false, question2);
		Options option7 = new Options("? extends for read", true, question2);
		Options option8 = new Options("? super for get", false, question2);
		question2.setOptions(Arrays.asList(option5,option6,option7,option8));
		quiz1.setQuestion(Arrays.asList(question1,question2));
		
		quizzes.add(quiz1);
		
		return quizzes;
	}

	public static List<Professor> getProfessors() {
		return professorList;
	}
}
