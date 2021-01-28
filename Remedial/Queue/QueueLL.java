public class QueueLL {
    Node first;
    Node last;
    int n = 0;
    private class Node {
        int ele;
        Node next;        
        Node() {
            next = null;
        }
        Node(int ele) {
            this.ele = ele;
            next = null;
        }
    }
    public int size() {
        return n;
    }

    public void enqueue(int ele) {
        if(n == 0) {
            last = new Node(ele);
            first = last;
            n++;
        }
        else{
            Node oldlast = last;
            last = new Node();
            last.ele = ele;
            last.next = null;
            oldlast.next = last;
            n++;
        }
        
    }

    public int dequeue() {
        int ele = first.ele;
        first = first.next;
        n--;
        return ele;
    }
    public void values() {
        for(Node x = first; x!=null; x = x.next){
            System.out.println(x.ele);
        }
    }
    public static void main(String[] args) {
        QueueLL qll = new QueueLL();
        qll.enqueue(35);
        qll.enqueue(38); 
        qll.enqueue(45);
        qll.enqueue(28);
        System.out.println("_____________________________");
        System.out.println(qll.dequeue());
        System.out.println(qll.dequeue());
        System.out.println("_____________________________");

        qll.values();
        
    }
}