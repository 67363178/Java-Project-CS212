// ListNode.java

public class ListNode
{
   public String data;
   public ListNode next;

   /*public ListNode(String newVal, ListNode newNext){
	   data=newVal;
	   next=newNext;
	   
   }
   8*/
   
   //Constructor
   public ListNode(String data, ListNode next){
	   this.data=data;
	   this.next=next;
   }
   
   public ListNode(String data)
   {
      this.data = data;
      this.next = null;
   }  // constructor

   public ListNode() 
   {
	  this.data=null;
	  this.next=null;
   }

/*public String getValue(){
	return data;
}

public ListNode getNext(){
	return next;
}

public void setValue(String newValue){
	data=newValue;
}

public void setNext(ListNode newNext){
	next=newNext;
}
*/
}  // class ShortNode
