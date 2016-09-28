package com.tek.interview.question;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * Class containing details of each order
 * 
 */
public class Order {
	
	//List containing all details of each order
	private List<OrderLine> orderLines = new ArrayList<OrderLine>(); 
	
	// List containing billing details of each order
	private List<BillDetails> billDetails = new ArrayList<BillDetails>();
	
	//Map containing final cost and item description
	private Map<String,Float> orderDetails = new LinkedHashMap<String, Float>();
	
	/*
	 * Method to add orderLine into order
	 */
	public void addOrder(OrderLine o) throws IllegalArgumentException {
		if (o == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		
		orderLines.add(o);
	}
	
	/*
	 * Method to add billing details in order
	 */	
	public void addBill(BillDetails billDetails) throws IllegalArgumentException {
		if (billDetails == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}	
		this.billDetails.add(billDetails);
	}
	
	/*
	 * Method to add total to the order
	 */
	public void addTotal(String orderName, float total) throws IllegalArgumentException {
		if (orderName == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		orderDetails.put(orderName, total);
	}
	
	public Map<String,Float> getTotal(){
		return orderDetails;
	}
	
	public int size() {
		return orderLines.size();
	}

	public OrderLine getOrderLine(int i) {
		return orderLines.get(i);
	}
	
	public BillDetails getBill(int i) {
		return billDetails.get(i);
	}

	public void clear() {
		orderLines.clear();
	}
}
