package org.example.use3.state.concrete;

import org.example.use3.context.OrderContext;
import org.example.use3.state.OrderState;


public class ModifyingState implements OrderState {

	@Override
	public void next(OrderContext context) {
		context.setState(new ReviewingState());
	}

	@Override
	public void prev(OrderContext context) {
		System.out.println("No previous state yet.");
	}

	@Override
	public void printStatus() {
		System.out.println("Modifying");
	}
}
