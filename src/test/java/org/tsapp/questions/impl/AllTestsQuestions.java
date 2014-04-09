package org.tsapp.questions.impl;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTestsQuestions {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTestsQuestions.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(DefaultAnswerBlockTest.class);
		suite.addTestSuite(DefaultAnswerTest.class);
		suite.addTestSuite(DefaultQuestionTest.class);
		suite.addTestSuite(DefaultQuizTest.class);
		suite.addTestSuite(DefaultUserAnswerBlockTest.class);
		suite.addTestSuite(DefaultUserResponseTest.class);
		//$JUnit-END$
		return suite;
	}

}
