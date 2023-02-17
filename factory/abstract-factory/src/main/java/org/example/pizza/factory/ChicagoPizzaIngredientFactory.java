package org.example.pizza.factory;

import org.example.pizza.ingredient.cheese.Cheese;
import org.example.pizza.ingredient.cheese.Mozzarella;
import org.example.pizza.ingredient.clams.Clams;
import org.example.pizza.ingredient.clams.FrozenClams;
import org.example.pizza.ingredient.dough.Dough;
import org.example.pizza.ingredient.dough.ThickCrustDough;
import org.example.pizza.ingredient.pepperoni.Pepperoni;
import org.example.pizza.ingredient.pepperoni.SlicedPepperoni;
import org.example.pizza.ingredient.sauce.PlumTomatoSauce;
import org.example.pizza.ingredient.sauce.Sauce;
import org.example.pizza.ingredient.veggies.BlackOlives;
import org.example.pizza.ingredient.veggies.EggPlant;
import org.example.pizza.ingredient.veggies.Spinach;
import org.example.pizza.ingredient.veggies.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
	@Override
	public Dough createDough() {
		return new ThickCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	@Override
	public Cheese createCheese() {
		return new Mozzarella();
	}

	@Override
	public Veggies[] createVeggies() {
		return new Veggies[]
			{
				new BlackOlives(),
				new Spinach(),
				new EggPlant()
			};
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FrozenClams();
	}
}
