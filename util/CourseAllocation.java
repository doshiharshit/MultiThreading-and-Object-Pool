package util;


import java.util.ArrayList;
import java.util.StringTokenizer;

import store.ObjectPool;
import store.Result;

public class CourseAllocation {
	
	public synchronized void allocate(String Student, Result rset, ObjectPool opIn)
	{
		//ArrayList<String> studentName=null;
		//System.out.println("Allocate course");
		StringTokenizer st=new StringTokenizer(Student);
//		System.out.println(
		
		String studentName=(String) st.nextElement();//);
		
		rset.currStudInfo = new ArrayList<Integer>();
		Integer idx = 0; Integer notInclSum = 0;
		while (st.hasMoreElements()) {
			Integer currPref = Integer.parseInt((String) st.nextElement());
			/*
			if (rset.counter.get(idx)<60)
			{*/
				rset.currStudInfo.add(currPref);
					if(currPref == 6 || currPref == 7){
						notInclSum = notInclSum + currPref;
					}else{
							rset.counter.set(idx, rset.counter.get(idx) + 1);
					}
			/*}*/
			
		
			idx++;
		}
		rset.currStudInfo.add(28-notInclSum);
		
		rset.studentList.add(rset.currStudInfo);
		System.out.println(Thread.currentThread().getName() + " inserted " + studentName);
		rset.studName.add(studentName);
		// retrieve counters 
		
		boolean doRealloc = false;
		ArrayList<Integer> cnter = opIn.numActive(rset);
		for(int x=0; x<cnter.size() && rset.studentList.size()>80; x++){
			if(cnter.get(x) > 60){
				doRealloc = true;
				break;
			}
		}
		
		if(doRealloc){
			opIn.setCaseConflict();
			rset.studentList.get(0).set(5, 0);
			rset.studentList.get(0).set(6, 0);
			for(int i=1; i<rset.studentList.size() && i<31; i++){
				for(int j=0; j<5; j++){
					rset.studentList.get(0).set(j, i);
				}
				int sum = 28;
				sum = sum - rset.studentList.get(i).get(5);
				rset.studentList.get(i).set(5, 0);
				sum = sum - rset.studentList.get(i).get(6);
				rset.studentList.get(i).set(6, 0);
				rset.studentList.get(i).set(7, sum);
			}
			for(int i=31; i<rset.studentList.size() && i<51; i++){
				for(int j=0; j<3; j++){
					rset.studentList.get(0).set(j, rset.studentList.get(0).get(j) + 1 );
				}
				for(int j=5; j<7; j++){
					rset.studentList.get(0).set(j, rset.studentList.get(0).get(j) + 1 );
				}
				int sum = 28;
				sum = sum - rset.studentList.get(i).get(3);
				rset.studentList.get(i).set(3, 0);
				sum = sum - rset.studentList.get(i).get(4);
				rset.studentList.get(i).set(4, 0);
				rset.studentList.get(i).set(7, sum);
			}
			for(int i=51; i<rset.studentList.size() && i<61; i++){
				for(int j=2; j<7; j++){
					rset.studentList.get(0).set(j, rset.studentList.get(0).get(j) + 1 );
				}
				int sum = 28;
				sum = sum - rset.studentList.get(i).get(0);
				rset.studentList.get(i).set(0, 0);
				sum = sum - rset.studentList.get(i).get(1);
				rset.studentList.get(i).set(1, 0);
				rset.studentList.get(i).set(7, sum);
			}
			for(int i=61; i<rset.studentList.size() && i<71; i++){
				for(int j=1; j<7; j++){
					if(j!=2){
						rset.studentList.get(0).set(j, rset.studentList.get(0).get(j) + 1 );
					}
				}
				int sum = 28;
				sum = sum - rset.studentList.get(i).get(0);
				rset.studentList.get(i).set(0, 0);
				sum = sum - rset.studentList.get(i).get(2);
				rset.studentList.get(i).set(2, 0);
				rset.studentList.get(i).set(7, sum);
			}
			for(int i=71; i<rset.studentList.size() && i<81; i++){
				rset.studentList.get(0).set(0, rset.studentList.get(0).get(0) + 1 );
				for(int j=3; j<7; j++){
					rset.studentList.get(0).set(j, rset.studentList.get(0).get(j) + 1 );
				}
				int sum = 28;
				sum = sum - rset.studentList.get(i).get(2);
				rset.studentList.get(i).set(2, 0);
				sum = sum - rset.studentList.get(i).get(1);
				rset.studentList.get(i).set(1, 0);
				rset.studentList.get(i).set(7, sum);
			}
			
		}
	   
	}

}
