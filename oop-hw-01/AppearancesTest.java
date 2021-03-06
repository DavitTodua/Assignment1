import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.*;

public class AppearancesTest extends TestCase {
	// utility -- converts a string to a list with one
	// elem for each char.
	@Test
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	@Test
	public void testSameCount1() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		assertEquals(3, Appearances.sameCount(a, b));
	}
	@Test
	public void testSameCount2() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
	}
	@Test
	public void testSameCount3() {
		List<String> a = stringToList("abcabcabc");
		List<String> b = stringToList("aaabbbccc");
		assertEquals(3, Appearances.sameCount(a, b));
	}
	@Test
	public void testSameCount4() {
		List<String> a = stringToList("a");
		List<String> b = stringToList("");
		assertEquals(0, Appearances.sameCount(a, b));
	}
}
