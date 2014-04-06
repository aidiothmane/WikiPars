package org.tsapp.questions.impl;



import java.util.List;

import junit.framework.TestCase;

import org.tsaap.quesions.impl.DefaultAnswer;
import org.tsaap.quesions.impl.DefaultAnswerBlock;
import org.tsaap.questions.Answer;



public class DefaultAnswerBlockTest extends TestCase{
	
	public void testaddAnswer(){
		DefaultAnswerBlock d=new DefaultAnswerBlock();
		DefaultAnswer an = new DefaultAnswer();
		d.addAnswer(an);
		assertFalse(d.getAnswerList().size()==0);
	}
	
	public void testgetAnswerList(){
		DefaultAnswerBlock d=new DefaultAnswerBlock();
		List<Answer> answers=d.getAnswerList();
		assertTrue(answers.size()==0);
	}
}
