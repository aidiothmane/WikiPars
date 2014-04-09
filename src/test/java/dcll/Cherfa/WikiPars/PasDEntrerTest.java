package dcll.Cherfa.WikiPars;

import junit.framework.TestCase;

public class PasDEntrerTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testErreurSyntax(){
		PasDEntrer bad1= new PasDEntrer();
		PasDEntrer bad2= new PasDEntrer("test");
		assertNotNull(bad1);
		assertNotNull(bad2);

	}

}
