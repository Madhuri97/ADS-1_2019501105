class Solution {
	public static String Josephus(int a, int b) {
		// fill you code Here
		CicularDoubleLinkedList cL = new CicularDoubleLinkedList();
		for (int i = 0; i < a; i++) {
			Node node = new Node(i);

			cL.add(i);
		}

		cL.formCircle();
		int inx = 1;
		Node temp = cL.head;
		int eliminate
		 = 0;
		String toReturn =" ";
		while(eliminate
		 != a) {
			temp = temp.next;
			inx++;
			if(inx == b) {
				inx = 1;
				toReturn += temp.value + " ";

				Node prevNode = temp.prev;
				Node nextNode = temp.next;

				prevNode.next = nextNode;
				nextNode.prev = prevNode;

				eliminate
				++;
				temp = temp.next;
			}
		}
		toReturn = toReturn.trim();
		return toReturn;
	}
}