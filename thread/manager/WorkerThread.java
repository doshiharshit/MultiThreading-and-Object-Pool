package thread.manager;
import store.ObjectPool;
import store.Result;
import util.CourseAllocation;
import util.FileProcessor;
import util.Logger;
import util.Logger.DebugLevel;

public class WorkerThread implements Runnable {
	private FileProcessor fp;
	private Result rset;
	String nm;
	private CourseAllocation ca;
	String getLineFromFile=null; 
	private ObjectPool objPool;

	public WorkerThread(FileProcessor fpIn, Result rsetIn, CourseAllocation caIn, ObjectPool objPoolIn) {
		// TODO Auto-generated constructor stub
		Logger.writeMessage("thread.manager: WorkerThread Constructor Initialized", DebugLevel.CONSTRUCTOR);
		this.fp=fpIn;
		this.rset=rsetIn;
		this.ca=caIn;
		this.objPool = objPoolIn;
//		this.nm=nmIn;
	}

	
	@Override
	public void run() {
		Logger.writeMessage("thread.manager: Inside run() method", DebugLevel.THREAD);
		while((getLineFromFile = fp.readInpLineFromFile(Thread.currentThread().getName())) !=null){
			ca.allocate(getLineFromFile,rset,objPool);
		//getLineFromFile=fp.readInpLineFromFile();
	}
		
	}

}
