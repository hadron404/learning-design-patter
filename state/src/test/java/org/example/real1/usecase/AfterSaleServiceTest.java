package org.example.real1.usecase;

import org.example.real1.constant.StatePersistenceMapping;
import org.example.real1.factory.ContextFactory;
import org.example.real1.persistence.Repository;
import org.example.real1.state.Context;
import org.example.real1.state.concrete.FinishedState;
import org.example.real1.persistence.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AfterSaleServiceTest {

	private final AfterSaleService afterSaleServiceUnderTest = new AfterSaleService();
	private final Repository repository = new Repository();

	@Test
	void givenWorkOrder_whenState_thenInitContextSucceeded() {
		Order order = repository.selectById(2);
		Assertions.assertDoesNotThrow(() -> ContextFactory.valueOf(order));
	}

	@Test
	void name() {
		Order order = repository.selectById(1);
		Context context = ContextFactory.valueOf(order);
		context.pick();
		context.nextState();
		context.handle();
		context.nextState();
		context.complete();
		context.nextState();
		context.printState();
		Assertions.assertTrue(context.getState() instanceof FinishedState);
	}

	@Test
	void givenNewOrder_whenOrder_thenOrderCreated() {
		// Step1. 工单新建
		Assertions.assertDoesNotThrow(afterSaleServiceUnderTest::create);
		Assertions.assertEquals(1, Repository.ORDER_MAP.size());
		Assertions.assertEquals(1, Repository.FLOW_MAP.size());
	}

	@Test
	void givenNewOrder_whenKFPick_thenOrderPicked() {
		// Step1. 工单新建
		Integer orderId = afterSaleServiceUnderTest.create();
		Assertions.assertEquals(1, Repository.ORDER_MAP.size());
		Assertions.assertEquals(1, Repository.FLOW_MAP.size());
		// Step2. 客服领取
		afterSaleServiceUnderTest.pick(orderId);
		Assertions.assertEquals(1, Repository.ORDER_MAP.size());
		Assertions.assertEquals(StatePersistenceMapping.HANDLING.getCode(), Repository.ORDER_MAP.get(orderId).getState());
		Assertions.assertEquals(2, Repository.FLOW_MAP.size());
		// Step3. 客服提交
		afterSaleServiceUnderTest.handle(orderId);
		Assertions.assertEquals(1, Repository.ORDER_MAP.size());
		Assertions.assertEquals(StatePersistenceMapping.WAITING_FINISH.getCode(), Repository.ORDER_MAP.get(orderId).getState());
		Assertions.assertEquals(3, Repository.FLOW_MAP.size());
		// Step4. 工单完结
		afterSaleServiceUnderTest.complete(orderId);
		Assertions.assertEquals(1, Repository.ORDER_MAP.size());
		Assertions.assertEquals(StatePersistenceMapping.FINISHED.getCode(), Repository.ORDER_MAP.get(orderId).getState());
		Assertions.assertEquals(4, Repository.FLOW_MAP.size());
	}
}
