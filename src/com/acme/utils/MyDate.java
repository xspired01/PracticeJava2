package com.acme.utils;

public class MyDate {
	private byte day;
	private byte month;
	private short year;
	

	// initialization block, make date for January 1, 2000
	{
		month = 1;
		day = 1;
		year = 2000;
	}

	// default constructor or constructor with no arguments
	//and initial date
	public MyDate() {
		this(1, 1, 1900);
	}

	// constructor with arguments
	public MyDate(int m, int d, int y) {
		setDate(m, d, y);
	}

	// setter method for MyDate
	public void setDate(int m, int d, int y) {
		//NOTE: order for valid is DAY, MONTH, YEAR
		if (valid(d, m, y)) {
			month = (byte) m;
			day = (byte) d;
			year = (short) y;
		}
	}

	// override toString() method
	public String toString() {
		String output = month + "/" + day + "/" + year;
		return output;
	}
	
	public static void leapYears() {
		int y;
		for (y = 1752; y <= 2020; y++) {
			if ((y % 4 == 0) && ((y % 100 != 0) || (y % 400 == 0)) ) {
				System.out.println("The year " + y + " is a Leap Year");
			}
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (valid(day, month, year)) {
			this.day = (byte) day;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (valid(day, month, year)) {
			this.month = (byte) month;
		}
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (valid(day, month, year)) {
			this.year = (short) year;
		}
	}
	
	//NOTE: valid parameter order is DAY, MONTH, YEAR which is different
	// than US dates MONTH, DAY, YEAR. 
	private boolean valid(int day, int month, int year) {
		if (day > 31 || day < 1 || month > 12 || month < 1) {
			System.out.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year);
			return false;
		}
		switch(month) {
		case 4:
		case 6:
		case 9:
		case 11: return (day <=30);
		case 2: return day <= 28 || (day == 29 && year % 4 == 0);
		}
		return true;
	}
	
	public boolean equals(Object o) {
		if (o instanceof MyDate) {
			MyDate d = (MyDate) o;
			if((d.day == day) && (d.month == month) && (d.year == year)) {
				return true;
			}
		}
		return false;
	}

	
	
}
