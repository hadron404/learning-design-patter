package org.example.pizza.store;

import org.example.pizza.Pizza;

/**
 * abstract Creator class
 *
 * */
public abstract class PizzaStore {
	// 声明为 final ，不允许子类覆盖这个方法
	final public Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

	/**
	 * abstract factory method
	 * */
	abstract Pizza createPizza(String type);
}
