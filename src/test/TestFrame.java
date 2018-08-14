package test;

import junit.framework.*;
import sourcecode.Frame;

public class TestFrame extends TestCase{
	public TestFrame(String name) {
		super(name);
	}
	
	public void testScoreNoThrows() {
		Frame f = new Frame();
		assertEquals( 0, f.getScore());
	}
	
	public void testAddoneThrow() {
		Frame f = new Frame();
		f.add(5);
		assertEquals(5, f.getScore());
	}
}
