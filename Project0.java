import javax.swing.JOptionPane;
public class Project0
{
public static void main(String [] arg)
{
// Name: ChunYiu Lam , Lab Section 
for(;;){ //keep asker user for input util "stop"
String x;
int E=0, e=0;
String y="stop";

x=JOptionPane.showInputDialog("Please enter a sentence.");

if(x.equalsIgnoreCase(y)){ //"STOP", then exit
System.exit(0);
}

// Compare each character in a string.
for(int i=0; i<x.length(); i++){
	if(x.charAt(i)=='E'){
	E=E+1;

	}
		if(x.charAt(i)=='e'){
		e=e+1;

		}

}

//Print
JOptionPane.showMessageDialog(null,"Number of lower case e's: "+e+"\nNumber of upper case e's: "+E);




}// for(;;)

}

}