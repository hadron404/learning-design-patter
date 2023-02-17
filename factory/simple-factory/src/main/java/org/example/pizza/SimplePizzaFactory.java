package org.example.pizza;

import org.example.pizza.concrete.CheesePizza;

public class SimplePizzaFactory {

	public static Pizza createPizza(String type) {
		Pizza pizza = null;
		if (type.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (type.equals("")) {

		}
		return pizza;
	}
}
