package interfaces;

/**
 * Collection that does not support removing items.
 * Allows you to collect and then iterate over items.
 * @param <Item>
 */
public interface Bag<Item> extends Iterable<Item> {

    void add(Item item);

    boolean isEmpty();

    int size();

}
