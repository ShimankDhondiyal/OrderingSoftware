/**
 * BuildYourOwn Pizza class to define BuildYourOwn pizzas
 *
 * @author Michael Cardoso
 * @author Shimank Dhondiyal
 */

package application;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {
	private int BASE_PRICE_SMALL = 5;
	private int BASE_PRICE_MEDIUM = BASE_PRICE_SMALL + 2;
	private int BASE_PRICE_LARGE = BASE_PRICE_SMALL + 4;

	/**
	 * Explicit constructor for BuildYourOwn
	 *
	 */
	public BuildYourOwn(String style, String size, ArrayList<String> toppings) {
		super(style, size, toppings);
	}

	/**
	 * Calculate the price of the pizza (base price + $2/topping)
	 *
	 * @return Price of pizza
	 */
	public int pizzaPrice() {
		int total = 0;
		if(this.size.toLowerCase().equals("small"))
			total += BASE_PRICE_SMALL;
		else if(this.size.toLowerCase().equals("medium"))
			total += BASE_PRICE_MEDIUM;
		else if(this.size.toLowerCase().equals("large"))
			total += BASE_PRICE_LARGE;
		total += 2 * (this.toppings.size());
		return total;
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
