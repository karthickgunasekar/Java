package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJunit {

	@Test(expected = AssertionError.class)
	public void testJunit(){	
		String str = new String("Setted up Junit");
		//assertEquals("Setted up Junti",str);
		//assertFalse("Results in False assertion",str.equals("Setted up Junit"));
		String str1 = new String("Setted up Junit");
		System.out.println(str1==str);
		assertSame(str,str1);
	}
}
