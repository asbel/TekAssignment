package com.tek.interview.question;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Class containing the main method
 * Builds the order and calls methods for calculation
 * of tax and finally printing the bill
 */
public class Foo {

	public static void main(String[] args) throws Exception {

		Map<String, Order> o = new LinkedHashMap<String, Order>();

		Order c = new Order();

		c.addOrder(new OrderLine(new Item("book", 12.49f), 1));
		c.addOrder(new OrderLine(new Item("music CD", 14.99f), 1));
		c.addOrder(new OrderLine(new Item("chocolate bar", 0.85f), 1));

		o.put("Order 1", c);
        c = new Order();
		
		c.addOrder(new OrderLine(new Item("imported box of chocolate", 10f), 1));
		c.addOrder(new OrderLine(new Item("imported bottle of perfume",  47.50f), 1));

		o.put("Order 2", c);
		c = new Order();
		
		c.addOrder(new OrderLine(new Item("Imported bottle of perfume", 27.99f), 1));
		c.addOrder(new OrderLine(new Item("bottle of perfume", 18.99f), 1));
		c.addOrder(new OrderLine(new Item("packet of headache pills", 9.75f), 1));
		c.addOrder(new OrderLine(new Item("box of imported chocolates", 11.25f), 1));

		o.put("Order 3", c);

		float total = new Calculator().calculateTotal(o);
		new BillDetails().printBill(o, total);
	}
}
