package org.doit.ik.di2;

import org.doit.ik.di.RecordImpl;
import org.doit.ik.di.RecordViewImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//application-context.xml // 자바클래스 설정 파일


@Configuration
public class Config {

	
	
		@Bean
		public RecordImpl record() {
			return new RecordImpl();
		}
		
		/*
		 * <bean id="rvi" class="org.doit.ik.di.RecordViewImpl"> <constructor-arg
		 * ref="record"></constructor-arg>
		 * 
		 * <!-- <property name="record" ref="record"></property> --> <!-- setter
		 * <property name="record" > <ref bean ="record"/>
		 * 
		 * 
		 * </property> -->
		 * 
		 * <!-- <property name="setrecord" ref="개체record"></property> -->
		 * 
		 * </bean>
		 */
	//유지보수가 필요함
		
		
		@Bean(name = "rvi")
		public RecordViewImpl getRecordViewImpl() {
			RecordViewImpl rvi = new RecordViewImpl();
			rvi.setRecord(record());
			return  rvi;
		}
		
		
		
		
}
