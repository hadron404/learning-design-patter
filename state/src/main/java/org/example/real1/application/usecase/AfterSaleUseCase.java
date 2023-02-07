package org.example.real1.application.usecase;

import org.example.real1.application.domain.Order;

public interface AfterSaleUseCase {

	Order.OrderId create(CreateOrderCommand command);

	void pick(PickOrderCommand command);


	void submit(SubmitOrderCommand command);

	void complete(CompleteOrderCommand command);

	record CreateOrderCommand(Operator operator) {

	}

	record PickOrderCommand(Order.OrderId pcikOrderId, Operator operator) {

	}

	record SubmitOrderCommand(Order.OrderId submitOrderId, Operator operator) {

	}

	record CompleteOrderCommand(Order.OrderId completeOrderId, Operator operator) {

	}
}
