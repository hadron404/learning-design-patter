package org.example.real1.persistence;

import org.example.real1.application.domain.Order;

public class OrderPersistenceAdapter {
	private final Repository repo = new Repository();
	private final FlowMapper flowMapper = new FlowMapper();
	private final OrderMapper orderMapper = new OrderMapper();

	public Order loadOrder(Order.OrderId oderId) {
		OrderEntity order = repo.selectById(oderId.value());
		return orderMapper.mapToDomain(order);
	}

	public Order.OrderId saveOrder(Order order) {
		order.setId(repo.insertOrder(orderMapper.mapToEntity(order)));
		repo.insertFlow(flowMapper.mapToFlowEntity(order.getId(), order.getFlows().get(0)));
		return order.getId();
	}

	public void updateOrderAndAddFlow(Order order) {
		repo.updateOrder(orderMapper.mapToEntity(order));
		repo.insertFlow(flowMapper.mapToFlowEntity(order.getId(), order.getFlows().get(0)));
	}
}
