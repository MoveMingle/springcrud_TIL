package org.doit.ik.di.test;

import org.doit.ik.di.Record;
import org.doit.ik.di.RecordImpl;
import org.doit.ik.di.RecordViewImpl;

public class Ex01 {

	public static void main(String[] args) {
		//org/doik.di 패키지
		//Record.java 인터페이스
		//RecordImpl.java 
		//RecordView.java 
		//RecordViewImpl.java 
		RecordImpl record = new RecordImpl();
		
		
		
		//setter DI
		RecordViewImpl rvi= new RecordViewImpl();
		//						생성자 DI
		//RecordViewImpl rvi = new RecordViewImpl(record);
		
		rvi.setRecord(record);
		rvi.input(); //성적입력
		rvi.output();//성적출략
		System.out.println("END");
		
	}
	
}
