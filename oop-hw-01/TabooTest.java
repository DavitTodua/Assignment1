// TabooTest.java
// Taboo class tests -- nothing provided.

import java.util.*;


import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class TabooTest extends TestCase {

    @Test
    public void noFollow1() {
        List<Character> taboos = new ArrayList<Character>();
        taboos.add('a');
        taboos.add('b');
        taboos.add('c');
        taboos.add('d');
        taboos.add('c');
        taboos.add('e');
        Set<Character> answer1 = new HashSet<Character>();
        answer1.add('d');
        answer1.add('e');
        Taboo<Character> ban = new Taboo<Character>(taboos);
        assertEquals(answer1,ban.noFollow('c'));

        //chectaboos for different spread, same content
        Set<Character> answer2 = new HashSet<Character>();
        answer2.add('e');
        answer2.add('d');
        assertEquals(answer2,ban.noFollow('c'));
    }
    @Test
    public void noFollow2() {
        List<Character> taboos = new ArrayList<Character>();
        taboos.add('a');
        taboos.add('a');
        taboos.add('b');
        taboos.add('l');
        taboos.add('a');
        taboos.add('e');
        taboos.add('b');
        taboos.add('f');

        //check for a
        Set<Character> answer1 = new HashSet<Character>();
        answer1.add('a');
        answer1.add('b');
        answer1.add('e');
        Taboo<Character> ban = new Taboo<Character>(taboos);

        assertEquals(answer1,ban.noFollow('a'));

        //check for b
        Set<Character> answer2 = new HashSet<Character>();
        answer2.add('l');
        answer2.add('f');
        assertEquals(answer2,ban.noFollow('b'));
    }

    @Test
    public void testReduce1() {
        List<Character> taboos = new ArrayList<Character>();
        taboos.add('a');
        taboos.add('a');
        taboos.add('b');
        taboos.add('l');
        taboos.add('a');
        taboos.add('e');
        taboos.add('b');
        taboos.add('f');

        Taboo<Character> ban = new Taboo<Character>(taboos);

        List<Character> toreduce1 = new ArrayList<Character>();
        toreduce1.add('b');
        toreduce1.add('b');
        toreduce1.add('l');
        toreduce1.add('l');
        toreduce1.add('k');

        List<Character> answer1 = new ArrayList<Character>();

        answer1.add('b');
        answer1.add('b');
        answer1.add('k');

        //check for toreduce1
        assertEquals(answer1,ban.reduce(toreduce1));


        List<Character> toreduce2 = new ArrayList<Character>();
        toreduce2.add('a');
        toreduce2.add('b');
        toreduce2.add('a');
        toreduce2.add('l');
        toreduce2.add('k');

        List<Character> answer2 = new ArrayList<Character>();

        answer2.add('a');
        answer2.add('l');
        answer2.add('k');

        //test for toreduce2
        assertEquals(answer2,ban.reduce(toreduce2));

    }
    @Test
    public void TestOnToreduceEmpty() {
        List<Character> taboos = new ArrayList<Character>();
        Taboo<Character> ban = new Taboo<Character>(taboos);

        List<Character> toreduce1 = new ArrayList<Character>();
        toreduce1.add('b');
        toreduce1.add('b');
        toreduce1.add('l');
        toreduce1.add('l');
        toreduce1.add('k');

        List<Character> answer1 = new ArrayList<Character>();
        answer1.add('b');
        answer1.add('b');
        answer1.add('l');
        answer1.add('l');
        answer1.add('k');
        //see if it gives back the answer unchainged
        assertEquals(answer1,ban.reduce(toreduce1));
    }
}
