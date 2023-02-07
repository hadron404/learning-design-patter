package org.example.real1.persistence;

import org.example.real1.application.domain.Order;

public class OrderMapper {

	public OrderEntity mapToEntity(Order order) {
		return new OrderEntity(
			order.getId() == null ? null : order.getId().value(),
			order.getState().value()
		);
	}

	public Order mapToDomain(OrderEntity entity) {
		return new Order(entity.getId(), entity.getState());
	}
}
