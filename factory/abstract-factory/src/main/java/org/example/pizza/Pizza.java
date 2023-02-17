package org.example.pizza;

import org.example.pizza.ingredient.cheese.Cheese;
import org.example.pizza.ingredient.clams.Clams;
import org.example.pizza.ingredient.dough.Dough;
import org.example.pizza.ingredient.pepperoni.Pepperoni;
import org.example.pizza.ingredient.sauce.Sauce;
import org.example.pizza.ingredient.veggies.Veggies;

/**
 * abstract product
 */
public abstract class Pizza {

	String name;

	Dough dough;

	Sauce sauce;


	Veggies[] veggies;

	Cheese cheese;

	Pepperoni pepperoni;

	Clams clams;


	public abstract void prepare();

	public void bake() {

	}

	public void cut() {

	}

	public void box() {

	}

}
