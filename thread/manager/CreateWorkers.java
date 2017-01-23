package thread.manager;
import store.ObjectPool;
import store.Result;
import util.CourseAllocation;
import util.FileProcessor;
import util.Logger;
import util.Logger.DebugLevel;

public class CreateWorkers {

	private FileProcessor fp;
	private Result rset;
	private CourseAllocation ca;
	private ObjectPool op;
	
	public CreateWorkers(FileProcessor fpIn, Result rsetIn, CourseAllocation caIn, ObjectPool opIn) {
		Logger.writeMessage("thread.manager: CreateWorkers Constructor Initialized", DebugLevel.CONSTRUCTOR);
		this.fp=fpIn;
		this.rset=rsetIn;
		this.ca=caIn;
		this.op=opIn;
		// TODO Auto-generated constructor stub
	}

	public void startWorkers(int numThreadsIn){
		Thread [] t=new Thread[numThreadsIn];
		WorkerThread wThead = new WorkerThread( fp,rset,ca,op );
		for (int i=0; i<numThreadsIn;i++)
		{
			t[i]=new Thread(wThead);
			t[i].setName("Thread" + (i+1) + ":");
//			System.out.println(t[i].getName());
			t[i].start();
			
		}
		for (int i=0; i<numThreadsIn;i++)
		{
		
		 try {
	            t[i].join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	}
}
