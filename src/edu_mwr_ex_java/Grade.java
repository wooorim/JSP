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
		char ch = '��';
		double avg = getAvg();
		
		if(avg >= 90) {
			ch = '��';
		}else if(avg >= 80){
			ch = '��';
		}else if(avg >= 70) {
			ch = '��';
		}else if(avg >= 60) {
			ch = '��';
		}else {
			ch = '��';
		}
		return ch;
	}
	
}
