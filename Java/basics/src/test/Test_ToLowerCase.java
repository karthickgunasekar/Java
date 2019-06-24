package test;

import static org.junit.Assert.*;

import java.io.Console;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.demo.ToLowerCase;

public class Test_ToLowerCase {
	ToLowerCase toLowerCase = new ToLowerCase();

	@Before
	public void beforeTest() {
		assertNull(toLowerCase.scanner);
		assertEquals(toLowerCase.T, 0);
	}

	@After
	public void afterTest() {
		assertNotNull(toLowerCase);
		toLowerCase = null;
	}

	@Test()
	public void test() {
		String[] s = toLowerCase.scan();
		assertNotNull(toLowerCase.scanner);
		assertFalse("Value is " + toLowerCase.T, toLowerCase.T == 0);
		// read values not null
		assertNotNull(s);
		assertFalse("Not Greater than 100 as input values", (3< toLowerCase.T));

	}

}
