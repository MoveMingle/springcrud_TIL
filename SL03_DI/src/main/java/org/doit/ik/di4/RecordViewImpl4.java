package org.doit.ik.di4;

import java.util.Scanner;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
//컴포넌트에 이름을 부여하지 않으면 클래스의 첫글자로 명명된다 


public class RecordViewImpl4 implements RecordView4{


		
		
		
		
	//@Setter()
    @Autowired(required=false) 
	//@Resource(name="record1") java 9부터는 사용 x 
	 
	// @Inject 
   //@Named(value ="record4") 
	private RecordImpl4 record = null;
	//여러개여도 오류 없어도 오류... 
	
	
	@Override
	public void input() {
								
		try(Scanner scanner = new Scanner(System.in)){
			System.out.printf(">kor,eng,mat input?");

			int kor = scanner.nextInt();
			int eng = scanner.nextInt();
			int mat = scanner.nextInt();

			this.record.setKor(kor);
			this.record.setEng(eng);
			this.record.setMat(mat);

		} catch (Exception e) {
			e.printStackTrace();
		}



	}


	@Override
	public void output() {
		
		System.out.printf("kor =%d, eng =%d, mat=%d,tot=%d, avg=%2f\n",

				this.record.getKor(),
				this.record.getEng(),
				this.record.getMat(),
				this.record.total(),
				this.record.avg()
				);

	}


}