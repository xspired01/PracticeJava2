package com.acme.testing;
import com.acme.utils.MyDate;
import com.acme.domain.Order;
import com.acme.domain.Service;
import com.acme.domain.Solid;
import com.acme.utils.MyDate;
import com.acme.domain.Good.UnitOfMeasureType;

public class TestMyDate{

	public static void main(String[] args){
		MyDate date1 = new MyDate(11,11,1918);

		MyDate date2 = new MyDate();
		date2.setDay(11);
		date2.setMonth(11);
		date2.setYear(1918);

		MyDate date3 = new MyDate();
		date3.setDate(1,1,2016);
		date3.setDay(28);
		System.out.println("This is date3 " + date3);

		String str1 = date1.toString();
		String str2 = date2.toString();
		String str3 = date3.toString();

		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		MyDate date4 = new MyDate();
		String str4 = date4.toString();
		System.out.println(str4);
		
		MyDate.leapYears();
		
		MyDate date5 = new MyDate();
		date5.setDate(13, 40, 1);
		
		MyDate newYear = new MyDate(1,1,2009);
		MyDate fiscalStart = new MyDate(1,1,2009);
		//new test case for equals about type casting
		Solid s2 = new Solid("Acme Balloon", 1401, 15, UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
		Order balloons = new Order(date2, 1000.00, "Bugs Bunny", s2, 125);
		
		if (newYear.equals(fiscalStart))
			System.out.println("These two dates are equal");
		else System.out.println("These two dates are not equal");
		
		if (newYear.equals(s2))
			System.out.println("These two dates are equal");
		else System.out.println("These two dates are not equal");
		
		MyDate.listHolidays();
		MyDate acme101 = new MyDate(1,1,2016);
		Solid s3 = new Solid("Acme Balloon", 1401, 15, UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
		Order balloons101 = new Order(acme101, 1499, "Porky Pig", s3, 125);
		
	}
}