package edu.ics211.h10;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Creates a new Binary Search Tree.
 * 
 * @author eliasthompson
 *
 * @param <E> Generic type.
 */
public class BinarySearchTree<E> implements SearchTree<E>, InOrder<E> {

  private Comparator<E> comp;
  private Node root;
  private boolean addReturn;
  private boolean removeBoolean;
  private boolean findBoolean;
  private E deleteReturn;
  private int size;

  /**
   * Creates Constructor.
   * 
   * @param comp the comparator to keep things in order
   */
  public BinarySearchTree(Comparator<E> comp) {
    this.root = null;
    this.comp = comp;
  }


  /**
   * Creates new Constructor with new root.
   * 
   * @param root the user given root
   * @param comp The comparator to keep things in order
   */
  public BinarySearchTree(Node root, Comparator<E> comp) {
    this.root = root;
    this.comp = comp;
  }


  @Override
  public List<E> inorder() {
    List<E> inOrderReturn = new LinkedList<E>();
    inOrderTraverse(root, inOrderReturn);
    return inOrderReturn;
  }


  @Override
  public boolean add(E item) {
    root = add(root, item);
    if (addReturn == true) {
      size++;
    }
    return addReturn;
  }
  
  /**
   * Recursive Helper for Add Method.
   * @param localRoot current root
   * @param item item being added
   * @return the recursive method or true able to add
   */
  private Node add(Node localRoot, E item) {
    if (localRoot == null) {
      addReturn = true;
      return new Node(item);
    }
    if (comp.compare(localRoot.data, item) == 0) {
      addReturn = false;
      return localRoot;

    } else if (comp.compare(item, localRoot.data) < 0) {

      localRoot.left = add(localRoot.left, item);
      return localRoot;

    } else {

      localRoot.right = add(localRoot.right, item);
      return localRoot;
    }
  }


  @Override
  public boolean contains(E item) {

    find(root, item);
    return findBoolean;

  }


  @Override
  public E find(E target) {

    return find(root, target);

  }
  
  /**
   * Recursive Helper for Find Method.
   * @param localRoot root searching.
   * @param target item trying to find.
   * @return the recursive method or item
   */
  private E find(Node localRoot, E target) {
    if (localRoot == null) {
      findBoolean = false;
      return null;
    }
    if (comp.compare(localRoot.data, target) == 0) {

      findBoolean = true;
      return localRoot.data;

    } else if (comp.compare(target, localRoot.data) < 0) {

      return find(localRoot.left, target);

    } else {

      return find(localRoot.right, target);

    }
  }



  @Override
  public E delete(E target) {

    root = delete(root, target);

    if (removeBoolean == true) {
      size--;
    }

    return deleteReturn;
  }

  /**
   * Recursive Helper for Delete Method.
   * @param localRoot Current Root
   * @param item item looking to be deleted
   * @return the recursive method or the old deleted node.
   */
  private Node delete(Node localRoot, E item) {
    if (localRoot == null) {

      removeBoolean = false;
      deleteReturn = null;
      return null;

    }

    if (comp.compare(item, localRoot.data) < 0) {

      localRoot.left = delete(localRoot.left, item);
      return localRoot;

    } else if (comp.compare(item, localRoot.data) > 0) {

      localRoot.right = delete(localRoot.right, item);
      return localRoot;

    } else {

      return replaceNode(localRoot);
    }
  }


  @Override
  public boolean remove(E target) {

    root = delete(root, target);

    if (removeBoolean == true) {
      size--;
    }

    return removeBoolean;

  }


  @Override
  public int size() {

    return this.size;

  }

  /**
   * Replaces node with its next largest child.
   * @param localRoot current node being deleted.
   * @return the old deleted node.
   */
  private Node replaceNode(Node localRoot) {
    removeBoolean = true;
    deleteReturn = localRoot.data;

    if (localRoot.left == null) {

      return localRoot.right;

    } else if (localRoot.right == null) {

      return localRoot.left;

    } else {

      if (localRoot.left.right == null) {

        localRoot.data = localRoot.left.data;
        localRoot.left = localRoot.left.left;
        return localRoot;

      } else {

        localRoot.data = findLargestChild(localRoot.left);
        return localRoot;

      }
    }
  }

  /**
   * Finds the largest child of node.
   * @param parent the node
   * @return the largest child of parent
   */
  private E findLargestChild(Node parent) {
    if (parent.right.right == null) {
      E returnValue = parent.right.data;
      parent.right = parent.right.left;
      return returnValue;
    } else {
      return findLargestChild(parent.right);
    }
  }

  /**
   * Recursive helper method of inOrder.
   * @param node The current node
   * @param list The item being added to
   */
  private void inOrderTraverse(Node node, List<E> list) {
    if (node != null) {
      if (node.left != null) {
        inOrderTraverse(node.left, list);
      }
      list.add(node.data);

      if (node.right != null) {
        inOrderTraverse(node.right, list);
      }
    }
  }

  /**
   * Creates a new Node.
   * @author eliasthompson
   *
   */
  private class Node {
    public E data;
    public Node left;
    public Node right;

    public Node(E data) {
      this.data = data;
    }
  }

}
