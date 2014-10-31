package queue;

import interfaces.Queue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestQueue {

    private Queue<String> underTest = new QueueImpl<>();

    @Test
    public void shouldReturnTrueForEmptyQueue() {
        assertTrue(underTest.isEmpty());
    }

    @Test
    public void shouldReturnFalseForNotEmptyQueue() {
        underTest.enqueue("Hello");
        assertFalse(underTest.isEmpty());
    }

    @Test
    public void emptyQueueShouldHaveSizeZero() {
        assertEquals(0, underTest.size());
    }

    @Test
    public void testSizeCorrectAfterAddingItemsToQueue() {
        underTest.enqueue("Hello");
        underTest.enqueue("World");
        assertEquals(2, underTest.size());
    }

    @Test
    public void testSizeCorrectAfterEnqueueAndDequeue() {
        underTest.enqueue("Hello");
        underTest.enqueue("World");
        underTest.dequeue();

        assertEquals(1, underTest.size());
    }

    @Test
    public void testSizeCorrectAfterDequeueOnEmptyQueue() {
        underTest.enqueue("Hello");
        underTest.enqueue("World");
        underTest.dequeue();
        underTest.dequeue();
        underTest.dequeue();
        underTest.enqueue("Hello again");

        assertEquals(1, underTest.size());
    }

    @Test
    public void testItemAddedCorrectlyAfterDequeueOnEmptyQueue() {
        underTest.enqueue("Hello");
        underTest.enqueue("World");
        underTest.dequeue();
        underTest.dequeue();
        underTest.dequeue();
        underTest.enqueue("Hello again");

        assertEquals("Hello again", underTest.dequeue());
    }

    @Test
    public void testItemReturnedFromQueueInCorrectOrder() {
        underTest.enqueue("Hello");
        underTest.enqueue("World");
        underTest.enqueue("Third Item");

        List<String> results = new ArrayList<>();

        results.add(underTest.dequeue());
        results.add(underTest.dequeue());
        results.add(underTest.dequeue());

        assertEquals("Hello", results.get(0));
        assertEquals("World", results.get(1));
        assertEquals("Third Item", results.get(2));
    }

    @Test
    public void dequeueOnEmptyQueueShouldReturnNull() {
        assertNull(underTest.dequeue());
    }

    @Test
    public void testIterator() {
        underTest.enqueue("Hello");
        underTest.enqueue("World");
        underTest.enqueue("Third Item");

        List<String> results = new ArrayList<>();

        for (String s : underTest) {
            results.add(s);
        }

        assertTrue(results.contains("Hello"));
        assertTrue(results.contains("World"));
        assertTrue(results.contains("Third Item"));
    }
}
