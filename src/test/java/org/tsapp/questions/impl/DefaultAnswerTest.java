package org.tsapp.questions.impl;



import org.tsaap.quesions.impl.DefaultAnswer;
import org.tsaap.quesions.impl.DefaultQuiz;

import junit.framework.TestCase;

public class DefaultAnswerTest extends TestCase {
	public void testequals(){
		DefaultAnswer d = new DefaultAnswer();
		DefaultAnswer e = new DefaultAnswer();
		d.setIdentifier("test");
		e.setIdentifier("test");
		DefaultQuiz q = new DefaultQuiz();
		assertFalse(d.equals(q));
		assertTrue(d.equals(e));
	}
	
	public void testhashCode(){
		DefaultAnswer a = new DefaultAnswer();
		a.setIdentifier("test");
		assertEquals(a.hashCode(),a.getIdentifier().hashCode());
	}
	
	public void testgetTextValue(){
		DefaultAnswer a = new DefaultAnswer();
		a.setTextValue("test");
		assertSame("test",a.getTextValue());
	}
	
	public void testsetTextValue(){
		DefaultAnswer a = new DefaultAnswer();
		a.setTextValue("test");
		assertSame("test",a.getTextValue());
	}
	
	public void testgetPercentCredit(){
		DefaultAnswer a = new DefaultAnswer();
		a.setPercentCredit(3.6f);
		assertNotSame(3.6f,a.getPercentCredit());
	}
	
	public void testsetPercentCredit(){
		DefaultAnswer a = new DefaultAnswer();
		a.setPercentCredit(3.6f);
		assertNotSame(3.6f,a.getPercentCredit());
	}
	
	public void testgetIdentifier(){
		DefaultAnswer a = new DefaultAnswer();
		a.setIdentifier("test");
		assertSame("test",a.getIdentifier());
	}
	
	public void testsetIdentifier(){
		DefaultAnswer a = new DefaultAnswer();
		a.setIdentifier("test");
		assertSame("test",a.getIdentifier());
	}
	
	public void testgetFeedBack(){
		DefaultAnswer a = new DefaultAnswer();
		a.setFeedback("test");
		assertSame("test",a.getFeedBack());
	}
	
	public void testsetFeedBack(){
		DefaultAnswer a = new DefaultAnswer();
		a.setFeedback("test");
		assertSame("test",a.getFeedBack());
	}	
}
