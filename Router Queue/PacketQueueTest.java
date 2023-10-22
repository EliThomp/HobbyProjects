package edu.ics211.h08;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class PacketQueueTest {

  private PacketQueue list;
  private List<Packet> packets;

  // Set up -- Not Used
  void setUp() throws Exception {
    packets = new LinkedList<Packet>();
    list = new PacketQueue();
    assertNotNull(list);
    assertNotNull(packets);

    for (int q = 0; q < 7; q++) {
      // send 7 packets, all to queue q
      Packet p = new Packet(q);
      packets.add(p);
      assertNotNull(p);
    }
  }


  @Test
  void testSize() {
    packets = new LinkedList<Packet>();
    list = new PacketQueue();
    assertNotNull(list);
    assertNotNull(packets);

    for (int q = 0; q < 7; q++) {
      // send 7 packets, all to queue q
      Packet p = new Packet(q);
      packets.add(p);
      assertNotNull(p);
      list.add(packets.get(q));
    }

    assertEquals(list.size(), 7);
  }


  @Test
  void testIterator() {
    packets = new LinkedList<Packet>();
    list = new PacketQueue();
    assertNotNull(list);
    assertNotNull(packets);

    for (int q = 0; q < 7; q++) {
      // send 7 packets, all to queue q
      Packet p = new Packet(q);
      packets.add(p);
      assertNotNull(p);
      list.add(packets.get(q));
    }

    Iterator<Packet> iter = list.iterator();
    assertEquals(iter.next(), packets.get(0));
    assertEquals(iter.next(), packets.get(1));
    assertEquals(iter.next(), packets.get(2));
    assertEquals(iter.next(), packets.get(3));
    assertEquals(iter.next(), packets.get(4));
    assertEquals(iter.next(), packets.get(5));
    assertEquals(iter.next(), packets.get(6));
    try {
      iter.next();
      fail("Not yet implemented");
    } catch (NoSuchElementException nse) {
      // this is what we want
    }
    try {
      iter.next();
      fail("Not yet implemented");
    } catch (NoSuchElementException nse) {
      // this is what we want
    }
  }


  @Test
  void testRemove() {
    packets = new LinkedList<Packet>();
    list = new PacketQueue();
    assertNotNull(list);
    assertNotNull(packets);

    for (int q = 0; q < 10; q++) {
      // send 7 packets, all to queue q
      Packet p = new Packet(q);
      packets.add(p);
      assertNotNull(p);
      list.add(packets.get(q));
    }

    for (int q = 0; q < 10; q++) {
      assertEquals(list.remove(), packets.get(q));
    }

    try {

      list.remove();
      fail("Not yet implemented");
    } catch (NoSuchElementException nse) {
      // This is wht we want
    }

  }


  @Test
  void testPoll() {
    packets = new LinkedList<Packet>();
    list = new PacketQueue();
    assertNotNull(list);
    assertNotNull(packets);

    for (int q = 0; q < 10; q++) {
      // send 7 packets, all to queue q
      Packet p = new Packet(q);
      packets.add(p);
      assertNotNull(p);
      list.add(packets.get(q));
    }

    for (int q = 0; q < 10; q++) {
      assertEquals(list.poll(), packets.get(q));
    }

    assertNull(list.poll());

  }


  @Test
  void testElement() {
    packets = new LinkedList<Packet>();
    list = new PacketQueue();
    assertNotNull(list);
    assertNotNull(packets);

    Packet a = new Packet(1);
    packets.add(a);
    list.add(a);
    assertEquals(list.element(), packets.get(0));

    Packet b = new Packet(2);
    packets.add(b);
    list.add(b);
    list.remove();
    assertEquals(list.element(), packets.get(1));

    Packet c = new Packet(3);
    packets.add(c);
    list.add(c);
    list.remove();
    assertEquals(list.element(), packets.get(2));
    list.remove();

    try {

      list.element();
      fail("Not yet implemented");

    } catch (NoSuchElementException nse) {

      // this is what we want

    }
  }


  @Test
  void testPeek() {
    packets = new LinkedList<Packet>();
    list = new PacketQueue();
    assertNotNull(list);
    assertNotNull(packets);

    Packet a = new Packet(1);
    packets.add(a);
    list.add(a);
    assertEquals(list.peek(), packets.get(0));

    Packet b = new Packet(2);
    packets.add(b);
    list.add(b);
    list.remove();
    assertEquals(list.peek(), packets.get(1));

    Packet c = new Packet(3);
    packets.add(c);
    list.add(c);
    list.remove();
    assertEquals(list.peek(), packets.get(2));
    list.remove();

    assertEquals(list.peek(), null);

  }


  @Test
  void testAddPacket() {
    packets = new LinkedList<Packet>();
    list = new PacketQueue();
    assertNotNull(list);
    assertNotNull(packets);

    for (int q = 0; q < 10; q++) {
      Packet p = new Packet(q);
      packets.add(p);
      assertNotNull(p);
      list.add(packets.get(q));
    }
    try {
      Packet f = new Packet(0);
      list.add(f);
      fail("Not yet implemented");
    } catch (IllegalStateException ise) {
      // This is wht we want
    }
  }


  @Test
  void testOffer() {
    packets = new LinkedList<Packet>();
    list = new PacketQueue();
    assertNotNull(list);
    assertNotNull(packets);

    for (int q = 0; q < 10; q++) {
      // send 7 packets, all to queue q
      Packet p = new Packet(q);
      packets.add(p);
      assertNotNull(p);
      list.offer(packets.get(q));
    }
    
    Packet f = new Packet(0);
    assertFalse(list.offer(f));
  }


  @Test
  void testToString() {
    list = new PacketQueue();
    assertNotNull(list);

    Packet a = new Packet(1);
    list.add(a);
    System.out.println(list.toString());
  }

}
