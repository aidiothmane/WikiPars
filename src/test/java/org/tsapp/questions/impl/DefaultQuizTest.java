package org.tsapp.questions.impl;



import org.tsaap.quesions.impl.DefaultQuestion;
import org.tsaap.quesions.impl.DefaultQuiz;

import junit.framework.TestCase;

public class DefaultQuizTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testaddQuestion(){
		DefaultQuiz defaultQuiz = new DefaultQuiz();
		DefaultQuestion defaultQuestion = new DefaultQuestion();
		defaultQuiz.addQuestion(defaultQuestion);
		int sizeQuestion = defaultQuiz.getQuestionList().size();
		assertFalse(sizeQuestion==0);
	}
	
	public void testgetQuestionList(){
		DefaultQuiz defaultQuiz = new DefaultQuiz();
		DefaultQuestion defaultQuestion = new DefaultQuestion();
		defaultQuiz.addQuestion(defaultQuestion);
		int sizeQuestion = defaultQuiz.getQuestionList().size();
		assertTrue(sizeQuestion==1);
	}

}
