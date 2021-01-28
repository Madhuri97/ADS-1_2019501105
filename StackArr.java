import java.util.NoSuchElementException;
import java.util.Scanner;

public class StackArr {
    
    public int[] a;
    int capacity;
    private int n;

    StackArr(int capacity){
        this.capacity = capacity;
        a = new int[capacity];
        n = 0;
    }
    public int size () {
        return n;
    }

    public boolean isEmpty () {
        return n == 0;
    }

    public void push (int item) {
        a[n++] = item;
    }

    public int pop () {
        if(isEmpty()) throw new NoSuchElementException();
        int item = a[--n];
        return item;
    }
    public void values(){
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
    public static void main (String[] args) { 
        Scanner scan = new Scanner(System.in);
        System.out.println("enter array length: ");
        int i = scan.nextInt();
        scan.close();
        StackArr sta = new StackArr(i);
        sta.push(12);
        sta.push(1);
        sta.push(34);
        sta.push(23);
        sta.push(11);
        System.out.println("_________________________________");
        System.out.println(sta.pop());
        System.err.println(sta.pop());
        System.out.println("_________________________________");
        sta.values();


    }
}
