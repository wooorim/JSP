package edu.global.ex.java;

public class Grade {

	private double kor;
	private double eng;
	private double math;

	public Grade(double kor, double eng, double math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public double getSum() {
		return (kor + eng + math);
	}

	public double getAvg() {
		return getSum() / 3.0;
	}

	public char getGrade() {
		char ch = '��';
		double avg = getAvg();

		if (avg >= 90) {
			ch = '��';
		} else if (avg >= 80) {
			ch = '��';
		} else if (avg >= 70) {
			ch = '��';
		} else if (avg >= 60) {
			ch = '��';
		} else {
			ch = '��';
		}
		return ch;
	}
}
