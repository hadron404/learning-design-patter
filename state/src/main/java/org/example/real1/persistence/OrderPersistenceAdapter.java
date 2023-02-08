package org.example.real1.persistence;

import org.example.real1.application.domain.Order;

public class OrderPersistenceAdapter {
	private final Repository repo = new Repository();
	private final FlowMapper flowMapper = new FlowMapper();
	private final OrderMapper orderMapper = new OrderMapper();
	private final RefundCostMapper costMapper = new RefundCostMapper();

	public Order loadOrder(Order.OrderId oderId) {
		OrderEntity order = repo.selectById(oderId.value());
		OrderRefundCostEntity cost = repo.selectCostByOrderId(oderId.value());
		Order result = orderMapper.mapToDomain(order);
		result.setRefundCost(costMapper.mapToDomain(cost));
		return result;
	}

	public Order.OrderId saveOrder(Order order) {
		Order.OrderId orderId = repo.insertOrder(orderMapper.mapToEntity(order));
		repo.insertOrderRefund(costMapper.mapToEntity(orderId, order.getRefundCost()));
		repo.insertFlow(flowMapper.mapToFlowEntity(orderId, order.getFlows().get(0)));
		return orderId;
	}

	public void updateOrderAndAddFlow(Order order) {
		repo.updateOrder(orderMapper.mapToEntity(order));
		repo.insertFlow(flowMapper.mapToFlowEntity(order.getId(), order.getFlows().get(0)));
	}
}
