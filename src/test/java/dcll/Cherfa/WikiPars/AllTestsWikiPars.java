package dcll.Cherfa.WikiPars;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTestsWikiPars {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTestsWikiPars.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(ErreurSyntaxTest.class);
		suite.addTestSuite(PasDEntrerTest.class);
		suite.addTestSuite(WikiReaderTest.class);
		//$JUnit-END$
		return suite;
	}

}
