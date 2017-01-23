package util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import util.Logger.DebugLevel;

public class FileProcessor {
	
	private String inputFile=null;
	private File file=null;
	private FileReader read=null;
	private BufferedReader br=null;
	private int lineNo=0;
	
	
	public FileProcessor(String inputFileIn)
	{
		Logger.writeMessage("FileProcessor Constructor Initialzed", DebugLevel.CONSTRUCTOR);
		this.inputFile=inputFileIn;
		
	}
	
	public  void FileParse()
	{
		file=new File(inputFile);
		
		try {
			read = new FileReader(file);
			br=new BufferedReader(read);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception");;
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public synchronized String readInpLineFromFile(String tName)
	{
		 
		String line=null;
		
		try {
			
			if((line=br.readLine())!=null)
			{
				System.out.println(tName + " " + line);
			    //line=br.readLine();
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error: Invalid input at line: "+ lineNo);
			System.exit(0);
			
		}
		return line;
		
		
	}
	
}
