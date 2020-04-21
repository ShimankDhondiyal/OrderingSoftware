/**
 * Abstract Pizza class
 * 
 * @author Shimank Dhondiyal
 * @author Michael Cardoso
 */

package application;

import java.util.ArrayList;

public abstract class Pizza {
	protected String style;
	protected String size;
	protected ArrayList<String> toppings;

	/**
	 * Constructor to make BuildYourOwn pizza
	 *
	 * @param Style BuildYourOwn pizza will be the only valid option
	 * @param Size Small/Medium/Large
	 * @param Toppings ArrayList of toppings for this pizza
	 */
	public Pizza(String style, String size, ArrayList<String> toppings) {
		this.style = style;
		this.size = size;
		this.toppings = toppings;
	}

	/**
	 * Constructor to make Hawaiian/Deluxe pizzas (no custom toppings)
	 *
	 * @param Style Deluxe/Hawaiian pizza
	 * @param Size Small/Medium/large
	 */
	public Pizza(String style, String size) {
		this.style = style;
		this.size = size;
	}

	/**
	 * Calculate price of pizza given toppings/size/type etc
	 *
	 * @return Cost of pizza
	 */
	public abstract int pizzaPrice();

	/**
	 * toString method to print <style>, <size>, <toppings>
	 *
	 * @return String representation of pizza attributes
	 */
	public String toString() {
		return "Style: " + this.style + "\tSize: " + this.size + "\tToppings: " + printToppings();
	}
	
	/**
	 * Iterate through the toppings ArrayList and print the toppings
	 * 
	 * @return String representation of the elements in the ArrayList
	 */
	private String printToppings() {
		String output = "";
		for (String topping : this.toppings) {
			output += topping + " ";
		}
		return output;
	}
}
