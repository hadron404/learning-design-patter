package org.example.use3.state.concrete;

import org.example.use3.context.OrderContext;
import org.example.use3.state.OrderState;


public class ReviewingState implements OrderState {

	@Override
	public void next(OrderContext context) {
		context.setState(new FinancialReviewingState());
	}

	@Override
	public void prev(OrderContext context) {
		context.setState(new ModifyingState());
	}

	@Override
	public void printStatus() {
		System.out.println("Reviewing");
	}
}
