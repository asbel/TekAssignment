package com.tek.interview.question;

import java.text.DecimalFormat;
import java.util.Map;

/*
 * Class that implements the calculation of tax for each order
 */
public class Calculator {

	/*
	 * Method to implement the rounding of decimal places
	 */
	public static float rounding(float value) {
		DecimalFormat f = new DecimalFormat("##.00");
		return Float.parseFloat(f.format(value));
	}

	/*
	 * Method to calculate the total
	 */

	public float calculateTotal(Map<String, Order> o) {
		float grandtotal = 0;
		/*
		 * Iterate through the map to calculate total
		 */
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			Order order = entry.getValue();
			float totalTax = 0;
			float total = 0;
			BillDetails billDetails = new BillDetails();
			/*
			 * Iterate through each order to calculate the total and tax
			 */
			for (int i = 0; i < order.size(); i++) {
				String description = order.getOrderLine(i).getItem()
						.getDescription();
				float price = order.getOrderLine(i).getItem().getPrice();
				float tax = 0;
				tax = calculateTax(description, price);
				float totalprice = price + tax;
				order.getTotal().put(description, rounding(totalprice));
				totalTax += tax;
				total += price;
			}
			billDetails.setSalesTax(rounding(totalTax));
			billDetails.setTotal(rounding(total));
			order.addBill(billDetails);
			grandtotal += total;
		}
		return rounding(grandtotal);

	}

	/*
	 * Method to calculate the tax
	 */

	public float calculateTax(String description, float price) {
		if (description.contains("imported")
				|| description.contains("Imported")) {
			return (price * 0.15f); // Extra 5% tax on
		} else {
			return (price * 0.10f);
		}
	}

}
