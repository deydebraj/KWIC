package MudtoStructureAP;

public class AlphabetizerFilter {

	private CircularShifterFilter cs;  
	private int[] sorted;  
	int linesort(){  
	    return sorted.length;  
	} 
	
	public AlphabetizerFilter(CircularShifterFilter cs){  //for circular shifting of alphabet
	    this.cs=cs;  
	    sorted=new int[cs.number_of_lines()];  
	    int i=0; 
	    while(i<sorted.length) {
	    	sorted[i]=i; 
	    	i++;
	    }
	}  
	public void sort(){    					//sorting into order A-Z
	    int temp, i=1;
	   while(i<sorted.length) {
		   int j=i;
		   while((j>0)&&(cs.compare(sorted[j], sorted[j-1]))<0) {
			   temp=sorted[j];  
	            sorted[j]=sorted[j-1];  
	            sorted[j-1]=temp;  
	           j--;
		   }
		   i++;
	   }
	}  
	
	 String lineop(int index){  
	    return cs.getLine(sorted[index]);  
	}  
	  
}