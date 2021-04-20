import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		HashMap<T,Integer> A = new HashMap<T,Integer>();
		HashMap<T,Integer> B = new HashMap<T,Integer>();
		Iterator Ita = a.iterator();
		while(Ita.hasNext()) {
			T curr = (T) Ita.next();
			if(A.containsKey(curr)) {
				A.replace(curr,A.get(curr)+1);
  			} else {
				A.put(curr,1);
			}
		}
		Iterator Itb = b.iterator();
		while(Itb.hasNext()) {
			T curr = (T) Itb.next();
			if(B.containsKey(curr)) {
				B.replace(curr,B.get(curr)+1);
			} else {
				B.put(curr,1);
			}
		}

		int Count = 0;
		Iterator It = B.keySet().iterator();
		while(It.hasNext()) {

			T curr = (T) It.next();

			if(A.containsKey(curr)) {
				if(A.get(curr) == B.get(curr)) {
					Count++;
				}
			}
		}

		return Count;
	}
	
}
