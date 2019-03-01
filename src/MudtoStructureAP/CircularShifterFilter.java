package MudtoStructureAP;
import java.util.*;

public class CircularShifterFilter {  
	private ControlFunction shifts=null;  
	public CircularShifterFilter(ControlFunction shifts){  
    this.shifts=shifts;  
 }  
	 void leftshift(){  				//For left Shift
     int number_of_lines=shifts.lines();  
     ArrayList<ArrayList> exlist=new ArrayList<ArrayList>(0);  
     ArrayList<String> inlist=new ArrayList<String>(0);    
     
     int q=0;
     while(q<number_of_lines) {
    	 int w=0;
    	 while(w<shifts.words(q)) {
    		 if(w==0) { 
         		inlist.add(shifts.indexfromline(q));  
         	}
         	else {
         		inlist.add(shifts.wordshift(q));  
         	} 
    		 w++;
    	 }
    	 
    	 exlist.add(inlist);  
         inlist=new ArrayList<String>(0);  
    	 q++;
     }
     
   
    shifts=new ControlFunction();  
    
    int i=0;
    while(i<number_of_lines) {
    	
    	int j=0;
    	while(j<exlist.get(i).size()) {
    		shifts.addtoline((String)exlist.get(i).get(j));
    		j++;
    	}	
    	i++;
    }

    int p=0;
    while(p<shifts.lines()) {
    	System.out.println(shifts.indexfromline(p));  	
    	p++;
    }
   
 }  
 
 String getLine(int index){  
    return shifts.indexfromline(index);  
}  
 int number_of_lines(){  
        return shifts.lines();  
    }  
 int compare(int index1,int index2){  
    return shifts.indexfromline(index1).compareTo(shifts.indexfromline(index2));  
}  
}