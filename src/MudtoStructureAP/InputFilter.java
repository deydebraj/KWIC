package MudtoStructureAP;
import java.io.*;
public class InputFilter {  
    public static ControlFunction parse(FileReader fr)throws IOException{  
        BufferedReader br=new BufferedReader(fr);  
        ControlFunction cf=new ControlFunction();  
        do{  
           cf.addtoline(br.readLine());  
        }  while(br.ready());
        	br.close();  
            return cf;  
    }  
}