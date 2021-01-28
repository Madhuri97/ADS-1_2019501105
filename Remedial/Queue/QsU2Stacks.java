import java.util.Stack;
public class QsU2Stacks {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    void enQueue(int q) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(q); 
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    int deQueue() {
        if (s1.isEmpty()) {
            System.out.println("queue is empty");
        }
        int q = s1.peek();
        s1.pop();
        return q;
    }

    public static void main(String[] args) {
        QsU2Stacks qu = new QsU2Stacks();
        qu.enQueue(3);
        qu.enQueue(9);
        qu.enQueue(1);
        qu.enQueue(4);
        qu.enQueue(2);

        System.out.println(qu.deQueue());
        System.out.println(qu.deQueue());
    }
}