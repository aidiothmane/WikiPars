package dcll.Cherfa.WikiPars;

import junit.framework.TestCase;

public class ErreurSyntaxTest extends TestCase {
	public void testBadSyntaxException(){
		ErreurSyntax bad1= new ErreurSyntax();
		ErreurSyntax bad2= new ErreurSyntax("test");
		assertNotNull(bad1);
		assertNotNull(bad2);
}
}
