/**
 * @author Madhuri
 */
import java.util.*;

/**
 * performing two stack operations using one deque.
 */
public class Dequeue {
    int stk1[];
    int stk2[];
    int n1;
    int n2;
    int cnt1;
    int cnt2;
    Deque<Integer> deq = new LinkedList<>();
    
    /**
     * this method is used to perform push
     * from first for first stack using deque 
     * addFirst operation. 
     * @param stk1
     */
    public void pushAtFirst(int stk1[]) {
        for(int  i = 0; i < stk1.length; i++) {
            deq.addFirst(stk1[i]);
            n1++;
        }
    }

    /**
     * this method is used to perform pop 
     * from first using deque removeFirst 
     * method on first stack.
     * @return integer
     */
    public int popAtFirst() {
        int f = 0;
        if(deq.isEmpty()) {
            System.out.println("unable to remove");
            return -1;
        } else if(cnt1 < n1) {
            f = deq.removeFirst();
            cnt1++;
        } else {
            System.out.println("empty");
        }
        return f;
    }

    /**
     * this method is used to perform push
     * from last for second stack using deque 
     * addLast operation.
     * @param stk2
     */
    public void pushAtLast(int stk2 []) {
        for(int i = 0; i < stk2.length; i++) {
            deq.addLast(stk2[i]);
            n2++;
        }
    }

    /**
     * this method is used to perform pop 
     * from last using deque removeLast
     * method on second stack.
     * @return integer
     */
    public int popAtLast() {
        int l = 0;
        if(deq.isEmpty()) {
            System.out.println("unable to remove");
            return -1;
        } else if(cnt2 < n2) {
            l = deq.removeLast();
            cnt2++;
        } else {
            System.out.println("empty");
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int stk1[] = new int[n];
        System.out.println("enter elements into first stack: ");
        for(int i = 0; i < n; i++) {
            stk1[i] = sc.nextInt();
        }
        int stk2[] = new int[n];
        System.out.println("enter elements into second stack: ");
        for(int j = 0; j < n; j++) {
            stk2[j] = sc.nextInt();
        }
        Dequeue d = new Dequeue();
        d.pushAtFirst(stk1);
        d.pushAtLast(stk2);
        System.out.println("stk1 is: ");
        System.out.println(d.popAtFirst());
        System.out.println(d.popAtFirst());
        System.out.println(d.popAtFirst());
        System.out.println("- -- -- - -- --  --- - - -");
        System.out.println("stk2 is: ");
        System.out.println(d.popAtLast());
        System.out.println(d.popAtLast());
        System.out.println(d.popAtLast());        
    }
}
