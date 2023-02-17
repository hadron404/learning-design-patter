package org.example.pizza.store;

import org.example.pizza.NYStyleCheesePizza;
import org.example.pizza.Pizza;

/**
 * concrete creator
 */
public class NYStylePizzaStore extends PizzaStore {
	@Override
	Pizza createPizza(String type) {
		if (type.equals("cheese")) {
			return new NYStyleCheesePizza();
		}
		return null;
	}
}
