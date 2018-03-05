package years.year2018.months02;

import junit.framework.TestCase;

public class Day28Test extends TestCase {
	public void testDay28Max(){
		assertEquals(9,new Day28().max(new int[]{1,2,3,4,9}) );
		assertEquals(9,new Day28().max(new int[]{}) );
	}
}
