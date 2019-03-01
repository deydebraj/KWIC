package MudtoStructureAP;
import java.awt.*;
import javax.swing.JToolBar; 
import javax.swing.JSplitPane;   
import java.awt.event.ActionEvent;   
import java.awt.event.ActionListener;   
import javax.swing.JButton;   
import javax.swing.JFrame;   
import javax.swing.JScrollPane;   
import javax.swing.JTextArea; 
import javax.swing.*;
import java.io.*;   

public class MainFunction extends JFrame  {
	  public static void main(String[] args) throws Exception{   
	        new MainFunction ().setVisible(true);   
	        FileReader frd=new FileReader("Input.txt");   	//including the input file.
	        printtext(frd,mainscreen);   
	        
	    } 	
    static JTextArea mainscreen=new JTextArea();   
    static JTextArea outputscreen=new JTextArea();
    static JTextArea screenone= new JTextArea();
    JButton press;
    JButton press1;
    JSplitPane split;   
    JToolBar toolbar=new JToolBar();  
    
    MainFunction() {
    	super("ASSIGNMENT 1");   		//name of the tab
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        int x=0,y=0;   
        Dimension size=Toolkit.getDefaultToolkit().getScreenSize();   
        setSize(600,600);   		// size of the tab
        setLocation(x,y);     
        mainscreen.setLineWrap(true);      
        outputscreen.setLineWrap(true);  
        screenone.setLineWrap(true);
        press=new JButton("Please Press Here");   //button text
        press.setForeground(Color.red); 
        press.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent event){   
        try {actions();} catch (Exception e) {
                            e.printStackTrace();}}   
             });   
        split=new JSplitPane(JSplitPane.VERTICAL_SPLIT,new JScrollPane(mainscreen),new JScrollPane(outputscreen));     
        getContentPane().add(split);   		//adding the split in the window
        toolbar.add(press);   				//adding it in the window 
        getContentPane().add(toolbar,BorderLayout.SOUTH);	//divide the window into two   
        split.setDividerLocation(215);   
        split.setResizeWeight(1);  
    } 
    void actions()throws Exception{   
        FileReader a=new FileReader("Input.txt");   		//file is added
        ControlFunction b=InputFilter.parse(a);   
        
        CircularShifterFilter c=new CircularShifterFilter(b);   // function called for shifting
        c.leftshift();   
        
        AlphabetizerFilter d=new AlphabetizerFilter(c);   		//function called 
        d.sort();   
        
        FileWriter e=new FileWriter("Output.txt");   	//showing the output
        
        OutputFilter.lines(d, e);   
        
        FileReader f=new FileReader("Output.txt");   	//storing the output
        printtext(f,outputscreen);   
    }     
     static void printtext(FileReader file,JTextArea area)throws IOException{   
        BufferedReader br=new BufferedReader(file);      
        do{   
            area.append(br.readLine()+"\n");   
        } 
        while(br.ready());  
        br.close();   
    }   
}
