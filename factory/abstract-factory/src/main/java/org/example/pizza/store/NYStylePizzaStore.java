package org.example.pizza.store;

import org.example.pizza.CheesePizza;
import org.example.pizza.Pizza;
import org.example.pizza.factory.NYPizzaIngredientFactory;
import org.example.pizza.factory.PizzaIngredientFactory;

/**
 * concrete creator
 */
public class NYStylePizzaStore extends PizzaStore {
	@Override
	Pizza createPizza(String type) {
		PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

		if (type.equals("cheese")) {
			return new CheesePizza(ingredientFactory);
		}
		return null;
	}
}
