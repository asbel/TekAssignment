package com.tek.interview.question;

import java.util.Map;
import java.util.Set;

/*
 * Class that implements the printing of the final bill
 * and also contains the total and 
 * sales tax of each order
 */ 
public class BillDetails{
	
	private float total;
	
	private float salesTax;
	
	public float getSalesTax() {
		return salesTax;
	}
	public void setSalesTax(float salesTax) {
		this.salesTax = salesTax;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	/*
	 * Method to print the final output in the 
	 *  required format
	 */
	
	public void printBill(Map<String, Order> o, float grandTotal){
		
		/*
		 * Iterate through the map to print the orders 
		 */
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******"); 
			Order r = entry.getValue();
			Map<String,Float> map = r.getTotal();
			Set<String> keySet = map.keySet();
			int i = 0;
			int j = 0;
			
			// Iterate through the order to print the details
			
			for(String key : keySet){
				int quantity = r.getOrderLine(i).getQuantity();
				System.out.println(quantity + " " + key + ": " + map.get(key) );
				i++;
			}
			
			System.out.println("Sales Tax: " + r.getBill(j).getSalesTax());
			System.out.println("Total: " + r.getBill(j).getTotal());
			
		}
		
		System.out.println("Sum of Orders: " + grandTotal);
	}
	
	
	
	
}