public class Project1GUI{
	private int width;
	private int length;
	private String title;



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
	title=myt;
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




}