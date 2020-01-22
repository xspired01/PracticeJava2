package com.acme.domain;

import com.acme.utils.MyDate;

public class Order {
	MyDate orderDate;
	double orderAmount = 0.00;
	String customer;
	private Good product;
	int quantity;

	public static double taxRate;
	// initialization block for taxRate
	{
		taxRate = 0.05;
	}

	public static void setTaxRate(double newRate) {
		taxRate = newRate;
	}

	public static void computeTaxOn(double anAmount) {
		System.out.println("The tax for " + anAmount + " is: " + anAmount * Order.taxRate);
	}

	public double computeTax() {
		System.out.println("The tax for this order is: " + orderAmount * Order.taxRate);
		return orderAmount * Order.taxRate;
	}

	
	public char jobSize() {
		
		if (quantity <= 25) {
			return 'S';
		} else if (quantity < 75) {
			return 'M';
		} else if (quantity < 150) {
			return 'L';
		} else  {
			return 'X';
		}
	}
	
	public double computeTotal() {
		double orderTotal = orderAmount;
		//Order total = order amount - discount + tax
		
		switch (jobSize()) {
		case 'M': orderTotal = orderTotal - (orderAmount * 0.01);
		break;
		case 'L': orderTotal = orderTotal - (orderAmount * 0.02);
		break;
		case 'X': orderTotal = orderTotal - (orderAmount * 0.03);
		break;
		}
		if (orderAmount <= 1500) {
			orderTotal = orderTotal + computeTax();
		}
		return orderTotal;
	}

	//default constructor
	public Order() {
		
	};
	
	public Good getProduct() {
		return product;
	}

	public Order(MyDate d, double amt, String c, Good p, int q) {
		orderDate = d;
		orderAmount = amt;
		customer = c;
		product = p;
		quantity = q;
	}

//	public Order(MyDate d, double amt, String c) {
//		// using this with default constructor to reuse/reduce code
//		this();
//		orderDate = d;
//		orderAmount = amt;
//		customer = c;
//	    product.setName("Anvil");
//		quantity = 1;
//	}

	public String toString() {
		return quantity + " ea. " + product + " for " + customer;
	}
}
