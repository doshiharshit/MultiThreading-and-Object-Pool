package driver;

import store.ObjectPool;
import store.Result;
import thread.manager.CreateWorkers;
import util.CourseAllocation;
import util.FileProcessor;
import util.Logger;

public class Driver {

	/**
	 * 
	 * @param args
	 */
	
	private static String inputFile=null;
	private static String outputFile=null;
	private static int NUM_THREADS;
	private static int debugLevel;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		inputFile="data3.txt";
		outputFile="outDemo.txt";

		 NUM_THREADS =3;//Integer.parseInt(args[2]);
		/*if(args.length < 4|| args.length > 4) {
			System.out.println("Wrong Number of arguments supplied");
			System.exit(1);
		}
		
		try{
				inputFile=args[0];
				outputFile=args[1];
				NUM_THREADS=Integer.parseInt(args[2]);
				debugLevel=Integer.parseInt(args[3]);
		
		
			if (NUM_THREADS  < 1 || NUM_THREADS > 3) {
				System.out.println("Please enter the number of threads between 1 and 3");
				System.exit(1);
			}

			if (debugLevel < 0 || debugLevel > 4) {
				System.out.println("Use debug level between 0 and 4");
				System.exit(1);
			}
		}
		
		catch(NumberFormatException nfe)
		{
			Systm.out.println("Cannot convert String into Integer");
			nfe.printStackTrace();
		}
		
		finally
		{
			
		}
*/		
		/**
		 * set the debug value from the command line
		 */
		
		//Logger.setDebugValue(Integer.parseInt(args[3]));
		
		/**
		 * /Creating object instance for FileProcessor, CourseAloocation and Result Class
		 */
		
		FileProcessor fp=new util.FileProcessor(inputFile);
		Result rset=new Result(outputFile);
		CourseAllocation ca=new CourseAllocation();
		ObjectPool op = new ObjectPool();
		System.out.println("In driver class");
		
		/**
		 * Parse file and read in Buffer using bufferedReader object
		 */
		fp.FileParse();
	
		CreateWorkers cw=new CreateWorkers(fp,rset,ca,op );
		cw.startWorkers(NUM_THREADS);
		
		
		
		for(int i=1;i<rset.studentList.size()-1;i++)
			System.out.println(rset.studName.get(i)+ rset.studentList.get(i));

		for(int i=0;i<rset.studentList.get(0).size()-1;i++)
			System.out.println(rset.studentList.get(0).get(i));
		
		rset.writeSchedulesToScreen();

	}
	
	

}
