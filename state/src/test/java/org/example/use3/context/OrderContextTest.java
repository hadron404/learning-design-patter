package org.example.use3.context;

import org.example.use3.state.concrete.FinancialReviewingState;
import org.example.use3.state.concrete.ReviewingState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderContextTest {

	@Test
	void givenNewOrder_whenOrderCreated_thenStateReviewing() {
		OrderContext order = new OrderContext();
		assertTrue(order.getState() instanceof ReviewingState);
	}

	@Test
	void givenNewOrder_whenOrderFinancialReviewed_thenStateFinancialReviewing() {
		OrderContext order = new OrderContext();

		assertTrue(order.getState() instanceof ReviewingState);
		order.nextState();

		assertTrue(order.getState() instanceof FinancialReviewingState);
		order.nextState();
	}
}
