package org.example.pizza.factory;

import org.example.pizza.ingredient.cheese.Cheese;
import org.example.pizza.ingredient.cheese.ReggianoCheese;
import org.example.pizza.ingredient.clams.Clams;
import org.example.pizza.ingredient.clams.FreshClams;
import org.example.pizza.ingredient.dough.Dough;
import org.example.pizza.ingredient.dough.ThinCrustDough;
import org.example.pizza.ingredient.pepperoni.Pepperoni;
import org.example.pizza.ingredient.pepperoni.SlicedPepperoni;
import org.example.pizza.ingredient.sauce.MarinaraSauce;
import org.example.pizza.ingredient.sauce.Sauce;
import org.example.pizza.ingredient.veggies.Garlic;
import org.example.pizza.ingredient.veggies.Onion;
import org.example.pizza.ingredient.veggies.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		return new Veggies[]{
			new Garlic(), new Onion()
		};
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FreshClams();
	}
}
