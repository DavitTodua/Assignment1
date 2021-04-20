
// Test cases for CharGrid -- a few basic tests are provided.

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class CharGridTest extends TestCase {
	@Test
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	
	@Test
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}
	@Test
	public void testCountPlusfor1() {
		char[][] grid = new char[][]{
				{'a', 'b', 'c'},
				{'b', 'b', 'b'},
				{'a', 'b', 'c'}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(1,cg.countPlus());
	}
	@Test
	public void testCountPlusfor2() {
		char[][] grid = new char[][]{
				{'a', 'b', 'c','k','c','c'},
				{'b', 'b', 'b','c','c','c'},
				{'a', 'b', 'c','a','c','c'}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(2,cg.countPlus());
	}
	@Test
	public void testCountPlusfor0() {
		char[][] grid = new char[][]{
				{'k', 'b', 'c','k','m','c'},
				{'a', 'b', 'b','c','c','c'},
				{'a', 'b', 'c','a','c','c'}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(0,cg.countPlus());
	}

	
	
	
	
}
