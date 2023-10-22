package edu.ics211.h07;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class StackTest {

  @Test
  void testStack() {
      Stack<String> list = new Stack<String>();
      assertNotNull(list);
  }


  @Test
  void testEmpty() {
    Stack<String> list = new Stack<String>();
    boolean falseTest = list.empty();
    assertTrue(falseTest);
    list.push("Foo");
    falseTest = list.empty();
    assertFalse(falseTest);
  }


  @Test
  void testPush() {
    Stack<String> list = new Stack<String>();
    assertEquals(list.push("foo"), "foo");
    assertEquals(list.peek(), "foo");
    assertEquals(list.push("bar"), "bar");
    assertEquals(list.peek(), "bar");
  }


  @Test
  void testPeek() {
    Stack<String> list = new Stack<String>();
    list.push("foo");
    list.push("bar");
    assertEquals(list.peek(), "bar");
    list.push("baz");
    assertEquals(list.peek(), "baz");
    
  }


  @Test
  void testPop() {
    Stack<String> list = new Stack<String>();
    list.push("foo");
    list.push("bar");
    list.push("baz");
    assertEquals(list.pop(), "baz");
    assertEquals(list.peek(), "bar");
    assertEquals(list.pop(), "bar");
    assertEquals(list.peek(), "foo");
  }

}
