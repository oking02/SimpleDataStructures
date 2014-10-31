package implementations;

import interfaces.Bag;

import java.util.Iterator;

/**
 * Created by oking on 31/10/14.
 */
public class BagImpl<Item> implements Bag<Item> {
    private int size;
    private Node head;

    public BagImpl(){
        this.size = 0;
        this.head = null;
    }

    @Override
    public void add(Item item) {
        Node newNode = new Node(item);

        if (size == 0){
            head = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public boolean isEmpty() { return head == null; }

    @Override
    public int size() { return size; }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            Node currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Item next() {
                Item item = (Item) currentNode.item;
                currentNode = currentNode.next;
                return item;
            }
        };
    }

    class Node<Item>{
        private Item item;
        private Node next;

        Node(Item item){ this.item = item; }
    }
}
