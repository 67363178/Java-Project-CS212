// append and prepend methods are updated by professor Kent Chin
// LinkedList.java
// 
// This version uses three instance variables,
// a pointer to the first node, a pointer to
// the last node, and length, to make our
// append and getLength methods more efficient
// than the would be if our only instance
// variable were a pointer to the first node.
//
// This version uses a dummy first node.  Hence
// it needs less decision-making than it would
// need if a dummy first node were not used.
//

/**
 * Encapsulates a linked list of <code>String</code>.
 */
public class LinkedList {

	/** First node in linked list - dummy node */
	private ListNode first = new ListNode(null);

	/** Last node in linked list */
	private ListNode last = first;

	/** Number of data items in the list. */
	private int length = 0;
	


	
	/**
	 * Gets the number of data values currently stored in this LinkedList.
	 * 
	 * @return the number of elements in the list.
	 */

	public int getLength() {
		return length;
	}

	/**
	 * Appends a String data element to this LinkedList.
	 * 
	 * @param data
	 *            the data element to be appended.
	 */
	public void append(String d) {
		ListNode node = new ListNode(d);
		last.next = node;
		last = node;
		++length;
	} // method append(String)

	/**
	 * Prepends (adds to the beginning) a String data element to this
	 * LinkedList.
	 * 
	 * @param data
	 *            the data element to be prepended.
	 */
	public void prepend(String d) {
		ListNode node = new ListNode(d);
		node.next = first.next;
		first.next = node;
		if (first == last) last = node;
		++length;
	} // method append(String)

	/**
	 * @return String representation of elements in linked list delimited by a
	 *         space character
	 */
	public String toString() {
		ListNode p = first.next;
		String returnString = "";
		while (p != null) {
			returnString += p.data + "\n";
			p = p.next;
		}
		return returnString;
	}

	/**
	 * Determines whether this ShortSequenceLinkedList is equal in value to the
	 * parameter object. They are equal if the parameter is of class
	 * ShortSequenceLinkedList and the two objects contain the same short
	 * integer values at each index.
	 * 
	 * @param other
	 *            the object to be compared to this ShortSequenceLinkedList
	 * 
	 * @return <code>true</code> if the parameter object is a
	 *         ShortSequenceLinkedList containing the same numbers at each index
	 *         as this ShortSequenceLinkedList, <code>false</code> otherwise.
	 */
	/*Don't need this
	 * public boolean equals(Object other) {
		if (other == null || getClass() != other.getClass()
				|| length != ((LinkedList) other).length)
			return false;

		ListNode nodeThis = first;
		ListNode nodeOther = ((LinkedList) other).first;
		while (nodeThis != null) {
			// Since the two linked lists are the same length,
			// they should reach null on the same iteration.

			if (nodeThis.data != nodeOther.data)
				return false;

			nodeThis = nodeThis.next;
			nodeOther = nodeOther.next;
		} // while

		return true;
	}  method equals*/
	
	public LinkedListIterator reset(){
		return new LinkedListIterator(first.next);
	}
	
	/*No use
	 * public ListNode find (String s){
		ListNode p=first.next;
		while(p!=null&&!(p.data).equals(s)){
			p=p.next;
		}
		return p;
	}
	*/
	
	/* No use
	public void remove(ListNode p){
		if(p==null) throw new IllegalArgumentException("Null Pointer");
		
		p=p.next;
		
		length --;
	}
	*/
	/*/Not working
	public ListNode remove2(String word){
		ListNode nodeBeforeNodeToDelete =find(word);
	 if(nodeBeforeNodeToDelete!=null){ //if the node !=null delete it
		if(last.data==word){ //delete element at tail
			
			nodeBeforeNodeToDelete.next=null;
			last=nodeBeforeNodeToDelete;
			
		}
		else{
			nodeBeforeNodeToDelete.next=nodeBeforeNodeToDelete.next.next; //delete
			
		}
		length--;
		
		
	}
	
	return null;
	
	
}
*/
	
	
	/*Not working
	 * public void remove(String word){
		if(first==null){
			System.out.println("The list is empty");
		}
		else {
			current=first;
			while(current!=null&&!current.getValue().equals(word)){
				last=current;
				current=current.getNext();
				
			}
			
			if(current==first&&current.getValue().equals(word)){
				first=first.next;
			}
			else if (current!=null){
				last.setNext(current.getNext());
			}
		}
	}
	*/
	
	
	
	/*/Not useful
	public ListNode deleteAtPosition(ListNode next, int position){
		int size= length(next);
		if(position>size||position<1){
			return next;
			
		}
		
		if(position==1){
			ListNode temp=next;
			next=next.next;
			temp.next=null;
			return temp;

		}
		
		else {
			
			ListNode previous=next;
			int count=1;
			while (count<position-1){
				previous=previous.next;
				count++;
				
			}
			
			ListNode current=previous.next;
			previous.next=current.next;
			current.next=null;
			return current;
			
		}
		
	}

	private int length(ListNode next) {
		if(next==null) return 0;
		int count=0;
		ListNode current=next;
		while (current!=null){
			count++;
			current=current.next;
		}
		
		return count;
	}
	*/
	
	
	// This Finally Work!
	public ListNode delete(String data){	 //Node you want to delete
		ListNode nodeToReturn=null;
		
		if(length==0)
			return null; 
		
		if(length==1){ // if size=1 , just delete the first one
			nodeToReturn=first;
			first=null;
			last=null;
			length--;	//delete 1 so size--
			return nodeToReturn;
		}
		
		
		
		//NON Empty Link List 
		//Find The node
		ListNode nodeBeforeNodeToDelete =findNodeBefore(data); //find the node that we want to dele
		
		if(nodeBeforeNodeToDelete.data==""){ //delete the head
			
			first=first.next;
			length--;
		}
		
		else if(nodeBeforeNodeToDelete!=null){ //if the node !=null delete it
			if(last.data==data){ //delete element at tail
				
				nodeBeforeNodeToDelete.next=null;
				last=nodeBeforeNodeToDelete;
				
			}
			else{
				nodeBeforeNodeToDelete.next=nodeBeforeNodeToDelete.next.next; //delete
				
			}
			length--;
			
			
		}
		
		return null;
		
	}
	
	public ListNode findNodeBefore(String data){
		
		if(first.data==data)	//Check for first element for a match
			return new ListNode(); //It means the element we want to delete in at the head of the link list
		
		ListNode node=first;	//Assign node as the iterator
		
		while(first.next!=null){	//Iterate through our link list
			
			if(node.next.data==data) //check the nextNode data and see if It matches
				return node;
			
			node=node.next; 
			
		}
		
		return null;
		
	}
	
	public ListNode find(String data){ //Find the data we want to delete
		
		if(first==null)		//If it's an empty list, return null
			return null;
		
		if(first.data==data)	//Check for first element for a match
			return first;
		
		ListNode node=first;	//Assign node as the iterator
		
		while(first.next!=null){	//Iterate through our link list
			
			node=node.next;
			if(node.data==data) //if the data = data we want, return the node
				return node;
		}
		
		return null;
		
	}
	//



} // class LinkedList
