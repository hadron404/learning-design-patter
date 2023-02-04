package org.example.real1.persistence;

import org.example.real1.constant.Action;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Repository {

	private static final AtomicInteger AUTO_ORDER = new AtomicInteger(0);
	private static final AtomicInteger AUTO_FLOW = new AtomicInteger(0);
	public static final List<Order> ORDER_MAP = new ArrayList<>();
	public static final List<Flow> FLOW_MAP = new ArrayList<>();

	public Order selectById(Integer id) {
		return ORDER_MAP.get(id);
	}

	public List<Flow> selectByOrderId(Integer orderId) {
		return FLOW_MAP.stream()
			.filter(i -> i.getOrderId().equals(orderId))
			.collect(Collectors.toList());
	}

	public void insertOrder(Order order) {
		order.setId(AUTO_ORDER.getAndIncrement());
		ORDER_MAP.add(order);
	}

	public void updateOrder(Order order) {
		ORDER_MAP.get(order.getId()).setState(order.getState());
	}

	public void insertFlow(Integer orderId, Action action) {
		System.out.println("recording operating flow: " + action.toString());
		Flow flow = new Flow();
		flow.setOrderId(orderId);
		flow.setOperator(action.toString());
		flow.setOperatorTime(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		flow.setId(AUTO_FLOW.incrementAndGet());
		FLOW_MAP.add(flow);
	}
}
