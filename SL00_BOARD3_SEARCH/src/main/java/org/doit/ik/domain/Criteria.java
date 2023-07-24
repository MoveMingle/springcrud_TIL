package org.doit.ik.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	private int pageNum;//햔재페이지 번호
	private int amount;//한 페이지 출력할 게시글 수
	
	
	private String type;
	private String keyword; //컨트롤러 메서드
	
	public Criteria(){
		this(1,2);
		
		
		
	}
	
	
	
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;



	}
	
	
	public String getListLink() {
	      UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
	            .queryParam("pageNum", this.getPageNum())
	            .queryParam("amount", this.getAmount())
	            .queryParam("type", this.type)
	            .queryParam("keyword", this.keyword);
	      return builder.toUriString();
	   }
	
	
	//pageNum=1&amount=10&type=T&keyword=홍길동
	
	//"TW.split("")
	//"T" "W"
	public String [] getTypeArr() {
		return type ==null? new String[] {}:this.type.split("");
				}
	
	
}
