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
		return getSum()/3.0;
	}
}
