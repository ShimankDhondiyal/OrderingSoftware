/**
 * Deluxe Pizza class to define deluxe pizzas
 * 
 * @author Michael Cardoso
 * @author Shimank Dhondiyal
 */

package application;

import java.util.ArrayList;

public class Deluxe extends Pizza {
	private int PRICE_SMALL = 14;
	private int PRICE_MEDIUM = PRICE_SMALL + 2;
	private int PRICE_LARGE = PRICE_SMALL + 4;
	
	/**
	 * Explicit constructor for Deluxe
	 */
	public Deluxe(String style, String size) {
		super(style, size);
		this.toppings = new ArrayList<>();
		this.toppings.add("Sausage");
		this.toppings.add("Pepperoni");
		this.toppings.add("Green Pepper");
		this.toppings.add("Onion");
		this.toppings.add("Mushroom");
	}
	
	/**
	 * Calculate the price of the pizza
	 * 
	 * @return Price of pizza
	 */
	public int pizzaPrice() {
		if(this.size.toLowerCase().equals("small"))
			return PRICE_SMALL;
		else if(this.size.toLowerCase().equals("medium"))
			return PRICE_MEDIUM;
		else
			return PRICE_LARGE;
	}
	
	/**
	 * toString method to print <style>, <size>, <toppings>
	 *
	 * @return String representation of pizza attributes
	 */
	public String toString() {
		return super.toString() + "\tPrice: $" + pizzaPrice();
	}
}
