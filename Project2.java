import javax.swing.*;
import java.util.*;
public class Project2 {
	
	public static void main(String[] args){
		LinkedList myList1 = new LinkedList();//From lab 16 for append creating  linked list
		String myFile="Project1.txt"; //The File name 
		String []StoreInArray =new String [17];

		//------------------First fill the array. ----------------------
		
		fillArray(myFile); 

		//-----------------Check if data contain Letter only, if so store them into a new array, else print it.-----------------------------------
		
		int counter1=0;//counter1 is the new array position.
		int a=0; //a = the amount of null value, we will use it to get a new array size.
		for(String data : fillArray(myFile)){
			if(isAlphabets(data)==true){
		
				StoreInArray[counter1]=data;
				counter1++;
			}
			else {
				System.out.println(data);
				a++;
			}
		}


		//-------------------Create a String array without null value (use 'a' to find out the new array size)--------------------------------------
		//-------------------NoNullArray will be the array that printed on the left and SortArray on the right------------------------------------
		String [] NoNullArray=new String[17-a];
		String [] SortArray=new String[17-a];
		String [] LinkedArray=new String[17-a];
		for(int i=0; i<17-a; i++){
			SortArray[i]=StoreInArray[i];
			NoNullArray[i]=StoreInArray[i];
			//LinkedArray[i]=SortArray[i];
				
		}
		for(int i=0; i<17-a;i++)
		System.out.println(StoreInArray[i]);
		

		//--------------------------------SORT the ARRAY--------------------------------------------
		selectionSort(SortArray);
		for(int i=0; i<17-a; i++)
		LinkedArray[i]=SortArray[i];
		
		//LinkED List
		String[] dataSource = new String [17-a]; //data for the linked list
		
		for(int i=0; i<17-a; i++){
			dataSource[i]=LinkedArray[i];
			
		}

		for (int i = 0; i < dataSource.length; i++) {
			myList1.append(dataSource[i]);
		}
		
		//System.out.println("Here is myList1: " + myList1);
		

			
		//GUI
		Project1GUI myGUI=new Project1GUI();
		myGUI.setDefaultCloseOperation();
		myGUI.setLocation(100,100);
		myGUI.setTitle("Projuect1GUI");
		myGUI.setVisible(true);
		myGUI.setSize(500, 500);
		myGUI.setLayout();
		myGUI.addContentPane1(NoNullArray);
		myGUI.addContentPane2(SortArray);
		myGUI.addContentPane3(LinkedArray);
		myGUI.printNoNullArray(NoNullArray);
		myGUI.printSortedArray(SortArray);
		myGUI.printLinkedArray(myList1);
		

		
		
		//Commands
		
		String Command, Word, WordtoDel;
		String word="";
		int commaPosition;
		boolean ShouldIResetTheText=false;
		for(;;){
		Command =JOptionPane.showInputDialog("Enter Command: ");
		if(Command.equalsIgnoreCase("STOP")) break;
		
		if(Command.substring(0,3).equalsIgnoreCase("Add")){ 	//(0,3) =Add
			Word=Command.substring(4,Command.length());		//Word = the string after "add"
			//System.out.print(Word); // see if it store in word (CHECKED)
			
			commaPosition=Word.indexOf(",");
	
			
			while(commaPosition!=-1){
				
				myList1.append(Word.substring(0, commaPosition));
				
				/*Check for output
				System.out.println("length"+Word.length());
				System.out.println("Position in "+commaPosition);
				System.out.println(Word);
				System.out.println("After");
				*/
				
				Word=Word.substring(commaPosition+1,Word.length());//commaPosition +1 so that it doesn't include ",";
				commaPosition=Word.indexOf(","); //update commaPosition
	
			}
			
			//code for linked list
			
				myList1.append(Word); // when it only has a word to add
				
		
				LinkedListIterator lli1=myList1.reset();
				while(lli1.hasNext()){	
					word=lli1.next();
					myGUI.setEmptyText(); //it the set the orig. one into "";
				}
				
				myGUI.printLinkedArray(myList1);
				
			
				
		}//add command

		
		if(Command.substring(0,6).equalsIgnoreCase("Delete")){ //(0,6)=Delete
			Word=Command.substring(7,Command.length());  //Word = the string after "delete"
			//System.out.print(Word);//checked
			//code
			
			//System.out.println(myList1.find(Word));
			
			LinkedListIterator lli=myList1.reset();
			while(lli.hasNext()){
				WordtoDel=lli.next();
				
				if(WordtoDel.equalsIgnoreCase(Word)){
					System.out.println("Did We find it? "+WordtoDel);
					myList1.delete(WordtoDel);
					ShouldIResetTheText=true;
				}

			}
			
		/*
		System.out.println("Here is myList1:\n" + myList1);
		LinkedListIterator lli1=myList1.reset(); //updated Strings
		while(lli1.hasNext()){
		System.out.println("Here is lli.ext\n" + lli1.next());
		
			myList1.append(lli1.next());
		
		
		}
		*/
			
			if(ShouldIResetTheText){
				LinkedListIterator lli1=myList1.reset();
				while(lli1.hasNext()){	
					word=lli1.next();
					myGUI.setEmptyText();
				}
				
				myGUI.printLinkedArray(myList1);
			}
			
			
		
		
		}//DEL command
		
		}//for(;;) loop
		
}
	
	
	
	
	
	
//---------------------------------METHODS BELOW-----------------------------------









//Just to store the file input into an array
public static String [] fillArray(String filename){
	TextFileInput in = new TextFileInput(filename);
	String line = in.readLine();
	String []fArray=new String[17];
	int aPosition =0; //array position

	while(line!=null){
		
		fArray[aPosition]=line;
		line=in.readLine();
		aPosition++;	
	}
	
	in.close();
	
return fArray;
}

	//Check if A STRING CONTAINS ONLY LETTER
public static boolean isAlphabets(String data){
	char[] chars=data.toCharArray();
	
	for(char c: chars){
		
		if(!Character.isLetter(c)){
			return false;
		}
	}
	return true;
}

	//SORTED THE ARRAY
static String[] selectionSort(String[] array){
	for (int i = 1; i < array.length; i++) { // find the index of the ith smallest value
		
		int s = i-1;
		
			for (int j = i; j < array.length; j++) { //length-1 will lose an element in an array, which is the word diamond. I ve tried it.
				
				if (array[j].compareTo(array[s]) < 0) {
					s = j;
				}
			}
            // swap the ith smallest value into entry i-1
			String temp = array[i-1];
			array[i-1] = array[s];
			array[s] = temp;
	}//FOR LOOP
        return array;
    }

}