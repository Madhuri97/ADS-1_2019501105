/**
 * @author Madhuri
 * @reference GeeksForGeeks
 * Write a Queue implementation that uses a 
 * circular linked list, which is the same as
 * a linked list except that no links are 
 * null and the value of last.next is first 
 * when-ever the list is not empty. Keep only 
 * one Node instance variable ( last ). Compare 
 * this implementation to the queue implemented 
 * using arrays and regular linked list. (Queues)
 */
import java.util.*;
public class CircularLLQueue {
    public class Node {
        int data;
        Node link;
        //parameterized constructor
        Node(int data) {
            this.data = data;
        }
    }
    static int N;
    static Node tail;

    /**
     * this method is used to get the size
     * 
     * @return int value
     */
    public int getSize() {
        return N;
    }

    /**
     * this method is used to check wether the queue is empty or not
     * 
     * @return boolean value
     */
    public boolean isEmpty() {
        if (N == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * this method inserts different data elements into the queue
     * 
     * @param data
     */
    public void enqueue(int data) {
        Node node = new Node(data);
        node.data = data;
        if (isEmpty()) {
            tail = node;
            tail.link = tail;
        } else {
            node.link = tail.link;
            tail.link = node;
            tail = tail.link;
        }
        N++;
    }

    /**
     * this method iss used to delete and return the deleted element form the
     * circular linked list
     * 
     * @return int value which is deleted
     */
    public int dequeue() {
        if (isEmpty()) {
            return -1;
        } else if(N == 1) {
            Node temp = tail;
            tail = null;
            N--; 
            return temp.data;   
        } else {
            Node temp = tail.link;
            tail.link = tail.link.link;
            N--;
            return temp.data;
        }
    }

    /**
     * thismethod finds wether the linked list is circullarly connected or not.
     * 
     * @return boolean value
     */
    public boolean isCircular() {
        int count = 1;
        Node temp = tail;
        while (temp.link != tail) {
            temp = temp.link;
            count++;
        }
        if (count == getSize()) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * this is main function used to execute 
     * the following enqueue dequeue functions
     * @param args
     */
    public static void main(String[] args) {
        CircularLLQueue CLL = new CircularLLQueue();
        CLL.enqueue(25);
        CLL.enqueue(35);
        CLL.enqueue(12);
        CLL.enqueue(38);
        System.out.println("the element which is dequeued: " + CLL.dequeue());
        System.out.println("the element which is dequeued: " + CLL.dequeue());
        System.out.println("this is Circular linked list: " + CLL.isCircular());
    }
}
        