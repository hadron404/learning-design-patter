package org.example.real1.usecase;

import org.example.real1.application.constant.StatePersistenceMapping;
import org.example.real1.application.domain.Order;
import org.example.real1.application.service.AfterSaleService;
import org.example.real1.application.usecase.AfterSaleUseCase;
import org.example.real1.application.usecase.Operator;
import org.example.real1.persistence.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AfterSaleServiceTest {

	private final AfterSaleService afterSaleServiceUnderTest = new AfterSaleService();

	@Test
	void givenNewOrder_whenOrder_thenOrderCreated() {
		Operator operator = new Operator(new Operator.OperatorId(13155), "Allen");
		AfterSaleUseCase.CreateOrderCommand command = new AfterSaleUseCase.CreateOrderCommand(operator);
		// Step1. 工单新建
		Assertions.assertDoesNotThrow(() -> afterSaleServiceUnderTest.create(command));
		Assertions.assertEquals(1, Repository.ORDER_MAP.size());
		Assertions.assertEquals(1, Repository.FLOW_MAP.size());
	}

	@Test
	void givenNewOrder_whenKFHandleFinished_thenOrderFinished() {
		Operator operator = new Operator(new Operator.OperatorId(13155), "Allen");
		// Step1. 工单新建
		AfterSaleUseCase.CreateOrderCommand command = new AfterSaleUseCase.CreateOrderCommand(operator);
		Order.OrderId orderId = afterSaleServiceUnderTest.create(command);
		Assertions.assertNotNull(orderId);
		Assertions.assertEquals(1, Repository.ORDER_MAP.size());
		Assertions.assertEquals(1, Repository.FLOW_MAP.size());
		// Step2. 客服领取
		operator = new Operator(new Operator.OperatorId(13155), "Allen2");
		AfterSaleUseCase.PickOrderCommand pickCommand = new AfterSaleUseCase.PickOrderCommand(orderId, operator);
		afterSaleServiceUnderTest.pick(pickCommand);
		Assertions.assertEquals(1, Repository.ORDER_MAP.size());
		Assertions.assertEquals(StatePersistenceMapping.HANDLING.getCode().value(), Repository.ORDER_MAP.get(orderId.value()).getState());
		Assertions.assertEquals(2, Repository.FLOW_MAP.size());
		// Step3. 客服提交
		AfterSaleUseCase.SubmitOrderCommand submitCommand = new AfterSaleUseCase.SubmitOrderCommand(orderId, operator);
		afterSaleServiceUnderTest.submit(submitCommand);
		Assertions.assertEquals(1, Repository.ORDER_MAP.size());
		Assertions.assertEquals(StatePersistenceMapping.WAITING_FINISH.getCode().value(), Repository.ORDER_MAP.get(orderId.value()).getState());
		Assertions.assertEquals(3, Repository.FLOW_MAP.size());
		// Step4. 工单完结
		AfterSaleUseCase.CompleteOrderCommand completeCommand = new AfterSaleUseCase.CompleteOrderCommand(orderId, operator);
		afterSaleServiceUnderTest.complete(completeCommand);
		Assertions.assertEquals(1, Repository.ORDER_MAP.size());
		Assertions.assertEquals(StatePersistenceMapping.FINISHED.getCode().value(), Repository.ORDER_MAP.get(orderId.value()).getState());
		Assertions.assertEquals(4, Repository.FLOW_MAP.size());
		Repository.FLOW_MAP.forEach(System.out::println);
	}
}
