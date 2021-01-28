public class StackLL {
    public int n;
    Node first;
    Node last;
    private class Node {
        int ele;
        Node next;
    }

    private int size() {
        return n;
    }
    
    public void push(int ele) {
		Node oldfirst = first;
        first = new Node();
        first.ele = ele; 
        first.next = oldfirst;
        n++;
    }

    public int pop() {
        int ele = first.ele;
        first = first.next;
        // first.next = first;
        n--;
        return ele;
    }

    public static void main(String[] args) {
        StackLL stll = new StackLL();
        stll.push(12);
        stll.push(36);
        stll.push(21);
        stll.push(11);
        stll.push(6);
        System.out.println(stll.pop());
        System.out.println(stll.pop());
    }
}