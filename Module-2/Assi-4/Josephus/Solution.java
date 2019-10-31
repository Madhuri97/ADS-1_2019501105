class Solution {
	public static class Node { 
        public int data ; 
		public Node next; 
		
        public Node( int data ) { 
            this.data = data; 
        } 
    }
	public static String Josephus(int a, int b) {
		// fill you code Here
		Node head = new Node(1); 
        Node prev = head; 
        for(int i = 2; i <= b; i++) 
        { 
            prev.next = new Node(i); 
            prev = prev.next; 
        } 
		prev.next = head; 
		Node ptr1 = head, ptr2 = head; 
          
        while(ptr1.next != ptr1) 
        { 
              
            // Find m-th node 
            int count = 1; 
            while(count != a) 
            { 
                ptr2 = ptr1; 
                ptr1 = ptr1.next; 
                count++; 
			}
			
			ptr2.next = ptr1.next; 
            ptr1 = ptr2.next; 
        } 
        System.out.println ("Last person left standing " + 
                 "(Josephus Position) is " + ptr1.data); 
    }
		return "";
	}
}