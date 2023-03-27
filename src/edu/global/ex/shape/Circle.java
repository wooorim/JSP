package edu.global.ex.shape;

public class Circle {
	
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	public double getArea() {
		return Math.pow(radius, 2) * Math.PI;
	}

}
