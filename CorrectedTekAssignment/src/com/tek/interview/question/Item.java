package com.tek.interview.question;

/*
 * Item class containing details of each 
 * item in an order
 */
public class Item {

	private String description;
	private float price;

	public Item(String description, float price) {
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public float getPrice() {
		return price;
	}
}
