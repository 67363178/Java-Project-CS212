import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JFrame;
public class Project1GUI extends JFrame{
	private int width;
	private int length;
	private String title;
	static JFrame myFrame=new JFrame();
	Container ContentPane=myFrame.getContentPane();
	TextArea ARRAY = new TextArea();
	TextArea SORTEDARRAY = new TextArea();
	TextArea LinkedARRAY=new TextArea();
	TextArea UpdatedLinkedArray=new TextArea();




//Constructors 
	public Project1GUI(){
		width=500;
		length=500;
		title="Project1GUI";
	}

	public Project1GUI(int myw, int myl, String myt){
		width=myw;
		length=myl;
		title=myt;
	}


//--------------Methods------------------------------------------------------
//SETTERS(Use arguments but do not return anything)
	public void setWidth(int myw){
		width=myw;
	}

	public void setLength(int myl){
		length=myl;
	}

	public void setTitle(String myt){
		myFrame.setTitle(myt);
	}

	public void setLocation(int x, int y){
		myFrame.setLocation(x,y);
	}

	public void setSize(int width, int length){
		myFrame.setSize(width, length);
		
	}
	
	public void setDefaultCloseOperation(){
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setLayout(){
		myFrame.setLayout(new GridLayout(1,2));
		
	}
	
	public void setVisible(boolean x){
		
		 myFrame.setVisible(x);
	}
	

	
	public void addContentPane1(String [] noNullArray){
		 ContentPane.add(ARRAY, BorderLayout.EAST); //EAST
		
	}
	
	public void addContentPane2(String [] SORTARRAY){
		 ContentPane.add(SORTEDARRAY, BorderLayout.WEST); //EAST
		
	}

	public void addContentPane3(String [] LINKEDARRAY){
		 ContentPane.add(LinkedARRAY, BorderLayout.WEST); //EAST
		
	}
	
	public void addContentPane4(String [] LINKEDARRAY){
		 ContentPane.add(UpdatedLinkedArray, BorderLayout.WEST); //EAST
		
	}

	
	
//GETTERS(Do not use arguments but return something)

	public int getLength(){
	return length;
	}
	public int getWidth(){
	return width;
	}
	public String getTitle(){
	return title;
	}

//-----------------------

	public void printNoNullArray(String [] NONULLARRAY){
		for(int i=0; i<NONULLARRAY.length; i++){
			 
			 ARRAY.append(NONULLARRAY[i]+"\n");	//Array will be the NoNullArray as I MENTIONED BEFORE.
		 } 
	}
	
	public void printSortedArray(String [] SORTARRAY){
		for(int i=0; i<SORTARRAY.length; i++){
			 
			 SORTEDARRAY.append(SORTARRAY[i]+"\n");	//Array will be the NoNullArray as I MENTIONED BEFORE.
		 } 
	}
	
	public void printLinkedArray(LinkedList myList1){
		
		LinkedARRAY.setText(""); 
		
			 
		LinkedARRAY.append(myList1+"\n");	
		
	}
	
	public void setEmptyText(){//So that it will erase the data we had
		 
		LinkedARRAY.append("");		
	
}
}