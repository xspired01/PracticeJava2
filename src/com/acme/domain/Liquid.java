package com.acme.domain;

public class Liquid extends Good {
	
	public Liquid(String name, int modelNumber, double height, UnitOfMeasureType uoM, boolean flammable,
			double wgtPerUoM, double radius) {
		super(name, modelNumber, height, uoM, flammable, wgtPerUoM);
		this.radius = radius;
	}

	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double volume() {
		return Math.PI * radius * radius * getHeight();
	}
	
	public String toString() {
		return super.toString() + " (liquid) " + volume() + " " + getUnitOfMeasure();
	}


}
