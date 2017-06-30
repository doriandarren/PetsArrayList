package test;

import org.junit.Assert;
import org.junit.Test;

import util.Input;

public class TestInput {
	
	//@Test
	public void testInput(){		
		int actual = Input.scanInt();
		int expected = 10;		
		Assert.assertEquals(expected, actual);
	}
	
	
	//@Test
	public void testFloat(){		
		float actual = Input.scanFloat();
		float expected = 10.4f;		
		Assert.assertEquals(expected, actual,0.1);
	}
	
	
	
}
