package stack;

import implementations.StackImpl;
import interfaces.Stack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestStack {

    private Stack<String> underTest = new StackImpl<>();

    @Test
    public void shouldReturnTrueForEmptyStack() {
        assertTrue(underTest.isEmpty());
    }

    @Test
    public void shouldReturnFalseForNotEmptyStack() {
        underTest.push("Hello");
        assertFalse(underTest.isEmpty());
    }

    @Test
    public void emptyStackShouldHaveSizeZero() {
        assertEquals(0, underTest.size());
    }

    @Test
    public void testSizeCorrectAfterAddingItemsToStack() {
        underTest.push("Hello");
        underTest.push("World");
        assertEquals(2, underTest.size());
    }

    @Test
    public void testSizeCorrectAfterPushAndPop() {
        underTest.push("Hello");
        underTest.push("World");
        underTest.pop();

        assertEquals(1, underTest.size());
    }

    @Test
    public void testSizeCorrectAfterPopOnEmptyStack() {
        underTest.push("Hello");
        underTest.push("World");
        underTest.pop();
        underTest.pop();
        underTest.pop();
        underTest.push("Hello again");

        assertEquals(1, underTest.size());
    }

    @Test
    public void testItemAddedCorrectlyAfterPopOnEmptyStack() {
        underTest.push("Hello");
        underTest.push("World");
        underTest.pop();
        underTest.pop();
        underTest.pop();
        underTest.push("Hello again");

        assertEquals("Hello again", underTest.pop());
    }

    @Test
    public void testItemReturnedFromStackInCorrectOrder() {
        underTest.push("Hello");
        underTest.push("World");
        underTest.push("Third Item");

        List<String> results = new ArrayList<>();

        results.add(underTest.pop());
        results.add(underTest.pop());
        results.add(underTest.pop());

        assertEquals("Third Item", results.get(0));
        assertEquals("World", results.get(1));
        assertEquals("Hello", results.get(2));
    }

    @Test
    public void popOnEmptyStackShouldReturnNull() {
        assertNull(underTest.pop());
    }

    @Test
    public void testIterator() {
        underTest.push("Hello");
        underTest.push("World");
        underTest.push("Third Item");

        List<String> results = new ArrayList<>();

        for (String s : underTest) {
            results.add(s);
        }

        assertTrue(results.contains("Hello"));
        assertTrue(results.contains("World"));
        assertTrue(results.contains("Third Item"));
    }
}
