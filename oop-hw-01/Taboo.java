
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {

	List<T> rules;
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		this.rules = rules;
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		Set<T> NO = new HashSet<T>();
		for(int i =0; i <rules.size()-1; i++) {
			if(rules.get(i) == elem) {
				if(rules.get(i+1) != null) {
					NO.add(rules.get(i + 1));
				}
			}
		}
		return NO; // YOUR CODE HERE
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public List<T> reduce(List<T> list) {
		List<T> reduced = list;
		int size = list.size();
		for(int i = 0; i< size-1; i++) {
			Set<T> curr = noFollow(reduced.get(i));
			if(curr.contains(reduced.get(i+1))) {
				reduced.remove(i+1);
				size--;
				i--;
			}
		}
		return reduced;
	}
}
