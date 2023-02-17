package org.example.pizza.factory;

import org.example.pizza.ingredient.cheese.Cheese;
import org.example.pizza.ingredient.clams.Clams;
import org.example.pizza.ingredient.dough.Dough;
import org.example.pizza.ingredient.pepperoni.Pepperoni;
import org.example.pizza.ingredient.sauce.Sauce;
import org.example.pizza.ingredient.veggies.Veggies;

public interface PizzaIngredientFactory {

	Dough createDough();

	Sauce createSauce();

	Cheese createCheese();

	Veggies[] createVeggies();

	Pepperoni createPepperoni();

	Clams createClam();
}
