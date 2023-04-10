package edu_mwr_ex_java;

public class Grade {
	private int kor;
	private int eng;
	private int math;
	
	public Grade(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getSum() {
		return (kor + eng + math);
	}
	
	public int getAvg() {
		return getSum() / 3;
	}
	
	public char getGrade() {
		char ch = '가';
		double avg = getAvg();
		
		if(avg >= 90) {
			ch = '수';
		}else if(avg >= 80){
			ch = '우';
		}else if(avg >= 70) {
			ch = '미';
		}else if(avg >= 60) {
			ch = '양';
		}else {
			ch = '가';
		}
		return ch;
	}
	
}
