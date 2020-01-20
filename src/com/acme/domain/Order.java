package com.acme.domain;
import com.acme.utils.MyDate;

public class Order {
	MyDate orderDate;
	double orderAmount = 0.00;
	String customer;
	String product;
	int quantity;
	
	public static double taxRate;
	//initialization block for taxRate
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
	
	public Order() {};
	
	public Order(MyDate d, double amt, String c, String p, int q){
		orderDate=d;
		orderAmount=amt;
		customer=c;
		product=p;
		quantity=q;
	}
	
	public Order(MyDate d, double amt, String c){
		//using this with default constructor to reuse/reduce code 
		this();
		orderDate=d;
		orderAmount=amt;
		customer=c;
		product="Anvil";
		quantity=1;
	}
	
	
	public String toString(){
		return quantity + " ea. " + product + " for " + customer; 
	}
}
