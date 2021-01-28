/**
 * @author Madhuri
 */
public class Stack {

    Stack() {
    }

    int n = 0;
    Node first = null;
    Node last;
    
    private class Node {
        int ele;
        Node next;
        public Node(int ele) {
            this.ele = ele;
        }
        public Node() {
        }
    }

    public int size() {
        return n;
    }
    
    public void push(int ele) {
        if(n == 0) {
            first = new Node(ele);
            first = last;
        } else {
		Node oldfirst = first;
        first = new Node();
        first.ele = ele;
        first.next = oldfirst;
        n++;
        }
    }

    public int pop() {
        int ele = first.ele;
        first = first.next;
        n--;
        return ele;
    }

    // public String toString() {
    //     retrun 
    // }
}
