package com.acme.domain;

import com.acme.utils.MyDate;

public class Order {
	private MyDate orderDate;
	private double orderAmount = 0.00;
	private String customer;
	private Product product;
	private int quantity;
	private static Rushable rushable;
	
	public static Rushable getRushable()
	{
		return rushable;
	}
	public static void setRushable(Rushable rushable)
	{
		Order.rushable = rushable;
	}
	public boolean isPriorityOrder()
	{
		boolean priorityOrder = false;
		if (rushable != null) {
			priorityOrder = rushable.isRushable(orderDate,  orderAmount);
		}
		return priorityOrder;
	}

	public MyDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(MyDate orderDate) {
		if (isHoliday(orderDate)) {
			System.out.println("Order date, " + orderDate + ", cannot be set to a holiday!");
		} else {
			this.orderDate = orderDate;
		}
		
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		if (orderAmount > 0) {
			this.orderAmount = orderAmount;
		} else {
			System.out.println("Attempting to set the orderAmount to a value less than or equal to zero");
		}
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	// default constructor
//		public Order() {
//			
//		};

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

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
		} else {
			return 'X';
		}
	}

	public double computeTotal() {
		double orderTotal = orderAmount;
		// Order total = order amount - discount + tax

		switch (jobSize()) {
		case 'M':
			orderTotal = orderTotal - (orderAmount * 0.01);
			break;
		case 'L':
			orderTotal = orderTotal - (orderAmount * 0.02);
			break;
		case 'X':
			orderTotal = orderTotal - (orderAmount * 0.03);
			break;
		}
		if (orderAmount <= 1500) {
			orderTotal = orderTotal + computeTax();
		}
		return orderTotal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity > 0) {
			this.quantity = quantity;
		} else {
			System.out.println("Attempting to set the quantity to a value less than or equal to zero.");
		}
	}

	public Order(MyDate d, double amt, String c, Product p, int q) {
		setOrderDate(d);
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
	
	private boolean isHoliday(MyDate proposedDate) {
		boolean result = false;
		for (MyDate holiday : MyDate.getHolidays()) {
			if(holiday.equals(proposedDate)) {
				result = true;
			}
		}
		return result;
	}
}
