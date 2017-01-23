package store;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.Logger;
import util.Logger.DebugLevel;

public class Result implements FileDisplayInterface, StdoutDisplayInterface  {

	public List<ArrayList<Integer>> studentList = Collections.synchronizedList(new ArrayList<ArrayList<Integer>>()); 
	public ArrayList<String> studName = new ArrayList<String>();
	public ArrayList<Integer> counter = new ArrayList<Integer>();
	public ArrayList<Integer> currStudInfo=null;
	private String outputFile;
	
	public Result(String outputFileIn) {
		
		Logger.writeMessage("store: Result Constructor Initialized", DebugLevel.CONSTRUCTOR);
		this.outputFile=outputFileIn;
		counter.add(0);	counter.add(0);	counter.add(0);	counter.add(0);
		counter.add(0);	counter.add(0);	counter.add(0);	counter.add(0);
		studentList.add(counter);
		studName.add("default");
	//	list1.add("harsha");
	}
	
	public synchronized int listSize(){
		return studentList.size();
	}

	public synchronized void writeOutputToFile(String outputFile)
	{
		BufferedWriter bw=null;
		try {
			bw = new BufferedWriter(new FileWriter(new File(outputFile)));
			int totPref = 0;
			int addStudPrefScore =0;
			for (int i=1; i< studentList.size(); i++)
			{
				bw.write(studName.get(i) + " ");
				currStudInfo = studentList.get(i);
				for(int j=0;j<currStudInfo.size();j++)
				{
					if(j != 7)
					{
						if(currStudInfo.get(j) != 0){
							bw.write(((char) (currStudInfo.get(j)+64)) + " ");
						}
					}
					else
					{
						bw.write(currStudInfo.get(j) + "\n");
						addStudPrefScore=currStudInfo.get(j);
					}
					
				}
//				bw.write(currStudInfo.get(7) + "\n");
				totPref = totPref + addStudPrefScore;
			}
			bw.write("\nAverage preference_score is: " + (new Float(new Float(totPref) / new Float(80))));
			bw.flush();
			bw.close();
		} catch (FileNotFoundException fe){
			System.out.println("Unable to locate File");
			fe.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Error while writing to file");
			e.printStackTrace();
			System.exit(0);
		} finally{
			/*try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		}
	}
	@Override
	public void writeSchedulesToScreen() {
		int totPref = 0;
		int addStudPrefScore =0;
		for (int i=1; i< studentList.size(); i++)
		{
			System.out.print(studName.get(i) + " ");
			currStudInfo = studentList.get(i);
			for(int j=0;j<currStudInfo.size();j++)
			{
				if(j != 7)
				{
					if(currStudInfo.get(j) != 0){
						System.out.print(((char) (currStudInfo.get(j)+64)) + " ");
					}
				}
				else
				{
					System.out.print(currStudInfo.get(j) + "\n");
					addStudPrefScore=currStudInfo.get(j);
				}
				
			}
//			bw.write(currStudInfo.get(7) + "\n");
			totPref = totPref + addStudPrefScore;
		}
		System.out.print("\nAverage preference_score is: " + (new Float(new Float(totPref) / new Float(80))));
	}

	@Override
	public void writeSchedulesToFiles() {
		writeOutputToFile(outputFile);
	}
}
