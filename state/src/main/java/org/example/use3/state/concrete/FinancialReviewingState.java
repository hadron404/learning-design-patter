package org.example.use3.state.concrete;

import org.example.use3.context.OrderContext;
import org.example.use3.state.OrderState;

public class FinancialReviewingState implements OrderState {

	@Override
	public void next(OrderContext context) {
		System.out.println("No next state yet.");
	}

	@Override
	public void prev(OrderContext context) {
		context.setState(new ModifyingState());
	}

	@Override
	public void printStatus() {
		System.out.println("FinancialReviewing");
	}
}
