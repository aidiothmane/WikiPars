package org.tsapp.questions.impl;



import org.tsaap.quesions.impl.DefaultAnswerBlock;
import org.tsaap.quesions.impl.DefaultQuestion;
import org.tsaap.questions.TextBlock;

import junit.framework.TestCase;

public class DefaultQuestionTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testaddAnswerBlock(){
		DefaultAnswerBlock defaultAnswerBlock = new DefaultAnswerBlock();
		DefaultQuestion defaultQuestion= new DefaultQuestion();
		defaultQuestion.addAnswerBlock(defaultAnswerBlock);
		int sizeBlock = defaultQuestion.getBlockList().size();
		int sizeAnswerBlock = defaultQuestion.getAnswerBlockList().size();
		assertFalse(sizeBlock==0);
		assertFalse(sizeAnswerBlock==0);
	}
	public void testaddTextBlock(){
		TextBlock text =null;
		DefaultQuestion question= new DefaultQuestion();
		question.addTextBlock(text);
		int sizeBlock = question.getBlockList().size();
		int sizeTextBlock = question.getTextBlockList().size();
		assertFalse(sizeBlock==0);
		assertFalse(sizeTextBlock==0);

	}
}
