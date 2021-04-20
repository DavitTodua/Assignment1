import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

// Provided testing for simple Point class.

public class PointTest extends TestCase {
	@Test
	public void test1() {
		// test basic x/y/shift behavior
		Point p = new Point(1, 2);
		assertEquals(1.0, p.getX());
		assertEquals(2.0, p.getY());
		Point p2 = p.shiftedPoint(10, -10);
		assertEquals(11.0, p2.getX());
		assertEquals(-8.0, p2.getY());	
	}
	@Test
	public void test2() {
		// test distance() and equals()
		Point p1 = new Point(1, 1);
		Point p2 = new Point(1, 4);
		assertEquals(3.0, p1.distance(p2));
		assertEquals(3.0, p2.distance(p1));
		assertFalse(p1.equals(p2));
		assertTrue(p1.equals(new Point(p1)));
		assertEquals(p1, p2.shiftedPoint(0, -3));
	}

	@Test
	public void test3() {
		// test tostring method and distance

		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, 4);
		//test tostring
		assertEquals("0.0 0.0",p1.toString());
		assertEquals("0.0 4.0",p2.toString());
		//test distance
		assertEquals(4.0, p1.distance(p2));
		assertEquals(4.0, p2.distance(p1));
	}

	@Test
	public void test4() {
		// test equals

		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, 4);
		assertFalse(p1.equals(p2));
		Point p3 = new Point(0, 4);
		assertTrue(p2.equals(p2));
		Point p4 = new Point(2,1);
		assertFalse(p4.equals(p1));

	}

	@Test
	public void test5() {
		// test shiftedPoint

		Point p1 = new Point(2, 1);
		Point p2 = new Point(2, 5);
		p1 = p1.shiftedPoint(0, 4);

		//assertTrue(p1.equals(p2));

		p1.shiftedPoint(1,0);
		assertFalse(p1.equals(p2));

		p2.shiftedPoint(10,2);
		assertFalse(p2.equals(p1));

	}
}
