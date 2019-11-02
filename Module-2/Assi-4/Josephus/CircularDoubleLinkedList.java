class Node{
    int value;
    Node next;
    Node prev;

    Node(int val) {
        this.value = val;
    }
}
class CicularDoubleLinkedList {
    Node head;
    Node tail;

    public void add(int val) {
        Node node = new Node(val);
        if (this.head == null){
            this.head = node;
            this.tail = node;
        }else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }
    public void formCircle() {
        this.tail.next = this.head;
        this.head.prev = this.tail;
    }
}