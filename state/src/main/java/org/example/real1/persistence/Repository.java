package org.example.real1.persistence;

import org.example.real1.application.domain.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Repository {

	private static final AtomicInteger AUTO_ORDER = new AtomicInteger(0);
	private static final AtomicInteger AUTO_FLOW = new AtomicInteger(0);
	private static final AtomicInteger AUTO_COST = new AtomicInteger(0);
	public static final List<OrderEntity> ORDER_MAP = new ArrayList<>();
	public static final List<FlowEntity> FLOW_MAP = new ArrayList<>();
	public static final List<OrderRefundCostEntity> REFUND_COST_MAP = new ArrayList<>();

	public OrderEntity selectById(Integer id) {
		return ORDER_MAP.get(id);
	}

	public OrderRefundCostEntity selectCostByOrderId(Integer orderId) {
		return REFUND_COST_MAP
			.stream()
			.filter(i -> Objects.equals(i.getOrderId(), orderId))
			.findFirst()
			.orElseThrow(NoSuchElementException::new);
	}

	public Order.OrderId insertOrder(OrderEntity order) {
		order.setId(AUTO_ORDER.getAndIncrement());
		ORDER_MAP.add(order);
		return new Order.OrderId(order.getId());
	}

	public void updateOrder(OrderEntity order) {
		ORDER_MAP.get(order.getId()).setState(order.getState());
	}

	public void insertOrderRefund(OrderRefundCostEntity refundCost) {
		refundCost.setId(AUTO_COST.getAndIncrement());
		REFUND_COST_MAP.add(refundCost);
	}

	public void insertFlow(FlowEntity flow) {
		System.out.println("recording operating flow: " + flow.getOperator());
		flow.setId(AUTO_FLOW.incrementAndGet());
		FLOW_MAP.add(flow);
	}
}
