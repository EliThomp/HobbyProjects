package edu.ics211.h07;

import java.util.NoSuchElementException;

/**
 * Creates a new Stack ADT.
 * 
 * @author eliasthompson
 *
 * @param <E> Abstract Data.
 */
public class Stack<E> implements IStack211<E> {
  //LinkedNode Implementation
  //variables used
  private node top; //Keeps track of the top node
  
  /**
   * Creates a new Stack list.
   */
  public Stack() {
    this.top = null;
  }
   
  @Override
  public boolean empty() {
    //Returns true if stack is empty, otherwise return false
    return top == null;
  }


  @Override
  public E push(E item) {
    //make new node of temp
    node temp = new node();
    
    if (top == null) {
      temp.data = item;
      temp.next = null;
      top = temp;
      return temp.data;
    }
    
    //set temp data to element
    temp.data = item;
    //set temp's next to current top
    temp.next = top;
    //set top as temp
    top = temp;
    //return the element
    
    return temp.data;
  }


  @Override
  public E peek() {
   //Check if empty
    ifEmpty();
    //return top.item;
    return top.data;
  }


  @Override
  public E pop() {
  //check if empty
    ifEmpty();
    //remember old val
    node temp = top;
    //set top to next item
    top = top.next;
    //return old
    return temp.data;
  }
  
  private class node {
    E data;
    node next;
  }

  private void ifEmpty() {
    if(empty()) {
      throw new NoSuchElementException();
    }
  }
}
