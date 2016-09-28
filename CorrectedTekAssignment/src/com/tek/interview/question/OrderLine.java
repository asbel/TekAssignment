package com.tek.interview.question;

/*
 * Class to build details of each order
 */
public class OrderLine {

	private int quantity;
	private Item item;

	public OrderLine(Item item, int quantity) throws IllegalArgumentException {
		if (item == null) {
			System.err.println("ERROR - Item is NULL");
			throw new IllegalArgumentException("Item is NULL");
		}
		
		if(quantity<1){
			System.err.println("ERROR - Quantity has a wrong value");
			throw new IllegalArgumentException("Quantity has a wrong value");
		}
		
		this.item = item; 
		this.quantity = quantity; 
		
		
	}

	public Item getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}
}
