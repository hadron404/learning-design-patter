package org.example.real1.application.service;

import org.example.real1.application.domain.Order;
import org.example.real1.application.factory.ContextFactory;
import org.example.real1.application.usecase.AfterSaleUseCase;
import org.example.real1.persistence.OrderPersistenceAdapter;

public class AfterSaleService implements AfterSaleUseCase {

	private final OrderPersistenceAdapter orderPersistenceAdapter = new OrderPersistenceAdapter();

	@Override
	public Order.OrderId create(CreateOrderCommand command) {
		Order order = ContextFactory
			.newOrder()
			.create(command.operator());
		return orderPersistenceAdapter.saveOrder(order);
	}

	@Override
	public void pick(PickOrderCommand command) {
		Order order = ContextFactory
			.valueOf(orderPersistenceAdapter.loadOrder(command.pcikOrderId()))
			.pick(command.operator());
		orderPersistenceAdapter.updateOrderAndAddFlow(order);
	}

	@Override
	public void submit(SubmitOrderCommand command) {
		Order order = ContextFactory
			.valueOf(orderPersistenceAdapter.loadOrder(command.submitOrderId()))
			.submit(command.operator());
		orderPersistenceAdapter.updateOrderAndAddFlow(order);
	}

	@Override
	public void complete(CompleteOrderCommand command) {
		Order order = ContextFactory
			.valueOf(orderPersistenceAdapter.loadOrder(command.completeOrderId()))
			.complete(command.operator());
		orderPersistenceAdapter.updateOrderAndAddFlow(order);
	}
}
