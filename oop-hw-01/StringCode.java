import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int max = 0;
		int curr = 1;
		for(int i =0; i< str.length()-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				curr++;
			} else {
				if(curr > max) {
					max = curr;
				}
				curr = 1;
			}
		}
		return max;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		//System.out.println(Character.getNumericValue('&'));
		String result = "";
		for(int i = 0; i< str.length(); i++) {
			int curr = Character.getNumericValue(str.charAt(i));
			//System.out.println(str.charAt(i) +" "+curr);
			if(curr < 10 && curr > -1 ) {
				if(i+1 == str.length()) {
					break;
				}

				for (int j = 0; j < curr; j++) {
					result += str.charAt(i + 1);
				}
			} else {
				result += str.charAt(i);
			}
		}
		return result;
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		HashSet<String> collected = new HashSet<String>();
		for (int i = 0; i<a.length()-len;i++) {
			collected.add(a.substring(i,i+len));
		}
		for (int i =0; i<a.length()-len; i++) {
			if(collected.contains(b.substring(i,i+len))) {
				return true;
			}
		}
		return false;
	}
}
