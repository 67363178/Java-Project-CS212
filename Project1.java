import javax.swing.JFrame;
import java.awt.*;

public class Project1 extends JFrame {
	
	static JFrame myFrame;

	public static void main(String[] args){
	
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
		for(int i=0; i<17-a; i++){
			SortArray[i]=StoreInArray[i];
			NoNullArray[i]=StoreInArray[i];
		}

		//--------------------------------SORT the ARRAY--------------------------------------------
		selectionSort(SortArray);
		
	   //-----------------------------------Show in GUI------------------------------------------
		Project1GUI(NoNullArray,17-a,SortArray);			
		
		
//GUI Don't Have to read it, just testing
//		myFrame=new JFrame();
//		Project1GUI myGUI=new Project1GUI();
//		myFrame.setSize(myGUI.getWidth(), myGUI.getLength());
//		myFrame.setLocation(100,100);
///		myFrame.setTitle(myGUI.getTitle());
//		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		myFrame.setVisible(true);
//		Container ContentPane=myFrame.getContentPane();
//		myFrame.setLayout(new GridLayout(1,2));
//		TextArea ARRAY = new TextArea();
//		TextArea SORTEDARRAY = new TextArea();
//		ContentPane.add(ARRAY, BorderLayout.EAST);
	//	ContentPane.add(SORTEDARRAY, BorderLayout.WEST);
		//Print the Array in GUI
	//	  for(int i=0; i<17-a; i++){
//		  ARRAY.append(NoNullArray[i]+"\n");
//		   } 
//		  for(int i=0; i<17-a; i++){ 
//		  SORTEDARRAY.append(SortArray[i]+"\n");
//		  }


	}
	

//---------------------------------METHODS BELOW-----------------------------------
//GUI
public static void Project1GUI(String [] Array,int size,String[] SortedArray){
	//GUI set up
	myFrame=new JFrame();
	Project1GUI myGUI=new Project1GUI(); //<<<<<<<<<<<Look!!!! MY Project1GUI CLASS
	myFrame.setSize(myGUI.getWidth(), myGUI.getLength());
	myFrame.setLocation(100,100);
	myFrame.setTitle(myGUI.getTitle());
	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     //TextArea
     Container ContentPane=myFrame.getContentPane();
      
     //set up layout and TextArea
     myFrame.setLayout(new GridLayout(1,2));
	 TextArea ARRAY = new TextArea();
	 TextArea SORTEDARRAY = new TextArea();
	 ContentPane.add(ARRAY, BorderLayout.EAST); //EAST
	 ContentPane.add(SORTEDARRAY, BorderLayout.WEST); //WEST
 
	  //Print the Array in GUI
	 for(int i=0; i<size; i++){
		 
		 ARRAY.append(Array[i]+"\n");	//Array will be the NoNullArray as I MENTIONED BEFORE.
	 } 
	 for(int i=0; i<size; i++){ 
		 
		 SORTEDARRAY.append(SortedArray[i]+"\n");
	 }   
     myFrame.setVisible(true);	   //set visible such that it will show
}

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
		
			for (int j = i; j < array.length; j++) {
				
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