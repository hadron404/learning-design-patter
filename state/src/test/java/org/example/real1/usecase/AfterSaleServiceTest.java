package org.example.real1.usecase;

import org.example.real1.factory.ContextFactory;
import org.example.real1.state.Context;
import org.example.real1.state.concrete.FinishedState;
import org.example.real1.usecase.entity.WorkOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AfterSaleServiceTest {

	WorkOrder selectById(Integer id) {
		WorkOrder result = new WorkOrder();
		result.setOrderId(id);
		result.setState(0);
		return result;
	}

	@Test
	void givenWorkOrder_whenState_thenInitContextSucceeded() {
		WorkOrder order = selectById(2);
		Assertions.assertDoesNotThrow(() -> ContextFactory.valueOf(order));
	}

	@Test
	void name() {
		WorkOrder order = selectById(1);
		Context context = ContextFactory.valueOf(order);
		context.getState().pick(context);
		context.nextState();
		context.getState().handle(context);
		context.nextState();
		context.getState().complete(context);
		context.nextState();
		Assertions.assertTrue(context.getState() instanceof FinishedState);
	}
}
