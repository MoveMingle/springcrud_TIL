package org.doit.ik.di3;

import java.util.Scanner;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordViewImpl3 implements RecordView3{


		
		
		
		
	//@Setter()
	/* @Autowired(required=false) */
	//@Resource(name="record1") java 9부터는 사용 x 
	@Inject
	@Named(value ="record2")
	private RecordImpl3 record = null;
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
		// TODO Auto-generated method stub
		System.out.printf("kor =%d, eng =%d, mat=%d,tot=%d, avg=%2f\n",

				this.record.getKor(),
				this.record.getEng(),
				this.record.getMat(),
				this.record.total(),
				this.record.avg()
				);

	}


}