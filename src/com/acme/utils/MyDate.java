package com.acme.utils;

public class MyDate {
	public int day;
	public int year;
	public int month;
	
	//initialization block, make date for January 1, 2000
	{
		month = 1;
		day = 1;
		year = 2000;
	}
	
	//default constructor or constructor with no arguments
	public MyDate() {}
	
	//constructor with arguments
	public MyDate(int m, int d, int y) {
		setDate(m, d, y);
	}
	
	// setter method for MyDate
	public void setDate(int m, int d, int y) {
		month = m;
		day = d;
		year = y;
		
	}
	
	//override toString() method
	public String toString() {
		String output = month + "/" + day + "/" + year;
		return output;
	}
	
	

}
