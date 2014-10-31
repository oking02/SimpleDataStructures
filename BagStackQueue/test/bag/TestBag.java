package bag;

import interfaces.Bag;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestBag {

    private Bag<String> underTest = new BagImpl<>();

    @Test
    public void testAddingToBag() {

        int expected = 3;

        underTest.add("Hello");
        underTest.add("World");
        underTest.add("Third Item");

        assertEquals(expected, underTest.size());

    }

    @Test
    public void testIterator() {
        underTest.add("Hello");
        underTest.add("World");
        underTest.add("Third Item");

        List<String> results = new ArrayList<>();

        for (String s : underTest) {
            results.add(s);
        }

        assertTrue(results.contains("Hello"));
        assertTrue(results.contains("World"));
        assertTrue(results.contains("Third Item"));

    }

    @Test
    public void emptyBagShouldReturnTrue() {
        assertTrue(underTest.isEmpty());
    }

    @Test
    public void notEmptyBagShouldReturnFalse() {
        underTest.add("Anything");
        assertFalse(underTest.isEmpty());
    }
}
