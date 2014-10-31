package implementations;

import interfaces.Queue;

import java.util.Iterator;

/**
 * Created by oking on 31/10/14.
 */
public class QueueImpl<Item> implements Queue<Item> {
    private int size;
    private Node firstNode; //front of the queue
    private Node lastNode; //back of the queue

    public QueueImpl(){
        this.size = 0;
        this.firstNode = null;
        this.lastNode = null;
    }



    @Override
    public void enqueue(Item item) {
        Node newNode = new Node(item);

        if (lastNode == null){
            lastNode = newNode;
            firstNode = newNode;
        }
        else{
            newNode.next = lastNode;
            lastNode = newNode;
        }
        size ++;
    }

    @Override
    public Item dequeue() {

        if (size == 0){
            return null;
        }
        else {
            Node toReturn = firstNode;
            Node current = lastNode;
            if (lastNode != firstNode){
                while (current.next != firstNode){
                    current = current.next;
                }
                firstNode = current;
            }
            else{
                firstNode = null;
                lastNode = null;
            }
            size --;
            return (Item) toReturn.item;
        }
    }

    @Override
    public boolean isEmpty() { return lastNode == null; }

    @Override
    public int size() { return size; }

    @Override
    public Iterator<Item> iterator() {

        return new Iterator<Item>() {

            Node currentNode = lastNode;

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

        Node(Item item){
            this.item = item;
        }
    }
}
