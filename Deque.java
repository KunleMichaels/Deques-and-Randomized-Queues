import java.util.Iterator;



public class Deque<Item> implements Iterable<Item> {

 private Node first;
 private Node last;
 private int length;

 public Deque() {
  first = null;
  last = null;
  length = 0;
 }

 public boolean isEmpty() {
  return length == 0;
 }

 public int size() {
  return length;
 }

 public void addFirst(Item item) {
  if (item == null)
   throw new NullPointerException();
  if (length == 0) {
   Node newNode = new Node();
   newNode.i = item;
   newNode.left = null;
   newNode.right = null;
   first = newNode;
   last = newNode;
   length++;
  } else {
   Node newNode = new Node();
   newNode.i = item;
   newNode.right = null;
   newNode.left = first;
   first.right = newNode;
   first = newNode;
   length++;
  }
 }

 public void addLast(Item item) {
  if (item == null)
   throw new NullPointerException();
  if (length == 0) {
   Node newNode = new Node();
   newNode.i = item;
   newNode.left = null;
   newNode.right = null;
   first = newNode;
   last = newNode;
   length++;
  } else {
   Node newNode = new Node();
   newNode.i = item;
   newNode.right = last;
   newNode.left = null;
   last.left = newNode;
   last = newNode;
   length++;
  }
 }

 public Item removeFirst() {
  if (isEmpty())
   throw new java.util.NoSuchElementException();
  if (length == 1) {
   Item item = first.i;
   first = null;
   last = null;
   length--;
   return item;
  } else {
   Item item = first.i;
   Node temp = first.left;
   first.left.right = null;
   first.left = null;
   first = temp;
   length--;
   return item;
  }
 }

 public Item removeLast() {
  if (isEmpty())
   throw new java.util.NoSuchElementException();
  if (length == 1) {
   Item item = first.i;
   first = null;
   last = null;
   length--;
   return item;
  } else {
   Item item = last.i;
   Node temp = last.right;
   last.right.left = null;
   last.right = null;
   last = temp;
   length--;
   return item;
  }
 }

 public static void main(String[] args) {
 
 }

 
 public Iterator<Item> iterator() {
  
  return new ListIterator();
 }

 private class Node {
  private Node left;
  private Node right;
  private Item i;
 }

 private class ListIterator implements Iterator<Item> {
  
  private Node ptr;
  private Item i;
  
  public ListIterator()
  {
   ptr = first;
  }

  
  public boolean hasNext(){
   if (ptr == null)
    return false;
   else
    return true;
  }

  
  public Item next() {
   if (!hasNext())
    throw new java.util.NoSuchElementException();
   else {
    i = ptr.i;
    ptr = ptr.left;
    return i;
   }

  }

  public void remove() {
   throw new UnsupportedOperationException();
  }

 }

}