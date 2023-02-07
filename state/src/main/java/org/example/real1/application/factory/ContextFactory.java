package org.example.real1.application.factory;

import org.example.real1.application.domain.Order;
import org.example.real1.application.state.Context;

public class ContextFactory {

	private ContextFactory() {
	}

	public static Context valueOf(Order order) {
		if (order == null || order.getId() == null || order.getId().value() == null) {
			throw new RuntimeException("order is null");
		}
		System.out.println("order [ " + order.getId() + " ] is preparing move");
		return new Context(order);
	}
}
