package org.doit.ik.di.test;

import org.doit.ik.di.RecordViewImpl;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex02 {

	public static void main(String[] args) {
		/* 
		 * 1.스프링 객체 생성+조립-> 스프링 컨테이너
		 * 2. 2가지 방법
		 * xml 파일    
		 * src/main/resources/application-context.xml 추가 
		 * java 파일 
		 * 
		 *  */
		String resouceLocations ="application-context.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(resouceLocations);
		
		//공장에서 가져와야함
		RecordViewImpl rvi =(RecordViewImpl) ctx.getBean("rvi");
		
		rvi.input(); //성적입력
		rvi.output();//성적출략
		System.out.println("END");
		
		
		
	}//main

}
