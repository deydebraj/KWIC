package MudtoStructureAP;

import java.util.*;  

public class ControlFunction { 

 	String wordshift(int line_index){  
    String line=this.indexfromline(line_index);  
    int indexwords=0;
    String string1="", string2="";  
    int temp=line.indexOf(' '); 
    if(temp!=-1){  
    	string1=line.substring(0,temp);  
    	string2=line.substring(temp+1);  
        lines.set(line_index,string2+" "+string1);  
        return string2+" "+string1;     
    }  
    else {
    	return null;
    	}  
}
 	private ArrayList<String> lines=null;  
    
    int words(int index){  			
        return lines.get(index).split(" ").length;  
    }  
     
     int lines(){  						//counting number of lines;     
    	return lines.size();  
    }  
     
 	public int temp1=0;
    
 	ControlFunction(){  
        lines=new ArrayList<String>(0);  
    }  
    
     String indexfromline(int index){  //indexing of the lines
        return lines.get(index);  
    }  
    
     void addtoline(String line){  		//parsing the lines
        lines.add(line);  
    }  
    
     void addtoline(int index,String line){  	//adding words to line
        lines.add(index,line);  
    } 
              
}