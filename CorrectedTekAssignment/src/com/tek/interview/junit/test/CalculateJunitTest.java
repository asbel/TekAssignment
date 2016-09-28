package com.tek.interview.junit.test;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.tek.interview.question.Calculator;
import com.tek.interview.question.Item;
import com.tek.interview.question.Order;
import com.tek.interview.question.OrderLine;

public class CalculateJunitTest {
	
	Order c = new Order();
	
	@Test
	public void testForGrandTotal() {
		Map<String, Order> o = new LinkedHashMap<String, Order>();
		
		c.addOrder(new OrderLine(new Item("headphones", 12.49f), 1));
		c.addOrder(new OrderLine(new Item("perfume", 14.99f), 1));
		o.put("Order 1", c);
        c = new Order();
		
		c.addOrder(new OrderLine(new Item("imported box of wine", 10f), 1));
		
		o.put("Order 2", c);
		float total = new Calculator().calculateTotal(o);
		System.out.println(total);
		assertEquals(37.48, total,0.0002);
	}
	
	@Test
	public void testForSalesTaxCalculation() {
		Map<String, Order> o = new LinkedHashMap<String, Order>();
		
		c.addOrder(new OrderLine(new Item("headphones", 12.49f), 1));
		c.addOrder(new OrderLine(new Item("perfume", 14.99f), 1));
		o.put("Order 1", c);
		new Calculator().calculateTotal(o);
		float salesTax = c.getBill(0).getSalesTax();
		assertEquals(2.75, salesTax,0.0002);
	}
	
	@Test
	public void testForTotalCalculation() {
		Map<String, Order> o = new LinkedHashMap<String, Order>();
		
		c.addOrder(new OrderLine(new Item("headphones", 12.49f), 1));
		c.addOrder(new OrderLine(new Item("perfume", 14.99f), 1));
		o.put("Order 1", c);
		new Calculator().calculateTotal(o);
		float total = c.getBill(0).getTotal();
		assertEquals(27.48, total,0.0002);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testForNegativeQuantityInOrder() {
		
		c.addOrder(new OrderLine(new Item("book", 12.49f), -2));
	    
	}
	
	
	
	
	

}
