package org.doit.ik.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	private int pageNum;//햔재페이지 번호
	private int amount;//한 페이지 출력할 게시글 수
	
	
	
	
	
	public Criteria(){
		this(1,5);
		
		
		
	}
	
	
	
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;



	}
	
	
	//pageNum=1&amount=10&type=T&keyword=홍길동
	
	
	
	
	
}
