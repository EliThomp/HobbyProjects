package edu.ics211.h08;

import java.util.LinkedList;
import java.util.List;

/**
 * Simulates a home router.
 * @author eliasthompson
 *
 */
public class Router implements RouterInterface {
  PacketSenderInterface sender;
  List<Packet> droppedPackets;
  PacketQueue[] packets;
  PacketQueue queueZero;
  PacketQueue queueOne;
  PacketQueue queueTwo;
  PacketQueue queueThree;
  PacketQueue queueFour;
  PacketQueue queueFive;
  PacketQueue queueSix;
  PacketQueue queueSeven;

  /**
   * Constructor.
   * @param sender who it is going to.
   */
  public Router(PacketSenderInterface sender) {
    packets = new PacketQueue[8];
    this.sender = sender;
    droppedPackets = new LinkedList<Packet>();
    packets[0] = queueZero = new PacketQueue();
    packets[1] = queueOne = new PacketQueue();
    packets[2] = queueTwo = new PacketQueue();
    packets[2] = queueThree = new PacketQueue();
    packets[3] = queueFour = new PacketQueue();
    packets[4] = queueFive = new PacketQueue();
    packets[5] = queueSix = new PacketQueue();
    packets[6] = queueSeven = new PacketQueue();

  }


  @Override
  public void advanceTime() {
    for (int i = 0; i < 7; i++) {
      System.out.println(i);
      if (packets[i].size() > 0) {
        sender.send(i, packets[i].remove());
      }
    }

  }


  @Override
  public boolean acceptPacket(Packet p) {

    for (int i = 0; i < 8; i++) {
      if (i == p.getAddress()) {
        try {
          packets[i].add(p);
          return true;
        } catch (IllegalStateException ise) {
          droppedPackets.add(p);
          return false;
        }
      }

    }
    droppedPackets.add(p);
    return false;
  }


  @Override
  public List<Packet> getDroppedPackets() {

    return droppedPackets;
  }

}
