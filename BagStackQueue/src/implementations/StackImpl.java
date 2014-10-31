package implementations;

import interfaces.Stack;

import java.util.Iterator;

/**
 * Created by oking on 31/10/14.
 */
public class StackImpl<Item> implements Stack<Item> {

    private int stackSize;
    private Node<Item> head;

    public StackImpl(){
        stackSize = 0;
        head = null;
    }

    @Override
    public void push(Item item) {

        Node<Item> newNode = new Node<>(item);
        if (head != null){
            newNode.next = head;
        }
        head = newNode;
        stackSize++;
    }

    @Override
    public Item pop() {

        if (stackSize != 0){

            Node<Item> toRemove = head;
            if (head.next != null){
                head = toRemove.next;
            }
            else head = null;
            stackSize--;
            return toRemove.item;

        }else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() { return head == null; }

    @Override
    public int size() { return stackSize; }

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
        private Node<Item> next;

        Node(Item newItem){
            this.item = newItem;
        }
    }
}
