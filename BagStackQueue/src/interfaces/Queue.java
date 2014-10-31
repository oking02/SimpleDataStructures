package interfaces;

/**
 * FIFO policy collection.
 * @param <Item>
 */
public interface Queue<Item> extends Iterable<Item> {

    void enqueue(Item item);

    Item dequeue();

    boolean isEmpty();

    int size();

}
