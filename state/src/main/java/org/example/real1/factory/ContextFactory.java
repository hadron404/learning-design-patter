package org.example.real1.factory;

import org.example.real1.constant.EnumConverter;
import org.example.real1.constant.StatePersistenceMapping;
import org.example.real1.state.Context;
import org.example.real1.persistence.Order;

import java.util.Optional;

public class ContextFactory {

	private ContextFactory() {
	}

	public static Context valueOf(Integer state) {
		StatePersistenceMapping stateMapping = EnumConverter
			.codeOf(StatePersistenceMapping.class, state)
			.orElseThrow(() -> {
				throw new RuntimeException("unknown state: " + state);
			});
		return new Context(stateMapping);
	}

	public static Context valueOf(Order order) {
		if (order == null) {
			throw new RuntimeException("order is null");
		}
		System.out.println("order [ " + order.getId() + " ] is preparing move");
		return valueOf(order.getState());
	}
}
