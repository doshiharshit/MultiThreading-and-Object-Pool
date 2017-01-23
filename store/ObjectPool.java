package store;

import java.util.ArrayList;

public class ObjectPool {
	boolean caseConflict = false;
	
	public ArrayList<Integer> numActive(Result rsetIn) {
		return rsetIn.counter;
	}
	
	public ArrayList<Integer> numIdle(Result rsetIn) {
		ArrayList<Integer> numIdleList = new ArrayList<Integer>();
		for(int i=0; i<rsetIn.counter.size(); i++){
			numIdleList.add(80-rsetIn.counter.get(i));
		}
		return numIdleList;
	}
	
	public void borrow(Result rsetIn) {
		
	}
	
	public ArrayList<Integer> returnStudentInfo() {
		return null;
	}
	
	public void setCaseConflict(){
		this.caseConflict=true;
	}
	
	public boolean getCaseConflict(){
		return this.caseConflict;
	}
}
