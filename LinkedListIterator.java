
public class LinkedListIterator {

	private ListNode node;
	   public LinkedListIterator(ListNode first)  {
	        node = first;
	   }

	   public boolean hasNext()  {
	      return ( node != null );
	   }
	   
	   public String next()  {
	      if ( node == null )
	         throw new NullPointerException("Linked list empty.");
	      String currentData = node.data;
	      node = node.next;
	      return currentData;
	   }

	
}
