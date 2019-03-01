package MudtoStructureAP;

import java.io.*;  

  
public class OutputFilter {  
    public static void lines(AlphabetizerFilter af,FileWriter filewrite)throws Exception{  
        BufferedWriter bw=new BufferedWriter(filewrite);   
        int mm=1;
        while(mm<af.linesort()){
        	bw.write(af.lineop(mm));  
            bw.newLine();
            mm++;
        }
        bw.close();  
        }  
    } 