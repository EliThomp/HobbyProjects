package edu.ics211.h08;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * A Queue of Packets.
 * 
 * @author eliasthompson
 *
 */
public class PacketQueue extends AbstractQueue<Packet> implements Queue<Packet> {
  private Node front;
  private Node rear;
  private int size;
  List<Packet> iterList = new LinkedList();

  @Override
  public Iterator<Packet> iterator() {

    return new QueueIterator();
  }


  @Override
  public Packet remove() {
    // check if empty - throw exception
    if (size == 0) {

      throw new NoSuchElementException();

    }
    // retrieves and remove ; throws exception
    Node temp;
    temp = front;
    // temp = front
    front = front.next;
    // front = front.next
    size--;
    // decrement size
    // return temp.item
    iterList.remove(0);
    return temp.item;
  }


  @Override
  public Packet poll() {
    // retrieves and removes head ; return null
    try {

      return remove();

    } catch (NoSuchElementException nse) {

      return null;

    }
  }


  @Override
  public Packet element() {
    if (size == 0) {

      throw new NoSuchElementException();

    }

    return front.item;

  }


  @Override
  public Packet peek() {

    try {

      return element();

    } catch (NoSuchElementException nse) {

      return null;
    }

  }


  @Override
  public boolean add(Packet e) {
    if (size == 10) {
      throw new IllegalStateException();
    }
    // inserts at end ; throws exception
    if (size == 0) {

      rear = new Node(e, null);
      front = rear;
      size = 1;

    } else {
    
      Node temp = new Node(e, null);
      rear.next = temp;
      rear = temp;
      size++;

    }
    iterList.add(e);
    return true;

  }


  @Override
  public boolean offer(Packet e) {
    // inserts at end ; return false
    try {

      return add(e);

    } catch (IllegalStateException ise) {

      return false;

    }
  }


  @Override
  public int size() {

    return this.size;

  }


  /**
   * Prints a string of the next queue.
   */
  public String toString() {
    return "Next packet in the queue: " + peek();

  }


  /**
   * Checks if queue is empty - throws exception.
   * 
   * @throws NoSuchElementException if not found.
   */
  private void ifEmpty() {
    if (front == null) {

      throw new NoSuchElementException();

    }
  }

  private class Node {

    private Node(Packet e, Node next) {

      this.item = e;
      this.next = next;

    }

    private Packet item;
    private Node next;

  }

  /**
   * Iterates over a Queue.
   * @author eliasthompson
   *
   */
  public class QueueIterator implements Iterator<Packet> {
    private int nextIndex;
    private int count;

    /**
     * Creates a new Queue Iterator.
     */
    public QueueIterator() {
      // init member variables
      this.nextIndex = 0;
      this.count = -1;
    }

    /**
     * Checks if there is a next in the queue.
     */
    public boolean hasNext() {
      return count < nextIndex;
    }

    /**
     * returns the next packet in the queue.
     * @throws NoSuchElementException if there isn't a next object.
     */
    public Packet next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Packet temp = iterList.get(nextIndex);
      nextIndex = (nextIndex + 1) % iterList.size();
      count++;
      return temp;
    }
  }

}
