package org.doit.ik.di;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordViewImpl implements RecordView{

	/* private RecordImpl record = new RecordImpl(); */
		private RecordImpl record = null;
	
	
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