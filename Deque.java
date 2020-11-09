package com.company;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item>{

    private Node first, last;
    private int size = 0;
    public Node testNull;

    class Node {
        Item item;
        Node next;
        Node previous;
    }

    public Deque() {
        last = null;
        first = last;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) throws IllegalArgumentException {
        if (item == null) throw  new  IllegalArgumentException();

        Node node = new Node();
        node.item = item;

        if (first == null) {
            first = node;
            last = first;
        } else {
            node.next = first;
            first.previous = node;
            first = node;
        }
        ++size;
    }

    public void addLast(Item item) throws IllegalArgumentException{
        if (item == null) throw  new  IllegalArgumentException();

        Node node = new Node();
        node.item = item;

        if (first == null) {
            last = node;
            first = last;
        } else {
            last.next = node;
            node.previous = last;
            last = node;
        }
        ++size;
    }

    public Item removeFirst() throws java.util.NoSuchElementException
    {
        if (isEmpty()) throw  new java.util.NoSuchElementException();
        Node returnValue = first;
        first = first.next;

        --size;
        return returnValue.item;
    }

    public Item removeLast() throws java.util.NoSuchElementException
    {
        if (isEmpty()) throw  new java.util.NoSuchElementException();

        Node returnValue = last;
        last = last.previous;

        --size;
        return returnValue.item;
    }

    public Iterator<Item> iterator()
    {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return !isEmpty();
        }

        @Override
        public Item next() throws java.util.NoSuchElementException {
            if (isEmpty()) throw  new java.util.NoSuchElementException();
            Item item = first.item;
            first = first.next;
            return item;
        }

        @Override
        public void remove() throws UnsupportedOperationException  {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();

        deque.addFirst("first Item");
        deque.addFirst("next First");
        deque.addLast("last Item");
        deque.addLast("next Last Item");

        assert (deque.removeFirst().equals("next First"));
        assert (deque.removeFirst().equals("next First"));
    }
}
