import java.util.NoSuchElementException;
import java.util.Scanner;

public class QueueArr {
    
    public int[] a;
    int capacity;
    private int n;
    int first;
    int last;

    QueueArr(int capacity){
        this.capacity = capacity;
        a = new int[capacity];
        n = 0;
        first = 0;
        last = 0;
    }
    public int size () {
        return n;
    }

    public boolean isEmpty () {
        return n == 0;
    }

    public void enqueue(int item) {
        a[last++] = item;
        n++;
    }

    public int dequeue() {
        if(isEmpty()) throw new NoSuchElementException();
        int item = a[first];
        first++;
        return item;
    }
    public void values(){
        for (int i = first; i < last; i++) {
            System.out.println(a[i]);
        }
    }
    public static void main (String[] args) { 
        Scanner scan = new Scanner(System.in);
        System.out.println("enter array length: ");
        int i = scan.nextInt();
        scan.close();
        QueueArr que = new QueueArr(i);
        que.enqueue(12);
        que.enqueue(1);
        que.enqueue(34);
        que.enqueue(23);
        que.enqueue(11);
        System.out.println("_________________________________");
        System.out.println(que.dequeue());
        System.err.println(que.dequeue());
        System.out.println("_________________________________");
        que.values();


    }
}